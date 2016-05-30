package com.ssic.education.app.dto;

import java.util.List;

import com.ssic.educateion.common.dto.EduCommitteeDto;
import com.ssic.educateion.common.dto.SchoolDto;
import com.ssic.education.utils.model.PageResult;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
* @ClassName: TaskReceiveDto
* @Description: 任务接收者Dto
* @author Ken Yin
* @date 2016年5月30日 下午1:52:33
*
 */
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskReceiveDto {
	
	private List<EduCommitteeDto> eduCommitteeList;
	private List<MapToListDto> levelList ;
	private PageResult<SchoolDto> schoolList;
	
    
}

