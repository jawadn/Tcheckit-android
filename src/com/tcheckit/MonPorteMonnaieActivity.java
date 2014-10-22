package com.tcheckit;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fortutech.tcheckit.ejb.sessions.Consumer;
import com.fortutech.tcheckit.ejb.sessions.TcheckitMobileBean;
import com.tcheckit.vo.DataSession;

public class MonPorteMonnaieActivity extends MenuBasActivity {
	private ProgressDialog progressDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mon_porte_monnaie);
		Typeface face;

		face = Typeface.createFromAsset(getAssets(), "SixCaps.ttf");
		((TextView) findViewById(R.id.textNom)).setTypeface(face);
		((TextView) findViewById(R.id.textViewSoldeEuros)).setTypeface(face);
		((TextView) findViewById(R.id.textViewSoldePoints)).setTypeface(face);
		((TextView) findViewById(R.id.textViewEurosAttente)).setTypeface(face);
		((TextView) findViewById(R.id.textViewPointsAttente)).setTypeface(face);
		((TextView) findViewById(R.id.textViewNombreMissions)).setTypeface(face);
		((TextView) findViewById(R.id.textViewTotalEuros)).setTypeface(face);

		Consumer cs = DataSession.getInstance().getConsumer();
		if (cs != null) {
			((TextView) findViewById(R.id.textNom)).setText(cs.getFirstName());
			((TextView) findViewById(R.id.textGenre)).setText(cs.getCivility().get_value_());
			((TextView) findViewById(R.id.textViewSoldeEuros)).setText(cs.getBalancecash().toString());
			((TextView) findViewById(R.id.textViewSoldePoints)).setText(cs.getPoints().toString());
			((TextView) findViewById(R.id.textViewEurosAttente)).setText(cs.getWaitcash().toString());
			((TextView) findViewById(R.id.textViewPointsAttente)).setText(cs.getWaitpoints().toString());
			((TextView) findViewById(R.id.textViewNombreMissions)).setText(cs.getNumberMissions().toString());
			((TextView) findViewById(R.id.textViewTotalEuros)).setText(cs.getTotalcash().toString());
		}
		
		((Button)findViewById(R.id.imageButtonMonPorteMonnaie)).setBackgroundColor(getResources().getColor(R.color.orange));
		((Button)findViewById(R.id.imageButtonMonPorteMonnaie)).setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.ico_mon_porte_monnaie_org), null, null);
	}

	public void deconnexion(View view) {
		Intent intent = new Intent(this, LoginActivity.class);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mon_porte_monnaie, menu);
		return true;
	}

	public void goMain(View view) {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}

	public void goVirement(View view) {
		if (DataSession.getInstance().getConsumer() != null && DataSession.getInstance().getConsumer().getWaitcash() != null
				&& DataSession.getInstance().getConsumer().getBalancecash() < 10.0) {
			AlertDialog.Builder builder1 = new AlertDialog.Builder(view.getContext());
			builder1.setTitle(R.string.transfer_request);
			builder1.setMessage(R.string.transfer_request_failure);
			builder1.setCancelable(true);
			builder1.setPositiveButton("Continuer", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					dialog.cancel();
				}
			});

			AlertDialog alert11 = builder1.create();
			alert11.show();
		} else {
			progressDialog = ProgressDialog.show(MonPorteMonnaieActivity.this, "", R.string.loading+"...");
			AsyncCallWS task = new AsyncCallWS(view.getContext());
			task.execute();
		}
	}

	private class AsyncCallWS extends AsyncTask<String, Void, Void> {

		Context context;
		Boolean result = null;

		private AsyncCallWS(Context context) {
			this.context = context;
		}

		@Override
		protected Void doInBackground(String... params) {
			Log.i("Tcheckit", "doInBackground");
			TcheckitMobileBean tb = new TcheckitMobileBean();
			try {
				if (DataSession.getInstance().getConsumer() != null) {
					result = tb.askPaiement(DataSession.getInstance().getConsumer());
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// textError = (TextView) findViewById(R.id.textViewError);

			}
			return null;
		}

		@Override
		protected void onPostExecute(Void resulta) {
			progressDialog.hide();
			if (result != null) {
				if (result) {
					AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
					builder1.setTitle(R.string.transfer_request);
					builder1.setMessage(R.string.transfer_request_success);
					builder1.setCancelable(true);
					builder1.setPositiveButton(R.string.continue_msg, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							dialog.cancel();
						}
					});

					AlertDialog alert13 = builder1.create();
					alert13.show();

				} else {
					AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
					builder1.setTitle(R.string.transfer_request);
					builder1.setMessage(R.string.transfer_request_contact);
					builder1.setCancelable(true);
					builder1.setPositiveButton(R.string.continue_msg, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							dialog.cancel();
						}
					});

					AlertDialog alert14 = builder1.create();
					alert14.show();

				}
			} else {
				AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
				builder1.setTitle(R.string.transfer_request);
				builder1.setMessage(R.string.technical_problem);
				builder1.setCancelable(true);
				builder1.setPositiveButton(R.string.continue_msg, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.cancel();
					}
				});

				AlertDialog alert14 = builder1.create();
				alert14.show();
			}

		}

		@Override
		protected void onPreExecute() {
			// Log.i("Tcheckit", "onPreExecute");
			super.onPreExecute();

		}

		@Override
		protected void onProgressUpdate(Void... values) {
			// Log.i("Tcheckit", "onProgressUpdate");
		}
	}
}
