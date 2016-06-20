package com.ssic.educateion.common.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import com.ssic.educateion.common.utils.ProductClass;

@Data
public class ProWaresDto implements Serializable {
	@Getter
	@Setter
	private String id;
	@Getter
	@Setter
	private String waresName;
	@Getter
	@Setter
	private String supplierName;// 供应商名称
	@Getter
	@Setter
	private String image;// 图片路径
	@Getter
	@Setter
	private String remark;// 备注
	@Getter
	@Setter
	private String spec;
	@Getter
	@Setter
	private Integer shelfLife;
	@Getter
	@Setter
	private String unit;
	@Getter
	@Setter
	 private String amountUnit;
	@Getter
	@Setter
	private String supplierId;
	@Getter
	@Setter
	private Integer way;
	@Getter
	@Setter
	private Integer waresType;
	public void setWaresType(int waresType) {
		waresTypeStr = ProductClass.getName(waresType);
		this.waresType=waresType;
		this.setWaresTypeStr(waresTypeStr);
	}
	@Getter
	@Setter
	private String waresTypeStr;
	@Getter
	@Setter
	private String customCode;
	@Getter
	@Setter
	private String barCode;
	@Getter
	@Setter
	private String enName;
	@Getter
	@Setter
	private String place;
	@Getter
	@Setter
	private Boolean dishes;
	@Getter
	@Setter
	private Date createTime;
	@Getter
	@Setter
	private Date lastUpdateTime;
	@Getter
	@Setter
	private Integer stat;
	@Getter
	@Setter
	private String manufacturer;
	@Getter
	@Setter
	private String waresTypeName;
	
<<<<<<< HEAD

=======
>>>>>>> branch 'master' of http://192.168.1.231/group-one/education.git
	@Getter
	@Setter
	 private String updater;
	@Getter
	@Setter
 private String creator;

}
