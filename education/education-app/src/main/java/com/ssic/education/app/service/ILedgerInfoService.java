package com.ssic.education.app.service;

import com.ssic.education.app.dto.LedgerInfoDto;
import com.ssic.education.app.dto.LedgerMasterInfoDto;
import com.ssic.education.app.dto.LedgerMasterListDto;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;

/**		
 * <p>Title: ILedgerInfoService </p>
 * <p>Description: 类描述</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月17日 下午1:21:22	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月17日 下午1:21:22</p>
 * <p>修改备注：</p>
 */
public interface ILedgerInfoService {
	LedgerInfoDto findLedgerByBatchNo(String batchNo);

	PageResult<LedgerMasterListDto> findMasterList(String receiverId, PageQuery page);

	PageResult<LedgerMasterListDto> findMasterDriverList(String userId, PageQuery page);

	LedgerMasterInfoDto findMasterById(String id, PageQuery page);
}
