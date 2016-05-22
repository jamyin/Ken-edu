package com.ssic.education.utils.constants;

/**
 * <p>Description: 原料枚举定义 </p>
 *  1-禽肉类,2-禽制品
 * @author wangxiang
 * @version 1.0
 * @time 16/5/12 上午10:07
 */
public enum WaresMaterialEnum {
    POULTRY(1, "禽肉类"),POULTRYPRODUCT(2, "禽制品");
    private int index;
    private String value;
    WaresMaterialEnum(int index, String value){
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
        WaresProdutEnum[] values = WaresProdutEnum.values();
        for (WaresProdutEnum enu : values){
            if (index == enu.getIndex()){
                return enu.getValue();
            }
        }
        return null;
    }
}
