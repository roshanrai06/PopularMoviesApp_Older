package com.nanodegree.roshan.popularmoviesapp;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.nanodegree.roshan.popularmoviesapp.fragments.dashboard.PopularMoviesDashboardFragment;
import com.nanodegree.roshan.popularmoviesapp.fragments.details.PopularMoviesDetailsFragment;
import com.nanodegree.roshan.popularmoviesapp.model.GetMoviesResponse;
import com.nanodegree.roshan.popularmoviesapp.model.MoviesResults;
import com.nanodegree.roshan.popularmoviesapp.movieapi.MoviesAPI;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class PopularMoviesDashboardActivity extends PopularMoviesBaseActivity implements PopularMoviesDashboardFragment.PopularMoviesDashboardFragmentListener, PopularMoviesDetailsFragment.PopularMoviesDetailsFragmentListener {
    public final String movie_list = "movie_list";
    ArrayList<String> mPosterPaths;
    private static final String TAG = PopularMoviesDashboardActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            requestMoviesDetails();
        }


    }

    @Override
    protected void setupActionBar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    private void requestMoviesDetails() {
        RestAdapter restAdapter;
        //TODO Save it in persistence
        String sort_by = "popularity.desc";
        restAdapter = new RestAdapter.Builder().setEndpoint(getString(R.string.base_url)).build();
        MoviesAPI moviesAPI = restAdapter.create(MoviesAPI.class);
        showLoadingDisplay();
        moviesAPI.getMovieList(sort_by, getString(R.string.api_key), new Callback<GetMoviesResponse>() {
            @Override
            public void success(GetMoviesResponse moviesResponse, Response response) {
                hideLoadingDisplay();
                final List<MoviesResults> results = moviesResponse.getMoviesResults();
                Log.d(TAG, "" + moviesResponse.getMoviesResults().size());
                mPosterPaths = new ArrayList<>();
                for (int i = 0; i < moviesResponse.getMoviesResults().size(); i++) {
                    MoviesResults moviesResult = results.get(i);
                    mPosterPaths.add(moviesResult.getPosterPath());
                }
                Bundle args = new Bundle();
                args.putStringArrayList(movie_list, mPosterPaths);
                launchFragment(PopularMoviesDashboardFragment.newInstance(args));
            }

            @Override
            public void failure(RetrofitError error) {
                hideLoadingDisplay();
                error.printStackTrace();
            }
        });
    }


    @Override
    public void onSuggestShowAvailableBalance(boolean show) {
        super.onSuggestShowAvailableBalance(true);
    }

    @Override
    public void onDashboardButtonClicked() {
        launchFragment(PopularMoviesDetailsFragment.newInstance());

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}