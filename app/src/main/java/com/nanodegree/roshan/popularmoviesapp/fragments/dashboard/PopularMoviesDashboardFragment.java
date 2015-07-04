package com.nanodegree.roshan.popularmoviesapp.fragments.dashboard;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import com.nanodegree.roshan.popularmoviesapp.R;
import com.nanodegree.roshan.popularmoviesapp.adapters.ImageAdapter;
import com.nanodegree.roshan.popularmoviesapp.fragments.base.PopularMoviesBaseFragment;

import java.util.ArrayList;

import butterknife.Bind;

public class PopularMoviesDashboardFragment extends PopularMoviesBaseFragment<PopularMoviesDashboardFragment.PopularMoviesDashboardFragmentListener> {


    public static String FRAGMENT_TAG = "PopularMoviesDashboardFragment";
    @Bind(R.id.gridview)
    protected GridView gridview;
    ArrayList<String> items;


    public static PopularMoviesDashboardFragment newInstance(Bundle args) {
        PopularMoviesDashboardFragment fragment = new PopularMoviesDashboardFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected boolean requestDisplayHomeAsUpEnabled() {
        return false;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public PopularMoviesDashboardFragment() {

    }

    @Override
    public String getFragmentTag() {
        return FRAGMENT_TAG;
    }


    @Override
    public View onInitFragment(View rootView, Bundle savedInstanceState) {
        items = getArguments().getStringArrayList("movie_list");
        gridview.setAdapter(new ImageAdapter(getActivity(), items));
        return rootView;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_movies_dashboard;
    }


    @Override
    public int getFragmentTitleResource() {
        return R.string.popular_movies_fragment_title;
    }


    public interface PopularMoviesDashboardFragmentListener extends PopularMoviesBaseFragment.PopularMoviesBaseFragmentListener {

        void onDashboardButtonClicked();
    }

    @Override
    public void onBackClicked() {
        getCallback().onFragmentActionFinish();
    }
}