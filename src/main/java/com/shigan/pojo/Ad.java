package com.shigan.pojo;

/**
 * Created by Administrator on 2017/6/30.
 */
public class Ad {

    private Integer id;
    private String adname;
    private Integer adlocationid;
    private  String url;
    private String path;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAdname(String adname) {
        this.adname = adname;
    }

    public void setAdlocationid(Integer adlocationid) {
        this.adlocationid = adlocationid;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getId() {

        return id;
    }

    public String getAdname() {
        return adname;
    }

    public Integer getAdlocationid() {
        return adlocationid;
    }

    public String getUrl() {
        return url;
    }

    public String getPath() {
        return path;
    }
}
