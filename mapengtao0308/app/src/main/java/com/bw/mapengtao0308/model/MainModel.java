package com.bw.mapengtao0308.model;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.bw.mapengtao0308.utils.OkHttpUtils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Time:2019.03.08--13:40
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:M层
 */
public class MainModel {

    String url = "http://172.17.8.100/ks/product/getCarts?uid=51";

//    接口回调
    public interface onShopLisenter{
        void onResult(String json);
    }

//    定义接口
    public onShopLisenter shopLisenter;

//    设置监听
    public void setShopLisenter(onShopLisenter onShopLisenter) {
        this.shopLisenter = onShopLisenter;
    }

    private Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:

                    String json = (String) msg.obj;
                    if (shopLisenter != null){
                        shopLisenter.onResult(json);
                    }

                    break;
            }
        }
    };

    public void show() {

        OkHttpUtils.getInstance().doGet(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String json = response.body().string();
//                Log.i("jjj",json);

                Message message = new Message();
                message.what = 0;
                message.obj = json;
                handler.sendMessage(message);//发送
            }
        });
    }
}
