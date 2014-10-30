package com.tcheckit.utils;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.transport.HttpResponseException;
import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.util.Log;

import com.fortutech.tcheckit.ejb.sessions.Consumer;
import com.fortutech.tcheckit.ejb.sessions.TcheckitMobileBean;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.tcheckit.MainActivity;
import com.tcheckit.vo.DataSession;

public class GcmUtility{
	
	private static final String TAG = "GCMUtility";
	private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
	public static final String PROPERTY_REG_ID = "registration_id";
	private static final String PROPERTY_APP_VERSION = "appVersion";
	
	String SENDER_ID = "755115427133";
	String regid;
	
	GoogleCloudMessaging gcm;
	//Context context;
	
	/*@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       // setContentView(R.layout.main);
       // mDisplay = (TextView) findViewById(R.id.display);

        context = getApplicationContext();

        // Check device for Play Services APK. If check succeeds, proceed with GCM registration.
        if (checkPlayServices(context)) {
            gcm = GoogleCloudMessaging.getInstance(this);
            regid = getRegistrationId(context);

            if (regid.isEmpty()) {
                registerInBackground();
            }
        } else {
            Log.i(TAG, "No valid Google Play Services APK found.");
        }
    }*/
	
	public void setRegId(String regId){
		this.regid = regId;
	}
	public boolean checkPlayServices(Context context) {
	    int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
	    if (resultCode != ConnectionResult.SUCCESS) {
	        if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
	           // GooglePlayServicesUtil.getErrorDialog(resultCode,context.getApplicationContext(),PLAY_SERVICES_RESOLUTION_REQUEST).show();
	        } else {
	            Log.i(TAG, "This device does not support GCM.");
	           // finish();
	        }
	        return false;
	    }
	    return true;
	}
	
	/**
     * Gets the current registration ID for application on GCM service, if there is one.
     * <p>
     * If result is empty, the app needs to register.
     *
     * @return registration ID, or empty string if there is no existing
     *         registration ID.
     */
	public String getRegistrationId(Context context) {
	    final SharedPreferences prefs = getGCMPreferences(context);
	    String registrationId = prefs.getString(PROPERTY_REG_ID, "");
	    if (registrationId.isEmpty()) {
	        Log.i(TAG, "Registration not found.");
	        return "";
	    }
	    // Check if app was updated; if so, it must clear the registration ID
	    // since the existing regID is not guaranteed to work with the new
	    // app version.
	    int registeredVersion = prefs.getInt(PROPERTY_APP_VERSION, Integer.MIN_VALUE);
	    int currentVersion = getAppVersion(context);
	    if (registeredVersion != currentVersion) {
	        Log.i(TAG, "App version changed.");
	        return "";
	    }
	    return registrationId;
	}
	


    /**
     * Registers the application with GCM servers asynchronously.
     * <p>
     * Stores the registration ID and the app versionCode in the application's
     * shared preferences.
     */
    public void registerInBackground(final Context context) {
        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                String msg = "";
                try {
                    if (gcm == null) {
                        gcm = GoogleCloudMessaging.getInstance(context);
                    }
                    regid = gcm.register(SENDER_ID);
                    msg = "Device registered, registration ID=" + regid;

                    // You should send the registration ID to your server over HTTP, so it
                    // can use GCM/HTTP or CCS to send messages to your app.
                    sendRegistrationIdToBackend();

                    // Persist the regID - no need to register again.
                    storeRegistrationId(context, regid);
                } catch (IOException ex) {
                    msg = "Error :" + ex.getMessage();
                    // If there is an error, don't just keep trying to register.
                    // Require the user to click a button again, or perform
                    // exponential back-off.
                }
                return msg;
            }

            @Override
            protected void onPostExecute(String msg) {
                //mDisplay.append(msg + "\n");
            }
        }.execute(null, null, null);
    }
    
	 /**
     * Stores the registration ID and the app versionCode in the application's
     * {@code SharedPreferences}.
     *
     * @param context application's context.
     * @param regId registration ID
     */
    private void storeRegistrationId(Context context, String regId) {
        final SharedPreferences prefs = getGCMPreferences(context);
        int appVersion = getAppVersion(context);
        Log.i(TAG, "Saving regId on app version " + appVersion);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(PROPERTY_REG_ID, regId);
        editor.putInt(PROPERTY_APP_VERSION, appVersion);
        editor.commit();
    }
	
    
   /* @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    */
	/**
	 * @return Application's version code from the {@code PackageManager}.
	 */
	private static int getAppVersion(Context context) {
	    try {
	        PackageInfo packageInfo = context.getPackageManager()
	                .getPackageInfo(context.getPackageName(), 0);
	        return packageInfo.versionCode;
	    } catch (NameNotFoundException e) {
	        // should never happen
	        throw new RuntimeException("Could not get package name: " + e);
	    }
	}
	
	
	
    private SharedPreferences getGCMPreferences(Context context) {
	    // This app persists the registration ID in shared preferences.
	    return context.getSharedPreferences(MainActivity.class.getSimpleName(),
	            Context.MODE_PRIVATE);
	}

	
    
    // Call the webservice method to send registration id to Tcheckit server
	private void sendRegistrationIdToBackend() {
		TcheckitMobileBean tb = new TcheckitMobileBean();
		
		JSONObject regJson = new JSONObject();
		try {
			regJson.put("consumerId", DataSession.getInstance().getConsumer().getId());
			regJson.put("regId", regid);
			regJson.put("device", "android");
			//regJson.put("deviceId",Secure.getString(context.getContentResolver(), Secure.ANDROID_ID));
			tb.sendGcmRegisterRequest(regJson.toString());
			
		} catch (JSONException e) {
			Log.e(TAG, "json error in sendRegistrationIdToBackend");
			
		} catch (HttpResponseException e) {
			Log.e(TAG, "HttpResponse error in sendRegistrationIdToBackend");
		} catch (IOException e) {
			Log.e(TAG, "IOException error in sendRegistrationIdToBackend");
		} catch (XmlPullParserException e) {
			Log.e(TAG, "XMLPullParse error in sendRegistrationIdToBackend");
		}
		
		
	}

}
