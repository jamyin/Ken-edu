package com.ssic.education.utils.constants;

/**
 * <p>Description: 类描述:分享的类型枚举定义 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 *
 * @author wangxiang
 * @version 1.0
 * @date 2016/4/25 13:50
 */
public enum ShareType {

    NEWS(1),ACTIVE(2);// 1-新闻,2-活动

    ShareType(int index){
        this.index = index;
    }
    private int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * <p>Description: 校验是否属于枚举定义范围内 </p>
     * <p>Company: 上海天坊信息科技有限公司</p>
     * @param infoType
     * @return boolean
     * @author wangxiang
     * @date 2016/4/29 11:32
     * @version 1.0
     */
    public static boolean isShareType(Integer infoType){
        if (null == infoType){
            return false;
        }
        for (ShareType en : ShareType.values()){
            if (en.getIndex() == infoType.intValue()){
                return true;
            }
        }
        return false;
    }
}