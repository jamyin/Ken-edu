package com.ssic.educateion.common.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class BaiduPointsDto implements Serializable {
	private String oc_time;// ": 1463732792,
	private String location;// ": [
	// 121.46267861886,
	// 31.222545883795
	// ],
	private String create_time;// ": "2016-05-25 09:12:05",
	private String direction;// ": 0,
	private String height;// ": 41,
	private String radius;// ": 65,
	private String speed;// ": 3.6

}
