package com.ssic.education.common.pojo;

import java.util.Date;

public class EduSchool {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_school.id
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_school.school_name
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    private String schoolName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_school.mobile_no
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    private String mobileNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_school.address
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_school.longitude
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    private String longitude;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_school.latitude
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    private String latitude;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_school.level
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    private Byte level;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_school.province
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    private String province;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_school.city
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    private String city;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_school.area
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    private String area;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_school.create_time
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_school.last_update_time
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    private Date lastUpdateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_school.stat
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    private Integer stat;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_school.id
     *
     * @return the value of t_edu_school.id
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_school.id
     *
     * @param id the value for t_edu_school.id
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_school.school_name
     *
     * @return the value of t_edu_school.school_name
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    public String getSchoolName() {
        return schoolName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_school.school_name
     *
     * @param schoolName the value for t_edu_school.school_name
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName == null ? null : schoolName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_school.mobile_no
     *
     * @return the value of t_edu_school.mobile_no
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_school.mobile_no
     *
     * @param mobileNo the value for t_edu_school.mobile_no
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo == null ? null : mobileNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_school.address
     *
     * @return the value of t_edu_school.address
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_school.address
     *
     * @param address the value for t_edu_school.address
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_school.longitude
     *
     * @return the value of t_edu_school.longitude
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_school.longitude
     *
     * @param longitude the value for t_edu_school.longitude
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_school.latitude
     *
     * @return the value of t_edu_school.latitude
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_school.latitude
     *
     * @param latitude the value for t_edu_school.latitude
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_school.level
     *
     * @return the value of t_edu_school.level
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    public Byte getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_school.level
     *
     * @param level the value for t_edu_school.level
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    public void setLevel(Byte level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_school.province
     *
     * @return the value of t_edu_school.province
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    public String getProvince() {
        return province;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_school.province
     *
     * @param province the value for t_edu_school.province
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_school.city
     *
     * @return the value of t_edu_school.city
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    public String getCity() {
        return city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_school.city
     *
     * @param city the value for t_edu_school.city
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_school.area
     *
     * @return the value of t_edu_school.area
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    public String getArea() {
        return area;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_school.area
     *
     * @param area the value for t_edu_school.area
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_school.create_time
     *
     * @return the value of t_edu_school.create_time
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_school.create_time
     *
     * @param createTime the value for t_edu_school.create_time
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_school.last_update_time
     *
     * @return the value of t_edu_school.last_update_time
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_school.last_update_time
     *
     * @param lastUpdateTime the value for t_edu_school.last_update_time
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_school.stat
     *
     * @return the value of t_edu_school.stat
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    public Integer getStat() {
        return stat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_school.stat
     *
     * @param stat the value for t_edu_school.stat
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    public void setStat(Integer stat) {
        this.stat = stat;
    }
}