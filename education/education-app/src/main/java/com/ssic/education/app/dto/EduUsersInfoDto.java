package com.ssic.education.app.dto;

import java.util.Date;
import lombok.Data;

/**
 * 		
 * <p>Title: EduUsersInfoDto </p>
 * <p>Description: APP用户信息类</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月20日 下午2:28:45	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月20日 下午2:28:45</p>
 * <p>修改备注：</p>
 */
public @Data class EduUsersInfoDto {
	private String id;
	private Integer age;
	private Date createdatetime;
	private String sourceId;
	private Byte sourceType;
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
}
