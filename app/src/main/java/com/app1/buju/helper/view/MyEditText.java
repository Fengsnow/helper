package com.app1.buju.helper.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.EditText;

import com.app1.buju.helper.R;

/**
 * Created by Administrator on 2017/3/14.
 */
public class MyEditText extends EditText{
    private Drawable mDrawable;
    private Context mContext;
    //画笔
    private Paint mPaint;
    private int color;

    private boolean hasFocus = false;
    public MyEditText(Context context) {
        super(context);
        mContext = context;
        initview();
    }

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initview();
    }

    private void initview() {
        mDrawable = getResources().getDrawable(R.mipmap.sign_check2x);

        //开始画线
        mPaint = new Paint();
        mPaint.setStrokeWidth(3.0f);
        color = Color.parseColor("#bfbfbf");

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setColor(color);
        int x = this.getScrollX();
        int w = this.getMeasuredWidth();

        canvas.drawLine(0,this.getHeight() - 1,w+x,this.getHeight()-1,mPaint);
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);

        this.hasFocus = focused;
        if(focused){
            setColor(Color.parseColor("#00c17c"));
        }else{
            setColor(Color.parseColor("#bfbfbf"));

        }
    }

    private void setColor(int i) {
        this.color = i;
        this.setTextColor(color);
        invalidate();;
    }

    public void setImageVisible(boolean isVisible){
        if(isVisible){
            setCompoundDrawablesWithIntrinsicBounds(null,null,mDrawable,null);
        }else{
            setCompoundDrawablesWithIntrinsicBounds(null,null,null,null);
        }
    }
   protected void finalize() throws Throwable{
        super.finalize();
    }
}
