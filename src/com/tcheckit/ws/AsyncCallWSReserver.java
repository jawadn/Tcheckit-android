package com.tcheckit.ws;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.fortutech.tcheckit.ejb.sessions.TcheckitMobileBean;
import com.tcheckit.MainActivity;
import com.tcheckit.R;
import com.tcheckit.vo.DataSession;

public class AsyncCallWSReserver extends AsyncTask<String, Void, Void> {
	Context context;
	private Boolean reponse = null;

	MainActivity main;

	public AsyncCallWSReserver(Context context, MainActivity main) {
		this.context = context;

		this.main = main;
	}

	@Override
	protected Void doInBackground(String... params) {
		Log.i("Tcheckit", "doInBackground AsyncCallWSReserver");

		TcheckitMobileBean tmb = new TcheckitMobileBean();
		try {
			reponse = tmb.missionAvailableForConsumer(DataSession.getInstance().getMission().getId(), DataSession.getInstance().getSign().getId(), DataSession.getInstance()
					.getConsumer().getId());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return null;
	}

	@Override
	protected void onPostExecute(Void result) {
		// Log.i("Tcheckit", "onPostExecute");
		if (main.progressDialog != null) {
			main.progressDialog.hide();
		}
		if (reponse != null) {
			if (reponse) {

				this.main.afficheDescription();
			} else {
				dejaReserverMission(context);
			}
		} else {
			erreurReserverMission(context);
		}
	}

	@Override
	protected void onPreExecute() {

	}

	@Override
	protected void onProgressUpdate(Void... values) {

	}

	public void erreurReserverMission(Context context) {
		if (main.progressDialog != null) {
			main.progressDialog.hide();
		}
		AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
		builder1.setTitle(R.string.mission_reserve_title);
		builder1.setMessage(R.string.mission_reserve_error);
		builder1.setCancelable(true);
		builder1.setPositiveButton(R.string.continue_msg, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				dialog.cancel();
			}
		});

		AlertDialog alert11 = builder1.create();
		alert11.show();
	}

	public void dejaReserverMission(final Context context) {
		if (main.progressDialog != null) {
			main.progressDialog.hide();
		}
		AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
		builder1.setTitle("Trop tard");
		builder1.setMessage("Cette mission a déjà été résérvé par un autre Tchecker.");
		builder1.setCancelable(true);
		builder1.setPositiveButton("Continuer", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				DataSession.getInstance().setMission(null);
				DataSession.getInstance().setMissions(null);
				DataSession.getInstance().setQuestionContainer(null);
				DataSession.getInstance().setSign(null);
				dialog.cancel();
				Intent intent = new Intent(context, MainActivity.class);
				context.startActivity(intent);

			}
		});

		AlertDialog alert11 = builder1.create();
		alert11.show();
	}
}
