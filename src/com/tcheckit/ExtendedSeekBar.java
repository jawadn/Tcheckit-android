package com.tcheckit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import android.widget.TextView;

public class ExtendedSeekBar extends SeekBar {
	TextView tv;

	public ExtendedSeekBar(Context context) {
		super(context);
	}

	public ExtendedSeekBar(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public ExtendedSeekBar(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	Drawable mThumb;

	@Override
	public void setThumb(Drawable thumb) {
		super.setThumb(thumb);
		mThumb = thumb;
	}

	public Drawable getSeekBarThumb() {
		return mThumb;
	}

	@Override
	protected void onDraw(Canvas c) {
		super.onDraw(c);
		if (tv != null) {
			tv.setX(mThumb.getBounds().left + 15);
		}
	}

	public void setTV(TextView tv) {
		this.tv = tv;
	}

}
