package com.nanodegree.roshan.popularmoviesapp.fragments.base;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public abstract class PopularMoviesBaseFragment<E extends PopularMoviesBaseFragment.PopularMoviesBaseFragmentListener> extends BaseActionFragment<E> {

    @Override
    public void onStart() {
        super.onStart();
        getCallback().onSuggestActionBar(suggestShowActionBar());
        getCallback().onSuggestShowAvailableBalance(showAvailableBalance());
       
    }

    /**
     * To suggest whether action bar is to visible or hide
     *
     * @return
     */
    protected boolean suggestShowActionBar() {
        return true;
    }

    /**
     * To suggest whether view is scrollable or not
     *
     * @return
     */
    protected boolean allowViewToScroll() {
        return true;
    }

    /**
     * To suggest whether available balance balance is to shown or not
     *
     * @return
     */
    protected boolean showAvailableBalance() {
        return false;
    }

    /**
     * To get the Error string
     *
     * @param errors
     * @return
     */
    public String getErrorString(List<String> errors) {
        StringBuilder sb = new StringBuilder();
        int noOfLine = errors.size();
        for (String e : errors) {
            if (noOfLine == 1) {
                sb.append(e);
            } else {
                sb.append(e + "\n");
            }
        }
        return sb.toString();
    }

    public interface PopularMoviesBaseFragmentListener extends BaseActionFragment.BaseActionFragmentListener {
        /**
         * Suggested action bar to be display
         *
         * @param show
         */
        public void onSuggestActionBar(boolean show);

        /**
         * Suggested available balance to be display
         *
         * @param show
         */
        public void onSuggestShowAvailableBalance(boolean show);


    }
}