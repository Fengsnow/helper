package com.app1.buju.helper.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.app1.buju.helper.R;

/**
 * Created by Administrator on 2016/12/10.
 */
public class ShareUtil {
    private SharedPreferences mPreferencrs;
    private SharedPreferences.Editor mEditor;

    public ShareUtil (Context context){
        mPreferencrs = context.getSharedPreferences(context.getString(R.string.app_name),Context.MODE_PRIVATE);
        mEditor = mPreferencrs.edit();
    }
    public void write(String key,boolean value){
        mEditor.putBoolean(key,value);
        mEditor.commit();
    }
    public boolean read(String key,boolean defValue){
        return mPreferencrs.getBoolean(key, defValue);
    }
}
