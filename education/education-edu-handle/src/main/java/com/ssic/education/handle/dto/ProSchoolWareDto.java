package com.ssic.education.handle.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProSchoolWareDto {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_school_ware.id
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_school_ware.school_id
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    private String schoolId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_school_ware.source_id
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    private String sourceId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_school_ware.supplier_id
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    private String supplierId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_school_ware.ware_id
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    private String wareId;
    
    private String waresName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_school_ware.create_time
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_school_ware.last_update_time
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    private Date lastUpdateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_pro_school_ware.stat
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    private Integer stat;
    
    private Integer source;

}