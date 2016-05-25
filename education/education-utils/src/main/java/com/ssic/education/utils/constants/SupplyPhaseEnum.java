package com.ssic.education.utils.constants;

/**
 * @ClassName: SupplyPhaseEnum
 * @Description: 套餐供应阶段枚举类
 * @author Ken Yin
 * @date 2016年5月25日 上午9:52:53
 *
 */
public enum SupplyPhaseEnum {
	BREAKFAST(0, "早餐"),LUNCH(1, "午餐"),DESSERT(2, "午后甜点"),DINNER(3, "晚餐"),NIGHTFOOD(4, "夜宵");
	private int index;
	private String value;
	SupplyPhaseEnum(int index, String value){
		this.index = index;
		this.value = value;
	}
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
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
	public static String getValueByIndex(int index){
		SupplyPhaseEnum[] values = SupplyPhaseEnum.values();
		for (SupplyPhaseEnum enu : values){
			if (index == enu.getIndex()){
				return enu.getValue();
			}
		}
		return null;
	}
}
