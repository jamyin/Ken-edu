package com.ssic.education.provider.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

import com.ssic.education.common.pojo.ProLedger;
import com.ssic.education.common.pojo.ProSupplier;
import com.ssic.education.common.pojo.ProWares;
import com.ssic.education.common.provider.dto.LedgerDto;
import com.ssic.education.common.provider.service.ILedgerService;
import com.ssic.education.common.provider.service.ISupplierService;
import com.ssic.education.common.provider.utils.DataGrid;
import com.ssic.education.common.provider.utils.PageHelper;
import com.ssic.education.common.service.IEduSchoolSupplierService;
import com.ssic.education.provider.dto.TImsUsersDto;
import com.ssic.education.provider.pageModel.Json;
import com.ssic.education.provider.pageModel.LedgerModel;
import com.ssic.education.provider.pageModel.SessionInfo;
import com.ssic.education.provider.service.IWaresService;
import com.ssic.education.provider.service.UserServiceI;
import com.ssic.education.provider.util.ConfigUtil;
import com.ssic.education.utils.poi.ParseExcelUtil;

/**
 * 
 * Description: 配货管理控制器类
 * 
 * Company: 上海天坊信息科技有限公司
 * 
 * @author minghai_chen
 * @date 2016年5月18日 下午2:2:53
 * @version 1.0
 */
@Controller
@RequestMapping("/ledgerController")
public class LedgerController {

	@Autowired
	private ISupplierService supplierService;

	@Autowired
	private IWaresService waresService;

	@Autowired
	private ILedgerService ledgerService;

	@Autowired
	private IEduSchoolSupplierService eduSchoolSupplierService;

	@Autowired
	private UserServiceI userService;

	@RequestMapping("/manager")
	public String manager(HttpServletRequest request) {
		return "ledger/ledgerList";
	}

	@RequestMapping("/dataGrid")
	@ResponseBody
	public DataGrid dataGrid(LedgerDto ld, HttpSession session, PageHelper ph) {
		TImsUsersDto user = (TImsUsersDto) session.getAttribute("user");
		if (user == null) {
			return null;
		}
		ld.setSourceId(user.getSourceId());
		DataGrid dataGrid = new DataGrid();
		return ledgerService.findAllLedger(ld, ph);
	}

	@RequestMapping("/addLedger")
	public String addLedger(HttpServletRequest request, HttpSession session) {
		TImsUsersDto user = (TImsUsersDto) session.getAttribute("user");
		if (user == null) {
			return null;
		}

		List<TImsUsersDto> driver = userService.findAllDriver(user
				.getSourceId());
		request.setAttribute("Driver", driver);
		return "ledger/ledgerAdd";
	}

	@RequestMapping("/saveLedger")
	@ResponseBody
	public Json saveLedger(LedgerModel lm, HttpSession session) {
		Json j = new Json();
		TImsUsersDto user = (TImsUsersDto) session.getAttribute("user");
		String sourceId = user.getSourceId();
		if (sourceId == null) {
			j.setMsg("尚未登录");
			j.setSuccess(false);
			return j;
		}
		List<LedgerDto> ledgers = lm.getLedger();
		ledgers.get(0).setSourceId(sourceId);
		Date actionDate = ledgers.get(0).getActionDate();
		if (actionDate == null) {
			j.setMsg("配送日期不能为空");
			j.setSuccess(false);
			return j;
		}
		String receiverId = eduSchoolSupplierService
				.findSchoolIdByReceiverId(ledgers.get(0));
		if (receiverId == null) {
			j.setMsg("不存在的配送点");
			j.setSuccess(false);
			return j;
		}
		for (LedgerDto ledger : ledgers) {
			ledger.setActionDate(actionDate);
			ledger.setReceiverId(receiverId);
			ledger.setSourceId(sourceId);
			ledger.setWaresId(waresService.findWaresIdBySupplierId(ledger));
			if (ledger.getWaresId() == null) {
				j.setMsg(ledger.getName() + "是错误的采购品");
				j.setSuccess(false);
				return j;
			}
			int num = ledger.getQuantity();
			if (num == 0) {
				j.setMsg(ledger.getName() + "错误的采购数量");
				j.setSuccess(false);
				return j;
			}
			String spce = ledger.getSpce();
			if (num == 0) {
				j.setMsg(ledger.getName() + "的采购规格不能为空");
				j.setSuccess(false);
				return j;
			}
			String supplierId = supplierService
					.findSupplierIdBySourceId(ledger);
			ledger.setSupplierId(supplierId);
			if (ledger.getSupplierId() == null) {
				ledger.setSupplierName(null);
			}
		}
		ledgerService.saveLedger(ledgers);
		j = new Json();
		j.setMsg("添加供应商成功");
		j.setSuccess(true);
		return j;
	}

