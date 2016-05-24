package com.ssic.education.app.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**		
 * <p>Title: ProSupplierDto </p>
 * <p>Description: 供应商DTO类</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月12日 上午10:55:16	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月12日 上午10:55:16</p>
 * <p>修改备注：</p>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProSupplierDto {

	private String id;

	private String supplierName;

	private String address;

	private String provinces;

	private String city;

	private String area;

	private Integer supplierType;

	private String businessLicense;

	private String organizationCode;

	private String foodServiceCode;

	private Date foodServiceCodeDate;

	private String foodBusinessCode;

	private Date foodBusinessCodeDate;

	private String foodCirculationCode;

	private Date foodCirculationCodeDate;

	private String foodProduceCode;

	private Date foodProduceCodeDate;

	private String corporation;

	private String idCard;

	private String idType;

	private String contactWay;

	private String longitude;

	private String latitude;

	private Byte reviewed;

	private Date createTime;

	private Date lastUpdateTime;

	private Integer stat;
}