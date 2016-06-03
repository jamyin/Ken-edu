package com.ssic.education.handle.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.educateion.common.dto.LedgerDto;
import com.ssic.educateion.common.utils.DataGrid;
import com.ssic.educateion.common.utils.PageHelper;
import com.ssic.education.handle.dao.ProLedgerDao;
import com.ssic.education.handle.mapper.ProLedgerMapper;
import com.ssic.education.handle.mapper.ProLedgerMasterMapper;
import com.ssic.education.handle.mapper.ProSchoolWareMapper;
import com.ssic.education.handle.pojo.ProLedger;
import com.ssic.education.handle.pojo.ProLedgerMaster;
import com.ssic.education.handle.pojo.ProSchoolWare;
import com.ssic.education.handle.pojo.ProSchoolWareExample;
import com.ssic.education.handle.service.ILedgerService;

@Service
public class LedgerService implements ILedgerService {

	@Autowired
	private ProLedgerDao ledgerDao;

	@Autowired
	private ProLedgerMasterMapper lmm;

	@Autowired
	private ProLedgerMapper lm;
	
	@Autowired
	private ProSchoolWareMapper swMapper;

	@Override
	public DataGrid findAllLedger(LedgerDto ld, PageHelper ph) {
		return ledgerDao.findAllLedger(ld, ph);
	}

	@Override
	public int saveLedger(List<LedgerDto> ledger) {
		return ledgerDao.saveLedger(ledger);
	}

	@Override
	public List<LedgerDto> findLedgerByMasterId(String sourceId, String masterId) {
		return ledgerDao.findLedgerByMasterId(sourceId, masterId);
	}

	@Override
	public int updataLedger(List<LedgerDto> ledger) {
		return ledgerDao.updataLedger(ledger);
	}

	@Override
	public int deleteLedger(String sourceId, String wareBatchNo) {
		return ledgerDao.deleteLedger(sourceId, wareBatchNo);
	}

	@Override
	public int findWareBatchNo(String wareBatchNo,String sourceId) {
		return ledgerDao.findWareBatchNo(wareBatchNo,sourceId);
	}

	@Override
	public int importLedger(Map<ProLedgerMaster, List<ProLedger>> map) {
		for (ProLedgerMaster o : map.keySet()) {
			o.setId(UUID.randomUUID().toString());
			lmm.insertSelective(o);
			List<ProLedger> list = map.get(o);
			for (ProLedger oo : list) {
				ProSchoolWare psw = new ProSchoolWare();
				psw.setSchoolId(o.getReceiverId());
				psw.setWareId(oo.getWaresId());
				psw.setSourceId(o.getSourceId());
				psw.setSupplierId(oo.getSupplierId());
				ProSchoolWareExample example = new ProSchoolWareExample();
				ProSchoolWareExample.Criteria criteria = example.createCriteria();
				criteria.andSchoolIdEqualTo(psw.getSchoolId());
				criteria.andWareIdEqualTo(psw.getWareId());
				criteria.andSourceIdEqualTo(psw.getSourceId());
				if (psw.getSupplierId() != null) {
					criteria.andSupplierIdEqualTo(psw.getSupplierId());
				} else {
					criteria.andSupplierIdIsNull();
				}
				List<ProSchoolWare> pslist = swMapper.selectByExample(example);
				if (pslist.size() == 0) {
					psw.setId(UUID.randomUUID().toString());
					psw.setCreateTime(new Date());
					psw.setLastUpdateTime(psw.getCreateTime());
					psw.setStat(1);
					swMapper.insert(psw);
				}else{
					for (ProSchoolWare sw : pslist) {
						ProSchoolWare psw1 = new ProSchoolWare();
						psw1.setId(sw.getId());
						psw1.setLastUpdateTime(new Date());
						swMapper.updateByPrimaryKeySelective(psw1);
					}
				}
				oo.setId(UUID.randomUUID().toString());
				oo.setMasterId(o.getId());
				lm.insertSelective(oo);
			}
		}
		return 0;
	}

	@Override
	public Map<ProLedgerMaster,List<ProLedger>> findExportProSupplier(LedgerDto ld) {
		return ledgerDao.findExportProSupplier(ld);
	}

	@Override
	public int upDeleteLedger(String id) {
		return ledgerDao.upDeleteLedger(id);
	}

	@Override
	public int upSaveLedger(List<LedgerDto> ledgers) {
		return ledgerDao.upSaveLedger(ledgers);
	}

}
