package com.ssic.education.handle.pojo;

import java.util.Date;

public class ProSupplierReceiver extends ProSupplierReceiverKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_supplier_receiver.supplier_code
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    private String supplierCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_supplier_receiver.receiver_code
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    private String receiverCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_supplier_receiver.create_time
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_supplier_receiver.last_update_time
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    private Date lastUpdateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_supplier_receiver.supplier_code
     *
     * @return the value of t_pro_supplier_receiver.supplier_code
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    public String getSupplierCode() {
        return supplierCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pro_supplier_receiver.supplier_code
     *
     * @param supplierCode the value for t_pro_supplier_receiver.supplier_code
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode == null ? null : supplierCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_supplier_receiver.receiver_code
     *
     * @return the value of t_pro_supplier_receiver.receiver_code
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    public String getReceiverCode() {
        return receiverCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pro_supplier_receiver.receiver_code
     *
     * @param receiverCode the value for t_pro_supplier_receiver.receiver_code
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    public void setReceiverCode(String receiverCode) {
        this.receiverCode = receiverCode == null ? null : receiverCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_supplier_receiver.create_time
     *
     * @return the value of t_pro_supplier_receiver.create_time
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pro_supplier_receiver.create_time
     *
     * @param createTime the value for t_pro_supplier_receiver.create_time
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_supplier_receiver.last_update_time
     *
     * @return the value of t_pro_supplier_receiver.last_update_time
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pro_supplier_receiver.last_update_time
     *
     * @param lastUpdateTime the value for t_pro_supplier_receiver.last_update_time
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}