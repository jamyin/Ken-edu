package com.ssic.education.app.dto;

import java.io.Serializable;
import java.util.Date;

import com.ssic.education.utils.redis.RedisKeyPrefix;

import lombok.Data;

/**		
 * <p>Title: EduAppUserDto </p>
 * <p>Description:团餐APP用户操作类</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年6月2日 上午11:17:55
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年6月2日 上午11:17:55</p>
 * <p>修改备注：</p>
 */
@Data
@RedisKeyPrefix(prefixValue = "Pro:User:{token}")
public class ProAppUserDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private Integer age;

	private String sourceId;

	private String email;

	private Integer gender;

	private Integer isadmin;

	private String name;

	private String pjNo;

	private String postNo;

	private String password;

	private String qjyAccount;

	private String userAccount;

	private String userImage;

	private String userNo;

	private String userType;

	private Integer isdelete;

	private Date createTime;

	private Date lastUpdateTime;

	private Integer stat;

}
