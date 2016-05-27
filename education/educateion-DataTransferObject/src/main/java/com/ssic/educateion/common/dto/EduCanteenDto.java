package com.ssic.educateion.common.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class EduCanteenDto implements Serializable {

	private String id;

	private String schoolId;

	private String canteenName;

	private String canteenContacts;

	private String phoneNumber;

	private Date lastUpdateTime;

	private Date createTime;

	private Integer stat;
}
