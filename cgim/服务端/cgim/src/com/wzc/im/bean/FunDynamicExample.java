package com.wzc.im.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FunDynamicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FunDynamicExample() {
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

        public Criteria andCreateuseridIsNull() {
            addCriterion("CREATEUSERID is null");
            return (Criteria) this;
        }

        public Criteria andCreateuseridIsNotNull() {
            addCriterion("CREATEUSERID is not null");
            return (Criteria) this;
        }

        public Criteria andCreateuseridEqualTo(Integer value) {
            addCriterion("CREATEUSERID =", value, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridNotEqualTo(Integer value) {
            addCriterion("CREATEUSERID <>", value, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridGreaterThan(Integer value) {
            addCriterion("CREATEUSERID >", value, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("CREATEUSERID >=", value, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridLessThan(Integer value) {
            addCriterion("CREATEUSERID <", value, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridLessThanOrEqualTo(Integer value) {
            addCriterion("CREATEUSERID <=", value, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridIn(List<Integer> values) {
            addCriterion("CREATEUSERID in", values, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridNotIn(List<Integer> values) {
            addCriterion("CREATEUSERID not in", values, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridBetween(Integer value1, Integer value2) {
            addCriterion("CREATEUSERID between", value1, value2, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridNotBetween(Integer value1, Integer value2) {
            addCriterion("CREATEUSERID not between", value1, value2, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreatenameIsNull() {
            addCriterion("CREATENAME is null");
            return (Criteria) this;
        }

        public Criteria andCreatenameIsNotNull() {
            addCriterion("CREATENAME is not null");
            return (Criteria) this;
        }

        public Criteria andCreatenameEqualTo(String value) {
            addCriterion("CREATENAME =", value, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameNotEqualTo(String value) {
            addCriterion("CREATENAME <>", value, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameGreaterThan(String value) {
            addCriterion("CREATENAME >", value, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameGreaterThanOrEqualTo(String value) {
            addCriterion("CREATENAME >=", value, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameLessThan(String value) {
            addCriterion("CREATENAME <", value, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameLessThanOrEqualTo(String value) {
            addCriterion("CREATENAME <=", value, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameLike(String value) {
            addCriterion("CREATENAME like", value, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameNotLike(String value) {
            addCriterion("CREATENAME not like", value, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameIn(List<String> values) {
            addCriterion("CREATENAME in", values, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameNotIn(List<String> values) {
            addCriterion("CREATENAME not in", values, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameBetween(String value1, String value2) {
            addCriterion("CREATENAME between", value1, value2, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameNotBetween(String value1, String value2) {
            addCriterion("CREATENAME not between", value1, value2, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("CREATETIME is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("CREATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("CREATETIME =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("CREATETIME <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("CREATETIME >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATETIME >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("CREATETIME <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATETIME <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("CREATETIME in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("CREATETIME not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("CREATETIME between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATETIME not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("CONTENT =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("CONTENT <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("CONTENT >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("CONTENT >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("CONTENT <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("CONTENT <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("CONTENT like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("CONTENT not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("CONTENT in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("CONTENT not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("CONTENT between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("CONTENT not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andExtrasIsNull() {
            addCriterion("EXTRAS is null");
            return (Criteria) this;
        }

        public Criteria andExtrasIsNotNull() {
            addCriterion("EXTRAS is not null");
            return (Criteria) this;
        }

        public Criteria andExtrasEqualTo(String value) {
            addCriterion("EXTRAS =", value, "extras");
            return (Criteria) this;
        }

        public Criteria andExtrasNotEqualTo(String value) {
            addCriterion("EXTRAS <>", value, "extras");
            return (Criteria) this;
        }

        public Criteria andExtrasGreaterThan(String value) {
            addCriterion("EXTRAS >", value, "extras");
            return (Criteria) this;
        }

        public Criteria andExtrasGreaterThanOrEqualTo(String value) {
            addCriterion("EXTRAS >=", value, "extras");
            return (Criteria) this;
        }

        public Criteria andExtrasLessThan(String value) {
            addCriterion("EXTRAS <", value, "extras");
            return (Criteria) this;
        }

        public Criteria andExtrasLessThanOrEqualTo(String value) {
            addCriterion("EXTRAS <=", value, "extras");
            return (Criteria) this;
        }

        public Criteria andExtrasLike(String value) {
            addCriterion("EXTRAS like", value, "extras");
            return (Criteria) this;
        }

        public Criteria andExtrasNotLike(String value) {
            addCriterion("EXTRAS not like", value, "extras");
            return (Criteria) this;
        }

        public Criteria andExtrasIn(List<String> values) {
            addCriterion("EXTRAS in", values, "extras");
            return (Criteria) this;
        }

        public Criteria andExtrasNotIn(List<String> values) {
            addCriterion("EXTRAS not in", values, "extras");
            return (Criteria) this;
        }

        public Criteria andExtrasBetween(String value1, String value2) {
            addCriterion("EXTRAS between", value1, value2, "extras");
            return (Criteria) this;
        }

        public Criteria andExtrasNotBetween(String value1, String value2) {
            addCriterion("EXTRAS not between", value1, value2, "extras");
            return (Criteria) this;
        }

        public Criteria andLikeUseridsIsNull() {
            addCriterion("LIKE_USERIDS is null");
            return (Criteria) this;
        }

        public Criteria andLikeUseridsIsNotNull() {
            addCriterion("LIKE_USERIDS is not null");
            return (Criteria) this;
        }

        public Criteria andLikeUseridsEqualTo(String value) {
            addCriterion("LIKE_USERIDS =", value, "likeUserids");
            return (Criteria) this;
        }

        public Criteria andLikeUseridsNotEqualTo(String value) {
            addCriterion("LIKE_USERIDS <>", value, "likeUserids");
            return (Criteria) this;
        }

        public Criteria andLikeUseridsGreaterThan(String value) {
            addCriterion("LIKE_USERIDS >", value, "likeUserids");
            return (Criteria) this;
        }

        public Criteria andLikeUseridsGreaterThanOrEqualTo(String value) {
            addCriterion("LIKE_USERIDS >=", value, "likeUserids");
            return (Criteria) this;
        }

        public Criteria andLikeUseridsLessThan(String value) {
            addCriterion("LIKE_USERIDS <", value, "likeUserids");
            return (Criteria) this;
        }

        public Criteria andLikeUseridsLessThanOrEqualTo(String value) {
            addCriterion("LIKE_USERIDS <=", value, "likeUserids");
            return (Criteria) this;
        }

        public Criteria andLikeUseridsLike(String value) {
            addCriterion("LIKE_USERIDS like", value, "likeUserids");
            return (Criteria) this;
        }

        public Criteria andLikeUseridsNotLike(String value) {
            addCriterion("LIKE_USERIDS not like", value, "likeUserids");
            return (Criteria) this;
        }

        public Criteria andLikeUseridsIn(List<String> values) {
            addCriterion("LIKE_USERIDS in", values, "likeUserids");
            return (Criteria) this;
        }

        public Criteria andLikeUseridsNotIn(List<String> values) {
            addCriterion("LIKE_USERIDS not in", values, "likeUserids");
            return (Criteria) this;
        }

        public Criteria andLikeUseridsBetween(String value1, String value2) {
            addCriterion("LIKE_USERIDS between", value1, value2, "likeUserids");
            return (Criteria) this;
        }

        public Criteria andLikeUseridsNotBetween(String value1, String value2) {
            addCriterion("LIKE_USERIDS not between", value1, value2, "likeUserids");
            return (Criteria) this;
        }

        public Criteria andLikeNamesIsNull() {
            addCriterion("LIKE_NAMES is null");
            return (Criteria) this;
        }

        public Criteria andLikeNamesIsNotNull() {
            addCriterion("LIKE_NAMES is not null");
            return (Criteria) this;
        }

        public Criteria andLikeNamesEqualTo(String value) {
            addCriterion("LIKE_NAMES =", value, "likeNames");
            return (Criteria) this;
        }

        public Criteria andLikeNamesNotEqualTo(String value) {
            addCriterion("LIKE_NAMES <>", value, "likeNames");
            return (Criteria) this;
        }

        public Criteria andLikeNamesGreaterThan(String value) {
            addCriterion("LIKE_NAMES >", value, "likeNames");
            return (Criteria) this;
        }

        public Criteria andLikeNamesGreaterThanOrEqualTo(String value) {
            addCriterion("LIKE_NAMES >=", value, "likeNames");
            return (Criteria) this;
        }

        public Criteria andLikeNamesLessThan(String value) {
            addCriterion("LIKE_NAMES <", value, "likeNames");
            return (Criteria) this;
        }

        public Criteria andLikeNamesLessThanOrEqualTo(String value) {
            addCriterion("LIKE_NAMES <=", value, "likeNames");
            return (Criteria) this;
        }

        public Criteria andLikeNamesLike(String value) {
            addCriterion("LIKE_NAMES like", value, "likeNames");
            return (Criteria) this;
        }

        public Criteria andLikeNamesNotLike(String value) {
            addCriterion("LIKE_NAMES not like", value, "likeNames");
            return (Criteria) this;
        }

        public Criteria andLikeNamesIn(List<String> values) {
            addCriterion("LIKE_NAMES in", values, "likeNames");
            return (Criteria) this;
        }

        public Criteria andLikeNamesNotIn(List<String> values) {
            addCriterion("LIKE_NAMES not in", values, "likeNames");
            return (Criteria) this;
        }

        public Criteria andLikeNamesBetween(String value1, String value2) {
            addCriterion("LIKE_NAMES between", value1, value2, "likeNames");
            return (Criteria) this;
        }

        public Criteria andLikeNamesNotBetween(String value1, String value2) {
            addCriterion("LIKE_NAMES not between", value1, value2, "likeNames");
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