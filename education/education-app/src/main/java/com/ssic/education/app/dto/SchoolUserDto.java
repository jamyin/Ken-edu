package com.ssic.education.app.dto;

import lombok.Data;

/**
 * 学校信息DTO
 * @author SeanYoung
 *
 */
@Data
public class SchoolUserDto {
	private String id; //主键ID
	private String committeeId; //教委ID 
	private String committeeName; //教委ID 
	private String schoolName;//学校名称
	private String mobileNo;//联系电话
	private String contacts; //联系人
	private String address; //地址
	private String level; //级别
	private String levelName; //级别
}
