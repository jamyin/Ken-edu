package com.ssic.education.provider.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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
import com.ssic.educateion.common.utils.ProductClass;
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
import com.ssic.education.utils.jdbc.DataSourceHolderUtil;
import com.ssic.education.utils.poi.ParseExcelUtil;
import com.ssic.education.utils.util.BeanUtils;
import com.ssic.education.utils.util.PageData;
import com.ssic.education.utils.util.PropertiesUtils;
import com.ssic.education.utils.util.Tools;
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

	@RequestMapping("/importPage")
	public String importPage(HttpServletRequest request) {
		return "wares/warseImport";
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
			proWaresDto.setWaresTypeName(proWaresDto.getWaresTypeStr());
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
			j.setMsg("原料名称不能为空");
			j.setSuccess(false);
			return j;
		}

		if (pro.getAmountUnit() == null || pro.getAmountUnit().equals("")) {
			j.setSuccess(false);
			j.setMsg("原料数量单位不能为空");
			return j;
		}

		if (pro.getWaresType() == null || pro.getWaresType().equals("")) {
			j.setSuccess(false);
			j.setMsg("原料类型不能为空");
			return j;
		}

		DataSourceHolderUtil.setToMaster();
		SessionInfo info = (SessionInfo) request.getSession().getAttribute(
				ConfigUtil.SESSIONINFONAME);
		pro.setSupplierId(info.getSupplierId());
		pro.setCreator(info.getId());

		ProWares specManu = waresService.findProWarsByNameSpecManu(
				pro.getWaresName(), pro.getAmountUnit(), pro.getManufacturer(),
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
	 * 跳转到修改图片页面
	 * 
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/editImage")
	public String editImage(HttpServletRequest request, String id) {
		ProWaresDto proWaresDto=new ProWaresDto();
		proWaresDto.setId(id);
		ProLicense license = new ProLicense();
		license.setRelationId(id);
		license.setCerSource((short) 2);
		List<ProLicense> ProLicenseList = proLicenseServiceImpl
				.lookImage(license);
		List<ProWaresDto> wares = waresService.findWares(proWaresDto);
		String realPath = PropertiesUtils.getProperty("upload.look.url");
		String image = wares.get(0).getImage();
		if(StringUtils.isNotEmpty(image)){
			license.setLicPic(wares.get(0).getImage());
			license.setLicName("商品图片");
			ProLicenseList.add(license);
		}
		for (ProLicense proLicense : ProLicenseList) {

			proLicense.setLicPic(realPath + proLicense.getLicPic());
		}
		JSONArray jsonarray = JSONArray.fromObject(ProLicenseList);
	
		request.setAttribute("id", id);
		request.setAttribute("ProLicenseList", jsonarray.toString());
		
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
		j.setMsg("删除采购品成功");
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
		if (pro.getWaresName() == null || pro.getWaresName().equals("")) {
			json.setMsg("商品名称不能为空");
			json.setSuccess(false);
			return json;
		}
		

		
		if (pro.getWaresType() == null || pro.getWaresType().equals("")) {
			json.setSuccess(false);
			json.setMsg("商品类型不能为空");
			return json;
		}

		ProWares specManu = waresService.findProWarsByNameSpecManu(
				pro.getWaresName(), pro.getAmountUnit(), pro.getManufacturer(),
				pro.getSupplierId());
		if(specManu!=null&&!specManu.getId().equals(pro.getId())){
			json.setMsg("修改商品失败，数据重复");
			json.setSuccess(false);
			return json;
		}
		pro.setStat(1);

		pro.setUpdater(info.getId());
		ProWares proWares = new ProWares();
		BeanUtils.copyProperties(pro, proWares);
		proWares.setCreateTime(new Date());
		proWares.setLastUpdateTime(new Date());

		waresService.updateImsUsers(proWares);
		json.setMsg("修改信息成功");
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
			@RequestParam(value = "qtImgUrl") MultipartFile scImgUrl,
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

		SessionInfo info = (SessionInfo) request.getSession().getAttribute(
				ConfigUtil.SESSIONINFONAME);
		if (imageurl1 != null && imageurl1 != "") {
			ProWares proWares = new ProWares();
			proWares.setUpdater(info.getId());
			proWares.setId(id);
			proWares.setImage(imageurl1);
			proWares.setCreateTime(new Date());
			proWares.setStat(1);
			int i = waresService.updateImsUsers(proWares);
			if (i == 0) {
				proWares.setCreateTime(new Date());
				proWares.setStat(1);
				proWares.setUpdater(info.getId());
				waresService.updateImsUsers(proWares);
			}
		}
		if (imageurl2 != null && imageurl2 != "") {
			license.setLicName("检测检验报告");
			license.setRelationId(id);
			license.setCerSource((short) 2);
			license.setLicPic(imageurl2);
			license.setLastUpdateTime(new Date());

			license.setUpdater(info.getId());
			int i = proLicenseServiceImpl.alterImage(license);

			if (i == 0) {
				license.setLicName("检测检验报告");
				license.setLicPic(imageurl2);
				license.setRelationId(id);
				license.setStat(1);
				license.setLicType(7);
				license.setCreateTime(new Date());
				license.setLastUpdateTime(new Date());
				license.setCerSource((short) 2);
				String uuid = UUID.randomUUID().toString();
				license.setId(uuid);
				license.setCreator(info.getId());

				proLicenseServiceImpl.updateImage(license);
			}
		}
		if (imageurl3 != null && imageurl3 != "") {

			license.setLicName("其他");
			license.setRelationId(id);
			license.setCerSource((short) 0);
			license.setLicPic(imageurl3);
			license.setLastUpdateTime(new Date());
			license.setUpdater(info.getId());
			int i = proLicenseServiceImpl.alterImage(license);

			if (i == 0) {
				license.setLicName("其他");				
				license.setRelationId(id);				
				license.setCreateTime(new Date());			
				license.setStat(1);
				license.setLicPic(imageurl3);
				license.setCreateTime(new Date());
				license.setCerSource((short) 2);
				license.setLicType(12);
				String uuid = UUID.randomUUID().toString();
				license.setId(uuid);
				license.setCreator(info.getId());

				proLicenseServiceImpl.updateImage(license);
			}
		}

		json.setMsg("修改图片成功");
		json.setSuccess(true);
		return json;
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
			HttpServletRequest request, HttpServletResponse response) {
		SessionInfo info = (SessionInfo) request.getSession().getAttribute(
				ConfigUtil.SESSIONINFONAME);
		if (info == null) {
			return null;
		}
		proWaresDto.setSupplierId(info.getSupplierId());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.M.d");
		Date date = new Date();
		String filename = Tools.date2Str(date, "yyyyMMddHHmmss");
		HSSFSheet sheet;
		HSSFCell cell;
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ filename + ".xls");
		Workbook workbook = new HSSFWorkbook();
		sheet = (HSSFSheet) workbook.createSheet("原料");
		try {
			List<String> titles = new ArrayList<String>();
			titles.add("名称");
			titles.add("数量单位");
			titles.add("规格");
			titles.add("采购品分类");
			titles.add("生产企业");
//			titles.add("英文名");
//			titles.add("商品包装条码");
//			titles.add("产品编码");
			titles.add("保质期");
			titles.add("保质期单位");
			titles.add("产地");
			int len = titles.size();
			HSSFCellStyle headerStyle = (HSSFCellStyle) workbook
					.createCellStyle(); // 标题样式
			headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			headerStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			HSSFFont headerFont = (HSSFFont) workbook.createFont(); // 标题字体
			headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			headerFont.setFontHeightInPoints((short) 11);
			headerStyle.setFont(headerFont);
			short width = 20, height = 25 * 20;
			sheet.setDefaultColumnWidth(width);
			HSSFRow sheetRow = sheet.createRow(0);
			for (int i = 0; i < len; i++) { // 设置标题
				String title = titles.get(i);
				cell = sheetRow.createCell(i);
				cell.setCellStyle(headerStyle);
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell.setCellValue(title);
			}
			sheet.getRow(0).setHeight(height);
			HSSFCellStyle contentStyle = (HSSFCellStyle) workbook
					.createCellStyle(); // 内容样式
			contentStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			List<ProWaresDto> expList = waresService.findAllWares(proWaresDto,
					null);
			List<PageData> varList = new ArrayList<PageData>();
			if (!CollectionUtils.isEmpty(expList)) {
				for (int i = 0; i < expList.size(); i++) {
					PageData vpd = new PageData();
					vpd.put("var1", expList.get(i).getWaresName());
					vpd.put("var2", expList.get(i).getAmountUnit());
					vpd.put("var3", expList.get(i).getSpec());
					vpd.put("var4",
							ProductClass.getName(expList.get(i).getWaresType()));
					vpd.put("var5", expList.get(i).getManufacturer());
//					vpd.put("var5", expList.get(i).getEnName());
//					vpd.put("var6", expList.get(i).getBarCode());
//					vpd.put("var7", expList.get(i).getCustomCode());
					vpd.put("var6", expList.get(i).getShelfLife());
					vpd.put("var7", expList.get(i).getUnit());
					vpd.put("var8", expList.get(i).getPlace());
					varList.add(vpd);
				}
			}
			for (int i = 0; i < varList.size(); i++) {
				HSSFRow row = sheet.createRow(i + 1);
				PageData vpd = varList.get(i);
				for (int j = 0; j < len; j++) {
					String varstr = vpd.getString("var" + (j + 1)) != null ? vpd
							.getString("var" + (j + 1)) : "";
					cell = row.createCell(j);
					HSSFCellStyle cellStyle2 = (HSSFCellStyle) workbook
							.createCellStyle();
					HSSFDataFormat format = (HSSFDataFormat) workbook
							.createDataFormat();
					cellStyle2.setDataFormat(format.getFormat("@"));
					cell.setCellStyle(cellStyle2);
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setCellValue(varstr);

				}

			}
			OutputStream os = response.getOutputStream();
			workbook.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {

		}
		return null;
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
	public Json importExcel(@RequestParam("filename") MultipartFile file,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		Json j = new Json();
		SessionInfo info = (SessionInfo) request.getSession().getAttribute(
				ConfigUtil.SESSIONINFONAME);
		// 当前登录用户所属供应商的id
		String supplierId = info.getSupplierId();
		String errorMsg = null;
		// 转换excel到list
		List<ProWares> list = new ArrayList();
		Set<String> set=new HashSet();
		// 读取excel
		try (Workbook wb = WorkbookFactory.create(file.getInputStream());) {
			Sheet sheet = wb.getSheetAt(0);
			if (sheet == null) {
				return null;
			}

			Date now = new Date();
			for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
				if (errorMsg != null) {
					break;
				}
				ProWares dto = new ProWares();
				Row row = sheet.getRow(rowNum);
				for (int i = 0; i < row.getLastCellNum(); i++) {
					if (errorMsg != null) {
						break;
					}
					Cell cell = row.getCell(i);
					String value = ParseExcelUtil.getStringCellValue(cell);
					if (value != null) {
						value = value.trim();
					}
					if (i == 0) {
						if (StringUtils.isBlank(value)) {
							errorMsg = "第" + (rowNum + 1) + "行数据不正确，名称不能为空。";
							break;
						}
						// 产品名称
						dto.setWaresName(value);
					} else if (i == 1) {
						if (StringUtils.isBlank(value)) {
							errorMsg = "第" + (rowNum + 1) + "行数据不正确，数量单位不能为空。";
							break;
						}
						// 产品规格
						dto.setAmountUnit(value);
					}else if (i == 2) {
						// 产品规格
						dto.setSpec(value);
					} else if (i == 3) {
						if (StringUtils.isBlank(value)) {
							errorMsg = "第" + (rowNum + 1) + "行数据不正确，分类不能为空。";
							break;
						}
						// 采购品分类
						try {
							dto.setWaresType(ProductClass.fromName(value));
							if(dto.getWaresType()==null){
								errorMsg = "第" + (rowNum + 1) + "行数据不正确，分类不正确。";
								break;
							}
						} catch (Exception e) {
							errorMsg = "第" + (rowNum + 1) + "行数据不正确，分类不正确。";
							break;
						}
					} else if (i == 4) {
						// 生产企业
						if (StringUtils.isBlank(value)) {
							errorMsg = "第" + (rowNum + 1) + "行数据不正确，生产企业不能为空。";
							break;
						}
						dto.setManufacturer(value);
						// 检查这个商品是否存在，如果存在不导入
						ProWares pw = waresService.findProWarsByNameSpecManu(
								dto.getWaresName(), dto.getAmountUnit(),
								dto.getManufacturer(), supplierId);
						if (pw != null) {
							errorMsg = "第" + (rowNum + 1) + "行数据不正确，商品已存在。";
							break;
						}
						String mark=dto.getWaresName()+","+dto.getAmountUnit()+","+dto.getManufacturer();
						int m=set.size();
						set.add(mark);
						if(m==set.size()){
							errorMsg = "第" + (rowNum + 1) + "行数据不正确，商品重复。";
							break;
						}
//					} else if (i == 4 && StringUtils.isNotBlank(value)) {
//						// 英文名称
//						dto.setEnName(value);
//					} else if (i == 5 && StringUtils.isNotBlank(value)) {
//						// 商品包装条码
//						dto.setBarCode(value);
//					} else if (i == 6 && StringUtils.isNotBlank(value)) {
//						// 企业自定义编码
//						dto.setCustomCode(value);
					} else if (i == 5 && StringUtils.isNotBlank(value)) {
						// 保质期
						try {
							dto.setShelfLife(Integer.parseInt(value));
						} catch (Exception e) {
							errorMsg = "第" + (rowNum + 1) + "行数据不正确，保质期格式不正确。";
							break;
						}
					} else if (i == 6 ) {
						// 保质期单位
						if(dto.getShelfLife() != null){
							if(StringUtils.isBlank(value)){
								errorMsg = "第" + (rowNum + 1) + "行数据不正确，保质期不能为空。";
								break;
							}
							dto.setUnit(value);
						}else{
							if(StringUtils.isNotBlank(value)){
								dto.setShelfLife(0);
								dto.setUnit(value);
							}
						}
					} else if (i == 7 && StringUtils.isNotBlank(value)) {
						// 产地
						dto.setPlace(value);
					}
				}
				if (errorMsg != null) {
					break;
				}
				dto.setSupplierId(supplierId);
				dto.setWay(0);
				dto.setDishes(false);
				dto.setCreator(info.getId());
				dto.setCreateTime(now);
				dto.setUpdater(info.getId());
				dto.setLastUpdateTime(now);
				dto.setStat(1);
				list.add(dto);
			}
		} catch (EncryptedDocumentException | InvalidFormatException e) {
			errorMsg = "Excel文件格式不正确";
		}

		if (errorMsg != null) {
			// TODO 反馈用户错误信息
			j.setMsg(errorMsg);
			j.setSuccess(false);
			return j;
		} else {
			// 导入商品
			waresService.addProWares(list);
			j.setMsg("成功添加数据");
			j.setSuccess(true);
			return j;
		}

	}

}
