package com.ssic.education.utils.constants;

/**
 * <p>Description: 成品枚举定义 </p>
 *  1-大荤,2-小荤,3-素菜
 * @author wangxiang
 * @version 1.0
 * @time 16/5/12 上午9:59
 */
public enum WaresProdutEnum {
    BIGMEAT(1, "大荤"),SMALLMEAT(2, "小荤"),VEGETABLE(3, "素菜");
    private int index;
    private String value;
    WaresProdutEnum(int index, String value){
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
