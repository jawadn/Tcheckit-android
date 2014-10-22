package com.tcheckit;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class AutresActivity extends MenuBasActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_autres);
		((Button)findViewById(R.id.imageButtonAutres)).setBackgroundColor(getResources().getColor(R.color.orange));
		((Button)findViewById(R.id.imageButtonAutres)).setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.ico_autres_org), null, null);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.autres, menu);
		return true;
	}

	public void goMain(View view) {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}

	
	
	public void goPartagerAvecMesAmis(View view) {
		String url = "http://goo.gl/zUTNrX";  
		Intent i = new Intent(Intent.ACTION_VIEW);  
		i.setData(Uri.parse(url));  
		startActivity(i);
	}
	 
	public void goVisiterNotreSiteWeb(View view) {
		String url = "http://goo.gl/v4MLou";  
		Intent i = new Intent(Intent.ACTION_VIEW);  
		i.setData(Uri.parse(url));  
		startActivity(i);
	}
	
	public void goConditionsDUtilisation(View view) {
		String url = "http://goo.gl/JyQGkV";  
		Intent i = new Intent(Intent.ACTION_VIEW);  
		i.setData(Uri.parse(url));  
		startActivity(i);
	}
	
	public void goCommentCaMarche(View view) {
		String url = "http://goo.gl/v4MLou";  
		Intent i = new Intent(Intent.ACTION_VIEW);  
		i.setData(Uri.parse(url));  
		startActivity(i);
	}
	
	public void goContactezNous(View view) {
		Intent intent = new Intent(this, ContactActivity.class);
		startActivity(intent);
	}
	
}
