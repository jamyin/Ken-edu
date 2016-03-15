package com.ssic.education.common.pojo;

import java.util.Date;

public class News {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_news.id
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_news.name
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_news.title
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_news.title_left_icon
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private String titleLeftIcon;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_news.text
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private String text;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_news.school_id
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private String schoolId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_news.address_id
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private String addressId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_news.proj_id
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private String projId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_news.news_type
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private Integer newsType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_news.publish_type
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private Integer publishType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_news.stat
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private Integer stat;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_news.create_time
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_news.last_update_time
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private Date lastUpdateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_news.text_html
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private String textHtml;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_news.id
     *
     * @return the value of t_edu_news.id
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_news.id
     *
     * @param id the value for t_edu_news.id
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_news.name
     *
     * @return the value of t_edu_news.name
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_news.name
     *
     * @param name the value for t_edu_news.name
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_news.title
     *
     * @return the value of t_edu_news.title
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_news.title
     *
     * @param title the value for t_edu_news.title
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_news.title_left_icon
     *
     * @return the value of t_edu_news.title_left_icon
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public String getTitleLeftIcon() {
        return titleLeftIcon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_news.title_left_icon
     *
     * @param titleLeftIcon the value for t_edu_news.title_left_icon
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setTitleLeftIcon(String titleLeftIcon) {
        this.titleLeftIcon = titleLeftIcon == null ? null : titleLeftIcon.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_news.text
     *
     * @return the value of t_edu_news.text
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public String getText() {
        return text;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_news.text
     *
     * @param text the value for t_edu_news.text
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_news.school_id
     *
     * @return the value of t_edu_news.school_id
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public String getSchoolId() {
        return schoolId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_news.school_id
     *
     * @param schoolId the value for t_edu_news.school_id
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId == null ? null : schoolId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_news.address_id
     *
     * @return the value of t_edu_news.address_id
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public String getAddressId() {
        return addressId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_news.address_id
     *
     * @param addressId the value for t_edu_news.address_id
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setAddressId(String addressId) {
        this.addressId = addressId == null ? null : addressId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_news.proj_id
     *
     * @return the value of t_edu_news.proj_id
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public String getProjId() {
        return projId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_news.proj_id
     *
     * @param projId the value for t_edu_news.proj_id
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setProjId(String projId) {
        this.projId = projId == null ? null : projId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_news.news_type
     *
     * @return the value of t_edu_news.news_type
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public Integer getNewsType() {
        return newsType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_news.news_type
     *
     * @param newsType the value for t_edu_news.news_type
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setNewsType(Integer newsType) {
        this.newsType = newsType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_news.publish_type
     *
     * @return the value of t_edu_news.publish_type
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public Integer getPublishType() {
        return publishType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_news.publish_type
     *
     * @param publishType the value for t_edu_news.publish_type
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setPublishType(Integer publishType) {
        this.publishType = publishType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_news.stat
     *
     * @return the value of t_edu_news.stat
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public Integer getStat() {
        return stat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_news.stat
     *
     * @param stat the value for t_edu_news.stat
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setStat(Integer stat) {
        this.stat = stat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_news.create_time
     *
     * @return the value of t_edu_news.create_time
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_news.create_time
     *
     * @param createTime the value for t_edu_news.create_time
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_news.last_update_time
     *
     * @return the value of t_edu_news.last_update_time
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_news.last_update_time
     *
     * @param lastUpdateTime the value for t_edu_news.last_update_time
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_news.text_html
     *
     * @return the value of t_edu_news.text_html
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public String getTextHtml() {
        return textHtml;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_news.text_html
     *
     * @param textHtml the value for t_edu_news.text_html
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setTextHtml(String textHtml) {
        this.textHtml = textHtml == null ? null : textHtml.trim();
    }
}