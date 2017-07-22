package com.shigan.pojo;

/**
 * Created by Administrator on 2017/6/26.
 */
public class User {

    private Integer id ;
    private String phoneNumber;
    private String nickname;
    private String name;
    private String city;
    private String community;
    private String address;
    private String password;
    private Integer communityid;

    public Integer getCommunityid() {
        return communityid;
    }

    public void setCommunityid(Integer communityid) {
        this.communityid = communityid;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {

        return id;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {

        return phoneNumber;
    }

    public String getNickname() {
        return nickname;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getCommunity() {
        return community;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }
}
