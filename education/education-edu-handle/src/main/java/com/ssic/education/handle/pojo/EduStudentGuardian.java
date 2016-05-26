package com.ssic.education.handle.pojo;

import java.util.Date;

public class EduStudentGuardian {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_student_guardian.id
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_student_guardian.student_id
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    private String studentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_student_guardian.guardian_id
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    private String guardianId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_student_guardian.create_time
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_student_guardian.last_update_time
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    private Date lastUpdateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_student_guardian.stat
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    private Integer stat;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_student_guardian.id
     *
     * @return the value of t_edu_student_guardian.id
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_student_guardian.id
     *
     * @param id the value for t_edu_student_guardian.id
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_student_guardian.student_id
     *
     * @return the value of t_edu_student_guardian.student_id
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_student_guardian.student_id
     *
     * @param studentId the value for t_edu_student_guardian.student_id
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_student_guardian.guardian_id
     *
     * @return the value of t_edu_student_guardian.guardian_id
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    public String getGuardianId() {
        return guardianId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_student_guardian.guardian_id
     *
     * @param guardianId the value for t_edu_student_guardian.guardian_id
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    public void setGuardianId(String guardianId) {
        this.guardianId = guardianId == null ? null : guardianId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_student_guardian.create_time
     *
     * @return the value of t_edu_student_guardian.create_time
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_student_guardian.create_time
     *
     * @param createTime the value for t_edu_student_guardian.create_time
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_student_guardian.last_update_time
     *
     * @return the value of t_edu_student_guardian.last_update_time
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_student_guardian.last_update_time
     *
     * @param lastUpdateTime the value for t_edu_student_guardian.last_update_time
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_student_guardian.stat
     *
     * @return the value of t_edu_student_guardian.stat
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    public Integer getStat() {
        return stat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_student_guardian.stat
     *
     * @param stat the value for t_edu_student_guardian.stat
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    public void setStat(Integer stat) {
        this.stat = stat;
    }
}