package com.ssic.education.common.pojo;

import java.util.Date;

public class Grade {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_grade.id
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_grade.grade_name
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private String gradeName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_grade.grade_level
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private Integer gradeLevel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_grade.school_level
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private Integer schoolLevel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_grade.school_id
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private String schoolId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_grade.create_time
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_grade.last_update_time
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private Date lastUpdateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_grade.stat
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private Integer stat;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_grade.id
     *
     * @return the value of t_edu_grade.id
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_grade.id
     *
     * @param id the value for t_edu_grade.id
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_grade.grade_name
     *
     * @return the value of t_edu_grade.grade_name
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public String getGradeName() {
        return gradeName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_grade.grade_name
     *
     * @param gradeName the value for t_edu_grade.grade_name
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setGradeName(String gradeName) {
        this.gradeName = gradeName == null ? null : gradeName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_grade.grade_level
     *
     * @return the value of t_edu_grade.grade_level
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public Integer getGradeLevel() {
        return gradeLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_grade.grade_level
     *
     * @param gradeLevel the value for t_edu_grade.grade_level
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setGradeLevel(Integer gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_grade.school_level
     *
     * @return the value of t_edu_grade.school_level
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public Integer getSchoolLevel() {
        return schoolLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_grade.school_level
     *
     * @param schoolLevel the value for t_edu_grade.school_level
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setSchoolLevel(Integer schoolLevel) {
        this.schoolLevel = schoolLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_grade.school_id
     *
     * @return the value of t_edu_grade.school_id
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public String getSchoolId() {
        return schoolId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_grade.school_id
     *
     * @param schoolId the value for t_edu_grade.school_id
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId == null ? null : schoolId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_grade.create_time
     *
     * @return the value of t_edu_grade.create_time
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_grade.create_time
     *
     * @param createTime the value for t_edu_grade.create_time
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_grade.last_update_time
     *
     * @return the value of t_edu_grade.last_update_time
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_grade.last_update_time
     *
     * @param lastUpdateTime the value for t_edu_grade.last_update_time
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_grade.stat
     *
     * @return the value of t_edu_grade.stat
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public Integer getStat() {
        return stat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_grade.stat
     *
     * @param stat the value for t_edu_grade.stat
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setStat(Integer stat) {
        this.stat = stat;
    }
}