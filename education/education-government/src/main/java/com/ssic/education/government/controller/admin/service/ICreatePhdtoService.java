package com.ssic.education.government.controller.admin.service;

import com.ssic.education.government.dto.PageHelperDto;


public interface ICreatePhdtoService {

	PageHelperDto getNewPhDto(String order, int page, int rows, String sort);

}
