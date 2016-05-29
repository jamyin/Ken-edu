package com.ssic.education.provider.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ssic.educateion.common.dto.ImageInfoDto;
import com.ssic.educateion.common.dto.ProWaresDto;
import com.ssic.educateion.common.dto.SupplierDto;
import com.ssic.educateion.common.utils.PageHelperDto;
import com.ssic.education.handle.pojo.ProLicense;
import com.ssic.education.handle.pojo.ProWares;
import com.ssic.education.handle.service.ICreateImageService;
import com.ssic.education.handle.service.IProLicenseService;
import com.ssic.education.handle.service.ISupplierService;
import com.ssic.education.handle.service.IWaresService;
import com.ssic.education.provider.pageModel.DataGrid;
import com.ssic.education.provider.pageModel.Json;
import com.ssic.education.provider.pageModel.PageHelper;
import com.ssic.education.provider.pageModel.SessionInfo;
import com.ssic.education.provider.service.ICreatePhdtoService;
import com.ssic.education.provider.util.ConfigUtil;
import com.ssic.education.provider.util.ProductClass;
import com.ssic.education.utils.jdbc.DataSourceHolderUtil;
import com.ssic.education.utils.poi.ParseExcelUtil;
import com.ssic.education.utils.util.BeanUtils;
import com.ssic.education.utils.util.ObjectExcelView;
import com.ssic.education.utils.util.PageData;
import com.ssic.education.utils.util.PropertiesUtils;
import com.ssic.education.utils.util.UUIDGenerator;

@Controller
@RequestMapping("/waresController")
public class WaresController extends BaseController {
	@Autowired
	private IWaresService waresService;
	@Autowired
	private ICreatePhdtoService createPhdtoService;
	@Autowired
	private ICreateImageService createImageServiceImpl;

	@Autowired
	private IProLicenseService proLicenseServiceImpl;
	@Autowired
	private ISupplierService supplierService;

	@RequestMapping("/manager")
	public String manager(HttpServletRequest request) {
		/*
		 * String nginxPath = PropertiesUtils.getProperty("nginx.url");
		 * request.setAttribute("nginxPath", nginxPath);
		 */

		return "wares/warseList";
	}

	/**
	 * 查询原料详情
	 * 
	 * @param waresDto
	 * @param ph
	 * @return gao
	 */
	@RequestMapping("/dataGrid")
	@ResponseBody
	public DataGrid dataGrid(ProWaresDto waresDto, PageHelper ph,
			HttpServletRequest request) {

		SessionInfo info = (SessionInfo) request.getSession().getAttribute(
				ConfigUtil.SESSIONINFONAME);
		waresDto.setSupplierId(info.getSupplierId());

		DataGrid dataGrid = new DataGrid();
		PageHelperDto phdto = new PageHelperDto();
		phdto.setOrder(ph.getOrder());
		phdto.setPage(ph.getPage());
		phdto.setRows(ph.getRows());
		phdto.setSort(ph.getSort());
		phdto.setBeginRow((ph.getPage() - 1) * ph.getRows());

		int count = waresService.findAllWaresCount(waresDto);
		List<ProWaresDto> pdtoList = waresService.findAllWares(waresDto, phdto);
		for (ProWaresDto proWaresDto : pdtoList) {

			String name = ProductClass.getName(proWaresDto.getWaresType());
			proWaresDto.setWaresTypeName(name);
		}
		// 查询数量
		dataGrid.setRows(pdtoList);
		dataGrid.setTotal((long) count);
		return dataGrid;
	}

	/**
	 * 添加商品
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/addWares")
	public String addWares(HttpServletRequest request) {
		request.setAttribute("id", UUIDGenerator.getUUID());
		return "wares/addWares";
	}

	/**
	 * 数据合法判断并插入数据库
	 * 
	 * @param user
	 * @param userId
	 * @param isExistManager
	 * @return
	 */
	@RequestMapping("/insertWares")
	@ResponseBody
	//
	public Json insertWares(ProWaresDto pro, HttpServletRequest request) {
		Json j = new Json();
		if (pro.getWaresName() == null || pro.getWaresName().equals("")) {
			j.setMsg("商品名称不能为空");
			j.setSuccess(false);
			return j;
		}

		if (pro.getSpec() == null || pro.getSpec().equals("")) {
			j.setSuccess(false);
			j.setMsg("商品规格不能为空");
			return j;
		}

		if (pro.getWaresType() == null || pro.getWaresType().equals("")) {
			j.setSuccess(false);
			j.setMsg("商品类型不能为空");
			return j;
		}

		DataSourceHolderUtil.setToMaster();
		SessionInfo info = (SessionInfo) request.getSession().getAttribute(
				ConfigUtil.SESSIONINFONAME);
		pro.setSupplierId(info.getSupplierId());

		ProWares specManu = waresService.findProWarsByNameSpecManu(
				pro.getWaresName(), pro.getSpec(), pro.getManufacturer(),
				pro.getSupplierId());
		if (specManu == null || specManu.equals("")) {
			waresService.insertWares(pro);
			j.setMsg("新增商品成功");
			j.setSuccess(true);
			return j;
		}
		j.setMsg("新增商品失败，数据重复");
		j.setSuccess(false);
		return j;

	}

