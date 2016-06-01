package com.ssic.education.handle.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import lombok.Getter;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.educateion.common.dto.LedgerDto;
import com.ssic.educateion.common.dto.ProLedgerDto;
import com.ssic.educateion.common.dto.ProSupplierDto;
import com.ssic.educateion.common.utils.DataGrid;
import com.ssic.educateion.common.utils.PageHelper;
import com.ssic.education.handle.mapper.ProLedgerExMapper;
import com.ssic.education.handle.mapper.ProLedgerMapper;
import com.ssic.education.handle.mapper.ProLedgerMasterExMapper;
import com.ssic.education.handle.mapper.ProLedgerMasterMapper;
import com.ssic.education.handle.mapper.ProSchoolWareMapper;
import com.ssic.education.handle.pojo.ProLedger;
import com.ssic.education.handle.pojo.ProLedgerExample;
import com.ssic.education.handle.pojo.ProLedgerMaster;
import com.ssic.education.handle.pojo.ProLedgerMasterExample;
import com.ssic.education.handle.pojo.ProSchoolWare;
import com.ssic.education.handle.pojo.ProSchoolWareExample;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;
import com.ssic.education.utils.util.BeanUtils;

/**
 * 
 * @author pengpeng
 * @Date: 2016年5月12日 下午5:36:46
 */
@Repository
public class ProLedgerDao extends MyBatisBaseDao<ProLedger> {

	@Autowired
	private ProSchoolWareMapper swMapper;

	@Getter
	@Autowired
	private ProLedgerMapper mapper;

	@Autowired
	private ProLedgerExMapper exMapper;

	@Autowired
	private ProLedgerMasterMapper lmMapper;

	@Autowired
	private ProLedgerMasterExMapper lmExMapper;

	public DataGrid findAllLedger(LedgerDto ld, PageHelper ph) {
		DataGrid dataGrid = new DataGrid();
		Long total = lmExMapper.countAllLedger(ld);
		dataGrid.setTotal(total);
		int beginRow = (ph.getPage() - 1) * ph.getRows();
		ph.setBeginRow(beginRow);
		List<LedgerDto> list = lmExMapper.findAllLedger(ld, ph);
		for (LedgerDto ledgerDto : list) {
			ProLedgerExample example = new ProLedgerExample();
			ProLedgerExample.Criteria criteria = example.createCriteria();
			criteria.andMasterIdEqualTo(ledgerDto.getMasterId());
			List<ProLedger> leadgers = mapper.selectByExample(example);
			String name = "";
			for (ProLedger proLedger : leadgers) {
				name += proLedger.getName() + ",";
			}
			if (name != "") {
				ledgerDto.setName(name.substring(0, name.length() - 1));
			}
		}
		dataGrid.setRows(list);
		return dataGrid;
	}

	public int saveLedger(List<LedgerDto> ledger) {
		// 采购品与学校
		for (LedgerDto ledgerDto : ledger) {
			ProSchoolWare psw = new ProSchoolWare();
			psw.setSchoolId(ledgerDto.getReceiverId());
			psw.setWareId(ledgerDto.getWaresId());
			psw.setSourceId(ledgerDto.getSourceId());
			psw.setSupplierId(ledgerDto.getSupplierId());
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
			List<ProSchoolWare> list = swMapper.selectByExample(example);
			if (list.size() == 0) {
				psw.setId(UUID.randomUUID().toString());
				psw.setCreateTime(new Date());
				psw.setLastUpdateTime(psw.getCreateTime());
				psw.setStat(1);
				swMapper.insert(psw);
			} else {
				for (ProSchoolWare sw : list) {
					ProSchoolWare psw1 = new ProSchoolWare();
					psw1.setId(sw.getId());
					psw1.setLastUpdateTime(new Date());
					swMapper.updateByPrimaryKeySelective(psw1);
				}
			}
		}
		ledger.get(0).setId(UUID.randomUUID().toString());
		ledger.get(0).setHaulStatus(0);
		lmExMapper.insertLedgerMaster(ledger.get(0));
		return exMapper.insertLedger(ledger);
	}

