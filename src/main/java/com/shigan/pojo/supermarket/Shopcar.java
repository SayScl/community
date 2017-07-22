package com.shigan.pojo.supermarket;

import java.util.List;

/**
 * Created by Administrator on 2017/7/14.
 */
public class Shopcar {
    private Integer id;
    private Integer userid;
    private Integer communityid;
    private Double totalprice;
    private String itemsid;
    private List<Shopcaritems> shopcaritems;
    private Integer shopcaritemscount;

    public Integer getShopcaritemscount() {
        return shopcaritemscount;
    }

    public void setShopcaritemscount(Integer shopcaritemscount) {
        this.shopcaritemscount = shopcaritemscount;
    }

    public List<Shopcaritems> getShopcaritems() {
        return shopcaritems;
    }

    public void setShopcaritems(List<Shopcaritems> shopcaritems) {
        this.shopcaritems = shopcaritems;
    }

    public String getItemsid() {
        return itemsid;
    }

    public void setItemsid(String itemsid) {
        this.itemsid = itemsid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getCommunityid() {
        return communityid;
    }

    public void setCommunityid(Integer communityid) {
        this.communityid = communityid;
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }
}
