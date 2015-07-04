package com.nanodegree.roshan.popularmoviesapp.fragments.base;

/**
 * A placeholder fragment containing a simple view.
 */
public abstract class PopularMoviesBaseFragment<E extends PopularMoviesBaseFragment.PopularMoviesBaseFragmentListener> extends BaseActionFragment<E> {

    @Override
    public void onStart() {
        super.onStart();
        getCallback().onSuggestActionBar(suggestShowActionBar());

    }

    /**
     * To suggest whether action bar is to visible or hide
     */
    protected boolean suggestShowActionBar() {
        return true;
    }


    public interface PopularMoviesBaseFragmentListener extends BaseActionFragment.BaseActionFragmentListener {
        /**
         * Suggested action bar to be display
         */
        void onSuggestActionBar(boolean show);


    }
}