package com.tcheckit;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;

import com.tcheckit.vo.DataSession;

public class MenuBasActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_bas);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_bas, menu);
		return true;
	}

	public void goMonCompte(View view) {
		if (DataSession.getInstance().getConsumer() != null) {
			Intent intent = new Intent(this, MonCompteActivity.class);
			startActivity(intent);
		} else {
			AlertDialog.Builder builder1 = new AlertDialog.Builder(
					view.getContext());
			builder1.setTitle(R.string.login_btn);
			builder1.setMessage(R.string.login_register_msg);
			builder1.setCancelable(true);
			builder1.setPositiveButton(R.string.later,
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							dialog.cancel();
						}
					});
			builder1.setNegativeButton(R.string.sign_in,
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							dialog.cancel();
							goLogin();
						}
					});

			AlertDialog alert11 = builder1.create();
			alert11.show();
		}
	}

	public void goMonPorteMonnaie(View view) {
		if (DataSession.getInstance().getConsumer() != null) {
			Intent intent = new Intent(this, MonPorteMonnaieActivity.class);
			startActivity(intent);
		} else {
			AlertDialog.Builder builder1 = new AlertDialog.Builder(
					view.getContext());
			builder1.setTitle(R.string.login_btn);
			builder1.setMessage(R.string.login_register_msg);
			builder1.setCancelable(true);
			builder1.setPositiveButton(R.string.later,
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							dialog.cancel();
						}
					});
			builder1.setNegativeButton(R.string.sign_in,
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							dialog.cancel();
							goLogin();
						}
					});

			AlertDialog alert11 = builder1.create();
			alert11.show();
		}
	}

	public void goReglages(View view) {
		if (DataSession.getInstance().getConsumer() != null) {

			Intent intent = new Intent(this, ReglagesActivity.class);
			startActivity(intent);
		} else {
			AlertDialog.Builder builder1 = new AlertDialog.Builder(
					view.getContext());
			builder1.setTitle(R.string.login_btn);
			builder1.setMessage(R.string.login_register_msg);
			builder1.setCancelable(true);
			builder1.setPositiveButton(R.string.later,
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							dialog.cancel();
						}
					});
			builder1.setNegativeButton(R.string.sign_in,
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							dialog.cancel();
							goLogin();
						}
					});

			AlertDialog alert11 = builder1.create();
			alert11.show();
		}
	}

	public void goAutres(View view) {
		Intent intent = new Intent(this, AutresActivity.class);
		startActivity(intent);
	}

	public void goLogin() {
		Intent intent = new Intent(this, LoginActivity.class);
		startActivity(intent);
	}

}
