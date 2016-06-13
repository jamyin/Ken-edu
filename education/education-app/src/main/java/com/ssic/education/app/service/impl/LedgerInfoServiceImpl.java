package com.ssic.education.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.app.dao.LedgerInfoDao;
import com.ssic.education.app.dao.SupplierInfoDao;
import com.ssic.education.app.dto.LedgerInfoDto;
import com.ssic.education.app.dto.LedgerMasterInfoDto;
import com.ssic.education.app.dto.LedgerMasterListDto;
import com.ssic.education.app.dto.LedgerDetailDto;
import com.ssic.education.app.service.ILedgerInfoService;
import com.ssic.education.handle.dao.ProLedgerMasterDao;
import com.ssic.education.handle.pojo.ProLedger;
import com.ssic.education.handle.pojo.ProLedgerMaster;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import com.ssic.education.utils.util.BeanUtils;

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
	@Autowired
	private SupplierInfoDao supplierInfoDao;
	@Autowired
	private ProLedgerMasterDao proLedgerMasterDao;

	/** 
	* (non-Javadoc)   
	* @see com.ssic.education.app.service.ILedgerInfoService#findLedgerByBatchNo(java.lang.String)   
	*/
	@Override
	public LedgerInfoDto findLedgerByBatchNo(String batchNo) {
		return ledgerInfoDao.findLedgerByBatchNo(batchNo);
	}

	//查询配送信息列表
	public PageResult<LedgerMasterListDto> findMasterList(String receiverId, PageQuery page) {
		ProLedgerMaster ledgerMaster = new ProLedgerMaster();
		ledgerMaster.setReceiverId(receiverId);
		List<LedgerMasterListDto> LedgerMasterList = ledgerInfoDao.findAllMaster(ledgerMaster, page, null);
		List<LedgerMasterListDto> result = new ArrayList<LedgerMasterListDto>();
		for (LedgerMasterListDto lmld : LedgerMasterList) {
			ProLedger Ledger = new ProLedger();
			Ledger.setMasterId(lmld.getId());
			List<ProLedger> ProLedgerList = ledgerInfoDao.findProLedgerList(Ledger, null);
			lmld.setStock(listToString(ProLedgerList));
			lmld.setOutset(supplierInfoDao.getSupplierName(lmld.getSourceId()));
			result.add(lmld);
		}
		return new PageResult<LedgerMasterListDto>(page, result);
	}

	//查询驾驶员配送信息列表
	public PageResult<LedgerMasterListDto> findMasterDriverList(String userId, PageQuery page, Date actionDate) {
		ProLedgerMaster ledgerMaster = new ProLedgerMaster();
		ledgerMaster.setUserId(userId);
		List<LedgerMasterListDto> LedgerMasterList = ledgerInfoDao.findAllMaster(ledgerMaster, page, actionDate);
		List<LedgerMasterListDto> result = new ArrayList<LedgerMasterListDto>();
		for (LedgerMasterListDto lmld : LedgerMasterList) {
			ProLedger Ledger = new ProLedger();
			Ledger.setMasterId(lmld.getId());
			List<ProLedger> ProLedgerList = ledgerInfoDao.findProLedgerList(Ledger, null);
			lmld.setStock(listToString(ProLedgerList));
			lmld.setOutset(supplierInfoDao.getSupplierName(lmld.getSourceId()));
			result.add(lmld);
		}
		return new PageResult<LedgerMasterListDto>(page, result);
	}

	//根据Id查询配送信息并带出批次列表
	public LedgerMasterInfoDto findMasterById(String id, PageQuery page) {
		LedgerMasterInfoDto ledgerMaster = this.ledgerInfoDao.findProLedgerMasterInfo(id);
		ProLedger Ledger = new ProLedger();
		Ledger.setMasterId(ledgerMaster.getId());
		List<ProLedger> ProLedgerString = ledgerInfoDao.findProLedgerList(Ledger, null);
		List<ProLedger> ProLedgerList = ledgerInfoDao.findProLedgerList(Ledger, page);
		if (ProLedgerString != null) {
			ledgerMaster.setStock(listToString(ProLedgerString));
			List<LedgerDetailDto> ldd = BeanUtils.createBeanListByTarget(ProLedgerList, LedgerDetailDto.class);
			ledgerMaster.setResultLedger((new PageResult<LedgerDetailDto>(page, ldd)));
			ledgerMaster.setOutset(supplierInfoDao.getSupplierName(ledgerMaster.getSourceId()));
		}
		//TODO 还缺少采购品列表
		return ledgerMaster;
	}

	/**
	 * List转String
	 * listToString：一句话描述方法功能
	 * @param list
	 * @return
	 * @exception	
	 * @author SeanYoung
	 * @date 2016年5月26日 下午3:31:15
	 */
	public String listToString(List<ProLedger> list) {
		if (list == null) {
			return null;
		}
		StringBuilder result = new StringBuilder();
		boolean flag = false;
		for (ProLedger proLedger : list) {
			if (flag) {
				result.append("," == null ? "" : ",");
			} else {
				flag = true;
			}
			result.append(proLedger.getName());
		}

		return result.toString();
	}

	public int updateStatus(String id, String status) {
		int count = ledgerInfoDao.updateStatus(id, status);
		if (count == 1) {
			return proLedgerMasterDao.selectByPrimaryKey(id).getHaulStatus();
		}
		return -1;
	}
}
