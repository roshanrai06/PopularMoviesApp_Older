package com.nanodegree.roshan.popularmoviesapp;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nanodegree.roshan.popularmoviesapp.fragments.base.PopularMoviesBaseFragment;
import com.nanodegree.roshan.popularmoviesapp.widgets.LockableScrollView;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;

public class PopularMoviesBaseActivity extends BaseActionActivity implements PopularMoviesBaseFragment.PopularMoviesBaseFragmentListener, FragmentManager.OnBackStackChangedListener {
    private static final String SAVE_SHOWING_HEADER = "SAVE_SHOWING_HEADER";
    private final int ANIMATION_TRANSITION_DURATION = 500;
    private final int ANIMATION_ROTATION_AMT = 0;// -2;
    protected ProgressBar mProgressBar;
    private FrameLayout mContent;
    protected boolean mLoadingDisplay = false;
    private boolean mShowingHeader = false;
    private AnimatorSet mAnimSet;
    private View mBalanceHeader;
    private LockableScrollView mContentScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_movies_base);
        setupActionBar();
        getSupportFragmentManager().addOnBackStackChangedListener(this);

        mContent = (FrameLayout) findViewById(R.id.content_frame);
        mProgressBar = (ProgressBar) findViewById(R.id.common_loading_display);
        mBalanceHeader = findViewById(R.id.balanceHeader);
        mContentScrollView = (LockableScrollView) findViewById(R.id.content_scrollview_parent);
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(SAVE_SHOWING_HEADER)) {
                mShowingHeader = savedInstanceState.getBoolean(SAVE_SHOWING_HEADER, false);
                if (mShowingHeader) {
                    showBalanceHeader();
                } else {
                    hideBalanceHeader();
                }
            }
        }
    }

    /**
     * Default action bar initialization
     */
    protected void setupActionBar() {
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);// enables home up and shows arrow
        getSupportActionBar().setDisplayShowHomeEnabled(false);// shows logo
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(SAVE_SHOWING_HEADER, mShowingHeader);
    }

    protected String getBalanceHeaderString() {
        String balanceHeaderString = "73";

        return balanceHeaderString;
    }

    /**
     * To show the balance header
     */
    private void showBalanceHeader() {
        showBalanceHeader(getBalanceHeaderString());
    }

    /**
     * To show the balance header
     *
     * @param display
     */
    private void showBalanceHeader(String display) {
        if (mBalanceHeader != null && mBalanceHeader.getVisibility() != View.VISIBLE) {
            mBalanceHeader.setVisibility(View.VISIBLE);
            ((TextView) findViewById(R.id.common_accountbalance_label_amount)).setText(display);
        }
    }

    /**
     * To hide the balance header
     */
    private void hideBalanceHeader() {
        if (mBalanceHeader != null && mBalanceHeader.getVisibility() != View.GONE)
            mBalanceHeader.setVisibility(View.GONE);
    }

    @Override
    protected View getContentView() {
        return mContent;
    }

    @Override
    protected int getFragmentContentFrameResourceID() {
        return R.id.content_frame;
    }

    @Override
    public void onSuggestActionBar(boolean show) {
        if (!getSupportActionBar().isShowing() && show) {
            getSupportActionBar().show();
        } else if (getSupportActionBar().isShowing() && !show) {
            getSupportActionBar().hide();
        }
    }

    @Override
    public void onSuggestShowAvailableBalance(boolean show) {
        if (show) {
            showBalanceHeader();
        } else {
            hideBalanceHeader();
        }
    }


    /**
     * To get the lockable master layout scroll view
     *
     * @return
     */
    public LockableScrollView getMasterScrollView() {
        return mContentScrollView;
    }

    /**
     * To lock the scroll view
     */
    protected void lockScrollView() {
        if (mContentScrollView != null) {
            mContentScrollView.setScrollContainer(false);
            mContentScrollView.setScrollingEnabled(false);
        }
    }

    /**
     * To unlock the scroll view
     */
    protected void unlockScrollView() {
        if (mContentScrollView != null) {
            mContentScrollView.setScrollContainer(true);
            mContentScrollView.setScrollingEnabled(true);
        }
    }

    @Override
    public void allowViewToScroll(boolean fragmentScrolling) {
        if (fragmentScrolling) {
            unlockScrollView();
        } else {
            lockScrollView();
        }
    }
/**
	 * Show activity loading display
	 */

    public void showLoadingDisplay() {
		if (mLoadingDisplay)
			return;
		mProgressBar.setVisibility(View.VISIBLE);
		mLoadingDisplay = true;
		mAnimSet = new AnimatorSet();
		mAnimSet.playTogether(ObjectAnimator.ofFloat(mContent, "alpha", 1.0f, 0.5f));
		mAnimSet.setDuration(ANIMATION_TRANSITION_DURATION).start();
		//lockOrientation();
		//lockTouchInput();
	}
	
	/**
	 * Hide activity loading display
	 */


    public void hideLoadingDisplay() {
		if (!mLoadingDisplay)
			return;
		mProgressBar.setVisibility(View.INVISIBLE);
		mLoadingDisplay = false;
		// setRequestedOrientation(mLastRequestedOrientation);
		mAnimSet = new AnimatorSet();
		mAnimSet.playTogether(ObjectAnimator.ofFloat(mContent, "alpha", 0.5f, 1.0f)// ,
		// ObjectAnimator.ofFloat(mContent, "rotationY", ANIMATION_ROTATION_AMT, 0)
		);
		//unLockOrientation();
		unlockTouchInput();
		mAnimSet.setDuration(ANIMATION_TRANSITION_DURATION).start();
	}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_popular_movies_base, menu);
        return true;
    }

    /**
     * To unlock the touch input of the view
     */
    protected void unlockTouchInput() {
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }


    /**
     * Action flow transition called before fragment swapping
     *
     * @param reverse
     */

    private void startTransitionDisplay(boolean reverse) {
        mAnimSet = new AnimatorSet();
        mAnimSet.playTogether(ObjectAnimator.ofFloat(mContent, "rotationY", 0, reverse ? ANIMATION_ROTATION_AMT * -1 : ANIMATION_ROTATION_AMT));
        mAnimSet.setDuration(ANIMATION_TRANSITION_DURATION).start();
    }


    /**
     * Action flow transition called after fragment swapping
     *
     * @param reverse
     */

    private void stopTransitionDisplay(boolean reverse) {
        mAnimSet = new AnimatorSet();
        mAnimSet.playTogether(ObjectAnimator.ofFloat(mContent, "rotationY", reverse ? ANIMATION_ROTATION_AMT * -1 : ANIMATION_ROTATION_AMT, 0));
        mAnimSet.setDuration(ANIMATION_TRANSITION_DURATION).start();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        onFragmentActionBack();
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}

