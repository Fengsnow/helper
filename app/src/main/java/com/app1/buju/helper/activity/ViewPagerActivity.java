package com.app1.buju.helper.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.app1.buju.helper.R;
import com.app1.buju.helper.adapter.guidePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {


    private Button mButton;
    private ViewPager mViewPager;
    private ViewGroup mViewGroup;
    //图片数组
    private int[] mImageIdArray;
    private List<View> mViewList;

    private ImageView mImageView;
    private ImageView[] mImageViewArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        mViewPager = (ViewPager)findViewById(R.id.first_viewpager);
        mViewGroup = (ViewGroup)findViewById(R.id.viewpager_tag);


        mButton = (Button)findViewById(R.id.view_pager_button);
       // Intent i = new ViewPagerActivity()
        mButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(ViewPagerActivity.this,LoginActivity.class));
            }

        });
        //加载viewpage
        initViewPager();
        //加载圆点
        initViewPagerTag();
    }

    private void initViewPagerTag() {
        mImageViewArray = new ImageView[mViewList.size()];

        for(int i = 0;i<mViewList.size();i++){
            mImageView = new ImageView(this);
            mImageView.setLayoutParams(new ViewGroup.MarginLayoutParams(40,40));
            mImageView.setPadding(30,0,30,0);
            mImageViewArray[i] = mImageView;
            if(i==0){
                mImageView.setBackgroundResource(R.drawable.tagon);
            }else{
                mImageView.setBackgroundResource(R.drawable.tagoff);
            }

            mViewGroup.addView(mImageViewArray[i]);
        }
    }

    private void initViewPager() {
        mImageIdArray = new int[]{R.drawable.guide2,R.drawable.guide1,R.drawable.guide3};
        mViewList = new ArrayList<View>();
        //获取一个参数
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);

        //循环创建view
        for(int i = 0;i<mImageIdArray.length;i++){
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(params);
            imageView.setBackgroundResource(mImageIdArray[i]);

            mViewList.add(imageView);
        }
        mViewPager.setAdapter(new guidePagerAdapter(mViewList));

        mViewPager.addOnPageChangeListener(this);




    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for(int i = 0;i<mImageViewArray.length;i++){
            mImageViewArray[position].setBackgroundResource(R.drawable.tagon);
            if(position != i){
                mImageViewArray[i].setBackgroundResource(R.drawable.tagoff);
            }
        }
        //通过判断显示按钮
        if(position == mImageIdArray.length-1){
            mButton.setVisibility(View.VISIBLE);
        }else{
            mButton.setVisibility(View.GONE);
        }
    }



    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
