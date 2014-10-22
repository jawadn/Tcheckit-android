package com.tcheckit;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.fortutech.tcheckit.ejb.sessions.Consumer;
import com.fortutech.tcheckit.ejb.sessions.TcheckitMobileBean;
import com.fortutech.tcheckit.ejb.sessions.UserAccount;
import com.tcheckit.vo.DataSession;

public class LoginMailActivity extends Activity {
	public EditText login;
	public EditText mdp;
	public TextView textError;
	private ProgressDialog progressDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_mail);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login_mail, menu);
		textError = (TextView) findViewById(R.id.textViewError);
		return true;
	}

	public void goValider(View view) {
		login = (EditText) findViewById(R.id.editTextNom);
		mdp = (EditText) findViewById(R.id.editTextPrenom);
		SharedPreferences prefs = getApplicationContext().getSharedPreferences("tcheckit", 0);
		SharedPreferences.Editor editor = prefs.edit();
		editor.putString("LoginMail", login.getText().toString());
		editor.putString("MdpMail", mdp.getText().toString());
		editor.commit();
		textError = (TextView) findViewById(R.id.textViewError);
		textError.setVisibility(View.INVISIBLE);
		if (!isNetworkConnected()) {
			AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
			builder1.setTitle(R.string.alert);
			String message = "Vous devez avoir un accés internet pour utiliser l'application";

			builder1.setMessage(R.string.internet_required);
			builder1.setCancelable(true);
			builder1.setPositiveButton(R.string.close, new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					dialog.cancel();
				}
			});

			AlertDialog alert11 = builder1.create();
			alert11.show();
		} else {
			if (login != null && login.getText() != null && login.getText().toString() != null && mdp != null && mdp.getText() != null && mdp.getText().toString() != null) {
				progressDialog = ProgressDialog.show(LoginMailActivity.this, "", R.string.loading+"...");
				AsyncCallWS task = new AsyncCallWS(this);
				task.execute();
			} else {
				textError.setVisibility(View.VISIBLE);
			}
		}
	}

	public void goRetour(View view) {
		Intent intent = new Intent(this, LoginActivity.class);
		startActivity(intent);
	}

	public class AsyncCallWS extends AsyncTask<String, Void, Void> {

		Context context;

		private AsyncCallWS(Context context) {
			this.context = context.getApplicationContext();
		}

		@Override
		protected Void doInBackground(String... params) {
			Log.i("Tcheckit", "doInBackground");
			TcheckitMobileBean tb = new TcheckitMobileBean();
			try {
				// UserAccount ua = tb.getUserAccountByLogin(
				 //login.getText().toString());
				UserAccount ua = tb.getUserAccountByLoginByPassword(login.getText().toString(), mdp.getText().toString());
				DataSession.getInstance().setConsumer((Consumer) ua.getOnePerson());

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// textError = (TextView) findViewById(R.id.textViewError);

			} finally {

			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			progressDialog.hide();
			Consumer cs = DataSession.getInstance().getConsumer();
			if (cs != null && cs.getId() != null) {

				Intent intent_name = new Intent();
				intent_name.setClass(getApplicationContext(), MainActivity.class);
				startActivity(intent_name);

			} else {
				textError = (TextView) findViewById(R.id.textViewError);
				textError.setVisibility(View.VISIBLE);

			}

		}

		@Override
		protected void onPreExecute() {
			// Log.i("Tcheckit", "onPreExecute");
			super.onPreExecute();
			textError = (TextView) findViewById(R.id.textViewError);
			textError.setVisibility(View.INVISIBLE);

		}

		@Override
		protected void onProgressUpdate(Void... values) {
			// Log.i("Tcheckit", "onProgressUpdate");
		}

		private String md5(String in) {
			MessageDigest digest;
			try {
				digest = MessageDigest.getInstance("MD5");
				digest.reset();
				digest.update(in.getBytes());
				byte[] a = digest.digest();
				int len = a.length;
				StringBuilder sb = new StringBuilder(len << 1);
				for (int i = 0; i < len; i++) {
					sb.append(Character.forDigit((a[i] & 0xf0) >> 4, 16));
					sb.append(Character.forDigit(a[i] & 0x0f, 16));
				}
				return sb.toString();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			return null;
		}

	}

	private boolean isNetworkConnected() {
		ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo ni = cm.getActiveNetworkInfo();
		if (ni == null) {
			// There are no active networks.
			return false;
		} else
			return true;
	}
}
