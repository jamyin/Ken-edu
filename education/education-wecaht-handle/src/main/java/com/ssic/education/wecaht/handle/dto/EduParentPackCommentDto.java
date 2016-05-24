package com.ssic.education.wecaht.handle.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class EduParentPackCommentDto implements Serializable {

	private String id;

	private String parentId;

	private String packageId;

	private Integer flavor;

	private Integer health;

	private Integer service;

	private String comment;

	private Date createTime;

	private Date lastUpdateTime;

	private Integer stat;

}