package com.ssic.education.government.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
public class EduUsersDto implements Serializable{

    private String id;
	
    private Integer age;
	
    private Date createdatetime;
	
    private String deptId;
	
    private String email;
	
    private Integer gender;
	
    private Integer isadmin;
	
    private Date modifydatetime;
	
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

}
