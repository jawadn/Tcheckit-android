package com.tcheckit;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import org.json.JSONObject;

import android.annotation.TargetApi;
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
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.model.GraphUser;
import com.facebook.widget.FacebookDialog;
import com.fortutech.tcheckit.ejb.sessions.Civility;
import com.fortutech.tcheckit.ejb.sessions.Consumer;
import com.fortutech.tcheckit.ejb.sessions.Person;
import com.fortutech.tcheckit.ejb.sessions.TcheckitMobileBean;
import com.fortutech.tcheckit.ejb.sessions.UserAccount;
import com.tcheckit.vo.DataSession;
import com.tcheckit.ws.AsyncCallWSCreate;

@TargetApi(14)
public class LoginActivity extends Activity {
	// private static final String URL_PREFIX_FRIENDS =
	// "https://graph.facebook.com/me/friends?access_token=";
	// private ProgressDialog progressDialog;
	private UiLifecycleHelper uiHelper;
	// private Facebook facebook;
	// private AsyncFacebookRunner mAsyncRunner;
	// String FILENAME = "AndroidSSO_data";
	// private SharedPreferences mPrefs;
	String message = "The best app ever";
	ProgressDialog progressDialog;
	ImageButton button;
	boolean error = true;
	// private static final String FACEBOOK_PERMISSION = "publish_stream";

	// Instance of Facebook Class

	private Session.StatusCallback callback = new Session.StatusCallback() {
		@Override
		public void call(Session session, SessionState state, Exception exception) {
			onSessionStateChange(session, state, exception);
		}
	};

