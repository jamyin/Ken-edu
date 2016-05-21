package com.ssic.education.government.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class EduUsersDto implements Serializable{
	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_users.id
     *
     * @mbggenerated Sat May 21 16:50:26 CST 2016
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_users.age
     *
     * @mbggenerated Sat May 21 16:50:26 CST 2016
     */
    private Integer age;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_users.create_time
     *
     * @mbggenerated Sat May 21 16:50:26 CST 2016
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_users.source_id
     *
     * @mbggenerated Sat May 21 16:50:26 CST 2016
     */
    private String sourceId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_users.source_type
     *
     * @mbggenerated Sat May 21 16:50:26 CST 2016
     */
    private Byte sourceType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_users.email
     *
     * @mbggenerated Sat May 21 16:50:26 CST 2016
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_users.gender
     *
     * @mbggenerated Sat May 21 16:50:26 CST 2016
     */
    private Integer gender;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_users.isAdmin
     *
     * @mbggenerated Sat May 21 16:50:26 CST 2016
     */
    private Integer isadmin;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_users.last_update_time
     *
     * @mbggenerated Sat May 21 16:50:26 CST 2016
     */
    private Date lastUpdateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_users.name
     *
     * @mbggenerated Sat May 21 16:50:26 CST 2016
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_users.pj_no
     *
     * @mbggenerated Sat May 21 16:50:26 CST 2016
     */
    private String pjNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_users.post_no
     *
     * @mbggenerated Sat May 21 16:50:26 CST 2016
     */
    private String postNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_users.password
     *
     * @mbggenerated Sat May 21 16:50:26 CST 2016
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_users.qjy_account
     *
     * @mbggenerated Sat May 21 16:50:26 CST 2016
     */
    private String qjyAccount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_users.user_account
     *
     * @mbggenerated Sat May 21 16:50:26 CST 2016
     */
    private String userAccount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_users.user_image
     *
     * @mbggenerated Sat May 21 16:50:26 CST 2016
     */
    private String userImage;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_users.user_no
     *
     * @mbggenerated Sat May 21 16:50:26 CST 2016
     */
    private String userNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_users.stat
     *
     * @mbggenerated Sat May 21 16:50:26 CST 2016
     */
    private Integer stat;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_edu_users.isDelete
     *
     * @mbggenerated Sat May 21 16:50:26 CST 2016
     */
    private Integer isdelete;

}
