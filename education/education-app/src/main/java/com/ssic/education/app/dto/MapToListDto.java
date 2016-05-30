package com.ssic.education.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
* @ClassName: MapToListDto
* @Description: TODO(这里用一句话描述这个类的作用)
* @author Ken Yin
* @date 2016年5月30日 下午2:33:47
*
 */
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MapToListDto {
	
	private Integer key;
	private String value;
    
}

