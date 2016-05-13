package com.ssic.education.common.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.ssic.education.common.dto.ImageInfoDto;

public interface ICreateImageService {

	Map<String, Object> createImage(ImageInfoDto image, MultipartFile file,
			HttpServletRequest request, HttpServletResponse response);

}
