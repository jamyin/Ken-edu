package com.ssic.education.utils.constants;

/**
 * @ClassName: SupplyPhaseEnum
 * @Description: 套餐供应阶段枚举类
 * @author Ken Yin
 * @date 2016年5月25日 上午9:52:53
 *
 */
public enum ProNutritionalUnitEnum {
	MG("毫克", "毫克"),G("克", "克"),KJ("千卡", "千卡");
	private String index;
	private String value;
	ProNutritionalUnitEnum(String index, String value){
		this.index = index;
		this.value = value;
	}
	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * 根据枚举index值获取定义名称
	 * @param index 枚举index值
	 * @return 枚举value值
	 */
	public static String getValueByIndex(String index){
		ProNutritionalUnitEnum[] values = ProNutritionalUnitEnum.values();
		for (ProNutritionalUnitEnum enu : values){
			if (index == enu.getIndex()){
				return enu.getValue();
			}
		}
		return null;
	}
}
