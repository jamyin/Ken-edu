package com.ssic.education.app.util;

import java.util.Properties;

/**
 * 获取图片上传地址URL
 * @author SeanYoung
 *
 */
public class LoadUpload {
	public static String getUrl() {
		Properties properties = new Properties();
		try {
			properties.load(LoadUpload.class.getClassLoader().getResourceAsStream("application.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return properties.getProperty("upload.look.url");
	}

	public static void main(String[] args) {
		System.out.println(getUrl());
	}
}
