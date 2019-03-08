package com.bw.mapengtao0308.weiget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.bw.mapengtao0308.R;

/**
 * Time:2019.03.08--15:30
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class CustView extends RelativeLayout {
    public CustView(Context context) {
        super(context);
    }

    public CustView(Context context, AttributeSet attrs) {
        super(context, attrs);

//        布局
        LayoutInflater.from(context).inflate(R.layout.cust_layout,this);

    }

    public CustView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
