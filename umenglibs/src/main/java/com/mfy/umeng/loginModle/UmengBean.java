package com.mfy.umeng.loginModle;

/*
* 友盟获取数据Bean类
* */
public class UmengBean {
    //进来初始值为空 避免盼空的时候 空指针
    private String uid = "";//qq  微信  微博 唯一标识
    private String name = "";//名字
    private String gender = "";//性别
    private String iconurl = "";//头像
    private String openid = "";//QQ原始id名
    private String unionid = "";//微信原始id名
    private String access_token = "";
    private String refresh_token = "";
    private String expires_in = "";

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIconurl() {
        return iconurl;
    }

    public void setIconurl(String iconurl) {
        this.iconurl = iconurl;
    }
}
