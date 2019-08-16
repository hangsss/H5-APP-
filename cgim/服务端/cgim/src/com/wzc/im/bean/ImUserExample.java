package com.wzc.im.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ImUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ImUserExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUimgIsNull() {
            addCriterion("UIMG is null");
            return (Criteria) this;
        }

        public Criteria andUimgIsNotNull() {
            addCriterion("UIMG is not null");
            return (Criteria) this;
        }

        public Criteria andUimgEqualTo(String value) {
            addCriterion("UIMG =", value, "uimg");
            return (Criteria) this;
        }

        public Criteria andUimgNotEqualTo(String value) {
            addCriterion("UIMG <>", value, "uimg");
            return (Criteria) this;
        }

        public Criteria andUimgGreaterThan(String value) {
            addCriterion("UIMG >", value, "uimg");
            return (Criteria) this;
        }

        public Criteria andUimgGreaterThanOrEqualTo(String value) {
            addCriterion("UIMG >=", value, "uimg");
            return (Criteria) this;
        }

        public Criteria andUimgLessThan(String value) {
            addCriterion("UIMG <", value, "uimg");
            return (Criteria) this;
        }

        public Criteria andUimgLessThanOrEqualTo(String value) {
            addCriterion("UIMG <=", value, "uimg");
            return (Criteria) this;
        }

        public Criteria andUimgLike(String value) {
            addCriterion("UIMG like", value, "uimg");
            return (Criteria) this;
        }

        public Criteria andUimgNotLike(String value) {
            addCriterion("UIMG not like", value, "uimg");
            return (Criteria) this;
        }

        public Criteria andUimgIn(List<String> values) {
            addCriterion("UIMG in", values, "uimg");
            return (Criteria) this;
        }

        public Criteria andUimgNotIn(List<String> values) {
            addCriterion("UIMG not in", values, "uimg");
            return (Criteria) this;
        }

        public Criteria andUimgBetween(String value1, String value2) {
            addCriterion("UIMG between", value1, value2, "uimg");
            return (Criteria) this;
        }

        public Criteria andUimgNotBetween(String value1, String value2) {
            addCriterion("UIMG not between", value1, value2, "uimg");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andRemarknameIsNull() {
            addCriterion("REMARKNAME is null");
            return (Criteria) this;
        }

        public Criteria andRemarknameIsNotNull() {
            addCriterion("REMARKNAME is not null");
            return (Criteria) this;
        }

        public Criteria andRemarknameEqualTo(String value) {
            addCriterion("REMARKNAME =", value, "remarkname");
            return (Criteria) this;
        }

        public Criteria andRemarknameNotEqualTo(String value) {
            addCriterion("REMARKNAME <>", value, "remarkname");
            return (Criteria) this;
        }

        public Criteria andRemarknameGreaterThan(String value) {
            addCriterion("REMARKNAME >", value, "remarkname");
            return (Criteria) this;
        }

        public Criteria andRemarknameGreaterThanOrEqualTo(String value) {
            addCriterion("REMARKNAME >=", value, "remarkname");
            return (Criteria) this;
        }

        public Criteria andRemarknameLessThan(String value) {
            addCriterion("REMARKNAME <", value, "remarkname");
            return (Criteria) this;
        }

        public Criteria andRemarknameLessThanOrEqualTo(String value) {
            addCriterion("REMARKNAME <=", value, "remarkname");
            return (Criteria) this;
        }

        public Criteria andRemarknameLike(String value) {
            addCriterion("REMARKNAME like", value, "remarkname");
            return (Criteria) this;
        }

        public Criteria andRemarknameNotLike(String value) {
            addCriterion("REMARKNAME not like", value, "remarkname");
            return (Criteria) this;
        }

        public Criteria andRemarknameIn(List<String> values) {
            addCriterion("REMARKNAME in", values, "remarkname");
            return (Criteria) this;
        }

        public Criteria andRemarknameNotIn(List<String> values) {
            addCriterion("REMARKNAME not in", values, "remarkname");
            return (Criteria) this;
        }

        public Criteria andRemarknameBetween(String value1, String value2) {
            addCriterion("REMARKNAME between", value1, value2, "remarkname");
            return (Criteria) this;
        }

        public Criteria andRemarknameNotBetween(String value1, String value2) {
            addCriterion("REMARKNAME not between", value1, value2, "remarkname");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("PASSWORD =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("PASSWORD <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("PASSWORD >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("PASSWORD >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("PASSWORD <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("PASSWORD <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("PASSWORD like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("PASSWORD not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("PASSWORD in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("PASSWORD not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("PASSWORD between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("PASSWORD not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andCellphoneIsNull() {
            addCriterion("CELLPHONE is null");
            return (Criteria) this;
        }

        public Criteria andCellphoneIsNotNull() {
            addCriterion("CELLPHONE is not null");
            return (Criteria) this;
        }

        public Criteria andCellphoneEqualTo(String value) {
            addCriterion("CELLPHONE =", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneNotEqualTo(String value) {
            addCriterion("CELLPHONE <>", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneGreaterThan(String value) {
            addCriterion("CELLPHONE >", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneGreaterThanOrEqualTo(String value) {
            addCriterion("CELLPHONE >=", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneLessThan(String value) {
            addCriterion("CELLPHONE <", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneLessThanOrEqualTo(String value) {
            addCriterion("CELLPHONE <=", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneLike(String value) {
            addCriterion("CELLPHONE like", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneNotLike(String value) {
            addCriterion("CELLPHONE not like", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneIn(List<String> values) {
            addCriterion("CELLPHONE in", values, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneNotIn(List<String> values) {
            addCriterion("CELLPHONE not in", values, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneBetween(String value1, String value2) {
            addCriterion("CELLPHONE between", value1, value2, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneNotBetween(String value1, String value2) {
            addCriterion("CELLPHONE not between", value1, value2, "cellphone");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("BIRTHDAY is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("BIRTHDAY is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("BIRTHDAY =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("BIRTHDAY <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("BIRTHDAY >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("BIRTHDAY >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("BIRTHDAY <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("BIRTHDAY <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("BIRTHDAY in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("BIRTHDAY not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("BIRTHDAY between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("BIRTHDAY not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("GENDER is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("GENDER is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(String value) {
            addCriterion("GENDER =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(String value) {
            addCriterion("GENDER <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(String value) {
            addCriterion("GENDER >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(String value) {
            addCriterion("GENDER >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(String value) {
            addCriterion("GENDER <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(String value) {
            addCriterion("GENDER <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLike(String value) {
            addCriterion("GENDER like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotLike(String value) {
            addCriterion("GENDER not like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<String> values) {
            addCriterion("GENDER in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<String> values) {
            addCriterion("GENDER not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(String value1, String value2) {
            addCriterion("GENDER between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(String value1, String value2) {
            addCriterion("GENDER not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("AGE is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("AGE is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(String value) {
            addCriterion("AGE =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(String value) {
            addCriterion("AGE <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(String value) {
            addCriterion("AGE >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(String value) {
            addCriterion("AGE >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(String value) {
            addCriterion("AGE <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(String value) {
            addCriterion("AGE <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLike(String value) {
            addCriterion("AGE like", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotLike(String value) {
            addCriterion("AGE not like", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<String> values) {
            addCriterion("AGE in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<String> values) {
            addCriterion("AGE not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(String value1, String value2) {
            addCriterion("AGE between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(String value1, String value2) {
            addCriterion("AGE not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("ADDRESS =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("ADDRESS <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("ADDRESS >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESS >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("ADDRESS <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("ADDRESS <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("ADDRESS like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("ADDRESS not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("ADDRESS in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("ADDRESS not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("ADDRESS between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("ADDRESS not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("EMAIL =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("EMAIL <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("EMAIL >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("EMAIL <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("EMAIL <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("EMAIL like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("EMAIL not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("EMAIL in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("EMAIL not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("EMAIL between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("EMAIL not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andHobbyIsNull() {
            addCriterion("HOBBY is null");
            return (Criteria) this;
        }

        public Criteria andHobbyIsNotNull() {
            addCriterion("HOBBY is not null");
            return (Criteria) this;
        }

        public Criteria andHobbyEqualTo(String value) {
            addCriterion("HOBBY =", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyNotEqualTo(String value) {
            addCriterion("HOBBY <>", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyGreaterThan(String value) {
            addCriterion("HOBBY >", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyGreaterThanOrEqualTo(String value) {
            addCriterion("HOBBY >=", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyLessThan(String value) {
            addCriterion("HOBBY <", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyLessThanOrEqualTo(String value) {
            addCriterion("HOBBY <=", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyLike(String value) {
            addCriterion("HOBBY like", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyNotLike(String value) {
            addCriterion("HOBBY not like", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyIn(List<String> values) {
            addCriterion("HOBBY in", values, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyNotIn(List<String> values) {
            addCriterion("HOBBY not in", values, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyBetween(String value1, String value2) {
            addCriterion("HOBBY between", value1, value2, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyNotBetween(String value1, String value2) {
            addCriterion("HOBBY not between", value1, value2, "hobby");
            return (Criteria) this;
        }

        public Criteria andSignatureIsNull() {
            addCriterion("SIGNATURE is null");
            return (Criteria) this;
        }

        public Criteria andSignatureIsNotNull() {
            addCriterion("SIGNATURE is not null");
            return (Criteria) this;
        }

        public Criteria andSignatureEqualTo(String value) {
            addCriterion("SIGNATURE =", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotEqualTo(String value) {
            addCriterion("SIGNATURE <>", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureGreaterThan(String value) {
            addCriterion("SIGNATURE >", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureGreaterThanOrEqualTo(String value) {
            addCriterion("SIGNATURE >=", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureLessThan(String value) {
            addCriterion("SIGNATURE <", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureLessThanOrEqualTo(String value) {
            addCriterion("SIGNATURE <=", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureLike(String value) {
            addCriterion("SIGNATURE like", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotLike(String value) {
            addCriterion("SIGNATURE not like", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureIn(List<String> values) {
            addCriterion("SIGNATURE in", values, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotIn(List<String> values) {
            addCriterion("SIGNATURE not in", values, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureBetween(String value1, String value2) {
            addCriterion("SIGNATURE between", value1, value2, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotBetween(String value1, String value2) {
            addCriterion("SIGNATURE not between", value1, value2, "signature");
            return (Criteria) this;
        }

        public Criteria andFriendsIsNull() {
            addCriterion("FRIENDS is null");
            return (Criteria) this;
        }

        public Criteria andFriendsIsNotNull() {
            addCriterion("FRIENDS is not null");
            return (Criteria) this;
        }

        public Criteria andFriendsEqualTo(String value) {
            addCriterion("FRIENDS =", value, "friends");
            return (Criteria) this;
        }

        public Criteria andFriendsNotEqualTo(String value) {
            addCriterion("FRIENDS <>", value, "friends");
            return (Criteria) this;
        }

        public Criteria andFriendsGreaterThan(String value) {
            addCriterion("FRIENDS >", value, "friends");
            return (Criteria) this;
        }

        public Criteria andFriendsGreaterThanOrEqualTo(String value) {
            addCriterion("FRIENDS >=", value, "friends");
            return (Criteria) this;
        }

        public Criteria andFriendsLessThan(String value) {
            addCriterion("FRIENDS <", value, "friends");
            return (Criteria) this;
        }

        public Criteria andFriendsLessThanOrEqualTo(String value) {
            addCriterion("FRIENDS <=", value, "friends");
            return (Criteria) this;
        }

        public Criteria andFriendsLike(String value) {
            addCriterion("FRIENDS like", value, "friends");
            return (Criteria) this;
        }

        public Criteria andFriendsNotLike(String value) {
            addCriterion("FRIENDS not like", value, "friends");
            return (Criteria) this;
        }

        public Criteria andFriendsIn(List<String> values) {
            addCriterion("FRIENDS in", values, "friends");
            return (Criteria) this;
        }

        public Criteria andFriendsNotIn(List<String> values) {
            addCriterion("FRIENDS not in", values, "friends");
            return (Criteria) this;
        }

        public Criteria andFriendsBetween(String value1, String value2) {
            addCriterion("FRIENDS between", value1, value2, "friends");
            return (Criteria) this;
        }

        public Criteria andFriendsNotBetween(String value1, String value2) {
            addCriterion("FRIENDS not between", value1, value2, "friends");
            return (Criteria) this;
        }

        public Criteria andGroupsIsNull() {
            addCriterion("GROUPS is null");
            return (Criteria) this;
        }

        public Criteria andGroupsIsNotNull() {
            addCriterion("GROUPS is not null");
            return (Criteria) this;
        }

        public Criteria andGroupsEqualTo(String value) {
            addCriterion("GROUPS =", value, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsNotEqualTo(String value) {
            addCriterion("GROUPS <>", value, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsGreaterThan(String value) {
            addCriterion("GROUPS >", value, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsGreaterThanOrEqualTo(String value) {
            addCriterion("GROUPS >=", value, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsLessThan(String value) {
            addCriterion("GROUPS <", value, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsLessThanOrEqualTo(String value) {
            addCriterion("GROUPS <=", value, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsLike(String value) {
            addCriterion("GROUPS like", value, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsNotLike(String value) {
            addCriterion("GROUPS not like", value, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsIn(List<String> values) {
            addCriterion("GROUPS in", values, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsNotIn(List<String> values) {
            addCriterion("GROUPS not in", values, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsBetween(String value1, String value2) {
            addCriterion("GROUPS between", value1, value2, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsNotBetween(String value1, String value2) {
            addCriterion("GROUPS not between", value1, value2, "groups");
            return (Criteria) this;
        }

        public Criteria andTalklistIsNull() {
            addCriterion("TALKLIST is null");
            return (Criteria) this;
        }

        public Criteria andTalklistIsNotNull() {
            addCriterion("TALKLIST is not null");
            return (Criteria) this;
        }

        public Criteria andTalklistEqualTo(String value) {
            addCriterion("TALKLIST =", value, "talklist");
            return (Criteria) this;
        }

        public Criteria andTalklistNotEqualTo(String value) {
            addCriterion("TALKLIST <>", value, "talklist");
            return (Criteria) this;
        }

        public Criteria andTalklistGreaterThan(String value) {
            addCriterion("TALKLIST >", value, "talklist");
            return (Criteria) this;
        }

        public Criteria andTalklistGreaterThanOrEqualTo(String value) {
            addCriterion("TALKLIST >=", value, "talklist");
            return (Criteria) this;
        }

        public Criteria andTalklistLessThan(String value) {
            addCriterion("TALKLIST <", value, "talklist");
            return (Criteria) this;
        }

        public Criteria andTalklistLessThanOrEqualTo(String value) {
            addCriterion("TALKLIST <=", value, "talklist");
            return (Criteria) this;
        }

        public Criteria andTalklistLike(String value) {
            addCriterion("TALKLIST like", value, "talklist");
            return (Criteria) this;
        }

        public Criteria andTalklistNotLike(String value) {
            addCriterion("TALKLIST not like", value, "talklist");
            return (Criteria) this;
        }

        public Criteria andTalklistIn(List<String> values) {
            addCriterion("TALKLIST in", values, "talklist");
            return (Criteria) this;
        }

        public Criteria andTalklistNotIn(List<String> values) {
            addCriterion("TALKLIST not in", values, "talklist");
            return (Criteria) this;
        }

        public Criteria andTalklistBetween(String value1, String value2) {
            addCriterion("TALKLIST between", value1, value2, "talklist");
            return (Criteria) this;
        }

        public Criteria andTalklistNotBetween(String value1, String value2) {
            addCriterion("TALKLIST not between", value1, value2, "talklist");
            return (Criteria) this;
        }

        public Criteria andOnlinetimeIsNull() {
            addCriterion("ONLINETIME is null");
            return (Criteria) this;
        }

        public Criteria andOnlinetimeIsNotNull() {
            addCriterion("ONLINETIME is not null");
            return (Criteria) this;
        }

        public Criteria andOnlinetimeEqualTo(Date value) {
            addCriterion("ONLINETIME =", value, "onlinetime");
            return (Criteria) this;
        }

        public Criteria andOnlinetimeNotEqualTo(Date value) {
            addCriterion("ONLINETIME <>", value, "onlinetime");
            return (Criteria) this;
        }

        public Criteria andOnlinetimeGreaterThan(Date value) {
            addCriterion("ONLINETIME >", value, "onlinetime");
            return (Criteria) this;
        }

        public Criteria andOnlinetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ONLINETIME >=", value, "onlinetime");
            return (Criteria) this;
        }

        public Criteria andOnlinetimeLessThan(Date value) {
            addCriterion("ONLINETIME <", value, "onlinetime");
            return (Criteria) this;
        }

        public Criteria andOnlinetimeLessThanOrEqualTo(Date value) {
            addCriterion("ONLINETIME <=", value, "onlinetime");
            return (Criteria) this;
        }

        public Criteria andOnlinetimeIn(List<Date> values) {
            addCriterion("ONLINETIME in", values, "onlinetime");
            return (Criteria) this;
        }

        public Criteria andOnlinetimeNotIn(List<Date> values) {
            addCriterion("ONLINETIME not in", values, "onlinetime");
            return (Criteria) this;
        }

        public Criteria andOnlinetimeBetween(Date value1, Date value2) {
            addCriterion("ONLINETIME between", value1, value2, "onlinetime");
            return (Criteria) this;
        }

        public Criteria andOnlinetimeNotBetween(Date value1, Date value2) {
            addCriterion("ONLINETIME not between", value1, value2, "onlinetime");
            return (Criteria) this;
        }

        public Criteria andOfflinetimeIsNull() {
            addCriterion("OFFLINETIME is null");
            return (Criteria) this;
        }

        public Criteria andOfflinetimeIsNotNull() {
            addCriterion("OFFLINETIME is not null");
            return (Criteria) this;
        }

        public Criteria andOfflinetimeEqualTo(Date value) {
            addCriterion("OFFLINETIME =", value, "offlinetime");
            return (Criteria) this;
        }

        public Criteria andOfflinetimeNotEqualTo(Date value) {
            addCriterion("OFFLINETIME <>", value, "offlinetime");
            return (Criteria) this;
        }

        public Criteria andOfflinetimeGreaterThan(Date value) {
            addCriterion("OFFLINETIME >", value, "offlinetime");
            return (Criteria) this;
        }

        public Criteria andOfflinetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("OFFLINETIME >=", value, "offlinetime");
            return (Criteria) this;
        }

        public Criteria andOfflinetimeLessThan(Date value) {
            addCriterion("OFFLINETIME <", value, "offlinetime");
            return (Criteria) this;
        }

        public Criteria andOfflinetimeLessThanOrEqualTo(Date value) {
            addCriterion("OFFLINETIME <=", value, "offlinetime");
            return (Criteria) this;
        }

        public Criteria andOfflinetimeIn(List<Date> values) {
            addCriterion("OFFLINETIME in", values, "offlinetime");
            return (Criteria) this;
        }

        public Criteria andOfflinetimeNotIn(List<Date> values) {
            addCriterion("OFFLINETIME not in", values, "offlinetime");
            return (Criteria) this;
        }

        public Criteria andOfflinetimeBetween(Date value1, Date value2) {
            addCriterion("OFFLINETIME between", value1, value2, "offlinetime");
            return (Criteria) this;
        }

        public Criteria andOfflinetimeNotBetween(Date value1, Date value2) {
            addCriterion("OFFLINETIME not between", value1, value2, "offlinetime");
            return (Criteria) this;
        }

        public Criteria andScrapIsNull() {
            addCriterion("SCRAP is null");
            return (Criteria) this;
        }

        public Criteria andScrapIsNotNull() {
            addCriterion("SCRAP is not null");
            return (Criteria) this;
        }

        public Criteria andScrapEqualTo(String value) {
            addCriterion("SCRAP =", value, "scrap");
            return (Criteria) this;
        }

        public Criteria andScrapNotEqualTo(String value) {
            addCriterion("SCRAP <>", value, "scrap");
            return (Criteria) this;
        }

        public Criteria andScrapGreaterThan(String value) {
            addCriterion("SCRAP >", value, "scrap");
            return (Criteria) this;
        }

        public Criteria andScrapGreaterThanOrEqualTo(String value) {
            addCriterion("SCRAP >=", value, "scrap");
            return (Criteria) this;
        }

        public Criteria andScrapLessThan(String value) {
            addCriterion("SCRAP <", value, "scrap");
            return (Criteria) this;
        }

        public Criteria andScrapLessThanOrEqualTo(String value) {
            addCriterion("SCRAP <=", value, "scrap");
            return (Criteria) this;
        }

        public Criteria andScrapLike(String value) {
            addCriterion("SCRAP like", value, "scrap");
            return (Criteria) this;
        }

        public Criteria andScrapNotLike(String value) {
            addCriterion("SCRAP not like", value, "scrap");
            return (Criteria) this;
        }

        public Criteria andScrapIn(List<String> values) {
            addCriterion("SCRAP in", values, "scrap");
            return (Criteria) this;
        }

        public Criteria andScrapNotIn(List<String> values) {
            addCriterion("SCRAP not in", values, "scrap");
            return (Criteria) this;
        }

        public Criteria andScrapBetween(String value1, String value2) {
            addCriterion("SCRAP between", value1, value2, "scrap");
            return (Criteria) this;
        }

        public Criteria andScrapNotBetween(String value1, String value2) {
            addCriterion("SCRAP not between", value1, value2, "scrap");
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