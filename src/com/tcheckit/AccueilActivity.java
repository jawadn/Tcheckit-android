package com.tcheckit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;

public class AccueilActivity extends Activity implements OnTouchListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_accueil);
		RelativeLayout layAcc = (RelativeLayout) findViewById(R.id.layout_accueil);
		layAcc.setOnTouchListener((OnTouchListener) this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.accueil, menu);
		return true;
	}
	@Override
	public boolean onTouch(View arg0, MotionEvent arg1) {
		Intent intent = new Intent(this, PresentationActivity.class);	   
	    startActivity(intent);
		return true;
	}
}
