package com.app1.buju.helper.base;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Administrator on 2016/12/14.
 */
public class BaseApplication extends Application {
     public void onCreate(){
         super.onCreate();

         x.Ext.init(this);
     }
}
