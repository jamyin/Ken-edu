package com.ssic.education.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.educateion.common.dto.ProSupplierDto;
import com.ssic.educateion.common.dto.ProWaresDto;
import com.ssic.education.app.dto.AppCanTeenDto;
import com.ssic.education.app.dto.MaterialSupplierDto;
import com.ssic.education.app.dto.SupplierLicDto;
import com.ssic.education.app.interceptor.AccessRequired;
import com.ssic.education.app.service.ISupplierService;
import com.ssic.education.handle.pojo.ProSupplier;
import com.ssic.education.handle.service.ProWaresService;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import com.ssic.education.utils.model.Response;
import com.ssic.education.utils.util.StringUtils;

/**
* @ClassName: SupplierController
* @Description: 供应商controller
* @author Ken Yin
* @date 2016年5月12日 下午1:50:46
*
*/
@Controller
@RequestMapping(value = "/supplier")
public class AppSupplierController {

	@Autowired
	private ISupplierService supplierService;

	@Autowired
	private ProWaresService proWaresService;

	/**
	 * @Title: findSupplierList
	 * @Description: 查询所有供应商-带分页
	 * @author Ken Yin  
	 * @date 2016年5月12日 上午11:27:34
	 * @return Response<EduTaskDto>    返回类型
	 */
	@RequestMapping("/findSupplierList")
	@AccessRequired
	public @ResponseBody Response<PageResult<ProSupplierDto>> findSupplierList(ProSupplierDto proSupplierDto, PageQuery query) {
		Response<PageResult<ProSupplierDto>> result = new Response<PageResult<ProSupplierDto>>();
		PageResult<ProSupplierDto> supplierList = supplierService.findSupplierList(proSupplierDto, query);
		if (supplierList.getResults() != null && supplierList.getResults().size() > 0) {
			result.setStatus(DataStatus.HTTP_SUCCESS);
			result.setMessage("查询成功！");
			result.setData(supplierList);
			return result;
		} else {
			result.setStatus(DataStatus.HTTP_SUCCESS);
			result.setMessage("未查到相关记录！");
			return result;
		}
	}

	/**
	* @Title: findSupplierDetail
	* @Description: 根据Id查询供应商详细信息
	* @author Ken Yin  
	* @date 2016年5月12日 下午5:10:49
	* @return Response<ProSupplierDto>    返回类型
	 */
	@RequestMapping("/findSupplierDetail/{id}")
	@AccessRequired
	public @ResponseBody Response<ProSupplierDto> findSupplierDetail(@PathVariable("id") String id) {
		Response<ProSupplierDto> result = new Response<ProSupplierDto>();
		if (StringUtils.isEmpty(id)) {
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("查询Id为空");
			return result;
		}
		ProSupplierDto supplier = supplierService.findSupplierDetail(id);
		if (supplier != null) {
			result.setStatus(DataStatus.HTTP_SUCCESS);
			result.setMessage("查询成功！");
			result.setData(supplier);
			return result;
		}
		result.setStatus(DataStatus.HTTP_SUCCESS);
		result.setMessage("未查到相关记录！");
		return result;
	}

	/**
	 * @Title: findSupplierWares
	 * @Description: 根据供应商Id查询对应的商品和原料(dishes:false-原料,true-成品)
	 * @author Ken Yin  
	 * @date 2016年5月12日 下午5:10:49
	 * @return Response<ProSupplierDto>    返回类型
	  */
	@RequestMapping("/findSupplierWares")
	@AccessRequired
	public @ResponseBody Response<PageResult<ProWaresDto>> findSupplierWares(ProWaresDto dto, PageQuery query) {
		Response<PageResult<ProWaresDto>> result = new Response<PageResult<ProWaresDto>>();
		if (dto.getId() == null) {
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("查询Id为空");
			return result;
		}
		PageResult<ProWaresDto> wares = proWaresService.queryWaresByParams(dto, query);
		if (wares != null && wares.getResults().size() > 0) {
			result.setStatus(DataStatus.HTTP_SUCCESS);
			result.setMessage("查询成功！");
			result.setData(wares);
			return result;
		}
		result.setStatus(DataStatus.HTTP_SUCCESS);
		result.setMessage("未查到相关记录！");
		return result;
	}

	/**
	 * 
	 * findSupplierInfo：根据Id查询供应商详细信息
	 * 包含证书信息 以及采购品供应商
	 * @param supplier_id
	 * @return
	 * @exception	
	 * @author SeanYoung
	 * @date 2016年5月23日 下午4:24:30
	 */
	@RequestMapping("/findSupplierInfo/{id}")
	@AccessRequired
	public @ResponseBody Response<SupplierLicDto> findSupplierInfo(@PathVariable("id") String id) {
		Response<SupplierLicDto> result = new Response<SupplierLicDto>();
		if (StringUtils.isEmpty(id)) {
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("查询Id为空");
			return result;
		}
		SupplierLicDto supplier = supplierService.findSupplierInfo(id);
		if (supplier != null) {
			result.setStatus(DataStatus.HTTP_SUCCESS);
			result.setMessage("查询成功！");
			result.setData(supplier);
			return result;
		}
		result.setStatus(DataStatus.HTTP_SUCCESS);
		result.setMessage("未查到相关记录！");
		return result;
	}

	/**
	 * 
	 * findSupplierInfo：供应商列表（根据团餐公司id查询）
	 * @param supplier_id
	 * @return
	 * @exception	
	 * @author SeanYoung
	 * @date 2016年5月23日 下午4:24:30
	 */
	@RequestMapping("/findSupplierList/{id}")
	@AccessRequired
	public @ResponseBody Response<PageResult<MaterialSupplierDto>> findSupplierList(@PathVariable("id") String id, ProSupplier supplier, PageQuery query) {
		Response<PageResult<MaterialSupplierDto>> result = new Response<PageResult<MaterialSupplierDto>>();
		if (StringUtils.isEmpty(id)) {
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("查询Id为空");
			return result;
		}
		PageResult<MaterialSupplierDto> PageResult = this.supplierService.findListByIds(id, supplier, query);
		if (PageResult != null) {
			result.setStatus(DataStatus.HTTP_SUCCESS);
			result.setMessage("查询成功！");
			result.setData(PageResult);
			return result;
		}
		result.setStatus(DataStatus.HTTP_SUCCESS);
		result.setMessage("未查到相关记录！");
		return result;
	}

	/**
	 * 根据ID查询食堂信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/findCantenn/{id}")
	@AccessRequired
	public @ResponseBody Response<AppCanTeenDto> findCantennById(@PathVariable("id") String id) {
		Response<AppCanTeenDto> result = new Response<AppCanTeenDto>();
		result.setData(this.supplierService.findCanteenByid(id));
		return result;
	}
}