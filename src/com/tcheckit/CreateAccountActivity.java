package com.tcheckit;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.tcheckit.ws.AsyncCallWSCreate;

public class CreateAccountActivity extends Activity {
	public EditText login;
	public EditText mdp;
	public EditText mdp2;
	public CheckBox acceptCGU;
	public TextView textError;
	private ProgressDialog progressDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_account);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create_account, menu);
		return true;
	}

	public void goCreer(View view) {
		textError = (TextView) findViewById(R.id.textViewError);
		textError.setVisibility(View.INVISIBLE);

		login = (EditText) findViewById(R.id.editTextCreateEmail);
		mdp = (EditText) findViewById(R.id.editTextCreateMotDePasse);
		mdp2 = (EditText) findViewById(R.id.editTextCreateConfirmationMdp);
		acceptCGU = (CheckBox) findViewById(R.id.checkBoxCGU);
		if (login.getText().toString().length() == 0
				|| mdp.getText().toString().length() == 0
				|| mdp2.getText().toString().length() == 0) {
			textError.setText("Tous les champs sont obligatoirs");
			textError.setVisibility(View.VISIBLE);
		} else if (!mdp.getText().toString().equals(mdp2.getText().toString())) {
			textError.setText("La confirmation est différente");
			textError.setVisibility(View.VISIBLE);
			
		} else if (!acceptCGU.isChecked()) {
			textError.setText("Vous devez accepter les CGU pour pouvoir créer un compte.");
			textError.setVisibility(View.VISIBLE);
		} else {
			textError = (TextView) findViewById(R.id.textViewError);
			progressDialog = ProgressDialog.show(CreateAccountActivity.this,
					"", "Loading...");
			AsyncCallWSCreate task = new AsyncCallWSCreate(this, login.getText().toString(), mdp.getText().toString(), textError);
			task.execute();
		}
	}

	public void goRetour(View view) {
		Intent intent = new Intent(this, LoginActivity.class);
		startActivity(intent);
	}

	public void goConditionsDUtilisation(View view) {
		String url = "http://goo.gl/JyQGkV";  
		Intent i = new Intent(Intent.ACTION_VIEW);  
		i.setData(Uri.parse(url));  
		startActivity(i);
	}
}
