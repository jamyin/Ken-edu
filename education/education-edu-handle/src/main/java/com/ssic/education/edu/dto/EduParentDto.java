package com.ssic.education.edu.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class EduParentDto implements Serializable {

	private String id;

	private String nickName;

	private String thumbnail;

	private Date createTime;

	private Date lastUpdateTime;

	private Integer stat;

}