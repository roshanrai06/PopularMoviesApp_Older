package com.nanodegree.roshan.popularmoviesapp;

import android.net.Uri;
import android.os.Bundle;

import com.nanodegree.roshan.popularmoviesapp.fragments.dashboard.PopularMoviesDashboardFragment;
import com.nanodegree.roshan.popularmoviesapp.fragments.details.PopularMoviesDetailsFragment;

public class PopularMoviesDashboardActivity extends PopularMoviesBaseActivity implements PopularMoviesDashboardFragment.PopularMoviesDashboardFragmentListener, PopularMoviesDetailsFragment.PopularMoviesDetailsFragmentListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        launchFragment(PopularMoviesDashboardFragment.newInstance());

    }


    @Override
    public void onDashboardButtonClicked() {
        launchFragment(PopularMoviesDetailsFragment.newInstance());

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}