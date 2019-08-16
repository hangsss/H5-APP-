package com.wzc.im.bean;

import java.util.Date;

public class ImMessage {
    private String mid;

    private Integer fromid;

    private String fromname;

    private String fromtype;

    private Integer targetid;

    private String targetname;

    private String targettype;

    private String msgtext;

    private String msgextras;

    private String msgtype;

    private Date msgtime;

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public Integer getFromid() {
        return fromid;
    }

    public void setFromid(Integer fromid) {
        this.fromid = fromid;
    }

    public String getFromname() {
        return fromname;
    }

    public void setFromname(String fromname) {
        this.fromname = fromname == null ? null : fromname.trim();
    }

    public String getFromtype() {
        return fromtype;
    }

    public void setFromtype(String fromtype) {
        this.fromtype = fromtype == null ? null : fromtype.trim();
    }

    public Integer getTargetid() {
        return targetid;
    }

    public void setTargetid(Integer targetid) {
        this.targetid = targetid;
    }

    public String getTargetname() {
        return targetname;
    }

    public void setTargetname(String targetname) {
        this.targetname = targetname == null ? null : targetname.trim();
    }

    public String getTargettype() {
        return targettype;
    }

    public void setTargettype(String targettype) {
        this.targettype = targettype == null ? null : targettype.trim();
    }

    public String getMsgtext() {
        return msgtext;
    }

    public void setMsgtext(String msgtext) {
        this.msgtext = msgtext == null ? null : msgtext.trim();
    }

    public String getMsgextras() {
        return msgextras;
    }

    public void setMsgextras(String msgextras) {
        this.msgextras = msgextras == null ? null : msgextras.trim();
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype == null ? null : msgtype.trim();
    }

    public Date getMsgtime() {
        return msgtime;
    }

    public void setMsgtime(Date msgtime) {
        this.msgtime = msgtime;
    }

	@Override
	public String toString() {
		return "ImMessage [mid=" + mid + ", fromid=" + fromid + ", fromname="
				+ fromname + ", fromtype=" + fromtype + ", targetid="
				+ targetid + ", targetname=" + targetname + ", targettype="
				+ targettype + ", msgtext=" + msgtext + ", msgextras="
				+ msgextras + ", msgtype=" + msgtype + ", msgtime=" + msgtime
				+ "]";
	}
    
}