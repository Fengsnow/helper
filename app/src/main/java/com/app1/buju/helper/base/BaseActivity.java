package com.app1.buju.helper.base;


import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2016/12/7.
 */
public abstract class BaseActivity extends AppCompatActivity{

    protected  void onCreate(android.os.Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }
    protected abstract void initView();
    protected abstract void initData();
}
