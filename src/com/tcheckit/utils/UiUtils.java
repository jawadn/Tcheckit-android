package com.tcheckit.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.DisplayMetrics;

public class UiUtils {
	public static int getUiDp(int size, Context context) {
		DisplayMetrics metrics = context.getResources().getDisplayMetrics();				
		int px = (int)(size * (metrics.densityDpi / 160f));
		return px;
	}
	
	
	
}
