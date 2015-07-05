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

        return getTypeOfStringTitle((getArguments().getString("sort_by")));
    }

    private int getTypeOfStringTitle(String title) {
        int typeOfTitle;
        switch (title) {
            case "popularity.desc":
                typeOfTitle = R.string.popular_movies_fragment_title;
                break;
            case "vote_average.desc":
                typeOfTitle = R.string.popular_movies_fragment_title_by_ratings;
                break;
            case "revenue.desc":
                typeOfTitle = R.string.popular_movies_fragment_title_by_revenue;
                break;

            default:
                typeOfTitle = R.string.popular_movies_fragment_title;
        }
        return typeOfTitle;
    }


    public interface PopularMoviesDashboardFragmentListener extends PopularMoviesBaseFragment.PopularMoviesBaseFragmentListener {

        void onDashboardButtonClicked();
    }

    @Override
    public void onBackClicked() {
        getCallback().onFragmentActionFinish();
    }
}