package com.ssic.education.government.dto;

import com.ssic.education.utils.constants.WaresMaterialEnum;
import com.ssic.education.utils.constants.WaresProdutEnum;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

public class ProWaresDto implements Serializable{
	
	@Getter
	@Setter
    private String id;

	@Getter
	@Setter
    private String waresName;

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
    private String supplierId;

	@Getter
	@Setter
    private Integer way;

	@Getter
    private Integer waresType;

	public void setWaresType(Integer waresType) {
		this.waresType = waresType;
		if(null != this.getDishes()){
			if (this.getDishes()){
				setWaresTypeStr(WaresProdutEnum.getValueByIndex(waresType));
			}else{
				setWaresTypeStr(WaresMaterialEnum.getValueByIndex(waresType));
			}
		}
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
    private Boolean dishes;

	public void setDishes(Boolean dishes) {
		this.dishes = dishes;
		if(null != this.getWaresType()){
			if (this.getDishes()){
				setWaresTypeStr(WaresProdutEnum.getValueByIndex(waresType));
			}else{
				setWaresTypeStr(WaresMaterialEnum.getValueByIndex(waresType));
			}
		}
	}

	@Getter
	@Setter
    private Date createTime;;

	@Getter
	@Setter
    private Date lastUpdateTime;

	@Getter
	@Setter
    private Integer stat;

}