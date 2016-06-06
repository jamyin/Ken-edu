package com.ssic.education.wechat.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class AccessToken implements Serializable{

	private String access_token;
	
	private Integer expires_in;
	
	private String openid;

}
