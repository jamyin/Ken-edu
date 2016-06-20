package com.ssic.education.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.education.app.dto.AppCanTeenDto;
import com.ssic.education.app.dto.MaterialSupplierDto;
import com.ssic.education.app.dto.SupplierLicDto;
import com.ssic.education.app.interceptor.AccessRequired;
import com.ssic.education.app.service.IAppSupplierService;
import com.ssic.education.handle.pojo.ProSupplier;
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
	private IAppSupplierService supplierService;

	/**
	 * findSupplierInfo：根据Id查询供应商详细信息
	 * 包含证书信息 以及采购品供应商
	 * @param supplier_id
	 * @return Response<SupplierLicDto>
	 * @author SeanYoung
	 * @date 2016年5月23日 下午4:24:30
	 */
	@RequestMapping("/findSupplierInfo/{id}")
	@AccessRequired
	public @ResponseBody Response<SupplierLicDto> findSupplierInfo(@PathVariable("id") String id, @RequestParam(required = false) String schoolId) {
		if (StringUtils.isEmpty(id)) {
			return new Response<SupplierLicDto>(DataStatus.HTTP_FAILE, "查询Id为空");
		}
		SupplierLicDto supplier = StringUtils.isNotBlank(schoolId) ? supplierService.findSupplierInfo(id, schoolId) : supplierService.findSupplierInfo(id);
		if (supplier != null) {
			return new Response<SupplierLicDto>(DataStatus.HTTP_SUCCESS, "查询成功！", supplier);
		}
		return new Response<SupplierLicDto>(DataStatus.HTTP_SUCCESS, "未查到相关记录！");
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
	public @ResponseBody Response<PageResult<MaterialSupplierDto>> findSupplierList(@PathVariable("id") String id, ProSupplier supplier, PageQuery query, @RequestParam(required = false) String schoolId) {
		if (StringUtils.isEmpty(id)) {
			return new Response<PageResult<MaterialSupplierDto>>(DataStatus.HTTP_FAILE, "查询Id为空");
		}
		PageResult<MaterialSupplierDto> PageResult = StringUtils.isNotBlank(schoolId) ? PageResult = this.supplierService.findListByIds(id, schoolId, supplier, query) : this.supplierService.findListByIds(id, supplier, query);
		if (PageResult != null) {
			return new Response<PageResult<MaterialSupplierDto>>(DataStatus.HTTP_SUCCESS, "查询成功！", PageResult);
		}
		return new Response<PageResult<MaterialSupplierDto>>(DataStatus.HTTP_SUCCESS, "未查到相关记录！");
	}

	/**
	 * 根据ID查询学校食堂信息
	 * @param id
	 * @return Response<AppCanTeenDto>
	 */
	@RequestMapping("/findCantenn/{id}")
	@AccessRequired
	public @ResponseBody Response<AppCanTeenDto> findCantennById(@PathVariable("id") String id) {
		AppCanTeenDto canTeenDto = this.supplierService.findCanteenByid(id);
		if (canTeenDto != null) {
			return new Response<AppCanTeenDto>(DataStatus.HTTP_SUCCESS, "查询成功！", canTeenDto);
		}
		return new Response<AppCanTeenDto>(DataStatus.HTTP_SUCCESS, "未查到相关记录！");
	}

}
