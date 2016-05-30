package com.ssic.educateion.common.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.ssic.education.utils.model.PageResult;

/**
 * @ClassName: ChooseSchoolDto
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Ken Yin
 * @date 2016年5月29日 下午12:48:20
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChooseSchoolDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private PageResult<SchoolDto>  schoolDto;
	//private Map<Integer, String> levelList;    
	//private List<EduAreaDto> areaList;
	private List<EduCommitteeDto> committeeList;
	public List<MapToListDto> levelList;
}
