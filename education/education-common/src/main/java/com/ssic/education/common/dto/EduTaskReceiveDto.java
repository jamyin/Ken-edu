package com.ssic.education.common.dto;

import java.io.Serializable;
import java.util.Date;

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
public class EduTaskReceiveDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private String id;
	
	private String taskId;

	private Integer readstat;

	private String receiveId;

	private String schoolId;

	private Date createTime;

	private Date lastUpdateTime;

	private Integer stat;


}

