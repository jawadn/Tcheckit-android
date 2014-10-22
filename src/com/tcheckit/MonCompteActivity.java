package com.tcheckit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.facebook.Session;
import com.facebook.widget.ProfilePictureView;
import com.fortutech.tcheckit.ejb.sessions.Address;
import com.fortutech.tcheckit.ejb.sessions.Civility;
import com.fortutech.tcheckit.ejb.sessions.Consumer;
import com.fortutech.tcheckit.ejb.sessions.Mission;
import com.fortutech.tcheckit.ejb.sessions.TcheckitMobileBean;
import com.tcheckit.vo.DataSession;
import com.tcheckit.vo.Tchecker;

public class MonCompteActivity extends MenuBasActivity {
	private ProfilePictureView profilePic;
	private ProgressDialog progressDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mon_compte);
		Typeface face;
		TextView tv3 = (TextView) findViewById(R.id.textNom);
		face = Typeface.createFromAsset(getAssets(), "SixCaps.ttf");
		tv3.setTypeface(face);
		profilePic = (ProfilePictureView) findViewById(R.id.profilepic);
		profilePic.setProfileId(Tchecker.getInstance().getId());

		DataSession ds = DataSession.getInstance();
		Consumer cs = ds.getConsumer();
		peuplerMonCompte(cs);
		((Button) findViewById(R.id.imageButtonMonCompte)).setBackgroundColor(getResources().getColor(R.color.orange));
		((Button) findViewById(R.id.imageButtonMonCompte)).setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.ico_mon_compte_org), null, null);
		RelativeLayout myLayout = (RelativeLayout) findViewById(R.id.relativeLayoutMonCompte);
		myLayout.requestFocus();
	}

	public void peuplerMonCompte(Consumer cs) {
		if (cs != null) {
			((TextView) findViewById(R.id.textNom)).setText(cs.getFirstName());
			((TextView) findViewById(R.id.editTextNom)).setText(cs.getName());
			((TextView) findViewById(R.id.editTextPrenom)).setText(cs.getFirstName());
			((TextView) findViewById(R.id.textGenre)).setText(cs.getCivility().get_value_());
			((TextView) findViewById(R.id.editTextCodepostal)).setText(cs.getOneAddress().getPostalCode());
			((TextView) findViewById(R.id.editTextTelephone)).setText(cs.getMobilePhone());
			Spinner mySpinner = ((Spinner) findViewById(R.id.spinner1));
			String sexe = cs.getCivility().get_value_();
			if ((Civility._Madame).equals(sexe)) {
				mySpinner.setSelection(((ArrayAdapter) mySpinner.getAdapter()).getPosition("FEMME"));
			}
			if ((Civility._Monsieur).equals(sexe)) {
				mySpinner.setSelection(((ArrayAdapter) mySpinner.getAdapter()).getPosition("HOMME"));
			}
			if (cs.getBirthday() != null) {
				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				String date = df.format(cs.getBirthday().getTime());
				((TextView) findViewById(R.id.editTextDateNaissance)).setText(date);
			}

		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mon_compte, menu);
		return true;
	}

	public void sauvegarder(View view) {
		progressDialog = ProgressDialog.show(MonCompteActivity.this, "", "Loading...");
		AsyncCallWS task = new AsyncCallWS(this);
		task.execute();
	}

	public void deconnexion(View view) {
		Session session = Session.getActiveSession();
		if (!session.isClosed()) {
			session.closeAndClearTokenInformation();
		}
		DataSession.getInstance().reset(getApplicationContext());
		Intent intent = new Intent(this, LoginActivity.class);
		startActivity(intent);
	}

	public void goMain(View view) {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}

	private class AsyncCallWS extends AsyncTask<String, Void, Void> {

		Context context;
		ArrayList<Mission> missions = null;

		private AsyncCallWS(Context context) {
			this.context = context.getApplicationContext();
		}

		@Override
		protected Void doInBackground(String... params) {

			Consumer cs = DataSession.getInstance().getConsumer();

			if (cs != null) {
				String nom = ((EditText) findViewById(R.id.editTextNom)).getText().toString();
				String prenom = ((EditText) findViewById(R.id.editTextPrenom)).getText().toString();
				String codepostale = ((EditText) findViewById(R.id.editTextCodepostal)).getText().toString();
				String telephone = ((EditText) findViewById(R.id.editTextTelephone)).getText().toString();
				cs.setName(nom);
				cs.setFirstName(prenom);
				cs.setMobilePhone(telephone);
				String sexe = ((Spinner) findViewById(R.id.spinner1)).getSelectedItem().toString();

				if (sexe.equals("HOMME")) {
					cs.setCivility(new Civility(Civility._Monsieur));
				}
				if (sexe.equals("FEMME")) {
					cs.setCivility(new Civility(Civility._Madame));
				}
				String dateNaissance = ((EditText) findViewById(R.id.editTextDateNaissance)).getText().toString();
				if (dateNaissance != null && dateNaissance.length() > 0) {
					Date birthDate = null;
					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					try {
						birthDate = df.parse(dateNaissance);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					df = new SimpleDateFormat("ddMMyyyy");
					try {
						birthDate = df.parse(dateNaissance);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					df = new SimpleDateFormat("dd-MM-yyyy");
					try {
						birthDate = df.parse(dateNaissance);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (birthDate != null) {
						GregorianCalendar gc = new GregorianCalendar();
						gc.setTime(birthDate);
						cs.setBirthday(gc);
					}
				} else {
					Calendar calendar = new GregorianCalendar();
					calendar.set(1900, 01, 01);
					cs.setBirthday(calendar);
				}
				// /
				cs.setBirthplace("");
				cs.setNationality("");

				if (cs.getOneAddress() == null) {
					cs.setOneAddress(new Address());
				}
				cs.getOneAddress().setPostalCode(codepostale);
				cs.setDateUpdated(GregorianCalendar.getInstance());

				TcheckitMobileBean tmb = new TcheckitMobileBean();
				try {
					cs = tmb.editConsumer(cs);
					DataSession.getInstance().setConsumer(cs);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					// Log.e("ERROR", e.getMessage());
					e.printStackTrace();
				}

			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			Consumer cs = DataSession.getInstance().getConsumer();
			peuplerMonCompte(cs);
			progressDialog.hide();

		}

		@Override
		protected void onPreExecute() {
			// Log.i("Tcheckit", "onPreExecute");

		}

		@Override
		protected void onProgressUpdate(Void... values) {
			// Log.i("Tcheckit", "onProgressUpdate");
		}
	}
}