	private void onSessionStateChange(Session session, SessionState state, Exception exception) {
		SharedPreferences prefs = getApplicationContext().getSharedPreferences("tcheckit", 0);

		if (state.isOpened()) {

			Request.executeMeRequestAsync(session, new Request.GraphUserCallback() {

				@Override
				public void onCompleted(GraphUser user, Response response) {
					if (user != null) {
						// Display the parsed user info
						String userFacebookId = (String) user.getProperty("id");
						String userFirstName = (String) user.getProperty("first_name");
						String userLastName = (String) user.getProperty("last_name");
						String birthDay = (String) user.getProperty("birthday");
						String gender = (String) user.getProperty("gender");
						String phone = (String) user.getProperty("phone");
						String email = (String) user.getProperty("email");

						UserAccount ua = new UserAccount();
						ua.setLogin(userFacebookId);
						Consumer onePerson = new Consumer();
						if (birthDay != null) {
							SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
							try {
								Date birthDate = df.parse(birthDay);
								GregorianCalendar gc = new GregorianCalendar();
								gc.setTime(birthDate);
								onePerson.setBirthday(gc);
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						onePerson.setEmail(email);
						if (gender != null) {
							if ("male".equals(gender)) {

								onePerson.setCivility(new Civility(Civility._Monsieur));
							} else if ("female".equals(gender)) {
								onePerson.setCivility(new Civility(Civility._Madame));
							}
						}

						onePerson.setFirstName(userFirstName);
						onePerson.setName(userLastName);
						onePerson.setMobilePhone(phone);

						ua.setOnePerson(onePerson);
						DataSession.getInstance().setFacebookid(userFacebookId);
						DataSession.getInstance().setFacebookConsumer(onePerson);

						// Sauvegarde de l'identifiant facebook
						SharedPreferences prefs = getApplicationContext().getSharedPreferences("tcheckit", 0);
						SharedPreferences.Editor editor = prefs.edit();
						editor.putString("FacebookId", userFacebookId);
						editor.commit();

						updateView();
					} else {
						if (getParent() != null) {
							AlertDialog.Builder builder1 = new AlertDialog.Builder(getParent());
							builder1.setTitle("Erreur");
							builder1.setMessage("Le user facebook est nul " + response.getError().getErrorMessage());
							builder1.setCancelable(true);
							builder1.setPositiveButton("Continuer", new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int id) {
									dialog.cancel();
								}
							});

							AlertDialog alert11 = builder1.create();
							alert11.show();
						}
					}
				}
			});
		} /*else if (exception != null) {
			AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
			builder1.setTitle("Erreur");
			String message = "";
			message += "State: isClosed=" + state.isClosed() + " - ";
			message += exception != null ? exception.getMessage() : " - ";
			message += session.getAccessToken() + " - ";
			message += session.getApplicationId();
			builder1.setMessage(message);
			builder1.setCancelable(true);
			builder1.setPositiveButton("Continuer", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					dialog.cancel();
				}
			});

			AlertDialog alert11 = builder1.create();
			alert11.show();
		}*/

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		Session session = Session.getActiveSession();

		if (session != null && (session.isOpened() || session.isClosed())) {
			onSessionStateChange(session, session.getState(), null);
		}
		uiHelper.onActivityResult(requestCode, resultCode, data, new FacebookDialog.Callback() {
			@Override
			public void onError(FacebookDialog.PendingCall pendingCall, Exception error, Bundle data) {
				Log.e("Activity", String.format("Error: %s", error.toString()));
			}

			@Override
			public void onComplete(FacebookDialog.PendingCall pendingCall, Bundle data) {
				Log.i("Activity", "Success!");
			}
		});
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		com.facebook.widget.LoginButton authButton = (com.facebook.widget.LoginButton) findViewById(R.id.authButton);
		// authButton.setReadPermissions(Arrays.asList("email"));

		uiHelper = new UiLifecycleHelper(this, callback);
		uiHelper.onCreate(savedInstanceState);

		// Code to get KeyHash value.
		/*
		 * try { PackageInfo info =
		 * getPackageManager().getPackageInfo(this.getPackageName(),
		 * PackageManager.GET_SIGNATURES); for (Signature signature :
		 * info.signatures) { MessageDigest md =
		 * MessageDigest.getInstance("SHA"); md.update(signature.toByteArray());
		 * System.out.println("KeyHash : " + Base64.encodeToString(md.digest(),
		 * Base64.DEFAULT)); } } catch (NameNotFoundException e) { } catch
		 * (NoSuchAlgorithmException e) { }
		 */
		SharedPreferences prefs = getApplicationContext().getSharedPreferences("tcheckit", 0);
		String facebookId = prefs.getString("FacebookId", null);
		String loginMail = prefs.getString("LoginMail", null);
		String mdpMail = prefs.getString("MdpMail", null);

		if (!isNetworkConnected()) {
			AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
			builder1.setTitle(R.string.alert);
			String message = "Vous devez avoir un accés internet pour utiliser l'application";

			builder1.setMessage(R.string.internet_req);
			builder1.setCancelable(true);
			builder1.setPositiveButton("Close", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					dialog.cancel();
				}
			});

