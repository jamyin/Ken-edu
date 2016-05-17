package com.ssic.education.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.app.dao.LedgerInfoDao;
import com.ssic.education.app.dto.LedgerInfoDto;
import com.ssic.education.app.service.ILedgerInfoService;

/**		
 * <p>Title: LedgerInfoServiceImpl </p>
 * <p>Description: 类描述</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月17日 下午1:22:08	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月17日 下午1:22:08</p>
 * <p>修改备注：</p>
 */
@Service
public class LedgerInfoServiceImpl implements ILedgerInfoService {

	@Autowired
	private LedgerInfoDao ledgerInfoDao;

	/** 
	* (non-Javadoc)   
	* @see com.ssic.education.app.service.ILedgerInfoService#findLedgerByBatchNo(java.lang.String)   
	*/
	@Override
	public LedgerInfoDto findLedgerByBatchNo(String batchNo) {
		return ledgerInfoDao.findLedgerByBatchNo(batchNo);
	}

}
