package com.tcheckit;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
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

public class ReinitMdpActivity extends Activity {
	public EditText login;

	public TextView textError;
	private ProgressDialog progressDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reinit_mdp);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.reinit_mdp, menu);
		return true;
	}

	public void goReinit(View view) {
		textError = (TextView) findViewById(R.id.textViewError);
		textError.setVisibility(View.INVISIBLE);

		login = (EditText) findViewById(R.id.editTextCreateEmail);

		if (login.getText().toString().length() == 0) {
			textError.setText(R.string.email_required);
			textError.setVisibility(View.VISIBLE);
		} else {

			progressDialog = ProgressDialog.show(ReinitMdpActivity.this, "", R.string.loading +"...");
			AsyncCallWS task = new AsyncCallWS(this);
			task.execute();
		}
	}

	public void goRetour(View view) {
		Intent intent = new Intent(this, LoginActivity.class);
		startActivity(intent);
	}

	private class AsyncCallWS extends AsyncTask<String, Void, Void> {

		Context context;
		Boolean result = null;

		private AsyncCallWS(Context context) {
			this.context = context.getApplicationContext();
		}

		@Override
		protected Void doInBackground(String... params) {
			Log.i("Tcheckit", "doInBackground");
			TcheckitMobileBean tb = new TcheckitMobileBean();
			try {

				result = tb.reinitializationPasswordWithEmail(login.getText()
						.toString());

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// textError = (TextView) findViewById(R.id.textViewError);

			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			progressDialog.hide();
			if (this.result == null) {
				textError = (TextView) findViewById(R.id.textViewError);
				textError.setText(R.string.error_reset);
				textError.setVisibility(View.VISIBLE);
			} else if (this.result) {

				Intent intent_name = new Intent();
				intent_name.setClass(getApplicationContext(),
						LoginActivity.class);
				startActivity(intent_name);

			} else {
				textError = (TextView) findViewById(R.id.textViewError);
				textError.setText(R.string.address_not_exist);
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
	}
}
