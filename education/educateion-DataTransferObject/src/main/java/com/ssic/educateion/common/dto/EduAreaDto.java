package com.ssic.educateion.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Description: 类描述:TODO </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 *
 * @author wangxiang
 * @version 1.0
 * @date 2016/5/13 12:51
 */
@JsonIgnoreProperties(value = {"lastUpdateTime","createTime","stat"})
public class EduAreaDto implements Serializable {

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
