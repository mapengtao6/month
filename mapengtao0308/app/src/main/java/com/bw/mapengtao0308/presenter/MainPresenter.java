package com.bw.mapengtao0308.presenter;

import com.bw.mapengtao0308.MainActivity;
import com.bw.mapengtao0308.model.MainModel;
import com.bw.mapengtao0308.view.MainView;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Time:2019.03.08--13:40
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:P层
 */
public class MainPresenter<T> {

    private Reference<T> tReference;
    private final MainModel mainModel;
    private final MainView mainView;

//    构造
    public void attachView(T t) {

        tReference = new WeakReference<T>(t);
    }

//    销毁内存方法
    public void deatchView() {
        if (tReference != null) {
            tReference.clear();
            tReference = null;
        }
    }

    //    实例化
    public MainPresenter(MainView view) {
        mainModel = new MainModel();

        mainView = view;
    }

    public void show() {

        mainModel.show();
        mainModel.setShopLisenter(new MainModel.onShopLisenter() {
            @Override
            public void onResult(String json) {
                mainView.getViewData(json);
            }
        });
    }
}