	/**
	 * 修改商品数据
	 */
	@RequestMapping("/editWares")
	public String editWares(HttpServletRequest request, String id) {
		ProWaresDto proWaresDto = new ProWaresDto();
		proWaresDto.setId(id);
		List<ProWaresDto> list = waresService.findWares(proWaresDto);
		if (list != null && list.size() > 0) {
			proWaresDto = list.get(0);
		}
		request.setAttribute("wdto", proWaresDto);
		request.setAttribute("id", id);
		return "wares/editWares";
	}

	/**
	 * 跳转到上传图片页面
	 * 
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/updateImage")
	public String updateImage(HttpServletRequest request, String id) {
		ProWaresDto proWaresDto = new ProWaresDto();
		proWaresDto.setId(id);
		List<ProWaresDto> list = waresService.findWares(proWaresDto);
		if (list != null && list.size() > 0) {
			proWaresDto = list.get(0);
		}
		request.setAttribute("wdto", proWaresDto);
		request.setAttribute("id", id);
		return "wares/updateImage";
	}

	/**
	 * 跳转到修改图片页面
	 * 
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/editImage")
	public String editImage(HttpServletRequest request, String id) {

		request.setAttribute("id", id);
		return "wares/editImage";
	}

	/**
	 * 删除商品数据
	 * 
	 * @param waresDto
	 * @return
	 */
	@RequestMapping("deleteWares")
	@ResponseBody
	public Json deleteWares(ProWaresDto waresDto) {
		Json j = new Json();
		DataSourceHolderUtil.setToMaster();
		waresService.deleteWares(waresDto);
		j.setMsg("删除用户成功");
		j.setSuccess(true);
		return j;
	}

	/**
	 * 修改商品信息
	 * 
	 * @param waresDto
	 * @return
	 */
	@RequestMapping("/updateWares")
	@ResponseBody
	public Json updateWares(ProWaresDto pro, HttpServletRequest request) {
		Json json = new Json();
		SessionInfo info = (SessionInfo) request.getSession().getAttribute(
				ConfigUtil.SESSIONINFONAME);
		pro.setSupplierId(info.getSupplierId());
		pro.setStat(1);
		ProWares proWares = new ProWares();
		BeanUtils.copyProperties(pro, proWares);
		ProWares specManu = waresService.findProWarsByNameSpecManu(
				pro.getWaresName(), pro.getSpec(), pro.getManufacturer(),
				pro.getSupplierId());
		proWares.setCreateTime(new Date());
		proWares.setLastUpdateTime(new Date());
		if (specManu == null || specManu.equals("")) {
			waresService.updateImsUsers(proWares);
			json.setMsg("修改信息成功");
			json.setSuccess(true);
			return json;
		}

		json.setMsg("修改信息失败，数据重复");
		json.setSuccess(true);
		return json;
	}

	/**
	 * 上传图片
	 */
	@RequestMapping("/insterImage")
	@ResponseBody
	public Json updateImage(String id,
			@RequestParam(value = "spImgUrl") MultipartFile spImgUrl,
			@RequestParam(value = "jcImgUrl") MultipartFile jcImgUrl,
			@RequestParam(value = "scImgUrl") MultipartFile scImgUrl,
			ImageInfoDto image, HttpServletRequest request,
			HttpServletResponse response) {
		Json json = new Json();
		ProLicense license = new ProLicense();
		Map<String, Object> map1 = createImageServiceImpl.createImage(image,
				spImgUrl, request, response);
		Map<String, Object> map2 = createImageServiceImpl.createImage(image,
				jcImgUrl, request, response);
		Map<String, Object> map3 = createImageServiceImpl.createImage(image,
				scImgUrl, request, response);
		// 如果已经有图片则更新image_url
		String imageurl1 = (String) map1.get("image_url");
		String imageurl2 = (String) map2.get("image_url");
		String imageurl3 = (String) map3.get("image_url");
		List<String> list = new ArrayList<String>();
		if (imageurl1 != null && imageurl1 != "") {
			license.setLicName("商品图片");
			license.setLicPic(imageurl1);
			license.setRelationId(id);
			license.setStat(1);
			license.setCreateTime(new Date());
			license.setLastUpdateTime(new Date());
			license.setCerSource((short) 2);
			String uuid = UUID.randomUUID().toString();
			license.setId(uuid);
			proLicenseServiceImpl.updateImage(license);
		}
		if (imageurl2 != null && imageurl2 != "") {
			license.setLicName("检测检验报告");
			license.setLicPic(imageurl2);
			license.setRelationId(id);
			license.setStat(1);
			license.setCreateTime(new Date());
			license.setLastUpdateTime(new Date());
			license.setCerSource((short) 2);
			String uuid = UUID.randomUUID().toString();
			license.setId(uuid);
			proLicenseServiceImpl.updateImage(license);
		}
		if (imageurl3 != null && imageurl3 != "") {
			license.setLicName("生产许可证");
			license.setLicPic(imageurl3);
			license.setRelationId(id);
			license.setStat(1);
			license.setCreateTime(new Date());
			license.setLastUpdateTime(new Date());
			license.setCerSource((short) 2);
			String uuid = UUID.randomUUID().toString();
			license.setId(uuid);
			proLicenseServiceImpl.updateImage(license);
		}

		json.setMsg("上传图片成功");
		json.setSuccess(true);
		return json;
	}