	public List<ProLedgerDto> findList(ProLedgerDto proLedgerDto, PageQuery page) {
		ProLedgerExample example = new ProLedgerExample();
		ProLedgerExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(proLedgerDto.getReceiverId())) {
			// criteria.andReceiverIdEqualTo(proLedgerDto.getReceiverId());
		}
		if (StringUtils.isNotBlank(proLedgerDto.getWaresId())) {
			criteria.andWaresIdEqualTo(proLedgerDto.getWaresId());
		}
		criteria.andStatEqualTo(DataStatus.ENABLED);
		if (null != page) {
			example.setOrderByClause("stat desc,create_time desc limit "
					+ page.getStartNum() + "," + page.getPageSize());
		}
		List<ProLedger> proLedgers = mapper.selectByExample(example);
		return BeanUtils.createBeanListByTarget(proLedgers, ProLedgerDto.class);
	}

	public long findCount(ProLedgerDto proLedgerDto) {
		ProLedgerExample example = new ProLedgerExample();
		ProLedgerExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(proLedgerDto.getReceiverId())) {
			// criteria.andReceiverIdEqualTo(proLedgerDto.getReceiverId());
		}
		if (StringUtils.isNotBlank(proLedgerDto.getWaresId())) {
			criteria.andWaresIdEqualTo(proLedgerDto.getWaresId());
		}
		criteria.andStatEqualTo(DataStatus.ENABLED);
		return mapper.countByExample(example);
	}

	public List<LedgerDto> selectLedgerList(LedgerDto ledgerDto) {
		return lmExMapper.selectLedgerList(ledgerDto);
	}

	public List<LedgerDto> selectLedgerListOrderby(LedgerDto ledgerDto,
			PageQuery page) {
		return lmExMapper.selectLedgerListOrderby(ledgerDto, page);
	}

	public long countLedgerListOrderby(LedgerDto ledgerDto) {
		return lmExMapper.countLedgerListOrderby(ledgerDto);
	}

	public List<ProSupplierDto> findPage(ProSupplierDto dto, PageQuery page) {
		return exMapper.selectSupplierByReceiverId(dto, page);
	}

	public long count(ProSupplierDto dto) {
		return exMapper.countSupplier(dto);
	}

	public List<LedgerDto> findLedgerByMasterId(String sourceId, String masterId) {
		return exMapper.findLedgerByMasterId(sourceId, masterId);
	}

	public int updataLedger(List<LedgerDto> ledgers) {
		lmExMapper.updateLedgerMaster(ledgers.get(0));
		for (LedgerDto ledger : ledgers) {
			ProSchoolWare psw = new ProSchoolWare();
			psw.setSchoolId(ledger.getReceiverId());
			psw.setWareId(ledger.getWaresId());
			psw.setSourceId(ledger.getSourceId());
			psw.setSupplierId(ledger.getSupplierId());
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
			List<ProSchoolWare> list = swMapper.selectByExample(example);
			if (list.size() == 0) {
				psw.setId(UUID.randomUUID().toString());
				psw.setCreateTime(new Date());
				psw.setLastUpdateTime(psw.getCreateTime());
				psw.setStat(1);
				swMapper.insert(psw);
			} else {
				for (ProSchoolWare sw : list) {
					ProSchoolWare psw1 = new ProSchoolWare();
					psw1.setId(sw.getId());
					psw1.setLastUpdateTime(new Date());
					swMapper.updateByPrimaryKeySelective(psw1);
				}
			}
			exMapper.updateLedger(ledger);
		}
		return 0;
	}

	public int deleteLedger(String sourceId, String masterId) {
		int r = lmExMapper.deleteLedgerMaster(sourceId, masterId);
		if (r != 0) {
			exMapper.deleteLedger(sourceId, masterId);
		}
		return r;
	}

	public int findWareBatchNo(String wareBatchNo, String sourceId) {
		ProLedgerMasterExample example = new ProLedgerMasterExample();
		ProLedgerMasterExample.Criteria criteria = example.createCriteria();
		criteria.andWareBatchNoEqualTo(wareBatchNo);
		criteria.andSourceIdEqualTo(sourceId);
		criteria.andStatEqualTo(1);
		List<ProLedgerMaster> list = lmMapper.selectByExample(example);
		return list.size();
	}

	public Map<ProLedgerMaster, List<ProLedger>> findExportProSupplier(
			LedgerDto ld) {
		Map<ProLedgerMaster, List<ProLedger>> map = new HashMap();
		ProLedgerMasterExample example = new ProLedgerMasterExample();
		ProLedgerMasterExample.Criteria plmCriteria = example.createCriteria();
		plmCriteria.andSourceIdEqualTo(ld.getSourceId());
		plmCriteria.andStatEqualTo(1);
		List<ProLedgerMaster> lmList = lmMapper.selectByExample(example);
		for (ProLedgerMaster plm : lmList) {
			ProLedgerExample plExample = new ProLedgerExample();
			ProLedgerExample.Criteria plCriteria = plExample.createCriteria();
			plCriteria.andMasterIdEqualTo(plm.getId());
			plCriteria.andStatEqualTo(1);
			List<ProLedger> list = mapper.selectByExample(plExample);
			map.put(plm, list);
		}
		return map;
	}

	public List<ProLedger> searchProLedger(List<String> ledgerMasterIds) {
		ProLedgerExample example = new ProLedgerExample();
		ProLedgerExample.Criteria criteria = example.createCriteria();

		if (ledgerMasterIds != null && ledgerMasterIds.size() > 0) {
			criteria.andMasterIdIn(ledgerMasterIds);
		}
		criteria.andStatEqualTo(DataStatus.ENABLED);

		return mapper.selectByExample(example);
	}

}
