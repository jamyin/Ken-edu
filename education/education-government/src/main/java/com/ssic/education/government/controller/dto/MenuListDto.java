package com.ssic.education.government.controller.dto;

import java.io.Serializable;

import lombok.Data;


@Data
public class MenuListDto implements Serializable{
	private String menuName;
	private String menuUrl;

}
