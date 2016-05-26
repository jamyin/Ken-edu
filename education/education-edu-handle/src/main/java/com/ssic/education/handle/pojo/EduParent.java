package com.ssic.education.handle.pojo;

import java.util.Date;

public class EduParent {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_parent.id
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_parent.nick_name
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    private String nickName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_parent.thumbnail
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    private String thumbnail;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_parent.create_time
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_parent.last_update_time
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    private Date lastUpdateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_parent.stat
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    private Integer stat;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_parent.id
     *
     * @return the value of t_edu_parent.id
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_parent.id
     *
     * @param id the value for t_edu_parent.id
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_parent.nick_name
     *
     * @return the value of t_edu_parent.nick_name
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_parent.nick_name
     *
     * @param nickName the value for t_edu_parent.nick_name
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_parent.thumbnail
     *
     * @return the value of t_edu_parent.thumbnail
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_parent.thumbnail
     *
     * @param thumbnail the value for t_edu_parent.thumbnail
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail == null ? null : thumbnail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_parent.create_time
     *
     * @return the value of t_edu_parent.create_time
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_parent.create_time
     *
     * @param createTime the value for t_edu_parent.create_time
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_parent.last_update_time
     *
     * @return the value of t_edu_parent.last_update_time
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_parent.last_update_time
     *
     * @param lastUpdateTime the value for t_edu_parent.last_update_time
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_parent.stat
     *
     * @return the value of t_edu_parent.stat
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    public Integer getStat() {
        return stat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_parent.stat
     *
     * @param stat the value for t_edu_parent.stat
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    public void setStat(Integer stat) {
        this.stat = stat;
    }
}