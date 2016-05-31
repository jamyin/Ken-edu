package com.ssic.educateion.common.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName: EduTaskDto
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Ken Yin
 * @date 2016年5月20日 下午3:40:34
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EduTaskDto  implements Serializable {

	private static final long serialVersionUID = -7535692466191048004L;

	private String id;
	private String title;
	private String pic;
	private String summary;
	private String content;
	private String createId;
	private String createName;
	private Date createTime;
	private Date lastUpdateTime;
	private Integer stat;
	
	private String receiveId; //接收者Id
	private Integer readstat;	//阅读状态(0:未读;1:已读)
	private String receiveIdsNames;  //接收者id和name, 格式id#name,id#name,  
	private String sendIdsNames;     //发送者者id和name, 格式id#name,id#name, 

	private Integer taskType;	//任务类型(0:接收的任务;1:发送的任务)
	private String receiveNames;   //接收者名字
	private Integer reads;	      //已读人数
	private Integer notReads;	  //未读人数
	
	private Integer sourceType;	  //用户类型   0教委;1学校;2区委
	
	//private PageResult<EduTaskDto> sendList;            //当前用户发送任务列表
	//private PageResult<EduTaskDto> receiveReadList;        //当前用户接收任务列表 -已读   readStat=1
	//private PageResult<EduTaskDto> receiveNotReadList;         //当前用户接收任务列表 -未读    readStat=0

}

