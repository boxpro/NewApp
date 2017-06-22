package com.dev2048.app.newapp.base;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment extends Fragment {
    public Activity mActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity= getActivity();
        init();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(setLayout(), container, false);
    }
    private void init(){
        initConfig();
        initData();
        initView();
    }

    protected abstract int setLayout ();
    protected abstract void initView();
    protected abstract void initData();
    protected abstract void initConfig();




}
