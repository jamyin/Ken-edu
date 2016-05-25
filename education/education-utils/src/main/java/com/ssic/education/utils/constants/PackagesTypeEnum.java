package com.ssic.education.utils.constants;

/**
 * @ClassName: packagesTypeEnum
 * @Description: 套餐类型枚举类
 * @author Ken Yin
 * @date 2016年5月25日 上午9:52:53
 *
 */
public enum PackagesTypeEnum {
	DOMESTIC(0, "国内班"),INTERNATIONAL(1, "国际班"),STAFF(2, "教工");
	private int index;
	private String value;
	PackagesTypeEnum(int index, String value){
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
		PackagesTypeEnum[] values = PackagesTypeEnum.values();
		for (PackagesTypeEnum enu : values){
			if (index == enu.getIndex()){
				return enu.getValue();
			}
		}
		return null;
	}
}
