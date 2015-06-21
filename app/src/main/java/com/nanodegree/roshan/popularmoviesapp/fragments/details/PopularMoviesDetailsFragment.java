package com.nanodegree.roshan.popularmoviesapp.fragments.details;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.nanodegree.roshan.popularmoviesapp.R;
import com.nanodegree.roshan.popularmoviesapp.fragments.base.PopularMoviesBaseFragment;


public class PopularMoviesDetailsFragment extends PopularMoviesBaseFragment<PopularMoviesDetailsFragment.PopularMoviesDetailsFragmentListener> {

    public static String FRAGMENT_TAG = "PopularMoviesDetailsFragment";


    public static PopularMoviesDetailsFragment newInstance() {
        PopularMoviesDetailsFragment fragment = new PopularMoviesDetailsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public PopularMoviesDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onInitFragment(View rootView, Bundle savedInstanceState) {
        return rootView;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_popular_movies_details;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public int getFragmentTitleResource() {
        return R.string.title_fragment_popular_movies_details;
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

        getCallback().onFragmentInteraction(uri);

    }

    @Override
    public String getFragmentTag() {
        return FRAGMENT_TAG;
    }


    public interface PopularMoviesDetailsFragmentListener extends PopularMoviesBaseFragment.PopularMoviesBaseFragmentListener {

         void onFragmentInteraction(Uri uri);
    }

}
