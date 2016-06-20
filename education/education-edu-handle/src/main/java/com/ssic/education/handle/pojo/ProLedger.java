package com.ssic.education.handle.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class ProLedger {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_ledger.id
     *
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_ledger.master_id
     *
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
     */
    private String masterId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_ledger.wares_id
     *
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
     */
    private String waresId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_ledger.name
     *
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_ledger.spce
     *
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
     */
    private String spce;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_ledger.amount_unit
     *
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
     */
    private String amountUnit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_ledger.supplier_id
     *
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
     */
    private String supplierId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_ledger.supplier_code
     *
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
     */
    private String supplierCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_ledger.supplier_name
     *
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
     */
    private String supplierName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_ledger.quantity
     *
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
     */
    private BigDecimal quantity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_ledger.production_date
     *
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
     */
    private Date productionDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_ledger.production_name
     *
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
     */
    private String productionName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_ledger.batch_no
     *
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
     */
    private String batchNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_ledger.trace_code
     *
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
     */
    private String traceCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_ledger.creator
     *
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
     */
    private String creator;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_ledger.create_time
     *
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_ledger.updater
     *
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
     */
    private String updater;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_ledger.last_update_time
     *
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
     */
    private Date lastUpdateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_ledger.stat
     *
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
     */
    private Integer stat;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_ledger.id
     *
     * @return the value of t_pro_ledger.id
     *
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
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
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_ledger.master_id
     *
     * @return the value of t_pro_ledger.master_id
     *
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
     */
    public String getMasterId() {
        return masterId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pro_ledger.master_id
     *
     * @param masterId the value for t_pro_ledger.master_id
     *
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
     */
    public void setMasterId(String masterId) {
        this.masterId = masterId == null ? null : masterId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_ledger.wares_id
     *
     * @return the value of t_pro_ledger.wares_id
     *
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
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
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
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
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
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
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
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
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
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
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
     */
    public void setSpce(String spce) {
        this.spce = spce == null ? null : spce.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_ledger.amount_unit
     *
     * @return the value of t_pro_ledger.amount_unit
     *
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
     */
    public String getAmountUnit() {
        return amountUnit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pro_ledger.amount_unit
     *
     * @param amountUnit the value for t_pro_ledger.amount_unit
     *
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
     */
    public void setAmountUnit(String amountUnit) {
        this.amountUnit = amountUnit == null ? null : amountUnit.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_ledger.supplier_id
     *
     * @return the value of t_pro_ledger.supplier_id
     *
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
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
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
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
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
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
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
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
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
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
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
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
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
     */
    public BigDecimal getQuantity() {
        return quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pro_ledger.quantity
     *
     * @param quantity the value for t_pro_ledger.quantity
     *
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
     */
    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_ledger.production_date
     *
     * @return the value of t_pro_ledger.production_date
     *
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
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
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
     */
    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_ledger.production_name
     *
     * @return the value of t_pro_ledger.production_name
     *
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
     */
    public String getProductionName() {
        return productionName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pro_ledger.production_name
     *
     * @param productionName the value for t_pro_ledger.production_name
     *
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
     */
    public void setProductionName(String productionName) {
        this.productionName = productionName == null ? null : productionName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_ledger.batch_no
     *
     * @return the value of t_pro_ledger.batch_no
     *
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
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
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
     */
    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_ledger.trace_code
     *
     * @return the value of t_pro_ledger.trace_code
     *
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
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
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
     */
    public void setTraceCode(String traceCode) {
        this.traceCode = traceCode == null ? null : traceCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_ledger.creator
     *
     * @return the value of t_pro_ledger.creator
     *
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
     */
    public String getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pro_ledger.creator
     *
     * @param creator the value for t_pro_ledger.creator
     *
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_ledger.create_time
     *
     * @return the value of t_pro_ledger.create_time
     *
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
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
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_ledger.updater
     *
     * @return the value of t_pro_ledger.updater
     *
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
     */
    public String getUpdater() {
        return updater;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pro_ledger.updater
     *
     * @param updater the value for t_pro_ledger.updater
     *
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
     */
    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_ledger.last_update_time
     *
     * @return the value of t_pro_ledger.last_update_time
     *
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
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
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
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
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
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
     * @mbggenerated Mon Jun 20 13:56:29 CST 2016
     */
    public void setStat(Integer stat) {
        this.stat = stat;
    }
}