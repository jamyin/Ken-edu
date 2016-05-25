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
import com.ssic.education.common.mapper.ProSchoolWareMapper;
import com.ssic.education.common.pojo.ProLedger;
import com.ssic.education.common.pojo.ProLedgerExample;
import com.ssic.education.common.pojo.ProSchoolWare;
import com.ssic.education.common.pojo.ProSchoolWareExample;
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

	public DataGrid findAllLedger(LedgerDto ld, PageHelper ph) {
		DataGrid dataGrid = new DataGrid();
		Long total = exMapper.countAllLedger(ld);
		dataGrid.setTotal(total);
		int beginRow = (ph.getPage() - 1) * ph.getRows();
		ph.setBeginRow(beginRow);
		dataGrid.setRows(exMapper.findAllLedger(ld, ph));
		return dataGrid;
	}

	public int saveLedger(List<LedgerDto> ledger) {
		ledger.get(0).setReceiverId(
				exMapper.findSchoolIdByReceiverId(ledger.get(0)));
		if (ledger.get(0).getReceiverId() == null) {
			return 0;
		}
		ledger.get(0).setCreateTime(new Date());
		ledger.get(0).setLastUpdateTime(ledger.get(0).getCreateTime());
		ledger.get(0).setStat(1);
		for (int i = 0; i < ledger.size(); i++) {
			ledger.get(i).setSourceId(ledger.get(0).getSourceId());
			// 采购品Id
			ledger.get(i).setWaresId(
					exMapper.findWaresIdBySupplierId(ledger.get(i)));
			if (ledger.get(i).getWaresId() != null) {
				// 供货商Id
				ledger.get(i).setSupplierId(
						exMapper.findSupplierIdBySourceId(ledger.get(i)));
				if (ledger.get(i).getSupplierId() == null) {
					ledger.get(i).setSupplierName(null);
				}
			}
			// 采购品与学校
			ProSchoolWare psw = new ProSchoolWare();
			psw.setSchoolId(ledger.get(0).getReceiverId());
			psw.setWareId(ledger.get(i).getWaresId());
			psw.setSourceId(ledger.get(i).getSourceId());
			ProSchoolWareExample example = new ProSchoolWareExample();
			ProSchoolWareExample.Criteria criteria = example.createCriteria();
			criteria.andSchoolIdEqualTo(psw.getSchoolId());
			criteria.andWareIdEqualTo(psw.getWareId());
			criteria.andSourceIdEqualTo(psw.getSourceId());
			List<ProSchoolWare> list = swMapper.selectByExample(example);
			if (list.size() == 0) {
				psw.setId(UUID.randomUUID().toString());
				psw.setCreateTime(new Date());
				psw.setLastUpdateTime(psw.getCreateTime());
				psw.setStat(1);
				swMapper.insert(psw);
			}
		}
		return exMapper.insertLedger(ledger);
	}

	public List<ProLedgerDto> findList(ProLedgerDto proLedgerDto, PageQuery page) {
		ProLedgerExample example = new ProLedgerExample();
		ProLedgerExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(proLedgerDto.getReceiverId())) {
			criteria.andReceiverIdEqualTo(proLedgerDto.getReceiverId());
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
			criteria.andReceiverIdEqualTo(proLedgerDto.getReceiverId());
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

	public int updataLedger(List<LedgerDto> ledger) {
		ledger.get(0).setReceiverId(
				exMapper.findSchoolIdByReceiverId(ledger.get(0)));
		if (ledger.get(0).getReceiverId() == null) {
			return 0;
		}

		for (LedgerDto ledgerDto : ledger) {
			ledgerDto.setReceiverName(ledger.get(0).getReceiverName());
			ledgerDto.setLastUpdateTime(new Date());
			ledgerDto.setStat(1);
			ledgerDto.setReceiverId(ledger.get(0).getReceiverId());
			ledgerDto.setWareBatchNo(ledger.get(0).getWareBatchNo());
			ledgerDto.setSourceId(ledger.get(0).getSourceId());
			ledgerDto.setUserId(ledger.get(0).getUserId());
			ledgerDto.setActionDate(ledger.get(0).getActionDate());
			ledgerDto.setWaresId(exMapper.findWaresIdBySupplierId(ledgerDto));
			if (ledgerDto.getWaresId() != null) {
				ledgerDto.setSupplierId(exMapper
						.findSupplierIdBySourceId(ledgerDto));
				if (ledgerDto.getSupplierId() == null) {
					ledgerDto.setSupplierName(null);
				}
				exMapper.updateLedger(ledgerDto);
			}
		}
		return 0;
	}

	public int deleteLedger(String sourceId, String wareBatchNo) {
		return exMapper.deleteLedger(sourceId, wareBatchNo);
	}

}
