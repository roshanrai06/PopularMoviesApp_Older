package com.nanodegree.roshan.popularmoviesapp;

import android.os.Bundle;
import android.view.Menu;

import com.nanodegree.roshan.popularmoviesapp.fragments.details.PopularMoviesDetailsFragment;

public class PopularMoviesDetailsActivity extends PopularMoviesBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            Bundle args = getIntent().getExtras();
            args.getParcelable("movie_result");
            launchFragment(PopularMoviesDetailsFragment.newInstance(args));

        }

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return false;
    }


}
