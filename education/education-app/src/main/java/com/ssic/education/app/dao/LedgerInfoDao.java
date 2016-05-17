package com.ssic.education.app.dao;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.app.dto.LedgerInfoDto;
import com.ssic.education.app.mapper.LedgerInfoExMapper;

/**		
 * <p>Title: LedgerInfoDao </p>
 * <p>Description: 类描述</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月17日 下午1:12:36	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月17日 下午1:12:36</p>
 * <p>修改备注：</p>
 */
@Repository
public class LedgerInfoDao {

	@Getter
	@Autowired
	private LedgerInfoExMapper mapper;

	public LedgerInfoDto findLedgerByBatchNo(String batchNo) {
		return mapper.findLedgerByBatchNo(batchNo);
	}
}
