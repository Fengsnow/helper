package com.app1.buju.helper.activity;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.app1.buju.helper.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements android.view.View.OnClickListener{


    private ViewPager mViewPager;//放置界面转换
    private PagerAdapter mPagerAdapter;//初始化view适配器
    private List<View> mViews = new ArrayList<View>();//存放page1-3

    //3个包，每个包包含一个按钮
    private LinearLayout mFirst;
    private LinearLayout mSecond;
    private LinearLayout mThird;
    //3个按钮
    private ImageButton mFirstImg;
    private ImageButton mSecondImg;
    private ImageButton mThirdImg;
    //3个按钮
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initViewPage();
        initEvent();
    }

    private void initEvent() {
        mFirst.setOnClickListener(this);
        mSecond.setOnClickListener(this);
        mThird.setOnClickListener(this);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            //左右滑动时
            @Override
            public void onPageSelected(int arg0) {
                int currentItem = mViewPager.getCurrentItem();
                switch (currentItem){
                    case 0:
                        resetImg();
                        mFirstImg.setImageResource(R.drawable.editpressed);
                        break;
                    case 1:
                        resetImg();
                        mSecondImg.setImageResource(R.drawable.formpressed);

                        break;
                    case 2:
                        resetImg();
                        mThirdImg.setImageResource(R.drawable.setpressed);
                        break;
                    default:
                        break;

                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initViewPage() {
        //初始化3个布局
        LayoutInflater mLayoutInflater = LayoutInflater.from(this);
        View page_01 = mLayoutInflater.inflate(R.layout.activity_first,null);
        View page_02 = mLayoutInflater.inflate(R.layout.activity_second,null);
        View page_03 = mLayoutInflater.inflate(R.layout.activity_third,null);

        mViews.add(page_01);
        mViews.add(page_02);
        mViews.add(page_03);

        //适配器初始化并设置
        mPagerAdapter = new PagerAdapter() {
            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                container.removeView(mViews.get(position));

            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = mViews.get(position);
                container.addView(view);
                return view;
            }

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {

                return arg0 == arg1;
            }

            @Override
            public int getCount() {

                return mViews.size();
            }
        };
        mViewPager.setAdapter(mPagerAdapter);
    }




    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.id_viewpage);
        //初始化3个LInearLayout
        mFirst = (LinearLayout) findViewById(R.id.ll_first);
        mSecond = (LinearLayout) findViewById(R.id.ll_second);
        mThird = (LinearLayout) findViewById(R.id.ll_third);
        //初始化3个按钮
        mFirstImg = (ImageButton) findViewById(R.id.ib_first);
        mSecondImg = (ImageButton) findViewById(R.id.ib_second);
        mThirdImg = (ImageButton) findViewById(R.id.ib_third);
    }
    //按钮点击切换界面改变图片
    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()){
            case R.id.ll_first:
                mViewPager.setCurrentItem(0);
                resetImg();
                mFirstImg.setImageResource(R.drawable.editpressed);
                break;
            case R.id.ll_second:
                mViewPager.setCurrentItem(1);
                resetImg();
                mSecondImg.setImageResource(R.drawable.formpressed);
                break;
            case R.id.ll_third:
                mViewPager.setCurrentItem(3);
                resetImg();
                mThirdImg.setImageResource(R.drawable.setpressed);
                break;
            default:
                break;

        }


    }
    private void resetImg() {
        mFirstImg.setImageResource(R.drawable.edit);
        mSecondImg.setImageResource(R.drawable.form);
        mThirdImg.setImageResource(R.drawable.set);


    }
}
