package com.ssic.education.provider.service.impl;

import org.springframework.stereotype.Service;

import com.ssic.education.provider.dto.PageHelperDto;
import com.ssic.education.provider.service.ICreatePhdtoService;
@Service
public class CreatePhdtoServiceImpl implements ICreatePhdtoService {

	public PageHelperDto getNewPhDto(String order, int page, int rows,
			String sort) {
		// TODO Auto-generated method stub
		 PageHelperDto phdto = new PageHelperDto();
	        phdto.setOrder(order);
	        phdto.setPage(page);
	        phdto.setRows(rows);
	        phdto.setSort(sort);
	        phdto.setBeginRow((page - 1) * rows);
	        return phdto;
	}

}
