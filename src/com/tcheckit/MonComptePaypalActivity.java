package com.tcheckit;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.fortutech.tcheckit.ejb.sessions.Consumer;
import com.fortutech.tcheckit.ejb.sessions.TcheckitMobileBean;
import com.tcheckit.vo.DataSession;

public class MonComptePaypalActivity extends MenuBasActivity {
	private ProgressDialog progressDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mon_compte_paypal);
		if (DataSession.getInstance().getConsumer() != null && DataSession.getInstance().getConsumer().getPaypalMail() != null) {
			((EditText) findViewById(R.id.editTextNom)).setText(DataSession.getInstance().getConsumer().getPaypalMail());
		}
		RelativeLayout myLayout = (RelativeLayout) 	findViewById(R.id.relativeLayoutMonComptePaypal);
		myLayout.requestFocus();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mon_compte_paypal, menu);
		return true;
	}

	public void sauvegarder(View view) {
		progressDialog = ProgressDialog.show(MonComptePaypalActivity.this, "", "Loading...");
		AsyncCallWS task = new AsyncCallWS();
		task.execute();
	}
    public void retour(View view) {
    	Intent intent = new Intent(view.getContext(), ReglagesActivity.class);
		startActivity(intent);
    }
	private class AsyncCallWS extends AsyncTask<String, Void, Void> {

		

		private AsyncCallWS() {
			
		}

		@Override
		protected Void doInBackground(String... params) {

			EditText paypal = (EditText) findViewById(R.id.editTextNom);
			if (paypal != null && paypal.getText() != null && paypal.getText().toString().length() > 0) {

				Consumer cs = DataSession.getInstance().getConsumer();
				cs.setPaypalMail(paypal.getText().toString());
				TcheckitMobileBean tmb = new TcheckitMobileBean();
				try {
					cs = tmb.editConsumer(cs);
					DataSession.getInstance().setConsumer(cs);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					//Log.e("ERROR", e.getMessage());
					e.printStackTrace();
				}
			}
			return null;

		}

		@Override
		protected void onPostExecute(Void result) {

			progressDialog.hide();
			Intent intent = new Intent(getApplicationContext(), ReglagesActivity.class);
			startActivity(intent);
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
	public void goMain(View view) {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
}
