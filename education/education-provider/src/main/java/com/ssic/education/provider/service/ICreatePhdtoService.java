package com.ssic.education.provider.service;

import com.ssic.educateion.common.utils.PageHelperDto;

public interface ICreatePhdtoService {

	PageHelperDto getNewPhDto(String order, int page, int rows, String sort);

}
