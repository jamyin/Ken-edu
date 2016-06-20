package com.ssic.education.app.constants;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
    
	private static final Map<Integer, String> productClassMap = new LinkedHashMap<Integer, String>();
	private static final List<ProductList> productClassList = new ArrayList<ProductList>();

	static {
		for (ProductClass productClass : ProductClass.values()) {
			productClassMap.put(productClass.getValue(), productClass.getName());
			ProductList productList = new ProductList();
			productList.setKey(productClass.getValue());
			productList.setValue(productClass.getName());
			productClassList.add(productList);
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

	public static List<ProductList> getList() {
		return productClassList;
	}
}
