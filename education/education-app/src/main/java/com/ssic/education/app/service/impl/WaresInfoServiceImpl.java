package com.ssic.education.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.app.dao.AppSchoolWaresDao;
import com.ssic.education.app.dao.LedgerInfoDao;
import com.ssic.education.app.dao.LicDao;
import com.ssic.education.app.dao.WaresInfoDao;
import com.ssic.education.app.dto.WaresInfoDto;
import com.ssic.education.app.dto.WaresListDto;
import com.ssic.education.app.dto.WaresRelatedDto;
import com.ssic.education.app.service.IWaresInfoService;
import com.ssic.education.app.util.JsonUtil;
import com.ssic.education.handle.pojo.ProWares;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import com.ssic.education.utils.util.BeanUtils;

/**		
 * <p>Title: WaresInfoServiceImpl </p>
 * <p>Description:商品信息业务逻辑接口类 实现类</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月16日 上午11:47:17	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月16日 上午11:47:17</p>
 * <p>修改备注：</p>
 */
@Service
public class WaresInfoServiceImpl implements IWaresInfoService {

	@Autowired
	private WaresInfoDao waresInfoDao;

	@Autowired
	private LicDao licDao;

	@Autowired
	private LedgerInfoDao ledgerDao;

	@Autowired
	private AppSchoolWaresDao schoolWaresDao;

	/**
	 * 根据供应商ID查询商品列表
	 * (non-Javadoc)   
	 * @see com.ssic.education.app.service.IWaresInfoService#getWaresBySupplierId(java.lang.String)
	 */
	@Override
	public List<WaresInfoDto> getWaresBySupplierId(String supplierId) {
		return waresInfoDao.findWarseBySupplier(supplierId);
	}

	/** 
	 * 根据供应商ID查询商品列表 带分页
	* (non-Javadoc)   
	 * @throws Exception 
	* @see com.ssic.education.app.service.IWaresInfoService#getWaresBySupplierId(java.lang.String, com.ssic.education.utils.model.PageQuery)   
	*/
	@Override
	public PageResult<WaresListDto> getWaresBySchoolId(String schoolId, String json) throws Exception {
		ProWares proWares = new ProWares();
		PageQuery query = new PageQuery();
		if (json != null) {
			try {
				proWares = JsonUtil.json2Obj(json, ProWares.class);
				query = JsonUtil.json2Obj(json, PageQuery.class);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		List<String> schoolWares = this.schoolWaresDao.findSchoolWaresBySchoolId(schoolId);
		if (schoolWares != null && !schoolWares.isEmpty()) {
			List<ProWares> wares = waresInfoDao.findWarseInSchool(schoolWares, proWares, query);
			List<WaresListDto> wareListDto = BeanUtils.createBeanListByTarget(wares, WaresListDto.class);
			return new PageResult<WaresListDto>(query, wareListDto);
		} else {
			return null;
		}
	}

	@Override
	public WaresRelatedDto findWarseById(String id) {
		WaresRelatedDto wrd = waresInfoDao.findWarseById(id);
		wrd.setInsReport(licDao.getLicbyType(wrd.getId(), 31));
		//wrd.setProLic(licDao.getLicbyType(wrd.getId(), 30));
		return wrd;
	}

	@Override
	public List<WaresListDto> findWarseBySchoolId(String schoolId) {
		// TODO 添加方法注释
		return waresInfoDao.findWarseBySchoolId(schoolId);
	}

}
