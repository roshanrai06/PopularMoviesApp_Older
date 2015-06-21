package com.nanodegree.roshan.popularmoviesapp.fragments.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.nanodegree.roshan.popularmoviesapp.BaseActivity;
import com.nanodegree.roshan.popularmoviesapp.interfaces.BaseFragmentInterface;

/**
 * A placeholder fragment containing a simple view.
 */
public abstract class BaseFragment<E extends BaseFragment.BaseFragmentListener> extends Fragment implements BaseFragmentInterface {


    protected E mCallback;
    protected BaseActivity mActivity;


    public abstract View onInitFragment(View rootView, Bundle savedInstanceState);


    public abstract int getLayout();


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        if (!ensureActivityImplementsCallback())
            return;
        try {
            mCallback = (E) activity;
            mActivity = (BaseActivity) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement BaseFragmentListener");
        }
    }

    public interface BaseFragmentListener {
        public void dismissKeyboard(View viewHoldingKeyboardForum);

        public void showKeyboard(EditText editText);


        public void showToast(String message);

        public void restorePreviousActionBarColors(int color);
    }

    public void showBackButton() {
        if (mActivity instanceof BaseActivity) {
            ((BaseActivity) mActivity).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    public E getCallback() {
        return mCallback;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setRetainInstance(true);
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    protected boolean ensureActivityImplementsCallback() {
        return true;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayout(), container, false);
        onInitFragment(rootView, savedInstanceState);
        return rootView;
    }
}