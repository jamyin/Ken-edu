package com.ssic.educateion.common.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName: EduTaskReceiveDto
 * @Description: 接收任务(通知Dto)
 * @author Ken Yin
 * @date 2016年5月21日 上午11:40:04
 *
 */
@Data
@ToString
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
	
	private String taskTitle;
    private String receiveName;
    private String sendName;
    private String createId;
    private Date readTime;
}

