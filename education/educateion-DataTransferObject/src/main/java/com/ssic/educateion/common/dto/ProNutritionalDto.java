package com.ssic.educateion.common.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProNutritionalDto {

	private String id;

    private String packageId;

    private String name;

    private String unit;

    private String weight;

    private Date lastUpdateTime;

    private Date createTime;

    private Integer stat;

}