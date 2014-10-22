package com.tcheckit;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;

public class DisplayMessageActivity extends FragmentActivity {

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_message);
		// Show the Up button in the action bar.
		// Make sure we're running on Honeycomb or higher to use ActionBar APIs
		

	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 * 
	 * @TargetApi(Build.VERSION_CODES.HONEYCOMB) private void setupActionBar() {
	 *                                           if (Build.VERSION.SDK_INT >=
	 *                                           Build.VERSION_CODES.HONEYCOMB)
	 *                                           {
	 *                                           getActionBar().setDisplayHomeAsUpEnabled
	 *                                           (true); } }
	 */

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.button1:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
