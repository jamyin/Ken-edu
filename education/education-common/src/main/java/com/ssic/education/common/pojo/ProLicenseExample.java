package com.ssic.education.common.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ProLicenseExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_pro_license
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_pro_license
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_pro_license
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_license
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    public ProLicenseExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_license
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_license
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_license
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_license
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_license
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_license
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_license
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_license
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_license
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_license
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_pro_license
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andLicNameIsNull() {
            addCriterion("lic_name is null");
            return (Criteria) this;
        }

        public Criteria andLicNameIsNotNull() {
            addCriterion("lic_name is not null");
            return (Criteria) this;
        }

        public Criteria andLicNameEqualTo(String value) {
            addCriterion("lic_name =", value, "licName");
            return (Criteria) this;
        }

        public Criteria andLicNameNotEqualTo(String value) {
            addCriterion("lic_name <>", value, "licName");
            return (Criteria) this;
        }

        public Criteria andLicNameGreaterThan(String value) {
            addCriterion("lic_name >", value, "licName");
            return (Criteria) this;
        }

        public Criteria andLicNameGreaterThanOrEqualTo(String value) {
            addCriterion("lic_name >=", value, "licName");
            return (Criteria) this;
        }

        public Criteria andLicNameLessThan(String value) {
            addCriterion("lic_name <", value, "licName");
            return (Criteria) this;
        }

        public Criteria andLicNameLessThanOrEqualTo(String value) {
            addCriterion("lic_name <=", value, "licName");
            return (Criteria) this;
        }

        public Criteria andLicNameLike(String value) {
            addCriterion("lic_name like", value, "licName");
            return (Criteria) this;
        }

        public Criteria andLicNameNotLike(String value) {
            addCriterion("lic_name not like", value, "licName");
            return (Criteria) this;
        }

        public Criteria andLicNameIn(List<String> values) {
            addCriterion("lic_name in", values, "licName");
            return (Criteria) this;
        }

        public Criteria andLicNameNotIn(List<String> values) {
            addCriterion("lic_name not in", values, "licName");
            return (Criteria) this;
        }

        public Criteria andLicNameBetween(String value1, String value2) {
            addCriterion("lic_name between", value1, value2, "licName");
            return (Criteria) this;
        }

        public Criteria andLicNameNotBetween(String value1, String value2) {
            addCriterion("lic_name not between", value1, value2, "licName");
            return (Criteria) this;
        }

        public Criteria andLicNoIsNull() {
            addCriterion("lic_no is null");
            return (Criteria) this;
        }

        public Criteria andLicNoIsNotNull() {
            addCriterion("lic_no is not null");
            return (Criteria) this;
        }

        public Criteria andLicNoEqualTo(String value) {
            addCriterion("lic_no =", value, "licNo");
            return (Criteria) this;
        }

        public Criteria andLicNoNotEqualTo(String value) {
            addCriterion("lic_no <>", value, "licNo");
            return (Criteria) this;
        }

        public Criteria andLicNoGreaterThan(String value) {
            addCriterion("lic_no >", value, "licNo");
            return (Criteria) this;
        }

        public Criteria andLicNoGreaterThanOrEqualTo(String value) {
            addCriterion("lic_no >=", value, "licNo");
            return (Criteria) this;
        }

        public Criteria andLicNoLessThan(String value) {
            addCriterion("lic_no <", value, "licNo");
            return (Criteria) this;
        }

        public Criteria andLicNoLessThanOrEqualTo(String value) {
            addCriterion("lic_no <=", value, "licNo");
            return (Criteria) this;
        }

        public Criteria andLicNoLike(String value) {
            addCriterion("lic_no like", value, "licNo");
            return (Criteria) this;
        }

        public Criteria andLicNoNotLike(String value) {
            addCriterion("lic_no not like", value, "licNo");
            return (Criteria) this;
        }

        public Criteria andLicNoIn(List<String> values) {
            addCriterion("lic_no in", values, "licNo");
            return (Criteria) this;
        }

        public Criteria andLicNoNotIn(List<String> values) {
            addCriterion("lic_no not in", values, "licNo");
            return (Criteria) this;
        }

        public Criteria andLicNoBetween(String value1, String value2) {
            addCriterion("lic_no between", value1, value2, "licNo");
            return (Criteria) this;
        }

        public Criteria andLicNoNotBetween(String value1, String value2) {
            addCriterion("lic_no not between", value1, value2, "licNo");
            return (Criteria) this;
        }

        public Criteria andLicTypeIsNull() {
            addCriterion("lic_type is null");
            return (Criteria) this;
        }

        public Criteria andLicTypeIsNotNull() {
            addCriterion("lic_type is not null");
            return (Criteria) this;
        }

        public Criteria andLicTypeEqualTo(Integer value) {
            addCriterion("lic_type =", value, "licType");
            return (Criteria) this;
        }

        public Criteria andLicTypeNotEqualTo(Integer value) {
            addCriterion("lic_type <>", value, "licType");
            return (Criteria) this;
        }

        public Criteria andLicTypeGreaterThan(Integer value) {
            addCriterion("lic_type >", value, "licType");
            return (Criteria) this;
        }

        public Criteria andLicTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("lic_type >=", value, "licType");
            return (Criteria) this;
        }

        public Criteria andLicTypeLessThan(Integer value) {
            addCriterion("lic_type <", value, "licType");
            return (Criteria) this;
        }

        public Criteria andLicTypeLessThanOrEqualTo(Integer value) {
            addCriterion("lic_type <=", value, "licType");
            return (Criteria) this;
        }

        public Criteria andLicTypeIn(List<Integer> values) {
            addCriterion("lic_type in", values, "licType");
            return (Criteria) this;
        }

        public Criteria andLicTypeNotIn(List<Integer> values) {
            addCriterion("lic_type not in", values, "licType");
            return (Criteria) this;
        }

        public Criteria andLicTypeBetween(Integer value1, Integer value2) {
            addCriterion("lic_type between", value1, value2, "licType");
            return (Criteria) this;
        }

        public Criteria andLicTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("lic_type not between", value1, value2, "licType");
            return (Criteria) this;
        }

        public Criteria andLicEndDateIsNull() {
            addCriterion("lic_end_date is null");
            return (Criteria) this;
        }

        public Criteria andLicEndDateIsNotNull() {
            addCriterion("lic_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andLicEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("lic_end_date =", value, "licEndDate");
            return (Criteria) this;
        }

        public Criteria andLicEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("lic_end_date <>", value, "licEndDate");
            return (Criteria) this;
        }

        public Criteria andLicEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("lic_end_date >", value, "licEndDate");
            return (Criteria) this;
        }

        public Criteria andLicEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("lic_end_date >=", value, "licEndDate");
            return (Criteria) this;
        }

        public Criteria andLicEndDateLessThan(Date value) {
            addCriterionForJDBCDate("lic_end_date <", value, "licEndDate");
            return (Criteria) this;
        }

        public Criteria andLicEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("lic_end_date <=", value, "licEndDate");
            return (Criteria) this;
        }

        public Criteria andLicEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("lic_end_date in", values, "licEndDate");
            return (Criteria) this;
        }

        public Criteria andLicEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("lic_end_date not in", values, "licEndDate");
            return (Criteria) this;
        }

        public Criteria andLicEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("lic_end_date between", value1, value2, "licEndDate");
            return (Criteria) this;
        }

        public Criteria andLicEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("lic_end_date not between", value1, value2, "licEndDate");
            return (Criteria) this;
        }

        public Criteria andLicPicIsNull() {
            addCriterion("lic_pic is null");
            return (Criteria) this;
        }

        public Criteria andLicPicIsNotNull() {
            addCriterion("lic_pic is not null");
            return (Criteria) this;
        }

        public Criteria andLicPicEqualTo(String value) {
            addCriterion("lic_pic =", value, "licPic");
            return (Criteria) this;
        }

        public Criteria andLicPicNotEqualTo(String value) {
            addCriterion("lic_pic <>", value, "licPic");
            return (Criteria) this;
        }

        public Criteria andLicPicGreaterThan(String value) {
            addCriterion("lic_pic >", value, "licPic");
            return (Criteria) this;
        }

        public Criteria andLicPicGreaterThanOrEqualTo(String value) {
            addCriterion("lic_pic >=", value, "licPic");
            return (Criteria) this;
        }

        public Criteria andLicPicLessThan(String value) {
            addCriterion("lic_pic <", value, "licPic");
            return (Criteria) this;
        }

        public Criteria andLicPicLessThanOrEqualTo(String value) {
            addCriterion("lic_pic <=", value, "licPic");
            return (Criteria) this;
        }

        public Criteria andLicPicLike(String value) {
            addCriterion("lic_pic like", value, "licPic");
            return (Criteria) this;
        }

        public Criteria andLicPicNotLike(String value) {
            addCriterion("lic_pic not like", value, "licPic");
            return (Criteria) this;
        }

        public Criteria andLicPicIn(List<String> values) {
            addCriterion("lic_pic in", values, "licPic");
            return (Criteria) this;
        }

        public Criteria andLicPicNotIn(List<String> values) {
            addCriterion("lic_pic not in", values, "licPic");
            return (Criteria) this;
        }

        public Criteria andLicPicBetween(String value1, String value2) {
            addCriterion("lic_pic between", value1, value2, "licPic");
            return (Criteria) this;
        }

        public Criteria andLicPicNotBetween(String value1, String value2) {
            addCriterion("lic_pic not between", value1, value2, "licPic");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNull() {
            addCriterion("last_update_time is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNotNull() {
            addCriterion("last_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeEqualTo(Date value) {
            addCriterion("last_update_time =", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotEqualTo(Date value) {
            addCriterion("last_update_time <>", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThan(Date value) {
            addCriterion("last_update_time >", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_update_time >=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThan(Date value) {
            addCriterion("last_update_time <", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_update_time <=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIn(List<Date> values) {
            addCriterion("last_update_time in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotIn(List<Date> values) {
            addCriterion("last_update_time not in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("last_update_time between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_update_time not between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andStatIsNull() {
            addCriterion("stat is null");
            return (Criteria) this;
        }

        public Criteria andStatIsNotNull() {
            addCriterion("stat is not null");
            return (Criteria) this;
        }

        public Criteria andStatEqualTo(Integer value) {
            addCriterion("stat =", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotEqualTo(Integer value) {
            addCriterion("stat <>", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatGreaterThan(Integer value) {
            addCriterion("stat >", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatGreaterThanOrEqualTo(Integer value) {
            addCriterion("stat >=", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLessThan(Integer value) {
            addCriterion("stat <", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLessThanOrEqualTo(Integer value) {
            addCriterion("stat <=", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatIn(List<Integer> values) {
            addCriterion("stat in", values, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotIn(List<Integer> values) {
            addCriterion("stat not in", values, "stat");
            return (Criteria) this;
        }

        public Criteria andStatBetween(Integer value1, Integer value2) {
            addCriterion("stat between", value1, value2, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotBetween(Integer value1, Integer value2) {
            addCriterion("stat not between", value1, value2, "stat");
            return (Criteria) this;
        }

        public Criteria andRelationIdIsNull() {
            addCriterion("relation_id is null");
            return (Criteria) this;
        }

        public Criteria andRelationIdIsNotNull() {
            addCriterion("relation_id is not null");
            return (Criteria) this;
        }

        public Criteria andRelationIdEqualTo(String value) {
            addCriterion("relation_id =", value, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdNotEqualTo(String value) {
            addCriterion("relation_id <>", value, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdGreaterThan(String value) {
            addCriterion("relation_id >", value, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdGreaterThanOrEqualTo(String value) {
            addCriterion("relation_id >=", value, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdLessThan(String value) {
            addCriterion("relation_id <", value, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdLessThanOrEqualTo(String value) {
            addCriterion("relation_id <=", value, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdLike(String value) {
            addCriterion("relation_id like", value, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdNotLike(String value) {
            addCriterion("relation_id not like", value, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdIn(List<String> values) {
            addCriterion("relation_id in", values, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdNotIn(List<String> values) {
            addCriterion("relation_id not in", values, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdBetween(String value1, String value2) {
            addCriterion("relation_id between", value1, value2, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdNotBetween(String value1, String value2) {
            addCriterion("relation_id not between", value1, value2, "relationId");
            return (Criteria) this;
        }

        public Criteria andCerSourceIsNull() {
            addCriterion("cer_source is null");
            return (Criteria) this;
        }

        public Criteria andCerSourceIsNotNull() {
            addCriterion("cer_source is not null");
            return (Criteria) this;
        }

        public Criteria andCerSourceEqualTo(Short value) {
            addCriterion("cer_source =", value, "cerSource");
            return (Criteria) this;
        }

        public Criteria andCerSourceNotEqualTo(Short value) {
            addCriterion("cer_source <>", value, "cerSource");
            return (Criteria) this;
        }

        public Criteria andCerSourceGreaterThan(Short value) {
            addCriterion("cer_source >", value, "cerSource");
            return (Criteria) this;
        }

        public Criteria andCerSourceGreaterThanOrEqualTo(Short value) {
            addCriterion("cer_source >=", value, "cerSource");
            return (Criteria) this;
        }

        public Criteria andCerSourceLessThan(Short value) {
            addCriterion("cer_source <", value, "cerSource");
            return (Criteria) this;
        }

        public Criteria andCerSourceLessThanOrEqualTo(Short value) {
            addCriterion("cer_source <=", value, "cerSource");
            return (Criteria) this;
        }

        public Criteria andCerSourceIn(List<Short> values) {
            addCriterion("cer_source in", values, "cerSource");
            return (Criteria) this;
        }

        public Criteria andCerSourceNotIn(List<Short> values) {
            addCriterion("cer_source not in", values, "cerSource");
            return (Criteria) this;
        }

        public Criteria andCerSourceBetween(Short value1, Short value2) {
            addCriterion("cer_source between", value1, value2, "cerSource");
            return (Criteria) this;
        }

        public Criteria andCerSourceNotBetween(Short value1, Short value2) {
            addCriterion("cer_source not between", value1, value2, "cerSource");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_pro_license
     *
     * @mbggenerated do_not_delete_during_merge Wed May 11 10:54:36 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_pro_license
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
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