package com.tcheckit.ws;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Base64;
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
					
					Consumer fbConsumer = DataSession.getInstance().getFacebookConsumer();
					
					JSONObject fbJson = new JSONObject();
					fbJson.put("id",fbConsumer.getId());
					fbJson.put("firstName", fbConsumer.getFirstName());
					fbJson.put("lastName", fbConsumer.getName());
					fbJson.put("email", fbConsumer.getEmail());
					fbJson.put("dob",fbConsumer.getBirthday().getTimeInMillis());
					fbJson.put("birthPlace",fbConsumer.getBirthplace());
					
					URL picUrl = new URL("https://graph.facebook.com/"+DataSession.getInstance().getFacebookid()+"/picture");
					HttpURLConnection urlConnection = (HttpURLConnection) picUrl.openConnection();
					InputStream in = new BufferedInputStream(urlConnection.getInputStream());
					byte[] byteArray = new byte[in.available()];
					in.read(byteArray);
					urlConnection.disconnect();
					String base64imageString = Base64.encodeToString(byteArray, Base64.DEFAULT);
        			
					fbJson.put("profilepic", base64imageString);
					
					tb.editConsumerJson(fbJson.toString());
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
