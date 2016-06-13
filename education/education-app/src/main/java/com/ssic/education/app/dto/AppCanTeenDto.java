package com.ssic.education.app.dto;

import java.util.List;

import lombok.Data;

/**
 * 食堂信息
 * @author SeanYoung
 *
 */
@Data
public class AppCanTeenDto {
	private String id;
	private String schoolId;
	private String canteenName;
	private String canteenContacts;
	private String phoneNumber;
	private List<AppLicenseDto> appLicense;
}
