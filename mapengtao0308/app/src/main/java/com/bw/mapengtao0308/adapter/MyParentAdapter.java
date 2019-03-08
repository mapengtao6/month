package com.bw.mapengtao0308.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bw.mapengtao0308.R;
import com.bw.mapengtao0308.bean.Data;
import com.bw.mapengtao0308.bean.List;

import java.util.ArrayList;

/**
 * Time:2019.03.08--14:11
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class MyParentAdapter extends RecyclerView.Adapter<MyParentAdapter.MyViewHolder> {

    Context context;
    ArrayList<Data> data;

    public MyParentAdapter(Context context, ArrayList<Data> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.parent_layout, null, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {

        final Data data = this.data.get(i);
        myViewHolder.parent_title.setText(data.getSellerName());

//        样式
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        myViewHolder.rlv2.setLayoutManager(linearLayoutManager);

        final ArrayList<List> list = data.getList();

        final MyChildAdapter myChildAdapter = new MyChildAdapter(context, list);
        myViewHolder.rlv2.setAdapter(myChildAdapter);

//        子选项控制父选项
        myChildAdapter.setCheckLisenter(new MyChildAdapter.onChildCheckLisenter() {
            @Override
            public void Check() {

                if (parentCheckLisenter != null) {
                    parentCheckLisenter.onCheck(data);
                }

                boolean value = true;
                for (int j = 0; j < list.size(); j++) {
                    boolean childCheck = list.get(j).isChildCheck();
                    if (!childCheck){
                        value = false;
                        break;
                    }
                }
                data.setParentCheck(value);
                myViewHolder.parent_check.setChecked(value);
            }
        });

//        父选项控制子选项
        myViewHolder.parent_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.setParentCheck(myViewHolder.parent_check.isChecked());
                myChildAdapter.setCheck(myViewHolder.parent_check.isChecked());
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView parent_title;
        private final RecyclerView rlv2;
        private final CheckBox parent_check;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            parent_title = itemView.findViewById(R.id.parent_title);
            rlv2 = itemView.findViewById(R.id.rlv2);
            parent_check = itemView.findViewById(R.id.parent_check);
        }
    }


    //    接口回调
    public interface onParentCheckLisenter {
        void onCheck(Data data);
    }

    public onParentCheckLisenter parentCheckLisenter;

    public void setParentCheckLisenter(onParentCheckLisenter onParentCheckLisenter) {
        this.parentCheckLisenter = onParentCheckLisenter;
    }
}
