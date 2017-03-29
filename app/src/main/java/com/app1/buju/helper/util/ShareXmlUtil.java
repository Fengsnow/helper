package com.app1.buju.helper.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.app1.buju.helper.R;

/**
 * Created by Administrator on 2017/3/17.
 */
public class ShareXmlUtil {
    public ShareXmlUtil mSharedXmlUtil;
    private SharedPreferences mShared;
    private SharedPreferences.Editor mEditor;

    public ShareXmlUtil(Context context, String filename) {
        mShared = context.getSharedPreferences(filename, Context.MODE_PRIVATE);
        mEditor = mShared.edit();
    }

    public ShareXmlUtil(Context context) {
        mShared = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE);
        mEditor = mShared.edit();
    }

    public void write(String key, String value) {
        mEditor.putString(key, value);
        mEditor.commit();
    }

    public void write(String key, boolean value) {
        mEditor.putBoolean(key, value);
        mEditor.commit();
    }

    public void write(String key, int value) {
        mEditor.putInt(key, value);
        mEditor.commit();
    }

    public void write(String key, float value) {
        mEditor.putFloat(key, value);
        mEditor.commit();
    }

    public void write(String key, long value) {
        mEditor.putLong(key, value);
        mEditor.commit();
    }

    public String read(String key, String defValue) {
        return mShared.getString(key, defValue);
    }

    public boolean read(String key, boolean defValue) {
        return mShared.getBoolean(key, defValue);
    }

    public int read(String key, int defValue) {
        return mShared.getInt(key, defValue);
    }

    public float read(String key, float defValue) {
        return mShared.getFloat(key, defValue);
    }

    public long read(String key, long defValue) {
        return mShared.getLong(key, defValue);
    }

    public void delete(String key) {
        mEditor.remove(key);
        mEditor.commit();
    }
}
