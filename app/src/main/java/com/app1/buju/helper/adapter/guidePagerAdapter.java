package com.app1.buju.helper.adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2016/12/13.
 */
public class guidePagerAdapter  extends PagerAdapter{
    private List<View> viewList;
    public guidePagerAdapter(List<View> list){

        this.viewList = list;
    }
    public int getCount(){
        if(viewList != null) {
            return viewList.size();
        }

            return 0;
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ((ViewPager)container).addView(viewList.get(position),0);
        return viewList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager)container).removeView(viewList.get(position));
    }
}
