package com.ssic.education.app.dto;

import java.io.Serializable;

import com.ssic.education.utils.redis.RedisKeyPrefix;

import lombok.Data;

/**		
 * <p>Title: EduAppUserDto </p>
 * <p>Description:教委 APP用户操作类</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月20日 上午11:17:55	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月20日 上午11:17:55</p>
 * <p>修改备注：</p>
 */
@Data
@RedisKeyPrefix(prefixValue = "Edu:User:{token}")
public class AppEduUserDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String sourceId;
	private Integer sourceType;
	private Integer gender;
	private String name;
	private String userImage;
	private String areaCode;
	private String pjNo;
	private String token;
}
