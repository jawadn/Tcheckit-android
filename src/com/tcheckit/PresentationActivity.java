package com.tcheckit;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ViewFlipper;

public class PresentationActivity extends Activity implements OnTouchListener {
	private float downXValue;
	private int presPageNumber = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_presentation);

		

		SharedPreferences prefs = getApplicationContext().getSharedPreferences(
				"tcheckit", 0);
		SharedPreferences.Editor editor = prefs.edit();
		Intent intent;
		if (prefs.getBoolean("isInitialAppLaunch", true)) {
			// First Time App launched, you are putting isInitialAppLaunch to
			// false and calling create password activity.

			editor.putBoolean("isInitialAppLaunch", false);
			editor.commit();
			intent = new Intent(this, PresentationActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			
			LinearLayout layMain = (LinearLayout) findViewById(R.id.layout_main);
			layMain.setOnTouchListener((OnTouchListener) this);
			((ProgressBar) findViewById(R.id.progressBar1)).setVisibility(ProgressBar.INVISIBLE);
			((ImageView) findViewById(R.id.imageView2)).setVisibility(ImageView.VISIBLE);
			
			

		} else {
			((ProgressBar) findViewById(R.id.progressBar1)).setVisibility(ProgressBar.VISIBLE);
			((ImageView) findViewById(R.id.imageView2)).setVisibility(ImageView.INVISIBLE);
			new Timer().schedule(new TimerTask() {
				public void run() {					
					startActivity(new Intent(PresentationActivity.this,
							LoginActivity.class));
				}
			}, 2000 /* amount of time in milliseconds before execution */);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pres3, menu);
		return true;
	}

	@Override
	public boolean onTouch(View arg0, MotionEvent arg1) {
		// Get the action that was done on this touch event
		switch (arg1.getAction()) {
		case MotionEvent.ACTION_DOWN: {
			// store the X value when the user's finger was pressed down
			downXValue = arg1.getX();
			break;
		}

		case MotionEvent.ACTION_UP: {
			// Get the X value when the user released his/her finger
			float currentX = arg1.getX();

			// going backwards: pushing stuff to the right
			if (downXValue < currentX) {
				if (this.presPageNumber > 0) {
					this.presPageNumber--;
					// Get a reference to the ViewFlipper
					ViewFlipper vf = (ViewFlipper) findViewById(R.id.details);
					// Set the animation
					vf.setInAnimation(AnimationUtils.loadAnimation(this,
							R.anim.slide_right));
					vf.setOutAnimation(AnimationUtils.loadAnimation(this,
							R.anim.slide_out_right));
					// Flip!
					vf.showPrevious();
				}
			}

			// going forwards: pushing stuff to the left
			if (downXValue > currentX) {
				if (this.presPageNumber < 4) {
					this.presPageNumber++;
					// Get a reference to the ViewFlipper
					ViewFlipper vf = (ViewFlipper) findViewById(R.id.details);
					// Set the animation
					vf.setInAnimation(AnimationUtils.loadAnimation(this,
							R.anim.slide_left));
					vf.setOutAnimation(AnimationUtils.loadAnimation(this,
							R.anim.slide_out_left));
					// Flip!
					vf.showNext();
				} else {
					Intent intent = new Intent(this, LoginActivity.class);

					startActivity(intent);
				}
			}
			break;
		}
		}

		// if you return false, these actions will not be recorded
		return true;
	}

	/** Called when the user clicks the Send button */
	public void goLogin(View view) {
		Intent intent = new Intent(this, LoginActivity.class);

		startActivity(intent);
	}
	
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		//super.onRestart();
		System.exit(0);
	}
	
	
	
	
}
