package com.ssic.education.utils.constants;

/**
 * @ClassName: SupplyPhaseEnum
 * @Description: 套餐供应阶段枚举类
 * @author Ken Yin
 * @date 2016年5月25日 上午9:52:53
 *
 */
public enum ProNutritionalNameEnum {
	ENERGY("热量", "热量"),PROTEIN("蛋白质", "蛋白质"),V3("脂肪","脂肪"),V4("钙","钙"),V5("铁","铁"),V6("锌","锌"),VITAMIN("维生素", "维生素");
	private String index;
	private String value;
	ProNutritionalNameEnum(String index, String value){
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
		ProNutritionalNameEnum[] values = ProNutritionalNameEnum.values();
		for (ProNutritionalNameEnum enu : values){
			if (index == enu.getIndex()){
				return enu.getValue();
			}
		}
		return null;
	}
}
