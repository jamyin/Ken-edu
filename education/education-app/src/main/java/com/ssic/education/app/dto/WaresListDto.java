package com.ssic.education.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**		
 * <p>Title: WaresListDto </p>
 * <p>Description: 采购品列表</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月23日 下午5:55:06	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月23日 下午5:55:06</p>
 * <p>修改备注：</p>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WaresListDto {
	private String id; //商品ID
	private String waresName; //商品名称
	private String customCode; //企业自定义代码
	private Integer waresType; //原料分类
	private String typeName; //原料分类
	private String spec;//商品规格
	private String amountUnit;//单位
	private String image;//商品展示图片
}
