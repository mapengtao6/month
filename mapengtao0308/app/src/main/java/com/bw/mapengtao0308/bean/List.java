package com.bw.mapengtao0308.bean;

/**
 * Time:2019.03.08--14:02
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class List {

              /*    "bargainPrice": 111.99,
                 "createtime": "2017-10-14T21:39:05",
                "detailUrl": "http://172.17.8.100/images/small/commodity/xbsd/sjb/5/1.jpg",
                "images": "http://172.17.8.100/images/small/commodity/xbsd/sjb/5/1.jpg",
                "num": 2,
                "pid": 2,
                "price": 299.0,
                "pscid": 1,
                "selected": 0,
                "sellerid": 18,
                "subhead": "每个中秋都不能简单，无论身在何处，你总需要一块饼让生活更圆满，京东月饼让爱更圆满京东自营，闪电配送，更多惊喜，快用手指戳一下",
                "title": "北京稻香村 稻香村中秋节月饼 老北京月饼礼盒655g"*/

    private String bargainPrice;
    private String createtime;
    private String detailUrl;
    private String images;
    private String num;
    private String pid;
    private String price;
    private String pscid;
    private String selected;
    private String sellerid;
    private String subhead;
    private String title;
    public boolean childCheck = false;

    @Override
    public String toString() {
        return "List{" +
                "bargainPrice='" + bargainPrice + '\'' +
                ", createtime='" + createtime + '\'' +
                ", detailUrl='" + detailUrl + '\'' +
                ", images='" + images + '\'' +
                ", num='" + num + '\'' +
                ", pid='" + pid + '\'' +
                ", price='" + price + '\'' +
                ", pscid='" + pscid + '\'' +
                ", selected='" + selected + '\'' +
                ", sellerid='" + sellerid + '\'' +
                ", subhead='" + subhead + '\'' +
                ", title='" + title + '\'' +
                ", childCheck=" + childCheck +
                '}';
    }

    public String getBargainPrice() {
        return bargainPrice;
    }

    public void setBargainPrice(String bargainPrice) {
        this.bargainPrice = bargainPrice;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPscid() {
        return pscid;
    }

    public void setPscid(String pscid) {
        this.pscid = pscid;
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }

    public String getSellerid() {
        return sellerid;
    }

    public void setSellerid(String sellerid) {
        this.sellerid = sellerid;
    }

    public String getSubhead() {
        return subhead;
    }

    public void setSubhead(String subhead) {
        this.subhead = subhead;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isChildCheck() {
        return childCheck;
    }

    public void setChildCheck(boolean childCheck) {
        this.childCheck = childCheck;
    }

    public List() {
    }

    public List(String bargainPrice, String createtime, String detailUrl, String images, String num, String pid, String price, String pscid, String selected, String sellerid, String subhead, String title, boolean childCheck) {
        this.bargainPrice = bargainPrice;
        this.createtime = createtime;
        this.detailUrl = detailUrl;
        this.images = images;
        this.num = num;
        this.pid = pid;
        this.price = price;
        this.pscid = pscid;
        this.selected = selected;
        this.sellerid = sellerid;
        this.subhead = subhead;
        this.title = title;
        this.childCheck = childCheck;
    }
}
