/**
 * 
 */
package com.ssic.education.common.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**		
 * <p>Title: AddressStatistic </p>
 * <p>Description: 类描述</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author rkzhang	
 * @date 2016年4月1日 上午10:51:38	
 * @version 1.0
 * <p>修改人：rkzhang</p>
 * <p>修改时间：2016年4月1日 上午10:51:38</p>
 * <p>修改备注：</p>
 */
@ToString
public class AddressStatistic {

    	/**
	 * 区域名称
	 */
	@Getter
	@Setter
	private String addressName;

	/**
	 * 区域编码
	 */
	@Getter
	@Setter
	private String addressCode;
	
	/**
	 * 经度
	 */
	@Getter
	@Setter
	private Float x;
	
	/**
	 * 纬度
	 */
	@Getter
	@Setter
	private Float y;
	
	/**
	 * 学校数量
	 */
	@Getter
	@Setter
	private Integer schoolNum;
	
}

