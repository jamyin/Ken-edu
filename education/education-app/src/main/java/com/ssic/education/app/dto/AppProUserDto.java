package com.ssic.education.app.dto;

import java.io.Serializable;
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
public class AppProUserDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id; //主键
	private String sourceId; //供应商ID
	private String supplierName;
	private String email; //邮箱
	private String name; //姓名
	private String userAccount; //用户名
	private String userNo; //联系方式
	private String job; //岗位

}
