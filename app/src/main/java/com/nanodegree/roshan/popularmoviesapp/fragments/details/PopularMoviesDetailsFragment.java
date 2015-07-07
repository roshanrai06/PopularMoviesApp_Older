package com.nanodegree.roshan.popularmoviesapp.fragments.details;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nanodegree.roshan.popularmoviesapp.R;
import com.nanodegree.roshan.popularmoviesapp.fragments.base.PopularMoviesBaseFragment;
import com.nanodegree.roshan.popularmoviesapp.model.MoviesResults;
import com.nanodegree.roshan.popularmoviesapp.utils.ImagePathUtil;
import com.squareup.picasso.Picasso;

import butterknife.Bind;


public class PopularMoviesDetailsFragment extends PopularMoviesBaseFragment<PopularMoviesDetailsFragment.PopularMoviesDetailsFragmentListener> {

    public static String FRAGMENT_TAG = "PopularMoviesDetailsFragment";
    @Bind(R.id.movie_title)
    TextView mMovieTitle;
    @Bind(R.id.movie_rating)
    TextView mMovieRating;
    @Bind(R.id.movie_overview)
    TextView mMovieOverview;
    @Bind(R.id.movie_release_date)
    TextView mMovieRelease;
    @Bind(R.id.movie_backdrop_image)
    ImageView mBackDropImageView;
    @Bind(R.id.movie_poster)
    ImageView mPosterImageView;
    MoviesResults mMoviesResults;

    public static PopularMoviesDetailsFragment newInstance(Bundle args) {
        PopularMoviesDetailsFragment fragment = new PopularMoviesDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }


    public PopularMoviesDetailsFragment() {
    }

    @Override
    public View onInitFragment(View rootView, Bundle savedInstanceState) {


        mMovieTitle.setText(mMoviesResults.getTitle());

        if (mMoviesResults.getVoteAverage() != null) {
            mMovieRating.setText(getResources().getString(R.string.rating) + mMoviesResults.getVoteAverage().toString());

        } else {
            mMovieRating.setText(getResources().getString(R.string.rating) + getResources().getString(R.string.na));
        }
        if ((mMoviesResults.getOverview() != null)) {
            mMovieOverview.setText(mMoviesResults.getOverview());
        } else {
            mMovieOverview.setText(getResources().getString(R.string.na));
        }

        if (mMoviesResults.getReleaseDate() != null) {
            mMovieRelease.setText(getResources().getString(R.string.release_date) + mMoviesResults.getReleaseDate());

        } else {
            mMovieRelease.setText(getResources().getString(R.string.release_date) + getResources().getString(R.string.na));

        }
        Picasso.with(getActivity()).load((ImagePathUtil.getMovieImageBackDropPath(getActivity(), mMoviesResults.getBackdropPath()))).placeholder(R.drawable.loading_image_back_path).error(R.drawable.loading_image_error_place_holder).into(mBackDropImageView);
        Picasso.with(getActivity()).load((ImagePathUtil.getMovieImagePosterPath(getActivity(), mMoviesResults.getPosterPath()))).placeholder(R.drawable.loading_image_placeholder).error(R.drawable.loading_image_error_place_holder).into(mPosterImageView);


        return rootView;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_popular_movies_details;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
        mMoviesResults = getArguments().getParcelable("movie_result");

    }

    @Override
    public int getFragmentTitleResource() {
        return R.string.title_fragment_popular_movies_details;
    }


    @Override
    public String getFragmentTag() {
        return FRAGMENT_TAG;
    }


    public interface PopularMoviesDetailsFragmentListener extends PopularMoviesBaseFragment.PopularMoviesBaseFragmentListener {

        // void onFragmentPlayTrailer(Uri uri);
    }

}
