package com.ssic.education.provider.service;

import com.ssic.education.provider.dto.PageHelperDto;

public interface ICreatePhdtoService {

	PageHelperDto getNewPhDto(String order, int page, int rows, String sort);

}
