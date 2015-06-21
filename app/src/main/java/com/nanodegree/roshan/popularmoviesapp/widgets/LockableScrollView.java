package com.nanodegree.roshan.popularmoviesapp.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class LockableScrollView extends ScrollView {
	/**
	 * Custom scroll view for the common flow throughout the app
	 * @param context
	 * @param attrs
	 */
	public LockableScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	private boolean mScrollable = true;

	public void setScrollingEnabled(boolean enabled) {
		mScrollable = enabled;
	}

	public boolean isScrollable() {
		return mScrollable;
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		switch (ev.getAction()) {
		case MotionEvent.ACTION_DOWN:
			if (mScrollable)
				return super.onTouchEvent(ev);
			return mScrollable;
		default:
			return super.onTouchEvent(ev);
		}
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		if (!mScrollable)
			return false;
		return super.onInterceptTouchEvent(ev);
	}
}