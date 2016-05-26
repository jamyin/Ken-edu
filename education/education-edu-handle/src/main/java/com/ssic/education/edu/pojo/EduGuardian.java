package com.ssic.education.edu.pojo;

import java.util.Date;

public class EduGuardian {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_guardian.id
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_guardian.guardian_name
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    private String guardianName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_guardian.identity_card
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    private String identityCard;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_guardian.create_time
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_guardian.last_update_time
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    private Date lastUpdateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_guardian.stat
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    private Integer stat;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_guardian.id
     *
     * @return the value of t_edu_guardian.id
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_guardian.id
     *
     * @param id the value for t_edu_guardian.id
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_guardian.guardian_name
     *
     * @return the value of t_edu_guardian.guardian_name
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    public String getGuardianName() {
        return guardianName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_guardian.guardian_name
     *
     * @param guardianName the value for t_edu_guardian.guardian_name
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName == null ? null : guardianName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_guardian.identity_card
     *
     * @return the value of t_edu_guardian.identity_card
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    public String getIdentityCard() {
        return identityCard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_guardian.identity_card
     *
     * @param identityCard the value for t_edu_guardian.identity_card
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard == null ? null : identityCard.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_guardian.create_time
     *
     * @return the value of t_edu_guardian.create_time
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_guardian.create_time
     *
     * @param createTime the value for t_edu_guardian.create_time
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_guardian.last_update_time
     *
     * @return the value of t_edu_guardian.last_update_time
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_guardian.last_update_time
     *
     * @param lastUpdateTime the value for t_edu_guardian.last_update_time
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_guardian.stat
     *
     * @return the value of t_edu_guardian.stat
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    public Integer getStat() {
        return stat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_guardian.stat
     *
     * @param stat the value for t_edu_guardian.stat
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    public void setStat(Integer stat) {
        this.stat = stat;
    }
}