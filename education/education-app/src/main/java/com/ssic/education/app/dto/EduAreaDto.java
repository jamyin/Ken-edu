package com.ssic.education.app.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
* @ClassName: EduAreaDto
* @Description: TODO(这里用一句话描述这个类的作用)
* @author Ken Yin
* @date 2016年5月12日 上午11:50:21
*
 */
@ToString
public class EduAreaDto {

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String addressName;

    @Getter
    @Setter
    private String addressCode;

    @Getter
    @Setter
    private String parentId;

    @Getter
    @Setter
    private String parentCode;

    @Getter
    @Setter
    private Float longitude;

    @Getter
    @Setter
    private Float latitude;

    @Getter
    @Setter
    private Date lastUpdateTime;

    @Getter
    @Setter
    private Date createTime;

    @Getter
    @Setter
    private Integer stat;
    
}

