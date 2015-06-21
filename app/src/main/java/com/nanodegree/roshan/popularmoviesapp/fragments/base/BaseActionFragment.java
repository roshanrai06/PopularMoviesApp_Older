package com.nanodegree.roshan.popularmoviesapp.fragments.base;

import android.os.Bundle;
import android.util.Log;

import com.nanodegree.roshan.popularmoviesapp.interfaces.BaseActionFragmentInterface;

public abstract class BaseActionFragment<E extends BaseActionFragment.BaseActionFragmentListener> extends BaseFragment<E> implements BaseActionFragmentInterface {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    public abstract int getFragmentTitleResource();


    public interface BaseActionFragmentListener extends BaseFragmentListener {
        /**
         * Let the activity know we want to pop the stack
         */
        public void onFragmentActionBack();

        /**
         * Let the activity know we want to finish the flow
         */
        public void onFragmentActionFinish();

        /**
         * Suggested ActionBar display to activity
         */
        public void onRequestDisplayHomeAsUpEnabled(boolean value);

        /**
         * Suggested ActionBar display to activity
         */
        public void onRequestDisplayShowHomeEnabled(boolean value);

        /**
         * Suggested ActionBar title display
         */
        public void onRequestTitleUpdate(int titleResource);

        /**
         * Suggested ActionBar title display
         */
        public void onRequestTitleUpdate(String titleResource);
    }

    @Override
    public void onBackClicked() {
Log.d("Roshan","BackLicked");
        getFragmentManager().popBackStackImmediate();



    }

    @Override
    public void onHomeLogoClick() {
        Log.d("Roshan","UpperBackLicked");
    }
}