	/**
	 * 修改图片
	 */
	@RequestMapping("/alterImage")
	@ResponseBody
	public Json alterImage(String id,
			@RequestParam(value = "spImgUrl") MultipartFile spImgUrl,
			@RequestParam(value = "jcImgUrl") MultipartFile jcImgUrl,
			@RequestParam(value = "scImgUrl") MultipartFile scImgUrl,
			ImageInfoDto image, HttpServletRequest request,
			HttpServletResponse response) {
		Json json = new Json();
		ProLicense license = new ProLicense();
		Map<String, Object> map1 = createImageServiceImpl.createImage(image,
				spImgUrl, request, response);
		Map<String, Object> map2 = createImageServiceImpl.createImage(image,
				jcImgUrl, request, response);
		Map<String, Object> map3 = createImageServiceImpl.createImage(image,
				scImgUrl, request, response);
		// 如果已经有图片则更新image_url
		String imageurl1 = (String) map1.get("image_url");
		String imageurl2 = (String) map2.get("image_url");
		String imageurl3 = (String) map3.get("image_url");
		List<String> list = new ArrayList<String>();
		if (imageurl1 != null && imageurl1 != "") {
			license.setLicName("商品图片");
			license.setRelationId(id);
			license.setCerSource((short) 2);
			license.setLicPic(imageurl1);
			proLicenseServiceImpl.alterImage(license);
		}
		if (imageurl2 != null && imageurl2 != "") {
			license.setLicName("检测检验报告");
			license.setRelationId(id);
			license.setCerSource((short) 2);
			license.setLicPic(imageurl1);
			proLicenseServiceImpl.alterImage(license);
		}
		if (imageurl3 != null && imageurl3 != "") {
			license.setLicName("生产许可证");
			license.setRelationId(id);
			license.setCerSource((short) 2);
			license.setLicPic(imageurl3);
			proLicenseServiceImpl.alterImage(license);
		}

		json.setMsg("修改图片成功");
		json.setSuccess(true);
		return json;
	}

	/**
	 * 查看图片
	 */
	@RequestMapping("/lookImage")
	public String lookImage(HttpServletRequest request, String id) {
		ProLicense license = new ProLicense();
		license.setRelationId(id);
		license.setCerSource((short) 2);
		List<ProLicense> ProLicenseList = proLicenseServiceImpl
				.lookImage(license);
		String realPath = PropertiesUtils.getProperty("upload.look.url");
		for (ProLicense proLicense : ProLicenseList) {

			proLicense.setLicPic(realPath + proLicense.getLicPic());
		}
		request.setAttribute("ProLicenseList", ProLicenseList);
		return "wares/lookImage";
	}

	/**
	 * 查看该商品供应商
	 * 
	 * @param request
	 * @param id
	 *            商品ID
	 * @return
	 */
	@RequestMapping("/lookSupplier")
	public String lookSupplier(HttpServletRequest request, String id) {
		ProWaresDto dto = new ProWaresDto();
		dto.setId(id);
		List<SupplierDto> SupplierDtoList = waresService.lookSupplier(dto);
		request.setAttribute("SupplierDtoList", SupplierDtoList);
		return "wares/lookSupplier";
	}