	@RequestMapping("/editPage")
	public String editPage(String wareBatchNo, HttpServletRequest request,
			HttpSession session) {
		TImsUsersDto user = (TImsUsersDto) session.getAttribute("user");
		if (user == null) {
			return null;
		}
		List<LedgerDto> list = ledgerService.findLedgerById(user.getSourceId(),
				wareBatchNo);
		request.setAttribute("LedgerList", list);
		System.out.println(list.get(0));
		return "ledger/ledgerEdit";
	}

	@RequestMapping(value = "/ledgerEdit")
	@ResponseBody
	public Json updataLedger(LedgerModel lm, HttpSession session) {
		Json j = new Json();
		TImsUsersDto user = (TImsUsersDto) session.getAttribute("user");
		String sourceId = user.getSourceId();
		if (sourceId == null) {
			j.setMsg("尚未登录");
			j.setSuccess(false);
			return j;
		}
		// String receiverId=
		// List<LedgerDto> ledgers = lm.getLedger();
		// for (LedgerDto ledger : ledgers) {
		// ledger.setSourceId(sourceId);
		// ledger.setWaresId(waresService.findWaresIdBySupplierId(ledger));
		// }
		// ledgerService.updataLedger(ledgers);
		j = new Json();
		j.setMsg("添加供应商成功");
		j.setSuccess(true);
		return j;
	}

	@RequestMapping("/deleteLedger")
	@ResponseBody
	public Json deleteLedger(String wareBatchNo, HttpSession session) {
		Json j = new Json();
		TImsUsersDto user = (TImsUsersDto) session.getAttribute("user");
		if (user == null) {
			j.setMsg("供应商不能为空");
			j.setSuccess(false);
			return j;
		}
		int r = ledgerService.deleteLedger(user.getSourceId(), wareBatchNo);
		if (r == 0) {
			j.setMsg("删除供应商失败");
			j.setSuccess(false);
			return j;
		}
		j.setMsg("删除供应商成功");
		j.setSuccess(true);
		return j;
	}

	@RequestMapping(value = "/import")
	@ResponseBody
	/**
	 * 配货导入excel
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
			throws IOException, ParseException {
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
		List<ProLedger> list = new ArrayList();
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/d");
		DecimalFormat df2 = new DecimalFormat("#.##");
		for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
			ProLedger dto = new ProLedger();
			HSSFRow hssfRow = hssfSheet.getRow(rowNum);
			String name = null;
			String spec = null;
			String manufacturer = null;

			String supplierCode = null;
			String supplierName = null;

			for (int i = 0; i < hssfRow.getLastCellNum(); i++) {
				HSSFCell cell = hssfRow.getCell(i);
				String value = ParseExcelUtil.getStringCellValue(cell);

				if (i == 0) {
					// 进货日期
					dto.setActionDate(sdf.parse(value));
				} else if (i == 1) {
					// 名称
					name = value;
				} else if (i == 2) {
					// 规格
					spec = value;
				} else if (i == 3) {
					// 生产企业
					manufacturer = value;

					// 查找商品
					ProWares pw = waresService.findProWarsByNameSpecManu(name,
							spec, manufacturer, supplierId);
					if (pw == null) {
						dto = null;
						break;
					} else {
						dto.setWaresId(pw.getId());
					}
				} else if (i == 4) {
					// 数量
					// TODO need yanggang regenerate pojo
					// dto.setUnit(df2.parse(value));
				} else if (i == 5) {
					// 生产日期
					dto.setProductionDate(sdf.parse(value));
				} else if (i == 6) {
					// 生产批号
					dto.setBatchNo(value);
				} else if (i == 7) {
					// 供应商编码
					supplierCode = value;
				} else if (i == 8) {
					// 供应商名称
					supplierName = value;

					ProSupplier ps = null;
					if (supplierCode != null) {
						ps = supplierService.getSupplierByCode(supplierCode,
								supplierId);
					} else if (supplierName != null) {
						ps = supplierService.getSupplierByName(supplierName,
								supplierId);
					}

					if (ps == null) {
						// TODO 报错
						dto = null;
						break;
					}
					dto.setSupplierId(ps.getId());
					dto.setSupplierCode(supplierCode);
					dto.setSupplierName(ps.getSupplierName());
				} else if (i == 9) {
					// 追溯码
					dto.setTraceCode(value);
				}
			}
			if (dto != null) {
				// TODO 检查参数
				dto.setSupplierId(supplierId);
				dto.setCreateTime(now);
				dto.setLastUpdateTime(now);
				dto.setStat(1);
				list.add(dto);
			}
		}
		// TODO 导入批次

		// TODO 反馈用户错误信息
		return null;
	}
}
