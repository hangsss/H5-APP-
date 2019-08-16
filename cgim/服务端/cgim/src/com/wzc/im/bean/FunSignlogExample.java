package com.wzc.im.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FunSignlogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FunSignlogExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSignidIsNull() {
            addCriterion("SIGNID is null");
            return (Criteria) this;
        }

        public Criteria andSignidIsNotNull() {
            addCriterion("SIGNID is not null");
            return (Criteria) this;
        }

        public Criteria andSignidEqualTo(String value) {
            addCriterion("SIGNID =", value, "signid");
            return (Criteria) this;
        }

        public Criteria andSignidNotEqualTo(String value) {
            addCriterion("SIGNID <>", value, "signid");
            return (Criteria) this;
        }

        public Criteria andSignidGreaterThan(String value) {
            addCriterion("SIGNID >", value, "signid");
            return (Criteria) this;
        }

        public Criteria andSignidGreaterThanOrEqualTo(String value) {
            addCriterion("SIGNID >=", value, "signid");
            return (Criteria) this;
        }

        public Criteria andSignidLessThan(String value) {
            addCriterion("SIGNID <", value, "signid");
            return (Criteria) this;
        }

        public Criteria andSignidLessThanOrEqualTo(String value) {
            addCriterion("SIGNID <=", value, "signid");
            return (Criteria) this;
        }

        public Criteria andSignidLike(String value) {
            addCriterion("SIGNID like", value, "signid");
            return (Criteria) this;
        }

        public Criteria andSignidNotLike(String value) {
            addCriterion("SIGNID not like", value, "signid");
            return (Criteria) this;
        }

        public Criteria andSignidIn(List<String> values) {
            addCriterion("SIGNID in", values, "signid");
            return (Criteria) this;
        }

        public Criteria andSignidNotIn(List<String> values) {
            addCriterion("SIGNID not in", values, "signid");
            return (Criteria) this;
        }

        public Criteria andSignidBetween(String value1, String value2) {
            addCriterion("SIGNID between", value1, value2, "signid");
            return (Criteria) this;
        }

        public Criteria andSignidNotBetween(String value1, String value2) {
            addCriterion("SIGNID not between", value1, value2, "signid");
            return (Criteria) this;
        }

        public Criteria andSignuserIsNull() {
            addCriterion("SIGNUSER is null");
            return (Criteria) this;
        }

        public Criteria andSignuserIsNotNull() {
            addCriterion("SIGNUSER is not null");
            return (Criteria) this;
        }

        public Criteria andSignuserEqualTo(String value) {
            addCriterion("SIGNUSER =", value, "signuser");
            return (Criteria) this;
        }

        public Criteria andSignuserNotEqualTo(String value) {
            addCriterion("SIGNUSER <>", value, "signuser");
            return (Criteria) this;
        }

        public Criteria andSignuserGreaterThan(String value) {
            addCriterion("SIGNUSER >", value, "signuser");
            return (Criteria) this;
        }

        public Criteria andSignuserGreaterThanOrEqualTo(String value) {
            addCriterion("SIGNUSER >=", value, "signuser");
            return (Criteria) this;
        }

        public Criteria andSignuserLessThan(String value) {
            addCriterion("SIGNUSER <", value, "signuser");
            return (Criteria) this;
        }

        public Criteria andSignuserLessThanOrEqualTo(String value) {
            addCriterion("SIGNUSER <=", value, "signuser");
            return (Criteria) this;
        }

        public Criteria andSignuserLike(String value) {
            addCriterion("SIGNUSER like", value, "signuser");
            return (Criteria) this;
        }

        public Criteria andSignuserNotLike(String value) {
            addCriterion("SIGNUSER not like", value, "signuser");
            return (Criteria) this;
        }

        public Criteria andSignuserIn(List<String> values) {
            addCriterion("SIGNUSER in", values, "signuser");
            return (Criteria) this;
        }

        public Criteria andSignuserNotIn(List<String> values) {
            addCriterion("SIGNUSER not in", values, "signuser");
            return (Criteria) this;
        }

        public Criteria andSignuserBetween(String value1, String value2) {
            addCriterion("SIGNUSER between", value1, value2, "signuser");
            return (Criteria) this;
        }

        public Criteria andSignuserNotBetween(String value1, String value2) {
            addCriterion("SIGNUSER not between", value1, value2, "signuser");
            return (Criteria) this;
        }

        public Criteria andSignuserimgIsNull() {
            addCriterion("SIGNUSERIMG is null");
            return (Criteria) this;
        }

        public Criteria andSignuserimgIsNotNull() {
            addCriterion("SIGNUSERIMG is not null");
            return (Criteria) this;
        }

        public Criteria andSignuserimgEqualTo(String value) {
            addCriterion("SIGNUSERIMG =", value, "signuserimg");
            return (Criteria) this;
        }

        public Criteria andSignuserimgNotEqualTo(String value) {
            addCriterion("SIGNUSERIMG <>", value, "signuserimg");
            return (Criteria) this;
        }

        public Criteria andSignuserimgGreaterThan(String value) {
            addCriterion("SIGNUSERIMG >", value, "signuserimg");
            return (Criteria) this;
        }

        public Criteria andSignuserimgGreaterThanOrEqualTo(String value) {
            addCriterion("SIGNUSERIMG >=", value, "signuserimg");
            return (Criteria) this;
        }

        public Criteria andSignuserimgLessThan(String value) {
            addCriterion("SIGNUSERIMG <", value, "signuserimg");
            return (Criteria) this;
        }

        public Criteria andSignuserimgLessThanOrEqualTo(String value) {
            addCriterion("SIGNUSERIMG <=", value, "signuserimg");
            return (Criteria) this;
        }

        public Criteria andSignuserimgLike(String value) {
            addCriterion("SIGNUSERIMG like", value, "signuserimg");
            return (Criteria) this;
        }

        public Criteria andSignuserimgNotLike(String value) {
            addCriterion("SIGNUSERIMG not like", value, "signuserimg");
            return (Criteria) this;
        }

        public Criteria andSignuserimgIn(List<String> values) {
            addCriterion("SIGNUSERIMG in", values, "signuserimg");
            return (Criteria) this;
        }

        public Criteria andSignuserimgNotIn(List<String> values) {
            addCriterion("SIGNUSERIMG not in", values, "signuserimg");
            return (Criteria) this;
        }

        public Criteria andSignuserimgBetween(String value1, String value2) {
            addCriterion("SIGNUSERIMG between", value1, value2, "signuserimg");
            return (Criteria) this;
        }

        public Criteria andSignuserimgNotBetween(String value1, String value2) {
            addCriterion("SIGNUSERIMG not between", value1, value2, "signuserimg");
            return (Criteria) this;
        }

        public Criteria andSignuseridIsNull() {
            addCriterion("SIGNUSERID is null");
            return (Criteria) this;
        }

        public Criteria andSignuseridIsNotNull() {
            addCriterion("SIGNUSERID is not null");
            return (Criteria) this;
        }

        public Criteria andSignuseridEqualTo(String value) {
            addCriterion("SIGNUSERID =", value, "signuserid");
            return (Criteria) this;
        }

        public Criteria andSignuseridNotEqualTo(String value) {
            addCriterion("SIGNUSERID <>", value, "signuserid");
            return (Criteria) this;
        }

        public Criteria andSignuseridGreaterThan(String value) {
            addCriterion("SIGNUSERID >", value, "signuserid");
            return (Criteria) this;
        }

        public Criteria andSignuseridGreaterThanOrEqualTo(String value) {
            addCriterion("SIGNUSERID >=", value, "signuserid");
            return (Criteria) this;
        }

        public Criteria andSignuseridLessThan(String value) {
            addCriterion("SIGNUSERID <", value, "signuserid");
            return (Criteria) this;
        }

        public Criteria andSignuseridLessThanOrEqualTo(String value) {
            addCriterion("SIGNUSERID <=", value, "signuserid");
            return (Criteria) this;
        }

        public Criteria andSignuseridLike(String value) {
            addCriterion("SIGNUSERID like", value, "signuserid");
            return (Criteria) this;
        }

        public Criteria andSignuseridNotLike(String value) {
            addCriterion("SIGNUSERID not like", value, "signuserid");
            return (Criteria) this;
        }

        public Criteria andSignuseridIn(List<String> values) {
            addCriterion("SIGNUSERID in", values, "signuserid");
            return (Criteria) this;
        }

        public Criteria andSignuseridNotIn(List<String> values) {
            addCriterion("SIGNUSERID not in", values, "signuserid");
            return (Criteria) this;
        }

        public Criteria andSignuseridBetween(String value1, String value2) {
            addCriterion("SIGNUSERID between", value1, value2, "signuserid");
            return (Criteria) this;
        }

        public Criteria andSignuseridNotBetween(String value1, String value2) {
            addCriterion("SIGNUSERID not between", value1, value2, "signuserid");
            return (Criteria) this;
        }

        public Criteria andSigntimeIsNull() {
            addCriterion("SIGNTIME is null");
            return (Criteria) this;
        }

        public Criteria andSigntimeIsNotNull() {
            addCriterion("SIGNTIME is not null");
            return (Criteria) this;
        }

        public Criteria andSigntimeEqualTo(Date value) {
            addCriterion("SIGNTIME =", value, "signtime");
            return (Criteria) this;
        }

        public Criteria andSigntimeNotEqualTo(Date value) {
            addCriterion("SIGNTIME <>", value, "signtime");
            return (Criteria) this;
        }

        public Criteria andSigntimeGreaterThan(Date value) {
            addCriterion("SIGNTIME >", value, "signtime");
            return (Criteria) this;
        }

        public Criteria andSigntimeGreaterThanOrEqualTo(Date value) {
            addCriterion("SIGNTIME >=", value, "signtime");
            return (Criteria) this;
        }

        public Criteria andSigntimeLessThan(Date value) {
            addCriterion("SIGNTIME <", value, "signtime");
            return (Criteria) this;
        }

        public Criteria andSigntimeLessThanOrEqualTo(Date value) {
            addCriterion("SIGNTIME <=", value, "signtime");
            return (Criteria) this;
        }

        public Criteria andSigntimeIn(List<Date> values) {
            addCriterion("SIGNTIME in", values, "signtime");
            return (Criteria) this;
        }

        public Criteria andSigntimeNotIn(List<Date> values) {
            addCriterion("SIGNTIME not in", values, "signtime");
            return (Criteria) this;
        }

        public Criteria andSigntimeBetween(Date value1, Date value2) {
            addCriterion("SIGNTIME between", value1, value2, "signtime");
            return (Criteria) this;
        }

        public Criteria andSigntimeNotBetween(Date value1, Date value2) {
            addCriterion("SIGNTIME not between", value1, value2, "signtime");
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