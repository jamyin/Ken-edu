package com.ssic.education.utils.jdbc;

import java.lang.reflect.Method;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import com.ssic.education.utils.exception.SystemException;
import com.ssic.education.utils.util.StringUtils;

public class DataSourceAspect {
	
	protected static final Log logger = LogFactory.getLog(DataSourceAspect.class);
	
	private static final Pattern slaveMethodsPattern = Pattern.compile("^(count|select|find|search|get|achieve|query)([A-Z].*)*$");
	

	public void before(JoinPoint point)
    {
        Object target = point.getTarget();
        String method = point.getSignature().getName();

        Class<?>[] classz = target.getClass().getInterfaces();

        Class<?>[] parameterTypes = ((MethodSignature) point.getSignature())
                .getMethod().getParameterTypes();
        try {
            Method m = classz[0].getMethod(method, parameterTypes);
            String methodName = m.getName();
            
            if (m != null && m.isAnnotationPresent(DataSource.class)) {
                DataSource data = m.getAnnotation(DataSource.class);               
                DynamicDataSourceHolder.putDataSource(data.value());
                logger.info(data.value());
            } else if(isSlaveMethod(methodName)){
            	 DynamicDataSourceHolder.putDataSource(DataSourceHolderUtil.SLAVE_KEY);
            	 logger.debug("slave");
            } else {
            	DynamicDataSourceHolder.putDataSource(DataSourceHolderUtil.MASTER_KEY);
           	 	logger.debug("master");
            }
            
        } catch (Throwable e) {
            throw new SystemException(e);
        }
    }
	
	private boolean isSlaveMethod(String methodName) {
		return StringUtils.isNotEmpty(methodName) ? slaveMethodsPattern.matcher(methodName).matches() : false;
	}

	public static void main(String[] args) {
		String methodName = "get";
		System.out.println(slaveMethodsPattern.matcher(methodName).matches());
	}

}
