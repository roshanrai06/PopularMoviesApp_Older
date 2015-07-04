package com.nanodegree.roshan.popularmoviesapp.movieapi;

import com.nanodegree.roshan.popularmoviesapp.model.GetMoviesResponse;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by roshan.rai on 7/4/2015.
 */
public interface MoviesAPI {
    @GET("/discover/movie")
    public void getMovieList(@Query("sort_by") String sort_by,@Query("api_key") String api_key, Callback<GetMoviesResponse> cb);

//    @GET("/movie/{id}/videos")
//    public void getMovieTrailers(@Path("id") String id,@Query("api_key") String api_key, Callback<MovieTrailers> cb);
//
//    @GET("/movie/{id}/reviews")
//    public void getMovieReviews(@Path("id") String id,@Query("api_key") String api_key, Callback<MovieReviews> cb);
}
