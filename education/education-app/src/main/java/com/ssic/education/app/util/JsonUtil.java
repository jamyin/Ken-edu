package com.ssic.education.app.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtil {
	private JsonUtil() {
	}

	@SuppressWarnings("deprecation")
	public static <T> String object2Json(T obj) throws Exception {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.getSerializationConfig().setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
			return objectMapper.writeValueAsString(obj);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Json转换出错...");
		}
	}

	public static <T> T json2Obj(String jsonstr, Class<T> Type) throws Exception {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			//允许类中缺少 json字符串中的字段
			objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return objectMapper.readValue(jsonstr, Type);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Json转换出错...");
		}
	}

	public static Map<String, Object> bean2Map(Object obj) {
		if (obj == null) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();

				// 过滤class属性  
				if (!key.equals("class")) {
					// 得到property对应的getter方法  
					Method getter = property.getReadMethod();
					Object value = getter.invoke(obj);
					map.put(key, value);
				}
			}
		} catch (Exception e) {
			System.out.println("transBean2Map Error " + e);
		}
		return map;
	}
}
