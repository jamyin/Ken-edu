package com.ssic.education.common.pojo;

import java.util.Date;

public class EduSchoolSupplier {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_school_supplier.id
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_school_supplier.school_id
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    private String schoolId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_school_supplier.supplier_id
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    private String supplierId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_school_supplier.create_time
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_school_supplier.last_update_time
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    private Date lastUpdateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_school_supplier.stat
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    private Integer stat;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_school_supplier.id
     *
     * @return the value of t_edu_school_supplier.id
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_school_supplier.id
     *
     * @param id the value for t_edu_school_supplier.id
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_school_supplier.school_id
     *
     * @return the value of t_edu_school_supplier.school_id
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    public String getSchoolId() {
        return schoolId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_school_supplier.school_id
     *
     * @param schoolId the value for t_edu_school_supplier.school_id
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId == null ? null : schoolId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_school_supplier.supplier_id
     *
     * @return the value of t_edu_school_supplier.supplier_id
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    public String getSupplierId() {
        return supplierId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_school_supplier.supplier_id
     *
     * @param supplierId the value for t_edu_school_supplier.supplier_id
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId == null ? null : supplierId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_school_supplier.create_time
     *
     * @return the value of t_edu_school_supplier.create_time
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_school_supplier.create_time
     *
     * @param createTime the value for t_edu_school_supplier.create_time
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_school_supplier.last_update_time
     *
     * @return the value of t_edu_school_supplier.last_update_time
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_school_supplier.last_update_time
     *
     * @param lastUpdateTime the value for t_edu_school_supplier.last_update_time
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_school_supplier.stat
     *
     * @return the value of t_edu_school_supplier.stat
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    public Integer getStat() {
        return stat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_school_supplier.stat
     *
     * @param stat the value for t_edu_school_supplier.stat
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    public void setStat(Integer stat) {
        this.stat = stat;
    }
}