package com.tcheckit;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.fortutech.tcheckit.ejb.sessions.Consumer;
import com.fortutech.tcheckit.ejb.sessions.TcheckitMobileBean;
import com.tcheckit.vo.DataSession;

public class MonCompteBanqueActivity extends  MenuBasActivity {
	private ProgressDialog progressDialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mon_compte_banque);
		afficheMonCompteBanque();
		RelativeLayout myLayout = (RelativeLayout) 	findViewById(R.id.relativeLayoutMonCompteBanque);
		myLayout.requestFocus();
	}

	public void afficheMonCompteBanque() {
		if (DataSession.getInstance().getConsumer() != null && DataSession.getInstance().getConsumer() != null) {			
			((EditText) findViewById(R.id.editTextIdentifiantBic)).setText(DataSession.getInstance().getConsumer().getBicId());
			((EditText) findViewById(R.id.editTextIdentifiantIban)).setText(DataSession.getInstance().getConsumer().getIbanId());
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mon_compte_banque, menu);
		return true;
	}
	
	public void sauvegarder(View view) {
		progressDialog = ProgressDialog.show(MonCompteBanqueActivity.this, "", "Loading...");
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

			EditText bic = (EditText) findViewById(R.id.editTextIdentifiantBic);
			EditText iban = (EditText) findViewById(R.id.editTextIdentifiantIban);
			if (bic != null && bic.getText() != null && bic.getText().toString().length() > 0) {

				Consumer cs = DataSession.getInstance().getConsumer();
				cs.setBicId(bic.getText().toString());
				
				
			} 
			if (iban != null && iban.getText() != null && iban.getText().toString().length() > 0) {

				Consumer cs = DataSession.getInstance().getConsumer();
				cs.setIbanId(iban.getText().toString());
				
			}
			TcheckitMobileBean tmb = new TcheckitMobileBean();
			try {
				Consumer cs = tmb.editConsumer(DataSession.getInstance().getConsumer());
				DataSession.getInstance().setConsumer(cs);
			

			} catch (Exception e) {
				// TODO Auto-generated catch block
				//Log.e("ERROR", e.getMessage());
				e.printStackTrace();
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
