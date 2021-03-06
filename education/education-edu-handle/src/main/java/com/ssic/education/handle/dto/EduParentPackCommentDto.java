package com.ssic.education.handle.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class EduParentPackCommentDto implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_parent_pack_comment.id
     *
     * @mbggenerated Sun May 29 16:27:13 CST 2016
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_parent_pack_comment.parent_id
     *
     * @mbggenerated Sun May 29 16:27:13 CST 2016
     */
    private String parentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_parent_pack_comment.package_id
     *
     * @mbggenerated Sun May 29 16:27:13 CST 2016
     */
    private String packageId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_parent_pack_comment.flavor
     *
     * @mbggenerated Sun May 29 16:27:13 CST 2016
     */
    private Integer flavor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_parent_pack_comment.health
     *
     * @mbggenerated Sun May 29 16:27:13 CST 2016
     */
    private Integer health;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_parent_pack_comment.weights
     *
     * @mbggenerated Sun May 29 16:27:13 CST 2016
     */
    private Integer weights;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_parent_pack_comment.comment
     *
     * @mbggenerated Sun May 29 16:27:13 CST 2016
     */
    private String comment;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_parent_pack_comment.supplyDate
     *
     * @mbggenerated Sun May 29 16:27:13 CST 2016
     */
    private String supplyDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_parent_pack_comment.school_name
     *
     * @mbggenerated Sun May 29 16:27:13 CST 2016
     */
    private String schoolName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_parent_pack_comment.school_Id
     *
     * @mbggenerated Sun May 29 16:27:13 CST 2016
     */
    private String schoolId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_parent_pack_comment.dishes
     *
     * @mbggenerated Sun May 29 16:27:13 CST 2016
     */
    private String dishes;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_parent_pack_comment.create_time
     *
     * @mbggenerated Sun May 29 16:27:13 CST 2016
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_parent_pack_comment.last_update_time
     *
     * @mbggenerated Sun May 29 16:27:13 CST 2016
     */
    private Date lastUpdateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_parent_pack_comment.stat
     *
     * @mbggenerated Sun May 29 16:27:13 CST 2016
     */
    private Integer stat;
    
    private String weekName;
    
    private String supplyPhase;
    
    private List<String> packageIds;

   
}