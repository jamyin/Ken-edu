package com.ssic.education.app.constants;

import java.util.LinkedHashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

public enum ProductClass {
     CHULEIJIQIZHIPIN(1,"畜产品及其制品"),
     QINLEIJIQIZHIPIN(2,"禽及其产品、制品"),
     SHUCAI(3,"蔬菜"),
     RUZHIPIN(4,"乳及乳制品"),
     YOUZHIJIQIZHIPIN(5,"油脂及其制品"),
     SHUICHANJIQIZHIPIN(6,"水产及其制品") ,
     LENGDONGYINPIN(7,"冷冻饮品"),
     SHUIGUO(8,"水果"),
     LIANGSHIJIQILIANGSHIZHIPIN(9,"粮食和粮食制品") ,
     DOULEIJIQIZHIPIN( 10,"豆类及其制品"),
     SHIYONGJUNHEZAOLEI(11,"食用菌和藻类"),
     KEKEQIAOKELITANGGUO(12,"可可和巧克力制品及糖果"),
     BEIKAOSHIPIN(13,"焙烤食品"),
     TIANWEILIAO(14,"甜味料"),
     TIAOWEIPIN(15,"调味品"),
    TESHUSHANSHIYONGSHIPIN(16,"特殊膳食用食品"),
     YINLIAOLEI(17,"饮料类"),
     JIULEI(18,"酒类"),
    TIANJIAJI (19,"添加剂类"),
     QITALEI(20,"其他类");
	 
     
     private static final Map<Integer, String> productClassMap = new LinkedHashMap<Integer, String>();
 
     static{
         	for(ProductClass school : ProductClass.values()){
         		productClassMap.put(school.getValue(), school.getName());
         	}
     }
     
	@Getter
	@Setter
	private Integer value;
	
	@Getter
	@Setter
	private String name;
	
	
	ProductClass(Integer value, String name) {
	    this.value = value;
	    this.name = name;
	}
 
	/**
	 * validateSchoolLevelValue：验证SchoolLevel值是否合法
	 * @param level
	 * @return
	 * @exception	
	 * @author rkzhang
	 * @date 2016年4月5日 上午11:22:02
	 */
	public static boolean validateProductClassValue(Integer level) {

	    return level == null ? false : level < -1 || level > 4 ? false : true;
	}
	
	/**     
	 * getName：获取学校等级名称
	 * @param value
	 * @return
	 * @exception	
	 * @author rkzhang
	 * @date 2016年4月5日 上午11:30:56	 
	 */
	public static String getName(Integer value) {
		return productClassMap.get(value);
	}
	
	/**     
	 * getAll：获取所有学校等级Map
	 * @return
	 * @exception	
	 * @author rkzhang
	 * @date 2016年4月5日 上午11:31:03	 
	 */
	public static Map<Integer, String> getAll() {
	    
	    return productClassMap;		
	}
}
