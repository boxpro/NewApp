package com.dev2048.app.newapp.base;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;


import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity implements AppLifeInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    @Override
    public void init() {
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initConifg() {

    }


}
