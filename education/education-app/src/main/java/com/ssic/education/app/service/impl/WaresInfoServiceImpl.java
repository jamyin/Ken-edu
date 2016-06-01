package com.ssic.education.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.app.constants.ProductClass;
import com.ssic.education.app.dao.AppSchoolWaresDao;
import com.ssic.education.app.dao.LedgerInfoDao;
import com.ssic.education.app.dao.LicDao;
import com.ssic.education.app.dao.SupplierInfoDao;
import com.ssic.education.app.dao.WaresInfoDao;
import com.ssic.education.app.dto.AppLicenseDto;
import com.ssic.education.app.dto.WaresInfoDto;
import com.ssic.education.app.dto.WaresListDto;
import com.ssic.education.app.dto.WaresRelatedDto;
import com.ssic.education.app.service.IWaresInfoService;
import com.ssic.education.app.util.JsonUtil;
import com.ssic.education.handle.pojo.ProLicense;
import com.ssic.education.handle.pojo.ProWares;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import com.ssic.education.utils.util.BeanUtils;
import com.ssic.education.utils.util.StringUtils;

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

	@Autowired
	private SupplierInfoDao supplierInfoDto;

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

	/** 
	 * 根据供应商ID查询商品列表 带分页
	* (non-Javadoc)   
	 * @throws Exception 
	* @see com.ssic.education.app.service.IWaresInfoService#getWaresBySupplierId(java.lang.String, com.ssic.education.utils.model.PageQuery)   
	*/
	@Override
	public PageResult<WaresListDto> getWaresBySchoolId(String schoolId, ProWares prowares, PageQuery query) {
		List<String> schoolWares = this.schoolWaresDao.findSchoolWaresBySchoolId(schoolId);
		if (schoolWares != null && !schoolWares.isEmpty()) {
			List<ProWares> wares = waresInfoDao.findWarseInSchool(schoolWares, prowares, query);
			int total = waresInfoDao.findWarseInSchoolCount(schoolWares, prowares);
			query.setTotal(total);
			List<WaresListDto> wareListDto = BeanUtils.createBeanListByTarget(wares, WaresListDto.class);
			return new PageResult<WaresListDto>(query, wareListDto);
		} else {
			return null;
		}
	}

	/**
	 * 根据ID查询商品信息
	 */
	@Override
	public WaresRelatedDto findWarseById(String id) {
		WaresRelatedDto wrd = waresInfoDao.findWarseById(id);
		if (wrd.getWaresType() != null) {
			wrd.setTypeName(ProductClass.getName(wrd.getWaresType()));
		}
		List<ProLicense> list = supplierInfoDto.getWaresLic(wrd.getId(), (short) 2);
		if (null != list && !list.isEmpty()) {
			List<AppLicenseDto> licList = BeanUtils.createBeanListByTarget(list, AppLicenseDto.class);
			for (AppLicenseDto appLicenseDto : licList) {
				String host = "http://192.168.1.242";
				if (StringUtils.isNotBlank(appLicenseDto.getLicPic())) {
					String pic = host + appLicenseDto.getLicPic();
					appLicenseDto.setLicPic(pic);
				}
			}
			wrd.setLicense(licList);
		}

		return wrd;
	}

	@Override
	public List<WaresListDto> findWarseBySchoolId(String schoolId) {
		return waresInfoDao.findWarseBySchoolId(schoolId);
	}

}
