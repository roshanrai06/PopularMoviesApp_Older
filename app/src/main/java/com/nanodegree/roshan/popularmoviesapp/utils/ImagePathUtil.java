package com.nanodegree.roshan.popularmoviesapp.utils;

import android.content.Context;

import com.nanodegree.roshan.popularmoviesapp.R;

/**
 * Created by Roshan Rai on 7/6/2015.
 */
public class ImagePathUtil {
    public static String getMovieImagePosterPath(Context context, String imagePosterPath) {
        if (Connectivity.isConnectedFast(context)) {
            imagePosterPath = context.getResources().getString(R.string.image_base_url_normal) + imagePosterPath;
        } else {
            imagePosterPath = context.getResources().getString(R.string.image_base_url_low) + imagePosterPath;

        }
        return imagePosterPath;

    }

    public static String getMovieImageBackDropPath(Context context, String imageBackDropPath) {
        if (Connectivity.isConnectedFast(context)) {
            imageBackDropPath = context.getResources().getString(R.string.image_base_url_high) + imageBackDropPath;
        } else {
            imageBackDropPath = context.getResources().getString(R.string.image_base_url_normal) + imageBackDropPath;

        }
        return imageBackDropPath;

    }
}
