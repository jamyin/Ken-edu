package com.ssic.education.common.pojo;

import java.util.Date;

public class EduTaskReceive {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_task_receive.id
     *
     * @mbggenerated Thu May 12 11:06:55 CST 2016
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_task_receive.task_id
     *
     * @mbggenerated Thu May 12 11:06:55 CST 2016
     */
    private String taskId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_task_receive.school_id
     *
     * @mbggenerated Thu May 12 11:06:55 CST 2016
     */
    private String schoolId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_task_receive.create_time
     *
     * @mbggenerated Thu May 12 11:06:55 CST 2016
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_task_receive.last_update_time
     *
     * @mbggenerated Thu May 12 11:06:55 CST 2016
     */
    private Date lastUpdateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_task_receive.stat
     *
     * @mbggenerated Thu May 12 11:06:55 CST 2016
     */
    private Integer stat;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_task_receive.id
     *
     * @return the value of t_edu_task_receive.id
     *
     * @mbggenerated Thu May 12 11:06:55 CST 2016
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_task_receive.id
     *
     * @param id the value for t_edu_task_receive.id
     *
     * @mbggenerated Thu May 12 11:06:55 CST 2016
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_task_receive.task_id
     *
     * @return the value of t_edu_task_receive.task_id
     *
     * @mbggenerated Thu May 12 11:06:55 CST 2016
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_task_receive.task_id
     *
     * @param taskId the value for t_edu_task_receive.task_id
     *
     * @mbggenerated Thu May 12 11:06:55 CST 2016
     */
    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_task_receive.school_id
     *
     * @return the value of t_edu_task_receive.school_id
     *
     * @mbggenerated Thu May 12 11:06:55 CST 2016
     */
    public String getSchoolId() {
        return schoolId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_task_receive.school_id
     *
     * @param schoolId the value for t_edu_task_receive.school_id
     *
     * @mbggenerated Thu May 12 11:06:55 CST 2016
     */
    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId == null ? null : schoolId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_task_receive.create_time
     *
     * @return the value of t_edu_task_receive.create_time
     *
     * @mbggenerated Thu May 12 11:06:55 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_task_receive.create_time
     *
     * @param createTime the value for t_edu_task_receive.create_time
     *
     * @mbggenerated Thu May 12 11:06:55 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_task_receive.last_update_time
     *
     * @return the value of t_edu_task_receive.last_update_time
     *
     * @mbggenerated Thu May 12 11:06:55 CST 2016
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_task_receive.last_update_time
     *
     * @param lastUpdateTime the value for t_edu_task_receive.last_update_time
     *
     * @mbggenerated Thu May 12 11:06:55 CST 2016
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_task_receive.stat
     *
     * @return the value of t_edu_task_receive.stat
     *
     * @mbggenerated Thu May 12 11:06:55 CST 2016
     */
    public Integer getStat() {
        return stat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_task_receive.stat
     *
     * @param stat the value for t_edu_task_receive.stat
     *
     * @mbggenerated Thu May 12 11:06:55 CST 2016
     */
    public void setStat(Integer stat) {
        this.stat = stat;
    }
}