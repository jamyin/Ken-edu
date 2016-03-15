package com.ssic.education.common.pojo;

import java.util.Date;

public class TransportDriver {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_transport_driver.id
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_transport_driver.supplier_id
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private String supplierId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_transport_driver.account
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private String account;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_transport_driver.password
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_transport_driver.name
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_transport_driver.nick_name
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private String nickName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_transport_driver.imei
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private String imei;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_transport_driver.phone
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_transport_driver.state
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private Integer state;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_transport_driver.create_time
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_transport_driver.last_update_time
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private Date lastUpdateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_transport_driver.stat
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    private Integer stat;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_transport_driver.id
     *
     * @return the value of t_edu_transport_driver.id
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_transport_driver.id
     *
     * @param id the value for t_edu_transport_driver.id
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_transport_driver.supplier_id
     *
     * @return the value of t_edu_transport_driver.supplier_id
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public String getSupplierId() {
        return supplierId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_transport_driver.supplier_id
     *
     * @param supplierId the value for t_edu_transport_driver.supplier_id
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId == null ? null : supplierId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_transport_driver.account
     *
     * @return the value of t_edu_transport_driver.account
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public String getAccount() {
        return account;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_transport_driver.account
     *
     * @param account the value for t_edu_transport_driver.account
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_transport_driver.password
     *
     * @return the value of t_edu_transport_driver.password
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_transport_driver.password
     *
     * @param password the value for t_edu_transport_driver.password
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_transport_driver.name
     *
     * @return the value of t_edu_transport_driver.name
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_transport_driver.name
     *
     * @param name the value for t_edu_transport_driver.name
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_transport_driver.nick_name
     *
     * @return the value of t_edu_transport_driver.nick_name
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_transport_driver.nick_name
     *
     * @param nickName the value for t_edu_transport_driver.nick_name
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_transport_driver.imei
     *
     * @return the value of t_edu_transport_driver.imei
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public String getImei() {
        return imei;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_transport_driver.imei
     *
     * @param imei the value for t_edu_transport_driver.imei
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setImei(String imei) {
        this.imei = imei == null ? null : imei.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_transport_driver.phone
     *
     * @return the value of t_edu_transport_driver.phone
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_transport_driver.phone
     *
     * @param phone the value for t_edu_transport_driver.phone
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_transport_driver.state
     *
     * @return the value of t_edu_transport_driver.state
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public Integer getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_transport_driver.state
     *
     * @param state the value for t_edu_transport_driver.state
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_transport_driver.create_time
     *
     * @return the value of t_edu_transport_driver.create_time
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_transport_driver.create_time
     *
     * @param createTime the value for t_edu_transport_driver.create_time
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_transport_driver.last_update_time
     *
     * @return the value of t_edu_transport_driver.last_update_time
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_transport_driver.last_update_time
     *
     * @param lastUpdateTime the value for t_edu_transport_driver.last_update_time
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_edu_transport_driver.stat
     *
     * @return the value of t_edu_transport_driver.stat
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public Integer getStat() {
        return stat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_edu_transport_driver.stat
     *
     * @param stat the value for t_edu_transport_driver.stat
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    public void setStat(Integer stat) {
        this.stat = stat;
    }
}