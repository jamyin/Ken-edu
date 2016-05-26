package com.ssic.education.edu.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class EduParentScChDto implements Serializable{

	private String id;

	private String schoolId;

	private String schoolName;

	private String schoolAddress;

	private String childName;

	private String childClass;

	private String mobile;

	private Integer childSex;

	private Integer relation;

	private Date createTime;

	private Date lastUpdateTime;

	private Integer stat;

}