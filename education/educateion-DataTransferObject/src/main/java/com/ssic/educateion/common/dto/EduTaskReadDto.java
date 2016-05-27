package com.ssic.educateion.common.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.ssic.education.utils.model.PageResult;

/**
* @ClassName: EduTaskReceiveDto
* @Description: 接收任务(通知Dto)
* @author Ken Yin
* @date 2016年5月21日 上午11:40:04
*
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EduTaskReadDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String taskId;  			 //任务Id
	private Integer readstat;			 //阅读状态
	private String userId;				 //用户 Id
	private String name;				 //用户姓名
	private String userImage;			 //头像
	
	private PageResult<EduTaskReadDto> readList;     //已读列表	
	private PageResult<EduTaskReadDto> notReadList;	//未读列表
	
}

