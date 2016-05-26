package com.ssic.education.app.dao;

import java.util.List;

import lombok.Getter;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.app.dto.LedgerInfoDto;
import com.ssic.education.app.dto.LedgerListDto;
import com.ssic.education.app.dto.LedgerMasterListDto;
import com.ssic.education.app.mapper.LedgerInfoExMapper;
import com.ssic.education.common.dto.ProLedgerDto;
import com.ssic.education.common.mapper.ProLedgerExMapper;
import com.ssic.education.common.mapper.ProLedgerMapper;
import com.ssic.education.common.mapper.ProLedgerMasterMapper;
import com.ssic.education.common.pojo.ProLedger;
import com.ssic.education.common.pojo.ProLedgerExample;
import com.ssic.education.common.pojo.ProLedgerMaster;
import com.ssic.education.common.pojo.ProLedgerMasterExample;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.util.BeanUtils;

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

	@Getter
	@Autowired
	private ProLedgerMapper ledgerMapper;
	@Getter
	@Autowired
	private ProLedgerMasterMapper ledgerMasterMapper;

	public LedgerInfoDto findLedgerByBatchNo(String batchNo) {
		return mapper.findLedgerByBatchNo(batchNo);
	}

	public List<LedgerListDto> findLedgerByWaresId(String waresId) {
		return mapper.findLedgerByWaresId(waresId);
	}

	/**
	 * findAllMaster：查询LedgerMaster列表根据ReceiverId
	 * @param proLedgerDto
	 * @param page
	 * @return
	 * @exception	
	 * @author SeanYoung
	 * @date 2016年5月26日 下午2:31:27
	 */
	public List<LedgerMasterListDto> findAllMaster(ProLedgerMaster proLedgerMaster, PageQuery page) {
		ProLedgerMasterExample example = new ProLedgerMasterExample();
		ProLedgerMasterExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(proLedgerMaster.getReceiverId())) {
			criteria.andReceiverIdEqualTo(proLedgerMaster.getReceiverId());
		}
		criteria.andStatEqualTo(DataStatus.ENABLED);
		if (null != page) {
			example.setOrderByClause("stat desc,create_time desc limit " + page.getStartNum() + "," + page.getPageSize());
		}
		List<ProLedgerMaster> proLedgersMaster = ledgerMasterMapper.selectByExample(example);
		return BeanUtils.createBeanListByTarget(proLedgersMaster, LedgerMasterListDto.class);
	}

	/**
	 * 根据masterId 查出采购品拼接字符串
	 * getWaresString：一句话描述方法功能
	 * @param masterId
	 * @return
	 * @exception	
	 * @author SeanYoung
	 * @date 2016年5月26日 下午2:36:48
	 */
	public List<ProLedger> findProLedgerList(ProLedger ProLedger, PageQuery page) {
		ProLedgerExample example = new ProLedgerExample();
		ProLedgerExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(ProLedger.getMasterId())) {
			criteria.andMasterIdEqualTo(ProLedger.getMasterId());
		}
		criteria.andStatEqualTo(DataStatus.ENABLED);
		if (null != page) {
			example.setOrderByClause("stat desc,create_time desc limit " + page.getStartNum() + "," + page.getPageSize());
		}
		List<ProLedger> proLedgers = ledgerMapper.selectByExample(example);
		return proLedgers;
	}
}
