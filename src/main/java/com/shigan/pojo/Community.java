package com.shigan.pojo;

/**
 * Created by Administrator on 2017/7/2.
 */
public class Community {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String parentId;
    private String Communtity;

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public void setCommuntity(String communtity) {
        Communtity = communtity;
    }

    public String getParentId() {

        return parentId;
    }

    public String getCommuntity() {
        return Communtity;
    }
}
