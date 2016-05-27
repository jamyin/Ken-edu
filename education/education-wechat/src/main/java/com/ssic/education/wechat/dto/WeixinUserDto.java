package com.ssic.education.wechat.dto;

import lombok.Data;

@Data
public class WeixinUserDto {
	private String openid;
	private String nickname;
	private String sex;
	private String unionid;

	private String city;// 用户所在城市
	private String country;// 用户所在国家
	private String province;// 用户所在省份
	
	
	

}
