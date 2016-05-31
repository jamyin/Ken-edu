package com.ssic.educateion.common.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class BaiduHistoryDto implements Serializable {

	 private Integer status;
	 private Integer size;//": 100,
	 private Integer total;//": 124,
	 private String entity_name;//": "8438B07A-2B4C-49B7-8523-5A177081F602",
	 private String distance;//": 40.538363789993,
 	 private List<BaiduPointsDto> points;
}
