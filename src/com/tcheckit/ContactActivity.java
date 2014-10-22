package com.tcheckit;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

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

public class ContactActivity extends Activity {
	private ProgressDialog progressDialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.contact, menu);
		return true;
	}

	public void goAutres(View view) {
		Intent intent = new Intent(this, AutresActivity.class);
		startActivity(intent);
	}

	public void goSendEmail(View view) {
		progressDialog = ProgressDialog.show(ContactActivity.this, "", "Loading...");
		AsyncCallWS task = new AsyncCallWS(this);
		task.execute();
		
		
	}
	
	
	private class AsyncCallWS extends AsyncTask<String, Void, Void> {

		Context context;

		private AsyncCallWS(Context context) {
			this.context = context.getApplicationContext();
		}

		@Override
		protected Void doInBackground(String... params) {
			Log.i("Tcheckit", "doInBackground");
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(
					"http://www.tcheckit.com/contactTcheckit");

			try {
				// Add your data
				String nom = ((EditText) findViewById(R.id.editTextContactNom)).getText()
						.toString();
				String prenom = ((EditText) findViewById(R.id.editTextContactPrenom))
						.getText().toString();
				String email = ((EditText) findViewById(R.id.editTextContactEmail))
						.getText().toString();
				String subject = ((EditText) findViewById(R.id.editTextContactSujet))
						.getText().toString();
				String message = ((EditText) findViewById(R.id.editTextContactMessage))
						.getText().toString();
				List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(5);
				nameValuePairs.add(new BasicNameValuePair("name", nom));
				nameValuePairs.add(new BasicNameValuePair("firstname", prenom));
				nameValuePairs.add(new BasicNameValuePair("mail", email));
				nameValuePairs.add(new BasicNameValuePair("subject", subject));
				nameValuePairs.add(new BasicNameValuePair("message", message));
				httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

				// Execute HTTP Post Request
				HttpResponse response = httpclient.execute(httppost);

			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			progressDialog.hide();
			Intent intent = new Intent(getApplicationContext(), AutresActivity.class);
			startActivity(intent);

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
