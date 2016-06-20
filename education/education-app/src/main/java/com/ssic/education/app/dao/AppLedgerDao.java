package com.ssic.education.app.dao;

import java.util.Date;
import java.util.List;

import lombok.Getter;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.app.dto.LedgerInfoDto;
import com.ssic.education.app.dto.LedgerListDto;
import com.ssic.education.app.dto.LedgerMasterInfoDto;
import com.ssic.education.app.dto.LedgerMasterListDto;
import com.ssic.education.app.mapper.LedgerInfoExMapper;
import com.ssic.education.handle.mapper.ProLedgerMapper;
import com.ssic.education.handle.mapper.ProLedgerMasterMapper;
import com.ssic.education.handle.pojo.ProLedger;
import com.ssic.education.handle.pojo.ProLedgerExample;
import com.ssic.education.handle.pojo.ProLedgerMaster;
import com.ssic.education.handle.pojo.ProLedgerMasterExample;
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
public class AppLedgerDao {

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
	public List<LedgerMasterListDto> findAllMaster(ProLedgerMaster proLedgerMaster, PageQuery page, Date actionDate) {
		ProLedgerMasterExample example = new ProLedgerMasterExample();
		ProLedgerMasterExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(proLedgerMaster.getReceiverId())) {
			criteria.andReceiverIdEqualTo(proLedgerMaster.getReceiverId());
		}
		if (StringUtils.isNotBlank(proLedgerMaster.getUserId())) {
			criteria.andUserIdEqualTo(proLedgerMaster.getUserId());
		}
		if (actionDate != null) {
			criteria.andActionDateEqualTo(actionDate);
		}
		criteria.andStatEqualTo(DataStatus.ENABLED);
		if (null != page) {
			if (StringUtils.isNotBlank(proLedgerMaster.getUserId())) {
				example.setOrderByClause("FIELD(haul_status,1,0,2),action_date desc limit " + page.getStartNum() + "," + page.getPageSize());
			}else
			{
				example.setOrderByClause("stat desc,action_date desc limit " + page.getStartNum() + "," + page.getPageSize());
			}
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
			example.setOrderByClause("stat desc limit " + page.getStartNum() + "," + page.getPageSize());
		}
		List<ProLedger> proLedgers = ledgerMapper.selectByExample(example);
		return proLedgers;
	}

	/**
	 * 根据ID查询ProLedgerMaster
	 * findProLedgerMasterInfo：一句话描述方法功能
	 * @param proLedgerMaster
	 * @return
	 * @exception	
	 * @author Administrator
	 * @date 2016年5月27日 下午2:06:51
	 */
	public LedgerMasterInfoDto findProLedgerMasterInfo(String id) {
		ProLedgerMaster ledgerMaster = ledgerMasterMapper.selectByPrimaryKey(id);
		return BeanUtils.createBeanByTarget(ledgerMaster, LedgerMasterInfoDto.class);
	}

	public int updateStatus(String id, String status) {
		ProLedgerMasterExample example = new ProLedgerMasterExample();
		ProLedgerMasterExample.Criteria criteria = example.createCriteria();
		ProLedgerMaster ledgerMaster = new ProLedgerMaster();
		ledgerMaster.setHaulStatus(Integer.valueOf(status));
		if (status.equals("1")) {
			ledgerMaster.setStartTime(new Date());
		}
		if (status.equals("2")) {
			ledgerMaster.setEndTime(new Date());
		}

		criteria.andIdEqualTo(id);
		return ledgerMasterMapper.updateByExampleSelective(ledgerMaster, example);
	}
}
