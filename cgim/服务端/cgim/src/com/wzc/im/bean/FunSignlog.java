package com.wzc.im.bean;

import java.util.Date;

public class FunSignlog {
    private String id;

    private String signid;

    private String signuser;

    private String signuserimg;

    private String signuserid;

    private Date signtime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSignid() {
        return signid;
    }

    public void setSignid(String signid) {
        this.signid = signid == null ? null : signid.trim();
    }

    public String getSignuser() {
        return signuser;
    }

    public void setSignuser(String signuser) {
        this.signuser = signuser == null ? null : signuser.trim();
    }

    public String getSignuserimg() {
        return signuserimg;
    }

    public void setSignuserimg(String signuserimg) {
        this.signuserimg = signuserimg == null ? null : signuserimg.trim();
    }

    public String getSignuserid() {
        return signuserid;
    }

    public void setSignuserid(String signuserid) {
        this.signuserid = signuserid == null ? null : signuserid.trim();
    }

    public Date getSigntime() {
        return signtime;
    }

    public void setSigntime(Date signtime) {
        this.signtime = signtime;
    }
}