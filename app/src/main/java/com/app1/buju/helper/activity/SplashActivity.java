package com.app1.buju.helper.activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app1.buju.helper.R;
import com.app1.buju.helper.util.ShareUtil;
import com.app1.buju.helper.base.BaseActivity;

public class SplashActivity extends BaseActivity {

    private static final int SPLASH_START_TIME = 2000;
    private static final String FIRST_RUN_APP = "firstapp";
    private TextView mVersionname;
    @Override

    protected void initView() {
        setContentView(R.layout.activity_splash);
        mVersionname = (TextView) findViewById(R.id.tv_versionname);
        final ShareUtil mShareUtil = new ShareUtil(this);
        mVersionname.setText("当前版本:  "+getVersionName());




        final boolean first = mShareUtil.read(FIRST_RUN_APP,true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(first){
                    mShareUtil.write(FIRST_RUN_APP,false);
                    //跳转到引导页
                    Intent i = new Intent();
                    i.setClass(SplashActivity.this,ViewPagerActivity.class);
                    startActivity(i);
                    SplashActivity.this.finish();
                }
                else {
                    //跳转到首页
                    Intent i = new Intent();
                    i.setClass(SplashActivity.this,LoginActivity.class);
                    startActivity(i);
                    SplashActivity.this.finish();
                }

            }
        },SPLASH_START_TIME);
        //加入动画效果
        AlphaAnimation alphaAnimation = new AlphaAnimation(0,1);
        alphaAnimation.setDuration(2000);
        RelativeLayout layout = (RelativeLayout)findViewById(R.id.splash_layout);
        layout.startAnimation(alphaAnimation);

    }
    protected void initData(){}


    private String getVersionName() {
        PackageManager packageManger = getPackageManager();
        //从包的管理者对象中，获取指定包名的基本信息，包括版本名称和版本号，传0代表基本信息
        try {
            PackageInfo packageinfo = packageManger.getPackageInfo(getPackageName(),0);
            String versionName =packageinfo.versionName;
            return  versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }


}
