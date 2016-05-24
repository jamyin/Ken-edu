package com.ssic.education.common.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	private List<String>  receive = new ArrayList<String>(); //接收者Id List

}

