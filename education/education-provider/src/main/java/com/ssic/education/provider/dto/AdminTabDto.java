package com.ssic.education.provider.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class AdminTabDto implements Serializable {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 8374324522609473347L;

	@Getter
	@Setter
	private String id;

	/**
	 * tab页面名称
	 */
	@Getter
	@Setter
	private String tabName;

	/**
	 * tab页面名称
	 */
	@Getter
	@Setter
	private Date createTime;

	/**
	 * tab页面名称
	 */
	@Getter
	@Setter
	private Date lastUpdateTime;

	/**
	 * tab页面名称
	 */
	@Getter
	@Setter
	private Integer stat;

}
