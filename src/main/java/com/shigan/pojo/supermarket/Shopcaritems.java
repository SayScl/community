package com.shigan.pojo.supermarket;

/**
 * Created by Administrator on 2017/7/14.
 */
public class Shopcaritems {
    private Integer id;
    private Integer productid;
    private Integer productcount;
    private Integer userid;
    private Double producttotalprice;
    private String productname;

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public Double getProducttotalprice() {
        return producttotalprice;
    }

    public void setProducttotalprice(Double producttotalprice) {
        this.producttotalprice = producttotalprice;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Integer getProductcount() {
        return productcount;
    }

    public void setProductcount(Integer productcount) {
        this.productcount = productcount;
    }
}
