package com.tcheckit;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.facebook.Session;
import com.tcheckit.utils.UiUtils;
import com.tcheckit.vo.DataSession;

public class ReglagesActivity extends MenuBasActivity {

	ExtendedSeekBar mSeekBar;
	TextView fade_text;
 
 

 
 
 
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reglages);

		mSeekBar = (ExtendedSeekBar) findViewById(R.id.seekBar1);
		

		mSeekBar.setY(mSeekBar.getY() - UiUtils.getUiDp(40, getApplicationContext()));
		fade_text = (TextView) findViewById(R.id.textView33);

		mSeekBar.setTV(fade_text);
		fade_text.setY(fade_text.getY() - UiUtils.getUiDp(85, getApplicationContext()));
		fade_text.setX(mSeekBar.getX() + 15);
		int perimetre = DataSession.getInstance().getPerimetre(getApplicationContext());
		switch (perimetre) {
		case 500:
			mSeekBar.setProgress(0);
			fade_text.setText("500 m");
			break;
		case 2000:
			mSeekBar.setProgress(1);
			fade_text.setText("2 Km");
			break;
		case 5000:
			mSeekBar.setProgress(2);
			fade_text.setText("5 Km");
			break;
		case 10000:
			mSeekBar.setProgress(3);
			fade_text.setText("10 Km");
			break;
		case 20000:
			mSeekBar.setProgress(4);
			fade_text.setText("20 Km");
			break;
		default:
			mSeekBar.setProgress(5);
			fade_text.setText("50 Km");
			break;
		}

		// fade_text.setX(mSeekBar.getX() + 15);
		SharedPreferences prefs = getApplicationContext().getSharedPreferences("tcheckit", 0);
		String tmp = prefs.getString("filtrePerimetreActif", "NON");
		((ToggleButton) findViewById(R.id.toggleButton1)).setText(tmp);
		if (tmp.equals("OUI")) {
			((ToggleButton) findViewById(R.id.toggleButton1)).setChecked(true);
		}
		tmp = prefs.getString("filtrePushActif", "NON");
		((ToggleButton) findViewById(R.id.toggleButton2)).setText(tmp);
		if (tmp.equals("OUI")) {
			((ToggleButton) findViewById(R.id.toggleButton2)).setChecked(true);
		}

		((Button) findViewById(R.id.imageButtonReglages)).setBackgroundColor(getResources().getColor(R.color.orange));
		((Button) findViewById(R.id.imageButtonReglages)).setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.ico_reglages_org), null, null);

		mSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				// TODO Auto-generated method stub
				mSeekBar.computeScroll();
				Rect thumbRect = mSeekBar.getSeekBarThumb().getBounds();
				// Log.v("sherif", "(" + thumbRect.left + ", " + thumbRect.top + ", " +
				// thumbRect.right + ", " + thumbRect.bottom + ") + " +
				// mSeekBar.getMeasuredWidth());
				String what_to_say = String.valueOf(progress);

				// int seek_label_pos = (int) ((float) (mSeekBar.getMeasuredWidth()) *
				// ((float) progress / 10f));
				SharedPreferences prefs = getApplicationContext().getSharedPreferences("tcheckit", 0);
				SharedPreferences.Editor editor = prefs.edit();

				switch (progress) {
				case 0:
					fade_text.setX(thumbRect.left + 15);
					fade_text.setText("500 m");
					editor.putInt("perimetre", 500);
					break;
				case 1:
					fade_text.setX(thumbRect.left + 15);
					fade_text.setText("2 Km");
					editor.putInt("perimetre", 2000);
					break;
				case 2:
					fade_text.setX(thumbRect.left + 15);
					fade_text.setText("5 Km");
					editor.putInt("perimetre", 5000);
					break;
				case 3:
					fade_text.setX(thumbRect.left + 13);
					fade_text.setText("10 Km");
					editor.putInt("perimetre", 10000);
					break;
				case 4:
					fade_text.setX(thumbRect.left + 13);
					fade_text.setText("20 Km");
					editor.putInt("perimetre", 20000);
					break;
				default:
					fade_text.setX(thumbRect.left + 13);
					fade_text.setText("50 Km");
					editor.putInt("perimetre", 50000);
					break;

				}
				editor.commit();
				mSeekBar.refreshDrawableState();

				thumbRect = mSeekBar.getSeekBarThumb().getBounds();
			}
		});
	}

	

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onPostCreate(savedInstanceState);

		Rect thumbRect = mSeekBar.getProgressDrawable().getBounds();// SeekBarThumb().getBounds();
		mSeekBar.getWidth();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.reglages, menu);
		return true;
	}

	public void goMain(View view) {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}

	/*@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

		mSeekBar.computeScroll();
		Rect thumbRect = mSeekBar.getSeekBarThumb().getBounds();
		// Log.v("sherif", "(" + thumbRect.left + ", " + thumbRect.top + ", " +
		// thumbRect.right + ", " + thumbRect.bottom + ") + " +
		// mSeekBar.getMeasuredWidth());
		String what_to_say = String.valueOf(progress);

		// int seek_label_pos = (int) ((float) (mSeekBar.getMeasuredWidth()) *
		// ((float) progress / 10f));
		SharedPreferences prefs = getApplicationContext().getSharedPreferences("tcheckit", 0);
		SharedPreferences.Editor editor = prefs.edit();

		switch (progress) {
		case 0:
			fade_text.setX(thumbRect.left + 15);
			fade_text.setText("500 m");
			editor.putInt("perimetre", 500);
			break;
		case 1:
			fade_text.setX(thumbRect.left + 15);
			fade_text.setText("2 Km");
			editor.putInt("perimetre", 2000);
			break;
		case 2:
			fade_text.setX(thumbRect.left + 15);
			fade_text.setText("5 Km");
			editor.putInt("perimetre", 5000);
			break;
		case 3:
			fade_text.setX(thumbRect.left + 13);
			fade_text.setText("10 Km");
			editor.putInt("perimetre", 10000);
			break;
		case 4:
			fade_text.setX(thumbRect.left + 13);
			fade_text.setText("20 Km");
			editor.putInt("perimetre", 20000);
			break;
		default:
			fade_text.setX(thumbRect.left + 13);
			fade_text.setText("50 Km");
			editor.putInt("perimetre", 50000);
			break;

		}
		editor.commit();
		mSeekBar.refreshDrawableState();

		thumbRect = mSeekBar.getSeekBarThumb().getBounds();
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}
*/
	public void goVotreCompteEnBanque(View view) {
		Intent intent = new Intent(this, MonCompteBanqueActivity.class);
		startActivity(intent);
	}

	public void goVotreComptePaypal(View view) {
		Intent intent = new Intent(this, MonComptePaypalActivity.class);
		startActivity(intent);
	}

	public void goModifierMdp(View view) {
		AlertDialog.Builder builder1 = new AlertDialog.Builder(view.getContext());
		builder1.setTitle("Attention!");
		builder1.setMessage(R.string.action_not_allowed);
		builder1.setCancelable(true);
		builder1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				dialog.cancel();
			}
		});

		AlertDialog alert11 = builder1.create();
		alert11.show();
	}

	public void deconnexion(View view) {
		Session session = Session.getActiveSession();
		if (!session.isClosed()) {
			session.closeAndClearTokenInformation();
		}
		DataSession.getInstance().reset(getApplicationContext());
		Intent intent = new Intent(this, LoginActivity.class);
		startActivity(intent);
	}

	public void filtrePerimetre(View view) {
		SharedPreferences prefs = getApplicationContext().getSharedPreferences("tcheckit", 0);
		SharedPreferences.Editor editor = prefs.edit();
		editor.putString("filtrePerimetreActif", ((ToggleButton) findViewById(R.id.toggleButton1)).getText().toString());
		editor.commit();
	}

	public void filtrePush(View view) {
		SharedPreferences prefs = getApplicationContext().getSharedPreferences("tcheckit", 0);
		SharedPreferences.Editor editor = prefs.edit();
		editor.putString("filtrePushActif", ((ToggleButton) findViewById(R.id.toggleButton2)).getText().toString());
		editor.commit();
	}
}
