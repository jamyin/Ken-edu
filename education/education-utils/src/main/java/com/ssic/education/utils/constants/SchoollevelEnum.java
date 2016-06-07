package com.ssic.education.utils.constants;

/**
 * <p>Description: 成品枚举定义 </p>
 *  1-大荤,2-小荤,3-素菜
 * @author wangxiang
 * @version 1.0
 * @time 16/5/12 上午9:59
 */
public enum SchoollevelEnum {
	NURSERY(0, "幼儿园"),PRIMARY(1, "小学"),MIDDLE(2, "初中"),HIGH(3, "高中"),UNIVERSITY(4, "大学");
    private int index;
    private String value;
    SchoollevelEnum(int index, String value){
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
        SchoollevelEnum[] values = SchoollevelEnum.values();
        for (SchoollevelEnum enu : values){
            if (index == enu.getIndex()){
                return enu.getValue();
            }
        }
        return null;
    }
}
