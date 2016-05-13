package com.ssic.education.government.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>Description: 类描述:供应商查询参数 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 *
 * @author wangxiang
 * @version 1.0
 * @date 2016/5/13 9:18
 */
public class SupplierQueryParams implements Serializable {
    @Getter
    @Setter
    private String area;

    @Getter
    @Setter
    private String school;

    @Getter
    @Setter
    private String supplierName;

    @Getter
    @Setter
    private String asddress;
}