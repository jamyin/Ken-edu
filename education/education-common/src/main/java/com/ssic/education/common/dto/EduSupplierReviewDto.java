package com.ssic.education.common.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class EduSupplierReviewDto {
	
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_supplier_review.committee_id
     *
     * @mbggenerated Mon May 16 18:56:32 CST 2016
     */
    private String committeeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_supplier_review.supplier_id
     *
     * @mbggenerated Mon May 16 18:56:32 CST 2016
     */
    private String supplierId;	
	
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_supplier_review.review_result
     *
     * @mbggenerated Mon May 16 18:56:32 CST 2016
     */
    private Short reviewResult;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_supplier_review.create_time
     *
     * @mbggenerated Mon May 16 18:56:32 CST 2016
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_supplier_review.last_update_time
     *
     * @mbggenerated Mon May 16 18:56:32 CST 2016
     */
    private Date lastUpdateTime;

}