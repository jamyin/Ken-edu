package com.ssic.education.common.pojo;

public class EduSupplierReceiverKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_supplier_receiver.receiver_id
     *
     * @mbggenerated Sat May 21 17:26:41 CST 2016
     */
    private String receiverId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_supplier_receiver.supplier_id
     *
     * @mbggenerated Sat May 21 17:26:41 CST 2016
     */
    private String supplierId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_supplier_receiver.receiver_id
     *
     * @return the value of t_pro_supplier_receiver.receiver_id
     *
     * @mbggenerated Sat May 21 17:26:41 CST 2016
     */
    public String getReceiverId() {
        return receiverId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pro_supplier_receiver.receiver_id
     *
     * @param receiverId the value for t_pro_supplier_receiver.receiver_id
     *
     * @mbggenerated Sat May 21 17:26:41 CST 2016
     */
    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId == null ? null : receiverId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_pro_supplier_receiver.supplier_id
     *
     * @return the value of t_pro_supplier_receiver.supplier_id
     *
     * @mbggenerated Sat May 21 17:26:41 CST 2016
     */
    public String getSupplierId() {
        return supplierId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_pro_supplier_receiver.supplier_id
     *
     * @param supplierId the value for t_pro_supplier_receiver.supplier_id
     *
     * @mbggenerated Sat May 21 17:26:41 CST 2016
     */
    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId == null ? null : supplierId.trim();
    }
}