			AlertDialog alert11 = builder1.create();
			alert11.show();
		} else {
			if (facebookId != null) {
				DataSession.getInstance().setFacebookid(facebookId);
				AsyncCallWS task = new AsyncCallWS(this);
				task.execute();
			} else if (loginMail != null && loginMail.length() > 0 && mdpMail != null && mdpMail.length() > 0) {
				DataSession.getInstance().setFacebookid(facebookId);
				AsyncCallWS task = new AsyncCallWS(this);
				task.execute();
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onDestroy() {
		uiHelper.onDestroy();
		super.onDestroy();
	}

	@Override
	protected void onResume() {
		super.onResume();
		uiHelper.onResume();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		uiHelper.onSaveInstanceState(outState);
	}

	@Override
	public void onPause() {
		super.onPause();
		uiHelper.onPause();
	}

	public void sendMessage(View view) {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}

	/*
	 * @Override public void onActivityResult(int requestCode, int resultCode,
	 * Intent data) { super.onActivityResult(requestCode, resultCode, data);
	 * 
	 * int sanitizedRequestCode = requestCode % 0x10000;
	 * Session.getActiveSession().onActivityResult(this, sanitizedRequestCode,
	 * resultCode, data);
	 * 
	 * }
	 */

	/*
	 * @Override public void onActivityResult(int requestCode, int resultCode,
	 * Intent data) { super.onActivityResult(requestCode, resultCode, data);
	 * Session.getActiveSession().onActivityResult(this, requestCode,
	 * resultCode, data); }
	 */

	private void updateView() {
		Session session = Session.getActiveSession();
		if (session != null && session.isOpened() && DataSession.getInstance().getFacebookid() != null) {
			error = false;
			AsyncCallWS task = new AsyncCallWS(this);
			task.execute();
		} /*
		 * else {
		 * 
		 * if (progressDialog != null) { progressDialog.hide(); } }
		 */
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub

		moveTaskToBack(true);
	}

	public void goLoginMail(View view) {
		Intent intent = new Intent(this, LoginMailActivity.class);
		startActivity(intent);
	}

	public void goCreate(View view) {
		Intent intent = new Intent(this, CreateAccountActivity.class);
		startActivity(intent);
	}

	public void goReinitMdp(View view) {
		Intent intent = new Intent(this, ReinitMdpActivity.class);
		startActivity(intent);
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

	/*
	 * public void goLoginFacebook(View view) { if (!checkNetwork()) {
	 * Toast.makeText(getApplicationContext(), "Pas de connexion internet...",
	 * Toast.LENGTH_SHORT).show(); return; } if (!checkFbInstalled()) {
	 * Toast.makeText(getApplicationContext(),
	 * "L'application Facebook est absente de l'appareil",
	 * Toast.LENGTH_SHORT).show(); return; }
	 * Toast.makeText(getApplicationContext(), "Chargement...",
	 * Toast.LENGTH_SHORT).show(); if
	 * (FacebookDialog.canPresentShareDialog(this,
	 * FacebookDialog.ShareDialogFeature.SHARE_DIALOG)) { FacebookDialog
	 * shareDialog = new FacebookDialog.ShareDialogBuilder(this).setName(
	 * "GAGNEZ DE L'ARGENT LORS DE VOTRE SHOPPING."
	 * ).setLink("http://www.tcheckit.com") .setDescription(message).setPicture(
	 * "http://www.tcheckit.com/images/tchek-icon-114x114.png").build();
	 * uiHelper.trackPendingDialogCall(shareDialog.present()); } else { //
	 * System.out.println("Fail Success!"); }
	 * 
	 * }
	 */
	@TargetApi(14)
	public class AsyncCallWS extends AsyncTask<String, Void, Void> {

		Context context;
	

		private AsyncCallWS(Context context) {
			this.context = context;

		}

		@Override
		protected Void doInBackground(String... params) {

			Log.i("Tcheckit", "doInBackground getUserFacebookByLogin");
			SharedPreferences prefs = getApplicationContext().getSharedPreferences("tcheckit", 0);
			String facebookId = prefs.getString("FacebookId", null);
			String loginMail = prefs.getString("LoginMail", null);
			String mdpMail = prefs.getString("MdpMail", null);
			TcheckitMobileBean tb = new TcheckitMobileBean();
			try {
				Consumer ua = null;
				if (facebookId != null) {
					ua = tb.getUserFacebookByLogin(DataSession.getInstance().getFacebookid());
					DataSession.getInstance().getFacebookConsumer().setId(ua.getId());
					
					URL picUrl = new URL("https://graph.facebook.com/"+facebookId+"/picture");
					HttpURLConnection urlConnection = (HttpURLConnection) picUrl.openConnection();
					InputStream in = new BufferedInputStream(urlConnection.getInputStream());
					byte[] byteArray = new byte[in.available()];
					in.read(byteArray);
					urlConnection.disconnect();
					String base64imageString = Base64.encodeToString(byteArray, Base64.DEFAULT);
        
					Consumer fbConsumer = DataSession.getInstance().getFacebookConsumer();
					
					JSONObject fbJson = new JSONObject();
					fbJson.put("id",fbConsumer.getId());
					fbJson.put("firstName", fbConsumer.getFirstName());
					fbJson.put("lastName", fbConsumer.getName());
					fbJson.put("email", fbConsumer.getEmail());
					if(fbConsumer.getBirthday() != null){
					 fbJson.put("dob",fbConsumer.getBirthday().getTimeInMillis());
					}else{
						fbJson.put("dob","");
					}
					fbJson.put("birthPlace",fbConsumer.getBirthplace());
					fbJson.put("profilepic", base64imageString);
					
					tb.editConsumerJson(fbJson.toString());
					
					
				} else if (loginMail != null && mdpMail != null) {
					UserAccount tmp = tb.getUserAccountByLoginByPassword(loginMail, mdpMail);
					if (tmp != null && tmp.getOnePerson() != null) {
						ua = (Consumer) tmp.getOnePerson();
					}
				}

				if (ua != null && ua.getId() != null) {
					DataSession.getInstance().setConsumer(ua);
					error = false;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {

			if (error) {
				progressDialog.hide();
				AlertDialog.Builder builder1 = new AlertDialog.Builder(this.context);
				builder1.setTitle(R.string.error_msg_title);
				String message = "Impossible de contacter les serveurs de Tcheck'it. Veuillez nous en excuser, les équipes technique font de leur mieux pour résoudre ce problème.";

				builder1.setMessage(R.string.error_msg);
				builder1.setCancelable(true);
				builder1.setPositiveButton("Close", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.cancel();
					}
				});

				AlertDialog alert11 = builder1.create();
				alert11.show();

			} else {

				Consumer cs = DataSession.getInstance().getConsumer();
				if (cs != null && cs.getId() != null) {
					Intent intent = new Intent(getApplicationContext(), MainActivity.class);
					startActivity(intent);
					

				} else {
					if (DataSession.getInstance().getFacebookConsumer() != null) {
						AsyncCallWSCreate task = new AsyncCallWSCreate(context, DataSession.getInstance().getFacebookid(), "", null);
						task.execute();
					}

				}
			}

		}

		@Override
		protected void onPreExecute() {
			// Log.i("Tcheckit", "onPreExecute");
			progressDialog = ProgressDialog.show(context, "", R.string.connecting + "...");
			super.onPreExecute();

		}

		@Override
		protected void onProgressUpdate(Void... values) {
			// Log.i("Tcheckit", "onProgressUpdate");
		}

	}
	/*
	 * private boolean checkNetwork() { boolean wifiAvailable = false; boolean
	 * mobileAvailable = false; ConnectivityManager conManager =
	 * (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	 * NetworkInfo[] networkInfo = conManager.getAllNetworkInfo(); for
	 * (NetworkInfo netInfo : networkInfo) { if
	 * (netInfo.getTypeName().equalsIgnoreCase("WIFI")) if
	 * (netInfo.isConnected()) wifiAvailable = true; if
	 * (netInfo.getTypeName().equalsIgnoreCase("MOBILE")) if
	 * (netInfo.isConnected()) mobileAvailable = true; } return wifiAvailable ||
	 * mobileAvailable; }
	 * 
	 * public Boolean checkFbInstalled() { PackageManager pm =
	 * getPackageManager(); boolean flag = false; try {
	 * pm.getPackageInfo("com.facebook.katana", PackageManager.GET_ACTIVITIES);
	 * flag = true; } catch (PackageManager.NameNotFoundException e) { flag =
	 * false; } return flag; }
	 * 
	 * @Override protected void onStop() { // TODO Auto-generated method stub
	 * super.onStop(); if (progressDialog != null) { progressDialog.hide(); } }
	 */

}
