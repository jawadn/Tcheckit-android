package com.tcheckit;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class TestActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		Typeface face;
		TextView tv3 = (TextView) findViewById(R.id.textNom);
		face = Typeface.createFromAsset(getAssets(), "SixCaps.ttf");
		tv3.setTypeface(face);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pres1, menu);
		return true;
	}

	public void sauvegarder(View view) {

	}

	public void goMain(View view) {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}

	public void goMonCompte(View view) {
		Intent intent = new Intent(this, MonCompteActivity.class);
		startActivity(intent);
	}
	public void goMonPorteMonnaie(View view) {
		Intent intent = new Intent(this, MonPorteMonnaieActivity.class);
		startActivity(intent);
	}
	public void goReglages(View view) {
		Intent intent = new Intent(this, ReglagesActivity.class);
		startActivity(intent);
	}
	public void goAutres(View view) {
		Intent intent = new Intent(this, AutresActivity.class);
		startActivity(intent);
	}
}
