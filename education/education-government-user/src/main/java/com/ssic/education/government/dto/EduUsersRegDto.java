package com.ssic.education.government.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class EduUsersRegDto implements Serializable{
	
	//用户信息
    private String id;

    private Integer age;

    private Date createTime;

    private String sourceId;

    private Byte sourceType;

    private String email;

    private Integer gender;

    private Integer isadmin;

    private Date lastUpdateTime;

    private String name;

    private String pjNo;

    private String postNo;

    private String password;

    private String qjyAccount;

    private String userAccount;

    private String userImage;

    private String userNo;

    private Integer stat;

    private Integer isdelete;
    
    //食堂信息
    private String canteenName;

    private String canteenContacts;

    private String phoneNumber;
    
    //学校信息
    private String schoolName;
    
    private String address;
    
    private String level;
    
    private String province;

    //证件信息
    private String jsonLic;
    
    private Integer cerSource;
}