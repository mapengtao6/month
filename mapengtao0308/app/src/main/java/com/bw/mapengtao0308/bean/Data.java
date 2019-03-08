package com.bw.mapengtao0308.bean;

import java.util.ArrayList;

/**
 * Time:2019.03.08--14:06
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class Data {

    private ArrayList<List> list;
    private String sellerName;
    private String sellerid;
    public boolean parentCheck = false;

    @Override
    public String toString() {
        return "Data{" +
                "list=" + list +
                ", sellerName='" + sellerName + '\'' +
                ", sellerid='" + sellerid + '\'' +
                ", parentCheck=" + parentCheck +
                '}';
    }

    public ArrayList<List> getList() {
        return list;
    }

    public void setList(ArrayList<List> list) {
        this.list = list;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerid() {
        return sellerid;
    }

    public void setSellerid(String sellerid) {
        this.sellerid = sellerid;
    }

    public boolean isParentCheck() {
        return parentCheck;
    }

    public void setParentCheck(boolean parentCheck) {
        this.parentCheck = parentCheck;
    }

    public Data() {
    }

    public Data(ArrayList<List> list, String sellerName, String sellerid, boolean parentCheck) {
        this.list = list;
        this.sellerName = sellerName;
        this.sellerid = sellerid;
        this.parentCheck = parentCheck;
    }
}
