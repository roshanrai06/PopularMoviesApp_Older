package com.nanodegree.roshan.popularmoviesapp.fragments.dashboard;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import com.nanodegree.roshan.popularmoviesapp.R;
import com.nanodegree.roshan.popularmoviesapp.adapters.ImageAdapter;
import com.nanodegree.roshan.popularmoviesapp.fragments.base.PopularMoviesBaseFragment;

import butterknife.Bind;

public class PopularMoviesDashboardFragment extends PopularMoviesBaseFragment<PopularMoviesDashboardFragment.PopularMoviesDashboardFragmentListener> {


    public static String FRAGMENT_TAG = "PopularMoviesDashboardFragment";
    @Bind(R.id.gridview)
    protected GridView gridview;

    public static PopularMoviesDashboardFragment newInstance() {
        PopularMoviesDashboardFragment fragment = new PopularMoviesDashboardFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
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
        gridview.setAdapter(new ImageAdapter(getActivity()));
        return rootView;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_movies_dashboard;
    }


    @Override
    public int getFragmentTitleResource() {
        return R.string.hello_blank_fragment;
    }


    public interface PopularMoviesDashboardFragmentListener extends PopularMoviesBaseFragment.PopularMoviesBaseFragmentListener {

        void onDashboardButtonClicked();
    }

    @Override
    public void onBackClicked() {
        getCallback().onFragmentActionFinish();
    }
}