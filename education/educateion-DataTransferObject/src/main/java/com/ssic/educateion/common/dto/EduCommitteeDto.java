package com.ssic.educateion.common.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @ClassName: EduCommitteeDto
* @Description: TODO(这里用一句话描述这个类的作用)
* @author Ken Yin
* @date 2016年5月23日 下午5:10:37
*
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EduCommitteeDto implements Serializable{
	private static final long serialVersionUID = -7174148151231374603L;
	
	private String id;
    private String name;
    private Short type;
    private String areaCode;
    private Date createTime;
    private Date lastUpdateTime;
    private Short stat;
}
