package com.ssic.education.government.controller.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class ParentMenuDto implements Serializable{

	private List<MenuListDto> parentMenu;

}
