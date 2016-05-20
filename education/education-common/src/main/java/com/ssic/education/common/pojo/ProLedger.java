package com.ssic.education.common.pojo;

import java.util.Date;

public class ProLedger {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_ledger.id
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_ledger.wares_id
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    private String waresId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_ledger.name
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_ledger.spce
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    private String spce;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_ledger.action_type
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    private Integer actionType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_ledger.action_date
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    private Date actionDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_ledger.supplier_id
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    private String supplierId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_ledger.supplier_code
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    private String supplierCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_ledger.supplier_name
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    private String supplierName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_ledger.quantity
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    private Integer quantity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_ledger.production_date
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    private Date productionDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_ledger.batch_no
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    private String batchNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_ledger.receiver_id
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    private String receiverId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_ledger.receiver_code
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    private String receiverCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_ledger.receiver_name
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    private String receiverName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_ledger.trace_code
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    private String traceCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_ledger.user_id
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_ledger.create_time
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_ledger.last_update_time
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    private Date lastUpdateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_ledger.stat
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    private Integer stat;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_ledger.id
     *
     * @return the value of t_pro_ledger.id
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pro_ledger.id
     *
     * @param id the value for t_pro_ledger.id
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_ledger.wares_id
     *
     * @return the value of t_pro_ledger.wares_id
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    public String getWaresId() {
        return waresId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pro_ledger.wares_id
     *
     * @param waresId the value for t_pro_ledger.wares_id
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    public void setWaresId(String waresId) {
        this.waresId = waresId == null ? null : waresId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_ledger.name
     *
     * @return the value of t_pro_ledger.name
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pro_ledger.name
     *
     * @param name the value for t_pro_ledger.name
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_ledger.spce
     *
     * @return the value of t_pro_ledger.spce
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    public String getSpce() {
        return spce;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pro_ledger.spce
     *
     * @param spce the value for t_pro_ledger.spce
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    public void setSpce(String spce) {
        this.spce = spce == null ? null : spce.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_ledger.action_type
     *
     * @return the value of t_pro_ledger.action_type
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    public Integer getActionType() {
        return actionType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pro_ledger.action_type
     *
     * @param actionType the value for t_pro_ledger.action_type
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    public void setActionType(Integer actionType) {
        this.actionType = actionType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_ledger.action_date
     *
     * @return the value of t_pro_ledger.action_date
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    public Date getActionDate() {
        return actionDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pro_ledger.action_date
     *
     * @param actionDate the value for t_pro_ledger.action_date
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_ledger.supplier_id
     *
     * @return the value of t_pro_ledger.supplier_id
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    public String getSupplierId() {
        return supplierId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pro_ledger.supplier_id
     *
     * @param supplierId the value for t_pro_ledger.supplier_id
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId == null ? null : supplierId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_ledger.supplier_code
     *
     * @return the value of t_pro_ledger.supplier_code
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    public String getSupplierCode() {
        return supplierCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pro_ledger.supplier_code
     *
     * @param supplierCode the value for t_pro_ledger.supplier_code
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode == null ? null : supplierCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_ledger.supplier_name
     *
     * @return the value of t_pro_ledger.supplier_name
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pro_ledger.supplier_name
     *
     * @param supplierName the value for t_pro_ledger.supplier_name
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName == null ? null : supplierName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_ledger.quantity
     *
     * @return the value of t_pro_ledger.quantity
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pro_ledger.quantity
     *
     * @param quantity the value for t_pro_ledger.quantity
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_ledger.production_date
     *
     * @return the value of t_pro_ledger.production_date
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    public Date getProductionDate() {
        return productionDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pro_ledger.production_date
     *
     * @param productionDate the value for t_pro_ledger.production_date
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_ledger.batch_no
     *
     * @return the value of t_pro_ledger.batch_no
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    public String getBatchNo() {
        return batchNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pro_ledger.batch_no
     *
     * @param batchNo the value for t_pro_ledger.batch_no
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_ledger.receiver_id
     *
     * @return the value of t_pro_ledger.receiver_id
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    public String getReceiverId() {
        return receiverId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pro_ledger.receiver_id
     *
     * @param receiverId the value for t_pro_ledger.receiver_id
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId == null ? null : receiverId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_ledger.receiver_code
     *
     * @return the value of t_pro_ledger.receiver_code
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    public String getReceiverCode() {
        return receiverCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pro_ledger.receiver_code
     *
     * @param receiverCode the value for t_pro_ledger.receiver_code
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    public void setReceiverCode(String receiverCode) {
        this.receiverCode = receiverCode == null ? null : receiverCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_ledger.receiver_name
     *
     * @return the value of t_pro_ledger.receiver_name
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    public String getReceiverName() {
        return receiverName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pro_ledger.receiver_name
     *
     * @param receiverName the value for t_pro_ledger.receiver_name
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName == null ? null : receiverName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_ledger.trace_code
     *
     * @return the value of t_pro_ledger.trace_code
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    public String getTraceCode() {
        return traceCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pro_ledger.trace_code
     *
     * @param traceCode the value for t_pro_ledger.trace_code
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    public void setTraceCode(String traceCode) {
        this.traceCode = traceCode == null ? null : traceCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_ledger.user_id
     *
     * @return the value of t_pro_ledger.user_id
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pro_ledger.user_id
     *
     * @param userId the value for t_pro_ledger.user_id
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_ledger.create_time
     *
     * @return the value of t_pro_ledger.create_time
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pro_ledger.create_time
     *
     * @param createTime the value for t_pro_ledger.create_time
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_ledger.last_update_time
     *
     * @return the value of t_pro_ledger.last_update_time
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pro_ledger.last_update_time
     *
     * @param lastUpdateTime the value for t_pro_ledger.last_update_time
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_ledger.stat
     *
     * @return the value of t_pro_ledger.stat
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    public Integer getStat() {
        return stat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pro_ledger.stat
     *
     * @param stat the value for t_pro_ledger.stat
     *
     * @mbggenerated Fri May 20 12:39:35 JST 2016
     */
    public void setStat(Integer stat) {
        this.stat = stat;
    }
}