package com.ssic.education.common.pojo;

import java.util.Date;

public class SensitiveWaringReport {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_sensitive_waring_report.id
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_sensitive_waring_report.sensitive_id
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private String sensitiveId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_sensitive_waring_report.sensitive_name
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private String sensitiveName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_sensitive_waring_report.school_id
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private String schoolId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_sensitive_waring_report.address_id
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private String addressId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_sensitive_waring_report.address_name
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private String addressName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_sensitive_waring_report.count
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private Integer count;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_sensitive_waring_report.warning
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private Integer warning;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_sensitive_waring_report.message
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private String message;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_sensitive_waring_report.warningproportion
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private Float warningproportion;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_sensitive_waring_report.create_time
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_sensitive_waring_report.last_update_time
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private Date lastUpdateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_sensitive_waring_report.stat
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private Integer stat;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_sensitive_waring_report.id
     *
     * @return the value of t_edu_sensitive_waring_report.id
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_sensitive_waring_report.id
     *
     * @param id the value for t_edu_sensitive_waring_report.id
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_sensitive_waring_report.sensitive_id
     *
     * @return the value of t_edu_sensitive_waring_report.sensitive_id
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public String getSensitiveId() {
        return sensitiveId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_sensitive_waring_report.sensitive_id
     *
     * @param sensitiveId the value for t_edu_sensitive_waring_report.sensitive_id
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setSensitiveId(String sensitiveId) {
        this.sensitiveId = sensitiveId == null ? null : sensitiveId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_sensitive_waring_report.sensitive_name
     *
     * @return the value of t_edu_sensitive_waring_report.sensitive_name
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public String getSensitiveName() {
        return sensitiveName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_sensitive_waring_report.sensitive_name
     *
     * @param sensitiveName the value for t_edu_sensitive_waring_report.sensitive_name
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setSensitiveName(String sensitiveName) {
        this.sensitiveName = sensitiveName == null ? null : sensitiveName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_sensitive_waring_report.school_id
     *
     * @return the value of t_edu_sensitive_waring_report.school_id
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public String getSchoolId() {
        return schoolId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_sensitive_waring_report.school_id
     *
     * @param schoolId the value for t_edu_sensitive_waring_report.school_id
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId == null ? null : schoolId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_sensitive_waring_report.address_id
     *
     * @return the value of t_edu_sensitive_waring_report.address_id
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public String getAddressId() {
        return addressId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_sensitive_waring_report.address_id
     *
     * @param addressId the value for t_edu_sensitive_waring_report.address_id
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setAddressId(String addressId) {
        this.addressId = addressId == null ? null : addressId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_sensitive_waring_report.address_name
     *
     * @return the value of t_edu_sensitive_waring_report.address_name
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public String getAddressName() {
        return addressName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_sensitive_waring_report.address_name
     *
     * @param addressName the value for t_edu_sensitive_waring_report.address_name
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setAddressName(String addressName) {
        this.addressName = addressName == null ? null : addressName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_sensitive_waring_report.count
     *
     * @return the value of t_edu_sensitive_waring_report.count
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public Integer getCount() {
        return count;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_sensitive_waring_report.count
     *
     * @param count the value for t_edu_sensitive_waring_report.count
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_sensitive_waring_report.warning
     *
     * @return the value of t_edu_sensitive_waring_report.warning
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public Integer getWarning() {
        return warning;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_sensitive_waring_report.warning
     *
     * @param warning the value for t_edu_sensitive_waring_report.warning
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setWarning(Integer warning) {
        this.warning = warning;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_sensitive_waring_report.message
     *
     * @return the value of t_edu_sensitive_waring_report.message
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public String getMessage() {
        return message;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_sensitive_waring_report.message
     *
     * @param message the value for t_edu_sensitive_waring_report.message
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_sensitive_waring_report.warningproportion
     *
     * @return the value of t_edu_sensitive_waring_report.warningproportion
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public Float getWarningproportion() {
        return warningproportion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_sensitive_waring_report.warningproportion
     *
     * @param warningproportion the value for t_edu_sensitive_waring_report.warningproportion
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setWarningproportion(Float warningproportion) {
        this.warningproportion = warningproportion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_sensitive_waring_report.create_time
     *
     * @return the value of t_edu_sensitive_waring_report.create_time
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_sensitive_waring_report.create_time
     *
     * @param createTime the value for t_edu_sensitive_waring_report.create_time
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_sensitive_waring_report.last_update_time
     *
     * @return the value of t_edu_sensitive_waring_report.last_update_time
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_sensitive_waring_report.last_update_time
     *
     * @param lastUpdateTime the value for t_edu_sensitive_waring_report.last_update_time
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_sensitive_waring_report.stat
     *
     * @return the value of t_edu_sensitive_waring_report.stat
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public Integer getStat() {
        return stat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_sensitive_waring_report.stat
     *
     * @param stat the value for t_edu_sensitive_waring_report.stat
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setStat(Integer stat) {
        this.stat = stat;
    }
}