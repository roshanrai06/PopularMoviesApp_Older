package com.nanodegree.roshan.popularmoviesapp.interfaces;

/**
 * Created by roshan.rai on 6/20/2015.
 */
public interface BaseActionFragmentInterface {
    /**
     * Activity will call this if it want to ask the fragment for navigation advice
     */
    public abstract void onBackClicked();
    /**
     * Activity will call this if it want to ask the fragment for navigation advice
     */
    public abstract void onHomeLogoClick();
    /**
     * Suggested ActionBar title resource
     */
    public abstract int getFragmentTitleResource();
}
