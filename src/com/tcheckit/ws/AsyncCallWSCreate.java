package com.tcheckit.ws;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.fortutech.tcheckit.ejb.sessions.Consumer;
import com.fortutech.tcheckit.ejb.sessions.TcheckitMobileBean;
import com.fortutech.tcheckit.ejb.sessions.UserAccount;
import com.tcheckit.MainActivity;
import com.tcheckit.vo.DataSession;

public class AsyncCallWSCreate extends AsyncTask<String, Void, Void> {
	Context context;
	Boolean result = null;
	String login;
	String mdp;
	TextView textError;

	public AsyncCallWSCreate(Context context, String login, String mdp, TextView textError) {
		this.context = context.getApplicationContext();
		this.login = login;
		this.mdp = mdp;
		this.textError = textError;
	}

	@Override
	protected Void doInBackground(String... params) {
		Log.i("Tcheckit", "doInBackground");
		TcheckitMobileBean tb = new TcheckitMobileBean();
		try {
			UserAccount ua = tb.createConsumerAccount(login, mdp);
			if (ua != null) {
				if(DataSession.getInstance().getFacebookid() != null){
					DataSession.getInstance().getFacebookConsumer().setId(ua.getId());
					//ua.setOnePerson(tb.editConsumer(DataSession.getInstance().getFacebookConsumer()));
				}
				DataSession.getInstance().setConsumer((Consumer) ua.getOnePerson());
				result = true;
			} else {
				result = false;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return null;
	}

	@Override
	protected void onPostExecute(Void result) {

		if (this.result != null) {
			Consumer cs = DataSession.getInstance().getConsumer();
			if (cs != null && cs.getId() != null) {

				Intent intent_name = new Intent();
				intent_name.setClass(context, MainActivity.class);
				intent_name.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				context.startActivity(intent_name);

			} else {
				// textError = (TextView) findViewById(R.id.textViewError);
				if (textError != null) {
					textError.setText("Ce mail existe déjà");
					textError.setVisibility(View.VISIBLE);
				}

			}
		} else {
			if (textError != null) {
				// textError = (TextView) findViewById(R.id.textViewError);
				textError.setText("Un problème technique est survenu");
				textError.setVisibility(View.VISIBLE);
			}
		}

	}

	@Override
	protected void onPreExecute() {
		// Log.i("Tcheckit", "onPreExecute");
		super.onPreExecute();
		// textError = (TextView) findViewById(R.id.textViewError);
		if (textError != null) {
			textError.setVisibility(View.INVISIBLE);
		}

	}

	@Override
	protected void onProgressUpdate(Void... values) {
		// Log.i("Tcheckit", "onProgressUpdate");
	}
}
