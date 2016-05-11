package com.ssic.education.government.pojo;

import java.util.Date;

public class EduTab {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_admin_tab.id
     *
     * @mbggenerated Wed May 11 11:02:34 CST 2016
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_admin_tab.tab_name
     *
     * @mbggenerated Wed May 11 11:02:34 CST 2016
     */
    private String tabName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_admin_tab.order_no
     *
     * @mbggenerated Wed May 11 11:02:34 CST 2016
     */
    private Integer orderNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_admin_tab.create_time
     *
     * @mbggenerated Wed May 11 11:02:34 CST 2016
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_admin_tab.last_update_time
     *
     * @mbggenerated Wed May 11 11:02:34 CST 2016
     */
    private Date lastUpdateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_admin_tab.stat
     *
     * @mbggenerated Wed May 11 11:02:34 CST 2016
     */
    private Integer stat;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_admin_tab.id
     *
     * @return the value of t_edu_admin_tab.id
     *
     * @mbggenerated Wed May 11 11:02:34 CST 2016
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_admin_tab.id
     *
     * @param id the value for t_edu_admin_tab.id
     *
     * @mbggenerated Wed May 11 11:02:34 CST 2016
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_admin_tab.tab_name
     *
     * @return the value of t_edu_admin_tab.tab_name
     *
     * @mbggenerated Wed May 11 11:02:34 CST 2016
     */
    public String getTabName() {
        return tabName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_admin_tab.tab_name
     *
     * @param tabName the value for t_edu_admin_tab.tab_name
     *
     * @mbggenerated Wed May 11 11:02:34 CST 2016
     */
    public void setTabName(String tabName) {
        this.tabName = tabName == null ? null : tabName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_admin_tab.order_no
     *
     * @return the value of t_edu_admin_tab.order_no
     *
     * @mbggenerated Wed May 11 11:02:34 CST 2016
     */
    public Integer getOrderNo() {
        return orderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_admin_tab.order_no
     *
     * @param orderNo the value for t_edu_admin_tab.order_no
     *
     * @mbggenerated Wed May 11 11:02:34 CST 2016
     */
    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_admin_tab.create_time
     *
     * @return the value of t_edu_admin_tab.create_time
     *
     * @mbggenerated Wed May 11 11:02:34 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_admin_tab.create_time
     *
     * @param createTime the value for t_edu_admin_tab.create_time
     *
     * @mbggenerated Wed May 11 11:02:34 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_admin_tab.last_update_time
     *
     * @return the value of t_edu_admin_tab.last_update_time
     *
     * @mbggenerated Wed May 11 11:02:34 CST 2016
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_admin_tab.last_update_time
     *
     * @param lastUpdateTime the value for t_edu_admin_tab.last_update_time
     *
     * @mbggenerated Wed May 11 11:02:34 CST 2016
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_admin_tab.stat
     *
     * @return the value of t_edu_admin_tab.stat
     *
     * @mbggenerated Wed May 11 11:02:34 CST 2016
     */
    public Integer getStat() {
        return stat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_admin_tab.stat
     *
     * @param stat the value for t_edu_admin_tab.stat
     *
     * @mbggenerated Wed May 11 11:02:34 CST 2016
     */
    public void setStat(Integer stat) {
        this.stat = stat;
    }
}