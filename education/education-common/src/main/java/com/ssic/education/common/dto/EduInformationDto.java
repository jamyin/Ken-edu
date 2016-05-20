package com.ssic.education.common.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: EduSchoolDto
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Ken Yin
 * @date 2016年5月17日 上午10:05:56
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EduInformationDto implements Serializable {
	private static final long serialVersionUID = 7634577141863743187L;
	
	private String id;
	private String title;
	private String pic;
	private String summary;
	private Integer type;       //(1:公告 2:卫生检查 3:健康宣教  )
	private String createAdminId;
	private String createAdminName;
	private Date createTime;
	private Date lastUpdateTime;
	private Integer stat;
	private String content;


}
