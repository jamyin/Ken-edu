package com.ssic.education.pro.pojo;

import java.util.Date;

public class ProLicense {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_license.id
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_license.lic_name
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    private String licName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_license.lic_no
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    private String licNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_license.lic_type
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    private Integer licType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_license.lic_end_date
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    private Date licEndDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_license.lic_pic
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    private String licPic;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_license.create_time
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_license.last_update_time
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    private Date lastUpdateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_license.stat
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    private Integer stat;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_license.relation_id
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    private String relationId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_license.cer_source
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    private Short cerSource;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_license.id
     *
     * @return the value of t_pro_license.id
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pro_license.id
     *
     * @param id the value for t_pro_license.id
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_license.lic_name
     *
     * @return the value of t_pro_license.lic_name
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    public String getLicName() {
        return licName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pro_license.lic_name
     *
     * @param licName the value for t_pro_license.lic_name
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    public void setLicName(String licName) {
        this.licName = licName == null ? null : licName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_license.lic_no
     *
     * @return the value of t_pro_license.lic_no
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    public String getLicNo() {
        return licNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pro_license.lic_no
     *
     * @param licNo the value for t_pro_license.lic_no
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    public void setLicNo(String licNo) {
        this.licNo = licNo == null ? null : licNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_license.lic_type
     *
     * @return the value of t_pro_license.lic_type
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    public Integer getLicType() {
        return licType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pro_license.lic_type
     *
     * @param licType the value for t_pro_license.lic_type
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    public void setLicType(Integer licType) {
        this.licType = licType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_license.lic_end_date
     *
     * @return the value of t_pro_license.lic_end_date
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    public Date getLicEndDate() {
        return licEndDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pro_license.lic_end_date
     *
     * @param licEndDate the value for t_pro_license.lic_end_date
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    public void setLicEndDate(Date licEndDate) {
        this.licEndDate = licEndDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_license.lic_pic
     *
     * @return the value of t_pro_license.lic_pic
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    public String getLicPic() {
        return licPic;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pro_license.lic_pic
     *
     * @param licPic the value for t_pro_license.lic_pic
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    public void setLicPic(String licPic) {
        this.licPic = licPic == null ? null : licPic.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_license.create_time
     *
     * @return the value of t_pro_license.create_time
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pro_license.create_time
     *
     * @param createTime the value for t_pro_license.create_time
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_license.last_update_time
     *
     * @return the value of t_pro_license.last_update_time
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pro_license.last_update_time
     *
     * @param lastUpdateTime the value for t_pro_license.last_update_time
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_license.stat
     *
     * @return the value of t_pro_license.stat
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    public Integer getStat() {
        return stat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pro_license.stat
     *
     * @param stat the value for t_pro_license.stat
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    public void setStat(Integer stat) {
        this.stat = stat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_license.relation_id
     *
     * @return the value of t_pro_license.relation_id
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    public String getRelationId() {
        return relationId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pro_license.relation_id
     *
     * @param relationId the value for t_pro_license.relation_id
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    public void setRelationId(String relationId) {
        this.relationId = relationId == null ? null : relationId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_license.cer_source
     *
     * @return the value of t_pro_license.cer_source
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    public Short getCerSource() {
        return cerSource;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pro_license.cer_source
     *
     * @param cerSource the value for t_pro_license.cer_source
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    public void setCerSource(Short cerSource) {
        this.cerSource = cerSource;
    }
}