package com.ssic.education.common.dao;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import lombok.Getter;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.common.dto.ProLedgerDto;
import com.ssic.education.common.dto.ProSupplierDto;
import com.ssic.education.common.mapper.ProLedgerExMapper;
import com.ssic.education.common.mapper.ProLedgerMapper;
import com.ssic.education.common.mapper.ProLedgerMasterExMapper;
import com.ssic.education.common.mapper.ProSchoolWareMapper;
import com.ssic.education.common.pojo.ProLedger;
import com.ssic.education.common.pojo.ProLedgerExample;
import com.ssic.education.common.provider.dto.LedgerDto;
import com.ssic.education.common.provider.utils.DataGrid;
import com.ssic.education.common.provider.utils.PageHelper;
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
	ProSchoolWareMapper swMapper;

	@Getter
	@Autowired
	private ProLedgerMapper mapper;

	@Autowired
	private ProLedgerExMapper exMapper;

	@Autowired
	private ProLedgerMasterExMapper lmMapper;

	public DataGrid findAllLedger(LedgerDto ld, PageHelper ph) {
		DataGrid dataGrid = new DataGrid();
		Long total = lmMapper.countAllLedger(ld);
		dataGrid.setTotal(total);
		int beginRow = (ph.getPage() - 1) * ph.getRows();
		ph.setBeginRow(beginRow);
		dataGrid.setRows(lmMapper.findAllLedger(ld, ph));
		return dataGrid;
	}

	public int saveLedger(List<LedgerDto> ledger) {
		// // 采购品与学校
		// ProSchoolWare psw = new ProSchoolWare();
		// psw.setSchoolId(ledger.get(0).getReceiverId());
		// psw.setWareId(ledger.get(i).getWaresId());
		// psw.setSourceId(ledger.get(i).getSourceId());
		// ProSchoolWareExample example = new ProSchoolWareExample();
		// ProSchoolWareExample.Criteria criteria = example.createCriteria();
		// criteria.andSchoolIdEqualTo(psw.getSchoolId());
		// criteria.andWareIdEqualTo(psw.getWareId());
		// criteria.andSourceIdEqualTo(psw.getSourceId());
		// List<ProSchoolWare> list = swMapper.selectByExample(example);
		// if (list.size() == 0) {
		// psw.setId(UUID.randomUUID().toString());
		// psw.setCreateTime(new Date());
		// psw.setLastUpdateTime(psw.getCreateTime());
		// psw.setStat(1);
		// swMapper.insert(psw);
		// }
		ledger.get(0).setId(UUID.randomUUID().toString());
		ledger.get(0).setHaulStatus(0);
		;
		lmMapper.insertLedgerMaster(ledger.get(0));
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

	public List<ProSupplierDto> findPage(ProSupplierDto dto, PageQuery page) {
		return exMapper.selectSupplierByReceiverId(dto, page);
	}

	public long count(ProSupplierDto dto) {
		return exMapper.countSupplier(dto);
	}

	public List<LedgerDto> findLedgerById(String sourceId, String wareBatchNo) {
		return exMapper.findLedgerByWareBatchNo(sourceId, wareBatchNo);
	}

	public int updataLedger(List<LedgerDto> ledgers) {
		lmMapper.updateLedgerMaster(ledgers.get(0));
		for (LedgerDto ledger : ledgers) {
			exMapper.updateLedger(ledger);
		}
		return 0;
	}

	public int deleteLedger(String sourceId, String wareBatchNo) {
		lmMapper.deleteLedgerMaster(sourceId, wareBatchNo);
		return exMapper.deleteLedger(sourceId, wareBatchNo);
	}

}
