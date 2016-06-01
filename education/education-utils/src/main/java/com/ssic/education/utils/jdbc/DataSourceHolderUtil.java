package com.ssic.education.utils.jdbc;

public class DataSourceHolderUtil {
	
	public static final String MASTER_KEY = "master";
	// 暂时不适用读写分离, 所以slave也是master数据源，zhangjiwei, 20160601
	public static final String SLAVE_KEY = "master";

	public static void setToMaster() {
		DynamicDataSourceHolder.putDataSource(DataSourceHolderUtil.MASTER_KEY);
	}
	
	public static void setToSlave() {
		DynamicDataSourceHolder.putDataSource(DataSourceHolderUtil.SLAVE_KEY);
	}
}
