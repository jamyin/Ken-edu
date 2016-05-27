package com.ssic.education.app.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**		
 * <p>Title: EduAppUserDto </p>
 * <p>Description: APP用户操作类</p>
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
@NoArgsConstructor
@AllArgsConstructor
public class EduAppUserDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String sourceId;
	private Integer sourceType;
	private Integer gender;
	private String name;
	private String userImage;
	private String eduType;
	private String eareCode;
	private String pjNo;
	private String token;
}
