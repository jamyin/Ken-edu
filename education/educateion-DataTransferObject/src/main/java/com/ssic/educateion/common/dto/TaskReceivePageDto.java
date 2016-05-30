package com.ssic.educateion.common.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class TaskReceivePageDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private String taskId;
	private String name;
	private Integer readstat;

}

