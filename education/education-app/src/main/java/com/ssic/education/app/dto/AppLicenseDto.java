package com.ssic.education.app.dto;

import java.util.Date;

import lombok.Data;

/**
 * 		
 * <p>Title: AppLicenseDtol </p>
 * <p>Description: 供应商证书列表DTO</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月31日 下午2:41:45	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月31日 下午2:41:45</p>
 * <p>修改备注：</p>
 */
public @Data class AppLicenseDto {

	private String id; //主键

	private String licName; //证书名称

	private String licNo; //证书编号 

	private Integer licType; //证书类型

	private Date licEndDate; //证书到期时间

	private String licPic;//证书图片
}
