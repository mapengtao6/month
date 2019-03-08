package com.bw.mapengtao0308;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.bw.mapengtao0308.adapter.MyParentAdapter;
import com.bw.mapengtao0308.bean.Data;
import com.bw.mapengtao0308.bean.JsonBean;
import com.bw.mapengtao0308.bean.List;
import com.bw.mapengtao0308.presenter.MainPresenter;
import com.bw.mapengtao0308.view.MainView;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainView {

    private RecyclerView rlv;
    private MainPresenter presenter;
    private CheckBox show_check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        http://172.17.8.100/ks/product/getCarts?uid=51

//        控件
        initID();
    }

    private void initID() {
        rlv = findViewById(R.id.main_rlv);
        show_check = findViewById(R.id.show_check);

//        设置管理模式
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rlv.setLayoutManager(linearLayoutManager);

        presenter = new MainPresenter(this);

        presenter.show();
        presenter.attachView(this);
    }

    @Override
    public void getViewData(String json) {

//        Log.i("kk",json);

        Gson gson = new Gson();
        JsonBean fromJson = gson.fromJson(json, JsonBean.class);

        final ArrayList<Data> data = fromJson.getData();

//        Toast.makeText(this, ""+data.toString(), Toast.LENGTH_SHORT).show();
//        适配器

        final MyParentAdapter myParentAdapter = new MyParentAdapter(this, data);
        rlv.setAdapter(myParentAdapter);

        show_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (show_check.isChecked()) {
                    for (int i = 0; i < data.size(); i++) {
                        data.get(i).setParentCheck(true);
                        ArrayList<List> list = data.get(i).getList();
                        for (int j = 0; j < list.size(); j++) {
                            list.get(j).setChildCheck(true);
                        }
                    }
                } else {
                    for (int i = 0; i < data.size(); i++) {
                        data.get(i).setParentCheck(false);
                        ArrayList<List> list = data.get(i).getList();
                        for (int j = 0; j < list.size(); j++) {
                            list.get(j).setChildCheck(false);
                        }
                    }
                }
                myParentAdapter.notifyDataSetChanged();
            }
        });

        myParentAdapter.setParentCheckLisenter(new MyParentAdapter.onParentCheckLisenter() {
            @Override
            public void onCheck(Data data) {
                int value = 0;
                for (int i = 0; i < data.getList().size(); i++) {
                    for (int j = 0; j < data.getList().size(); j++) {
                        value++;
                    }
                }

//                选中、
                if (data.getList().size() == value){
                    show_check.setChecked(true);
                }
//                不选中
                else {
                    show_check.setChecked(false);
                }
            }
        });
    }

//    销毁内存
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.deatchView();
    }
}
