package com.wzc.im.bean;

import java.util.Date;

public class FunDynamic {
    private String id;

    private Integer createuserid;

    private String createname;

    private Date createtime;

    private String content;

    private String extras;

    private String likeUserids;

    private String likeNames;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getCreateuserid() {
        return createuserid;
    }

    public void setCreateuserid(Integer createuserid) {
        this.createuserid = createuserid;
    }

    public String getCreatename() {
        return createname;
    }

    public void setCreatename(String createname) {
        this.createname = createname == null ? null : createname.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras == null ? null : extras.trim();
    }

    public String getLikeUserids() {
        return likeUserids;
    }

    public void setLikeUserids(String likeUserids) {
        this.likeUserids = likeUserids == null ? null : likeUserids.trim();
    }

    public String getLikeNames() {
        return likeNames;
    }

    public void setLikeNames(String likeNames) {
        this.likeNames = likeNames == null ? null : likeNames.trim();
    }
}