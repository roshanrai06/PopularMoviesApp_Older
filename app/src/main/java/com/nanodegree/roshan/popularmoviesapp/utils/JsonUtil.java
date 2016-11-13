package com.nanodegree.roshan.popularmoviesapp.utils;

import android.content.Context;

import com.google.gson.Gson;
import com.nanodegree.roshan.popularmoviesapp.model.MoviesResults;

/**
 * Created by Roshan Rai on 8/23/2015.
 */
public class JsonUtil {

    public static String convertToJsonString(Context context, MoviesResults mMovieDetails) {
        Gson gson = new Gson();
        return gson.toJson(mMovieDetails);
    }

}
