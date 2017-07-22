package com.shigan.pojo.supermarket;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/7/19.
 */
public class Order {
    private Integer id;
    private String orderid;
    private Integer userid;
    private String name;
    private String address;
    private String shoplist;
    private Double totalprice;
    private String time;
    private String play;
    private Integer playstatu;
    private Integer evaluatestatu;
    private Integer count;
    private String createtime;
    private Integer sendstatu;
    private List<Shopcaritems> shopcaritems;
    private String path;
    private String phonenumber;
    private Integer communityid;

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Integer getCommunityid() {
        return communityid;
    }

    public void setCommunityid(Integer communityid) {
        this.communityid = communityid;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Shopcaritems> getShopcaritems() {
        return shopcaritems;
    }

    public void setShopcaritems(List<Shopcaritems> shopcaritems) {
        this.shopcaritems = shopcaritems;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public Integer getSendstatu() {
        return sendstatu;
    }

    public void setSendstatu(Integer sendstatu) {
        this.sendstatu = sendstatu;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getShoplist() {
        return shoplist;
    }

    public void setShoplist(String shoplist) {
        this.shoplist = shoplist;
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPlay() {
        return play;
    }

    public void setPlay(String play) {
        this.play = play;
    }

    public Integer getPlaystatu() {
        return playstatu;
    }

    public void setPlaystatu(Integer playstatu) {
        this.playstatu = playstatu;
    }

    public Integer getEvaluatestatu() {
        return evaluatestatu;
    }

    public void setEvaluatestatu(Integer evaluatestatu) {
        this.evaluatestatu = evaluatestatu;
    }
}
