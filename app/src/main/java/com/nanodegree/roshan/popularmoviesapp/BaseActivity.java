package com.nanodegree.roshan.popularmoviesapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.nanodegree.roshan.popularmoviesapp.fragments.base.BaseFragment;
import com.nanodegree.roshan.popularmoviesapp.interfaces.BaseFragmentInterface;

public abstract class BaseActivity extends AppCompatActivity implements BaseFragment.BaseFragmentListener {

    protected Handler mHandler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(getTransitionIn(), getTransitionOut());

    }


    @Override
    public void showToast(String message) {

    }


    protected void launchFragment(final Fragment fragment, final int fragmentReplaceId, final int animationIn, final int animationOut, final int popAnimationIn, final int popAnimationOut) {
        handleLaunchFragment(fragment, fragmentReplaceId, animationIn, animationOut, popAnimationIn, popAnimationOut);
    }

    private void handleLaunchFragment(Fragment fragment, int fragmentReplaceId, int animationIn, int animationOut, int popAnimationIn, int popAnimationOut) {
        String fragmentTag = getFragmentTag(fragment);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.addToBackStack(fragmentTag);
        ft.setCustomAnimations(animationIn, animationOut, popAnimationIn, popAnimationOut);
        ft.replace(fragmentReplaceId, fragment, fragmentTag);
        try {
            ft.commitAllowingStateLoss();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    protected String getFragmentTag(Fragment fragment) {
        if (fragment instanceof BaseFragmentInterface) {
            return ((BaseFragmentInterface) fragment).getFragmentTag();
        } else {
            return fragment.getClass().getSimpleName();
        }
    }

    protected int getTransitionIn() {
        return android.R.anim.fade_in;
    }

    protected int getTransitionOut() {
        return android.R.anim.fade_out;
    }

    protected abstract int getFragmentContentFrameResourceID();

    @Override
    public void finish() {

        super.finish();
        overridePendingTransition(getTransitionIn(), getTransitionOut());
    }


    @Override
    public void startActivityForResult(Intent intent, int requestCode) {

        super.startActivityForResult(intent, requestCode);
        overridePendingTransition(getTransitionIn(), getTransitionOut());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_base, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