	@RequestMapping(value = "/excel")
	@ResponseBody
	public ModelAndView exportExcel(ProWaresDto proWaresDto,
			HttpServletRequest request) {
		SessionInfo info = (SessionInfo) request.getSession().getAttribute(
				ConfigUtil.SESSIONINFONAME);
		proWaresDto.setSupplierId(info.getSupplierId());
		PageHelperDto phdto = new PageHelperDto();
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			List<String> titles = new ArrayList<String>();
			titles.add("名称");
			titles.add("规格");
			titles.add("生产企业");
			titles.add("保质期");
			titles.add("保质期单位");
			titles.add("商品分类");
			titles.add("企业自定义编码");
			titles.add("商品条形码");
			titles.add("英文名");
			titles.add("产地");
			dataMap.put("titles", titles);

			List<ProWaresDto> expList = waresService.findAllWares(proWaresDto,
					phdto);

			List<PageData> varList = new ArrayList<PageData>();
			if (!CollectionUtils.isEmpty(expList)) {
				for (int i = 0; i < expList.size(); i++) {
					PageData vpd = new PageData();
					vpd.put("var1", expList.get(i).getWaresName());
					vpd.put("var2", expList.get(i).getSpec());
					vpd.put("var3", expList.get(i).getManufacturer());
					vpd.put("var4", expList.get(i).getShelfLife());
					vpd.put("var5", expList.get(i).getUnit());
					vpd.put("var6",
							ProductClass.getName(expList.get(i).getWaresType()));
					vpd.put("var7", expList.get(i).getCustomCode());
					vpd.put("var8", expList.get(i).getBarCode());
					vpd.put("var9", expList.get(i).getEnName());
					vpd.put("var10", expList.get(i).getPlace());
					varList.add(vpd);
				}
			}
			dataMap.put("varList", varList);
			ObjectExcelView erv = new ObjectExcelView(); // 执行excel操作

			mv = new ModelAndView(erv, dataMap);

		} catch (Exception e) {

		}
		return mv;
	}

	@RequestMapping(value = "/import")
	@ResponseBody
	/**
	 * 采购品导入excel
	 * 
	 * @param file
	 * @param request
	 * @param response
	 * @return
	 * @author zhangjiwei
	 * @since 2016.5.21
	 */
	public ModelAndView importExcel(
			@RequestParam("filename") MultipartFile file,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		SessionInfo info = (SessionInfo) request.getSession().getAttribute(
				ConfigUtil.SESSIONINFONAME);
		// 当前登录用户所属供应商的id
		String supplierId = info.getSupplierId();
		// 读取excel
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(file.getInputStream());
		HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
		if (hssfSheet == null) {
			return null;
		}

		// 转换excel到list
		List<ProWares> list = new ArrayList();
		String errorMsg = null;
		Date now = new Date();
		for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
			if (errorMsg != null) {
				break;
			}
			ProWares dto = new ProWares();
			HSSFRow hssfRow = hssfSheet.getRow(rowNum);
			for (int i = 0; i < hssfRow.getLastCellNum(); i++) {
				if (errorMsg != null) {
					break;
				}
				HSSFCell cell = hssfRow.getCell(i);
				String value = ParseExcelUtil.getStringCellValue(cell);
				if (value != null) {
					value = value.trim();
				}
				if (i == 0) {
					// 产品名称
					dto.setWaresName(value);
				} else if (i == 1) {
					// 产品规格
					dto.setSpec(value);
				} else if (i == 2) {
					// 采购品分类
					dto.setWaresType(ProductClass.fromName(value));
				} else if (i == 3) {
					// 生产企业
					dto.setManufacturer(value);
					// 检查这个商品是否存在，如果存在不导入
					ProWares pw = waresService.findProWarsByNameSpecManu(
							dto.getWaresName(), dto.getSpec(),
							dto.getManufacturer(), supplierId);
					if (pw != null) {
						errorMsg = "第" + (i + 1) + "行数据不正确，商品已存在。";
						break;
					}
				} else if (i == 4) {
					// 英文名称
					dto.setEnName(value);
				} else if (i == 5) {
					// 商品包装条码
					dto.setBarCode(value);
				} else if (i == 6) {
					// 企业自定义编码
					dto.setCustomCode(value);
				} else if (i == 7) {
					// 保质期
					if (value != null) {
						dto.setShelfLife(Integer.parseInt(value));
					}
				} else if (i == 8 && dto.getShelfLife() != null) {
					// 保质期单位
					dto.setUnit(value);
				} else if (i == 9) {
					// 产地
					dto.setPlace(value);
				}
			}
			if (errorMsg != null) {
				break;
			}
			// TODO 检查参数
			if (dto.getWaresName() == null || dto.getSpec() == null
					|| dto.getWaresType() == null) {
				continue;
			}
			dto.setSupplierId(supplierId);
			dto.setWay(0);
			dto.setCreateTime(now);
			dto.setLastUpdateTime(now);
			dto.setStat(1);
			list.add(dto);
		}

		if (errorMsg != null) {
			// TODO 反馈用户错误信息
		} else {
			// 导入商品
			waresService.addProWares(list);
		}

		return null;
	}
}
