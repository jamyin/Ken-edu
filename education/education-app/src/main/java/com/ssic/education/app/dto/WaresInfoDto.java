package com.ssic.education.app.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>Title: ProWaresDto </p>
 * <p>Description: 类描述</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月12日 上午10:22:02	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月12日 上午10:22:02</p>
 * <p>修改备注：</p>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WaresInfoDto {
	private String id;

	private String waresName;

	private String spec;

	private Integer shelfLife;

	private String unit;

	private String supplierId;

	private Integer way;

	private Integer waresType;

	private String customCode;

	private String barCode;

	private String enName;

	private String place;

	private Boolean dishes;
	
	private String image;
	
	private String remark;

	private Date crateTime;

	private Date lastUpdateTime;

	private Integer stat;
}
