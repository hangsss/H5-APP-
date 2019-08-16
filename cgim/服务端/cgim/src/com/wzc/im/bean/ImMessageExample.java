package com.wzc.im.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImMessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ImMessageExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andMidIsNull() {
            addCriterion("MID is null");
            return (Criteria) this;
        }

        public Criteria andMidIsNotNull() {
            addCriterion("MID is not null");
            return (Criteria) this;
        }

        public Criteria andMidEqualTo(String value) {
            addCriterion("MID =", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotEqualTo(String value) {
            addCriterion("MID <>", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThan(String value) {
            addCriterion("MID >", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThanOrEqualTo(String value) {
            addCriterion("MID >=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThan(String value) {
            addCriterion("MID <", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThanOrEqualTo(String value) {
            addCriterion("MID <=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLike(String value) {
            addCriterion("MID like", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotLike(String value) {
            addCriterion("MID not like", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidIn(List<String> values) {
            addCriterion("MID in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotIn(List<String> values) {
            addCriterion("MID not in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidBetween(String value1, String value2) {
            addCriterion("MID between", value1, value2, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotBetween(String value1, String value2) {
            addCriterion("MID not between", value1, value2, "mid");
            return (Criteria) this;
        }

        public Criteria andFromidIsNull() {
            addCriterion("FROMID is null");
            return (Criteria) this;
        }

        public Criteria andFromidIsNotNull() {
            addCriterion("FROMID is not null");
            return (Criteria) this;
        }

        public Criteria andFromidEqualTo(Integer value) {
            addCriterion("FROMID =", value, "fromid");
            return (Criteria) this;
        }

        public Criteria andFromidNotEqualTo(Integer value) {
            addCriterion("FROMID <>", value, "fromid");
            return (Criteria) this;
        }

        public Criteria andFromidGreaterThan(Integer value) {
            addCriterion("FROMID >", value, "fromid");
            return (Criteria) this;
        }

        public Criteria andFromidGreaterThanOrEqualTo(Integer value) {
            addCriterion("FROMID >=", value, "fromid");
            return (Criteria) this;
        }

        public Criteria andFromidLessThan(Integer value) {
            addCriterion("FROMID <", value, "fromid");
            return (Criteria) this;
        }

        public Criteria andFromidLessThanOrEqualTo(Integer value) {
            addCriterion("FROMID <=", value, "fromid");
            return (Criteria) this;
        }

        public Criteria andFromidIn(List<Integer> values) {
            addCriterion("FROMID in", values, "fromid");
            return (Criteria) this;
        }

        public Criteria andFromidNotIn(List<Integer> values) {
            addCriterion("FROMID not in", values, "fromid");
            return (Criteria) this;
        }

        public Criteria andFromidBetween(Integer value1, Integer value2) {
            addCriterion("FROMID between", value1, value2, "fromid");
            return (Criteria) this;
        }

        public Criteria andFromidNotBetween(Integer value1, Integer value2) {
            addCriterion("FROMID not between", value1, value2, "fromid");
            return (Criteria) this;
        }

        public Criteria andFromnameIsNull() {
            addCriterion("FROMNAME is null");
            return (Criteria) this;
        }

        public Criteria andFromnameIsNotNull() {
            addCriterion("FROMNAME is not null");
            return (Criteria) this;
        }

        public Criteria andFromnameEqualTo(String value) {
            addCriterion("FROMNAME =", value, "fromname");
            return (Criteria) this;
        }

        public Criteria andFromnameNotEqualTo(String value) {
            addCriterion("FROMNAME <>", value, "fromname");
            return (Criteria) this;
        }

        public Criteria andFromnameGreaterThan(String value) {
            addCriterion("FROMNAME >", value, "fromname");
            return (Criteria) this;
        }

        public Criteria andFromnameGreaterThanOrEqualTo(String value) {
            addCriterion("FROMNAME >=", value, "fromname");
            return (Criteria) this;
        }

        public Criteria andFromnameLessThan(String value) {
            addCriterion("FROMNAME <", value, "fromname");
            return (Criteria) this;
        }

        public Criteria andFromnameLessThanOrEqualTo(String value) {
            addCriterion("FROMNAME <=", value, "fromname");
            return (Criteria) this;
        }

        public Criteria andFromnameLike(String value) {
            addCriterion("FROMNAME like", value, "fromname");
            return (Criteria) this;
        }

        public Criteria andFromnameNotLike(String value) {
            addCriterion("FROMNAME not like", value, "fromname");
            return (Criteria) this;
        }

        public Criteria andFromnameIn(List<String> values) {
            addCriterion("FROMNAME in", values, "fromname");
            return (Criteria) this;
        }

        public Criteria andFromnameNotIn(List<String> values) {
            addCriterion("FROMNAME not in", values, "fromname");
            return (Criteria) this;
        }

        public Criteria andFromnameBetween(String value1, String value2) {
            addCriterion("FROMNAME between", value1, value2, "fromname");
            return (Criteria) this;
        }

        public Criteria andFromnameNotBetween(String value1, String value2) {
            addCriterion("FROMNAME not between", value1, value2, "fromname");
            return (Criteria) this;
        }

        public Criteria andFromtypeIsNull() {
            addCriterion("FROMTYPE is null");
            return (Criteria) this;
        }

        public Criteria andFromtypeIsNotNull() {
            addCriterion("FROMTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andFromtypeEqualTo(String value) {
            addCriterion("FROMTYPE =", value, "fromtype");
            return (Criteria) this;
        }

        public Criteria andFromtypeNotEqualTo(String value) {
            addCriterion("FROMTYPE <>", value, "fromtype");
            return (Criteria) this;
        }

        public Criteria andFromtypeGreaterThan(String value) {
            addCriterion("FROMTYPE >", value, "fromtype");
            return (Criteria) this;
        }

        public Criteria andFromtypeGreaterThanOrEqualTo(String value) {
            addCriterion("FROMTYPE >=", value, "fromtype");
            return (Criteria) this;
        }

        public Criteria andFromtypeLessThan(String value) {
            addCriterion("FROMTYPE <", value, "fromtype");
            return (Criteria) this;
        }

        public Criteria andFromtypeLessThanOrEqualTo(String value) {
            addCriterion("FROMTYPE <=", value, "fromtype");
            return (Criteria) this;
        }

        public Criteria andFromtypeLike(String value) {
            addCriterion("FROMTYPE like", value, "fromtype");
            return (Criteria) this;
        }

        public Criteria andFromtypeNotLike(String value) {
            addCriterion("FROMTYPE not like", value, "fromtype");
            return (Criteria) this;
        }

        public Criteria andFromtypeIn(List<String> values) {
            addCriterion("FROMTYPE in", values, "fromtype");
            return (Criteria) this;
        }

        public Criteria andFromtypeNotIn(List<String> values) {
            addCriterion("FROMTYPE not in", values, "fromtype");
            return (Criteria) this;
        }

        public Criteria andFromtypeBetween(String value1, String value2) {
            addCriterion("FROMTYPE between", value1, value2, "fromtype");
            return (Criteria) this;
        }

        public Criteria andFromtypeNotBetween(String value1, String value2) {
            addCriterion("FROMTYPE not between", value1, value2, "fromtype");
            return (Criteria) this;
        }

        public Criteria andTargetidIsNull() {
            addCriterion("TARGETID is null");
            return (Criteria) this;
        }

        public Criteria andTargetidIsNotNull() {
            addCriterion("TARGETID is not null");
            return (Criteria) this;
        }

        public Criteria andTargetidEqualTo(Integer value) {
            addCriterion("TARGETID =", value, "targetid");
            return (Criteria) this;
        }

        public Criteria andTargetidNotEqualTo(Integer value) {
            addCriterion("TARGETID <>", value, "targetid");
            return (Criteria) this;
        }

        public Criteria andTargetidGreaterThan(Integer value) {
            addCriterion("TARGETID >", value, "targetid");
            return (Criteria) this;
        }

        public Criteria andTargetidGreaterThanOrEqualTo(Integer value) {
            addCriterion("TARGETID >=", value, "targetid");
            return (Criteria) this;
        }

        public Criteria andTargetidLessThan(Integer value) {
            addCriterion("TARGETID <", value, "targetid");
            return (Criteria) this;
        }

        public Criteria andTargetidLessThanOrEqualTo(Integer value) {
            addCriterion("TARGETID <=", value, "targetid");
            return (Criteria) this;
        }

        public Criteria andTargetidIn(List<Integer> values) {
            addCriterion("TARGETID in", values, "targetid");
            return (Criteria) this;
        }

        public Criteria andTargetidNotIn(List<Integer> values) {
            addCriterion("TARGETID not in", values, "targetid");
            return (Criteria) this;
        }

        public Criteria andTargetidBetween(Integer value1, Integer value2) {
            addCriterion("TARGETID between", value1, value2, "targetid");
            return (Criteria) this;
        }

        public Criteria andTargetidNotBetween(Integer value1, Integer value2) {
            addCriterion("TARGETID not between", value1, value2, "targetid");
            return (Criteria) this;
        }

        public Criteria andTargetnameIsNull() {
            addCriterion("TARGETNAME is null");
            return (Criteria) this;
        }

        public Criteria andTargetnameIsNotNull() {
            addCriterion("TARGETNAME is not null");
            return (Criteria) this;
        }

        public Criteria andTargetnameEqualTo(String value) {
            addCriterion("TARGETNAME =", value, "targetname");
            return (Criteria) this;
        }

        public Criteria andTargetnameNotEqualTo(String value) {
            addCriterion("TARGETNAME <>", value, "targetname");
            return (Criteria) this;
        }

        public Criteria andTargetnameGreaterThan(String value) {
            addCriterion("TARGETNAME >", value, "targetname");
            return (Criteria) this;
        }

        public Criteria andTargetnameGreaterThanOrEqualTo(String value) {
            addCriterion("TARGETNAME >=", value, "targetname");
            return (Criteria) this;
        }

        public Criteria andTargetnameLessThan(String value) {
            addCriterion("TARGETNAME <", value, "targetname");
            return (Criteria) this;
        }

        public Criteria andTargetnameLessThanOrEqualTo(String value) {
            addCriterion("TARGETNAME <=", value, "targetname");
            return (Criteria) this;
        }

        public Criteria andTargetnameLike(String value) {
            addCriterion("TARGETNAME like", value, "targetname");
            return (Criteria) this;
        }

        public Criteria andTargetnameNotLike(String value) {
            addCriterion("TARGETNAME not like", value, "targetname");
            return (Criteria) this;
        }

        public Criteria andTargetnameIn(List<String> values) {
            addCriterion("TARGETNAME in", values, "targetname");
            return (Criteria) this;
        }

        public Criteria andTargetnameNotIn(List<String> values) {
            addCriterion("TARGETNAME not in", values, "targetname");
            return (Criteria) this;
        }

        public Criteria andTargetnameBetween(String value1, String value2) {
            addCriterion("TARGETNAME between", value1, value2, "targetname");
            return (Criteria) this;
        }

        public Criteria andTargetnameNotBetween(String value1, String value2) {
            addCriterion("TARGETNAME not between", value1, value2, "targetname");
            return (Criteria) this;
        }

        public Criteria andTargettypeIsNull() {
            addCriterion("TARGETTYPE is null");
            return (Criteria) this;
        }

        public Criteria andTargettypeIsNotNull() {
            addCriterion("TARGETTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTargettypeEqualTo(String value) {
            addCriterion("TARGETTYPE =", value, "targettype");
            return (Criteria) this;
        }

        public Criteria andTargettypeNotEqualTo(String value) {
            addCriterion("TARGETTYPE <>", value, "targettype");
            return (Criteria) this;
        }

        public Criteria andTargettypeGreaterThan(String value) {
            addCriterion("TARGETTYPE >", value, "targettype");
            return (Criteria) this;
        }

        public Criteria andTargettypeGreaterThanOrEqualTo(String value) {
            addCriterion("TARGETTYPE >=", value, "targettype");
            return (Criteria) this;
        }

        public Criteria andTargettypeLessThan(String value) {
            addCriterion("TARGETTYPE <", value, "targettype");
            return (Criteria) this;
        }

        public Criteria andTargettypeLessThanOrEqualTo(String value) {
            addCriterion("TARGETTYPE <=", value, "targettype");
            return (Criteria) this;
        }

        public Criteria andTargettypeLike(String value) {
            addCriterion("TARGETTYPE like", value, "targettype");
            return (Criteria) this;
        }

        public Criteria andTargettypeNotLike(String value) {
            addCriterion("TARGETTYPE not like", value, "targettype");
            return (Criteria) this;
        }

        public Criteria andTargettypeIn(List<String> values) {
            addCriterion("TARGETTYPE in", values, "targettype");
            return (Criteria) this;
        }

        public Criteria andTargettypeNotIn(List<String> values) {
            addCriterion("TARGETTYPE not in", values, "targettype");
            return (Criteria) this;
        }

        public Criteria andTargettypeBetween(String value1, String value2) {
            addCriterion("TARGETTYPE between", value1, value2, "targettype");
            return (Criteria) this;
        }

        public Criteria andTargettypeNotBetween(String value1, String value2) {
            addCriterion("TARGETTYPE not between", value1, value2, "targettype");
            return (Criteria) this;
        }

        public Criteria andMsgtextIsNull() {
            addCriterion("MSGTEXT is null");
            return (Criteria) this;
        }

        public Criteria andMsgtextIsNotNull() {
            addCriterion("MSGTEXT is not null");
            return (Criteria) this;
        }

        public Criteria andMsgtextEqualTo(String value) {
            addCriterion("MSGTEXT =", value, "msgtext");
            return (Criteria) this;
        }

        public Criteria andMsgtextNotEqualTo(String value) {
            addCriterion("MSGTEXT <>", value, "msgtext");
            return (Criteria) this;
        }

        public Criteria andMsgtextGreaterThan(String value) {
            addCriterion("MSGTEXT >", value, "msgtext");
            return (Criteria) this;
        }

        public Criteria andMsgtextGreaterThanOrEqualTo(String value) {
            addCriterion("MSGTEXT >=", value, "msgtext");
            return (Criteria) this;
        }

        public Criteria andMsgtextLessThan(String value) {
            addCriterion("MSGTEXT <", value, "msgtext");
            return (Criteria) this;
        }

        public Criteria andMsgtextLessThanOrEqualTo(String value) {
            addCriterion("MSGTEXT <=", value, "msgtext");
            return (Criteria) this;
        }

        public Criteria andMsgtextLike(String value) {
            addCriterion("MSGTEXT like", value, "msgtext");
            return (Criteria) this;
        }

        public Criteria andMsgtextNotLike(String value) {
            addCriterion("MSGTEXT not like", value, "msgtext");
            return (Criteria) this;
        }

        public Criteria andMsgtextIn(List<String> values) {
            addCriterion("MSGTEXT in", values, "msgtext");
            return (Criteria) this;
        }

        public Criteria andMsgtextNotIn(List<String> values) {
            addCriterion("MSGTEXT not in", values, "msgtext");
            return (Criteria) this;
        }

        public Criteria andMsgtextBetween(String value1, String value2) {
            addCriterion("MSGTEXT between", value1, value2, "msgtext");
            return (Criteria) this;
        }

        public Criteria andMsgtextNotBetween(String value1, String value2) {
            addCriterion("MSGTEXT not between", value1, value2, "msgtext");
            return (Criteria) this;
        }

        public Criteria andMsgextrasIsNull() {
            addCriterion("MSGEXTRAS is null");
            return (Criteria) this;
        }

        public Criteria andMsgextrasIsNotNull() {
            addCriterion("MSGEXTRAS is not null");
            return (Criteria) this;
        }

        public Criteria andMsgextrasEqualTo(String value) {
            addCriterion("MSGEXTRAS =", value, "msgextras");
            return (Criteria) this;
        }

        public Criteria andMsgextrasNotEqualTo(String value) {
            addCriterion("MSGEXTRAS <>", value, "msgextras");
            return (Criteria) this;
        }

        public Criteria andMsgextrasGreaterThan(String value) {
            addCriterion("MSGEXTRAS >", value, "msgextras");
            return (Criteria) this;
        }

        public Criteria andMsgextrasGreaterThanOrEqualTo(String value) {
            addCriterion("MSGEXTRAS >=", value, "msgextras");
            return (Criteria) this;
        }

        public Criteria andMsgextrasLessThan(String value) {
            addCriterion("MSGEXTRAS <", value, "msgextras");
            return (Criteria) this;
        }

        public Criteria andMsgextrasLessThanOrEqualTo(String value) {
            addCriterion("MSGEXTRAS <=", value, "msgextras");
            return (Criteria) this;
        }

        public Criteria andMsgextrasLike(String value) {
            addCriterion("MSGEXTRAS like", value, "msgextras");
            return (Criteria) this;
        }

        public Criteria andMsgextrasNotLike(String value) {
            addCriterion("MSGEXTRAS not like", value, "msgextras");
            return (Criteria) this;
        }

        public Criteria andMsgextrasIn(List<String> values) {
            addCriterion("MSGEXTRAS in", values, "msgextras");
            return (Criteria) this;
        }

        public Criteria andMsgextrasNotIn(List<String> values) {
            addCriterion("MSGEXTRAS not in", values, "msgextras");
            return (Criteria) this;
        }

        public Criteria andMsgextrasBetween(String value1, String value2) {
            addCriterion("MSGEXTRAS between", value1, value2, "msgextras");
            return (Criteria) this;
        }

        public Criteria andMsgextrasNotBetween(String value1, String value2) {
            addCriterion("MSGEXTRAS not between", value1, value2, "msgextras");
            return (Criteria) this;
        }

        public Criteria andMsgtypeIsNull() {
            addCriterion("MSGTYPE is null");
            return (Criteria) this;
        }

        public Criteria andMsgtypeIsNotNull() {
            addCriterion("MSGTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMsgtypeEqualTo(String value) {
            addCriterion("MSGTYPE =", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeNotEqualTo(String value) {
            addCriterion("MSGTYPE <>", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeGreaterThan(String value) {
            addCriterion("MSGTYPE >", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeGreaterThanOrEqualTo(String value) {
            addCriterion("MSGTYPE >=", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeLessThan(String value) {
            addCriterion("MSGTYPE <", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeLessThanOrEqualTo(String value) {
            addCriterion("MSGTYPE <=", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeLike(String value) {
            addCriterion("MSGTYPE like", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeNotLike(String value) {
            addCriterion("MSGTYPE not like", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeIn(List<String> values) {
            addCriterion("MSGTYPE in", values, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeNotIn(List<String> values) {
            addCriterion("MSGTYPE not in", values, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeBetween(String value1, String value2) {
            addCriterion("MSGTYPE between", value1, value2, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeNotBetween(String value1, String value2) {
            addCriterion("MSGTYPE not between", value1, value2, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtimeIsNull() {
            addCriterion("MSGTIME is null");
            return (Criteria) this;
        }

        public Criteria andMsgtimeIsNotNull() {
            addCriterion("MSGTIME is not null");
            return (Criteria) this;
        }

        public Criteria andMsgtimeEqualTo(Date value) {
            addCriterion("MSGTIME =", value, "msgtime");
            return (Criteria) this;
        }

        public Criteria andMsgtimeNotEqualTo(Date value) {
            addCriterion("MSGTIME <>", value, "msgtime");
            return (Criteria) this;
        }

        public Criteria andMsgtimeGreaterThan(Date value) {
            addCriterion("MSGTIME >", value, "msgtime");
            return (Criteria) this;
        }

        public Criteria andMsgtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("MSGTIME >=", value, "msgtime");
            return (Criteria) this;
        }

        public Criteria andMsgtimeLessThan(Date value) {
            addCriterion("MSGTIME <", value, "msgtime");
            return (Criteria) this;
        }

        public Criteria andMsgtimeLessThanOrEqualTo(Date value) {
            addCriterion("MSGTIME <=", value, "msgtime");
            return (Criteria) this;
        }

        public Criteria andMsgtimeIn(List<Date> values) {
            addCriterion("MSGTIME in", values, "msgtime");
            return (Criteria) this;
        }

        public Criteria andMsgtimeNotIn(List<Date> values) {
            addCriterion("MSGTIME not in", values, "msgtime");
            return (Criteria) this;
        }

        public Criteria andMsgtimeBetween(Date value1, Date value2) {
            addCriterion("MSGTIME between", value1, value2, "msgtime");
            return (Criteria) this;
        }

        public Criteria andMsgtimeNotBetween(Date value1, Date value2) {
            addCriterion("MSGTIME not between", value1, value2, "msgtime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}