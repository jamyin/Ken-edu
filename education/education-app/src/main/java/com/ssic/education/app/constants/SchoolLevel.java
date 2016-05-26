/**
 * 
 */
package com.ssic.education.app.constants;

import java.util.LinkedHashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

/**		
 * <p>Title: SchoolLevel </p>
 * <p>Description: 学校等级枚举</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author rkzhang	
 * @date 2016年4月5日 上午11:30:50	
 * @version 1.0
 * <p>修改人：rkzhang</p>
 * <p>修改时间：2016年4月5日 上午11:30:50</p>
 * <p>修改备注：</p>
 */
public enum SchoolLevel {

        All(-1, "全部"),
        
        Kindergarten(0, "幼儿园"),
        
        PrimarySchool(1, "小学"),
        
        JuniorMiddleSchool(2, "初中"),
        
        SeniorMiddleSchool(3, "高中"),
        
        University(4, "大学");
        
        private static final Map<Integer, String> schoolLevelMap = new LinkedHashMap<Integer, String>();
    
        static{
            	for(SchoolLevel school : SchoolLevel.values()){
            	    schoolLevelMap.put(school.getValue(), school.getName());
            	}
        }
        
	@Getter
	@Setter
	private Integer value;
	
	@Getter
	@Setter
	private String name;
	
	
	SchoolLevel(Integer value, String name) {
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
	public static boolean validateSchoolLevelValue(Integer level) {

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

