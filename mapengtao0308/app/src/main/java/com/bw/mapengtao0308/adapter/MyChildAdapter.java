package com.bw.mapengtao0308.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.mapengtao0308.R;
import com.bw.mapengtao0308.bean.List;

import java.util.ArrayList;

/**
 * Time:2019.03.08--14:17
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class MyChildAdapter extends RecyclerView.Adapter<MyChildAdapter.MyViewHolder> {

    Context context;
    ArrayList<List> list;

    public MyChildAdapter(Context context, ArrayList<List> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.child_layout, null, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        List list = this.list.get(i);
        myViewHolder.child_price.setText("¥:" + list.getPrice());
        myViewHolder.child_title.setText(list.getTitle());

        Glide.with(context).load(list.getDetailUrl()).into(myViewHolder.child_image);


//      选中状态
        myViewHolder.child_checkbox.setChecked(list.isChildCheck());
        myViewHolder.child_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (checkLisenter != null) {
                    checkLisenter.Check();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setCheck(boolean checked) {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setChildCheck(checked);
            notifyDataSetChanged();
        }
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView child_image;
        private final TextView child_title;
        private final TextView child_price;
        private final CheckBox child_checkbox;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            child_image = itemView.findViewById(R.id.child_image);
            child_title = itemView.findViewById(R.id.child_title);
            child_price = itemView.findViewById(R.id.child_price);
            child_checkbox = itemView.findViewById(R.id.child_checkbox);
        }
    }

    //    条盲目点击事件
    public interface onChildCheckLisenter {

        void Check();
    }

    public onChildCheckLisenter checkLisenter;

    public void setCheckLisenter(onChildCheckLisenter onCheckLisenter) {
        this.checkLisenter = onCheckLisenter;
    }
}
