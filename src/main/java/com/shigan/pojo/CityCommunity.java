package com.shigan.pojo;

import java.util.List;

/**
 * Created by Administrator on 2017/7/2.
 */
public class CityCommunity {
    private Integer id;
    private String cityName;
    private Integer parentId;
    private String community;
    private Integer cityid;
    private List<CityCommunity> list;

    public List<CityCommunity> getList() {
        return list;
    }

    public void setList(List<CityCommunity> list) {
        this.list = list;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public void setCommunity(String community) {
        this.community = community;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public Integer getId() {

        return id;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {

        return cityName;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getParentId() {

        return parentId;
    }

    public String getCommunity() {
        return community;
    }

    public Integer getCityid() {
        return cityid;
    }
}
