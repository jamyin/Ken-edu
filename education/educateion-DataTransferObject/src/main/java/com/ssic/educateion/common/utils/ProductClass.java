package com.ssic.educateion.common.utils;

import java.util.LinkedHashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

public enum ProductClass {
    LIANGSHIZHIPIN(1,"粮食及其制品"),
    CHULEIZHIPIN(2,"畜产品及其制品"),
    QINLEI(3,"禽及其产品、制品"),
    SHUCAI(4,"蔬菜"),
    SHUIGUO(5,"水果"),
    SHUICHANPIN(6,"水产品") ,
    DOUZHIPIN(7,"豆制品"),
    RUPIN(8,"乳品"),
    SHIYONGYOU(9,"食用油") ,
    QITA( 10,"其它类别的食品和食用农产品");

     private static final Map<Integer, String> schoolLevelMap = new LinkedHashMap<Integer, String>();
     private static final Map<String, Integer> schoolLevelMap2 = new LinkedHashMap<String, Integer>();
 
     static{
         	for(ProductClass school : ProductClass.values()){
         	    schoolLevelMap.put(school.getValue(), school.getName());
         	    schoolLevelMap2.put(school.getName(), school.getValue());
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
		return schoolLevelMap.get(value);
	}
	
	public static Integer fromName(String name) {
		return schoolLevelMap2.get(name);
	}
	
	/**     
	 * getAll：获取所有学校等级Map
	 * @return
	 * @exception	
	 * @author rkzhang
	 * @date 2016年4月5日 上午11:31:03	 
	 */
	public static Map<Integer, String> getAll() {
	    
	    return schoolLevelMap;		
	}
}
