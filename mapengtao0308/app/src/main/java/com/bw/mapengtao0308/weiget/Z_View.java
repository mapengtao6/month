package com.bw.mapengtao0308.weiget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bw.mapengtao0308.R;

/**
 * Time:2019.03.08--14:33
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class Z_View extends LinearLayout implements View.OnClickListener {

    int number = 1;
    private EditText mum_goods;

    public Z_View(Context context) {
        super(context);
    }

    public Z_View(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.z_view, this);
//        找控件
        Button min_goods = findViewById(R.id.min_goods);
        Button add_goods = findViewById(R.id.add_goods);

        mum_goods = findViewById(R.id.num_goods);

        mum_goods.setText(number + "");

//        设置点击事件
        min_goods.setOnClickListener(this);
        add_goods.setOnClickListener(this);

    }

    public Z_View(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.add_goods:
                number++;
                mum_goods.setText(number + "");
                if (numChangeLisenter != null) {
                    numChangeLisenter.changeNum(number);
                }
                break;

            case R.id.min_goods:
                if (number>1){
                    number--;
                    mum_goods.setText(number+"");
                    if (numChangeLisenter!= null){
                        numChangeLisenter.changeNum(number);
                    }
                }else {
                    Toast.makeText(getContext(), "不能再少了~", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    //    创建接口
    public interface onNumChangeLisenter {
        void changeNum(int num);
    }

    public onNumChangeLisenter numChangeLisenter;

    public void setNumChangeLisenter(onNumChangeLisenter onNumChangeLisenter) {
        this.numChangeLisenter = onNumChangeLisenter;
    }
}
