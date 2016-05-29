package com.ssic.education.provider.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
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

import com.ssic.educateion.common.dto.LedgerDto;
import com.ssic.educateion.common.dto.ProWaresDto;
import com.ssic.educateion.common.utils.DataGrid;
import com.ssic.educateion.common.utils.PageHelper;
import com.ssic.education.handle.pojo.ProLedger;
import com.ssic.education.handle.pojo.ProLedgerMaster;
import com.ssic.education.handle.pojo.ProSupplier;
import com.ssic.education.handle.pojo.ProWares;
import com.ssic.education.handle.service.IEduSchoolSupplierService;
import com.ssic.education.handle.service.ILedgerService;
import com.ssic.education.handle.service.ISupplierService;
import com.ssic.education.handle.service.IWaresService;
import com.ssic.education.provider.dto.TImsUsersDto;
import com.ssic.education.provider.pageModel.Json;
import com.ssic.education.provider.pageModel.LedgerModel;
import com.ssic.education.provider.pageModel.SessionInfo;
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
		String receiverId = eduSchoolSupplierService.findSchoolIdByReceiverId(
				ledgers.get(0).getReceiverName(), ledgers.get(0).getSourceId());
		if (receiverId == null) {
			j.setMsg("不存在的配送点");
			j.setSuccess(false);
			return j;
		}
		int w = ledgerService.findWareBatchNo(ledgers.get(0));
		if (w != 0) {
			j.setMsg("已存在的配送号");
			j.setSuccess(false);
			return j;
		}
		int i = 0;
		String str = "";
		for (LedgerDto ledger : ledgers) {
			if (ledger.getMark() != 1) {
				str += i + ",";
				continue;
			}
			if (ledger.getName() == null) {
				j.setMsg("采购品不能为空");
				j.setSuccess(false);
				return j;
			}
			ledger.setWareBatchNo(ledgers.get(0).getWareBatchNo());
			ledger.setActionDate(actionDate);
			ledger.setReceiverId(receiverId);
			ledger.setSourceId(sourceId);
			ProWaresDto warerDto = waresService.findWaresBySupplierId(ledger);
			if (warerDto == null) {
				j.setMsg(ledger.getName() + "不存在的采购品");
				j.setSuccess(false);
				return j;
			}
			ledger.setWaresId(warerDto.getId());
			if (ledger.getProductionDate() != null) {
				if (!ledgers.get(0).getActionDate()
						.after(ledger.getProductionDate())) {
					j.setMsg(ledger.getName() + "错误的进货日期或生产日期");
					j.setSuccess(false);
					return j;
				}
			}
			if (ledger.getWaresId() == null) {
				j.setMsg(ledger.getName() + "是错误的采购品");
				j.setSuccess(false);
				return j;
			}
			String num = ledger.getQuantity();
			if (!num.matches("^[1-9][0-9]*$")) {
				j.setMsg(ledger.getName() + "错误的采购数量");
				j.setSuccess(false);
				return j;
			}
			String spce = ledger.getSpce();
			if (!spce.equals(warerDto.getSpec())) {
				j.setMsg(ledger.getName() + "错误的的采购规格");
				j.setSuccess(false);
				return j;
			}
			String supplierId = supplierService
					.findSupplierIdBySourceId(ledger);
			ledger.setSupplierId(supplierId);
			if (ledger.getSupplierId() == null) {
				ledger.setSupplierName(null);
			}
			ledger.setCreateTime(new Date());
			ledger.setLastUpdateTime(ledger.getCreateTime());
			ledger.setStat(1);
			i += 1;
		}
		if (str != "") {
			for (String b : str.split(",")) {
				ledgers.remove(Integer.parseInt(b));
			}
		}
		ledgerService.saveLedger(ledgers);
		j = new Json();
		j.setMsg("添加供应商成功");
		j.setSuccess(true);
		return j;
	}

	@RequestMapping("/editPage")
	public String editPage(String masterId, HttpServletRequest request,
			HttpSession session) {
		TImsUsersDto user = (TImsUsersDto) session.getAttribute("user");
		if (user == null) {
			return null;
		}
		List<TImsUsersDto> driver = userService.findAllDriver(user
				.getSourceId());
		List<LedgerDto> list = ledgerService.findLedgerByMasterId(
				user.getSourceId(), masterId);
		request.setAttribute("Driver", driver);
		request.setAttribute("LedgerList", list);
		return "ledger/ledgerEdit";
	}

	@RequestMapping("/showPage")
	public String showPage(String masterId, HttpServletRequest request,
			HttpSession session) {
		TImsUsersDto user = (TImsUsersDto) session.getAttribute("user");
		if (user == null) {
			return null;
		}
		List<TImsUsersDto> driver = userService.findAllDriver(user
				.getSourceId());
		List<LedgerDto> list = ledgerService.findLedgerByMasterId(
				user.getSourceId(), masterId);
		request.setAttribute("Driver", driver);
		request.setAttribute("LedgerList", list);
		return "ledger/ledgerShow";
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
		List<LedgerDto> ledgers = lm.getLedger();
		ledgers.get(0).setSourceId(sourceId);
		Date actionDate = ledgers.get(0).getActionDate();
		if (actionDate == null) {
			j.setMsg("配送日期不能为空");
			j.setSuccess(false);
			return j;
		}
		String receiverId = eduSchoolSupplierService.findSchoolIdByReceiverId(
				ledgers.get(0).getReceiverName(), ledgers.get(0).getSourceId());
		if (receiverId == null) {
			j.setMsg("不存在的配送点");
			j.setSuccess(false);
			return j;
		}
		for (LedgerDto ledger : ledgers) {
			if (ledger.getName() == null) {
				j.setMsg("采购品不能为空");
				j.setSuccess(false);
				return j;
			}
			ledger.setMasterId(ledgers.get(0).getMasterId());
			ledger.setWareBatchNo(ledgers.get(0).getWareBatchNo());
			ledger.setActionDate(actionDate);
			ledger.setReceiverId(receiverId);
			ledger.setSourceId(sourceId);
			ProWaresDto warerDto = waresService.findWaresBySupplierId(ledger);
			ledger.setWaresId(warerDto.getId());
			if (ledger.getProductionDate() != null) {
				if (!ledgers.get(0).getActionDate()
						.after(ledger.getProductionDate())) {
					j.setMsg(ledger.getName() + "错误的进货日期或生产日期");
					j.setSuccess(false);
					return j;
				}
			}
			if (ledger.getWaresId() == null) {
				j.setMsg(ledger.getName() + "是错误的采购品");
				j.setSuccess(false);
				return j;
			}
			String num = ledger.getQuantity();
			if (num.matches("^[1-9][0-9]*$")) {
				j.setMsg(ledger.getName() + "错误的采购数量");
				j.setSuccess(false);
				return j;
			}
			String spce = ledger.getSpce();
			if (!spce.equals(warerDto.getSpec())) {
				j.setMsg(ledger.getName() + "错误的的采购规格");
				j.setSuccess(false);
				return j;
			}
			String supplierId = supplierService
					.findSupplierIdBySourceId(ledger);
			ledger.setSupplierId(supplierId);
			if (ledger.getSupplierId() == null) {
				ledger.setSupplierName(null);
			}
			ledger.setCreateTime(null);
			ledger.setLastUpdateTime(ledger.getCreateTime());
			ledger.setStat(1);
			ledgerService.updataLedger(ledgers);
		}
		j = new Json();
		j.setMsg("添加供应商成功");
		j.setSuccess(true);
		return j;
	}

	@RequestMapping("/deleteLedger")
	@ResponseBody
	public Json deleteLedger(String masterId, HttpSession session) {
		Json j = new Json();
		TImsUsersDto user = (TImsUsersDto) session.getAttribute("user");
		if (user == null) {
			j.setMsg("供应商不能为空");
			j.setSuccess(false);
			return j;
		}
		int r = ledgerService.deleteLedger(user.getSourceId(), masterId);
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
		String errorMsg = null;
		// 读取excel
		try (HSSFWorkbook hssfWorkbook = new HSSFWorkbook(file.getInputStream())) {
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
			if (hssfSheet == null) {
				return null;
			}

			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.M.d");

			Map<String, ProLedgerMaster> noMaster = new HashMap();
			Map<ProLedgerMaster, List<ProLedger>> masterLedger = new LinkedHashMap();

			// 缓存所有司机，数据量不大
			List<TImsUsersDto> drivers = userService.findAllDriver(supplierId);
			for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
				if (errorMsg != null) {
					break;
				}
				ProLedgerMaster master = null;
				ProLedger dto = new ProLedger();
				HSSFRow hssfRow = hssfSheet.getRow(rowNum);
				String name = null;
				String spec = null;

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
						if (StringUtils.isBlank(value)) {
							errorMsg = "第" + (rowNum + 1) + "行数据不正确，配货号不能为空。";
							break;
						}
						// 配货号
						master = noMaster.get(value);
						if (master == null) {
							master = new ProLedgerMaster();
							master.setWareBatchNo(value);
							master.setSourceId(supplierId);
							master.setHaulStatus(0);
							master.setStat(1);
							master.setCreateTime(now);
							master.setLastUpdateTime(now);
							noMaster.put(value, master);
							masterLedger.put(master, new ArrayList());
						}
					}
					if (i == 1 && master.getActionDate() != null) {
						if (StringUtils.isBlank(value)) {
							errorMsg = "第" + (rowNum + 1) + "行数据不正确，配送日期不能为空。";
							break;
						}
						// 进货日期
						try {
							master.setActionDate(sdf.parse(value));
						} catch (ParseException e) {
							errorMsg = "第" + (rowNum + 1) + "行数据不正确，配送日期格式不正确。";
							break;
						}
					} else if (i == 2) {
						if (StringUtils.isBlank(value)) {
							errorMsg = "第" + (rowNum + 1) + "行数据不正确，采购品名称不能为空。";
							break;
						}
						// 名称
						name = value;
					} else if (i == 3) {
						if (StringUtils.isBlank(value)) {
							errorMsg = "第" + (rowNum + 1) + "行数据不正确，数量不能为空。";
							break;
						}
						// 数量
						try {
							dto.setQuantity(new BigDecimal(value,
									new MathContext(2, RoundingMode.DOWN)));
						} catch (Exception e) {
							errorMsg = "第" + (rowNum + 1) + "行数据不正确，数量格式不正确。";
							break;
						}
					} else if (i == 4) {
						if (StringUtils.isBlank(value)) {
							errorMsg = "第" + (rowNum + 1) + "行数据不正确，规格不能为空。";
							break;
						}
						// 规格
						spec = value;
					} else if (i == 5 && master.getReceiverId() == null) {
						if (StringUtils.isBlank(value)) {
							errorMsg = "第" + (rowNum + 1) + "行数据不正确，配货点不能为空。";
							break;
						}
						// 配货点
						String receiverId = eduSchoolSupplierService
								.findSchoolIdByReceiverId(value, supplierId);
						if (receiverId == null) {
							errorMsg = "第" + (rowNum + 1) + "行数据不正确，配货点不存在。";
							break;
						}
						master.setReceiverId(receiverId);
						master.setReceiverName(value);
					} else if (i == 6 && StringUtils.isNotBlank(value)
							&& master.getUserId() == null) {
						// 根据name取司机
						for (TImsUsersDto o : drivers) {
							if (value.equals(o.getName())) {
								master.setUserId(o.getId());
								break;
							}
						}
					} else if (i == 7 && StringUtils.isNotBlank(value)) {
						// 供应商名称
						ProSupplier ps = supplierService.getSupplierByName(
								value, supplierId);

						if (ps != null) {
							dto.setSupplierId(ps.getId());
							dto.setSupplierName(ps.getSupplierName());
						}
					} else if (i == 8) {
						// 生产单位
						// 查找商品
						ProWares pw = waresService.findProWarsByNameSpecManu(
								name, spec, value, supplierId);
						if (pw == null) {
							errorMsg = "第" + (i + 1) + "行数据不正确，商品不存在。";
							break;
						} else {
							dto.setWaresId(pw.getId());
						}
					} else if (i == 9 && StringUtils.isNotBlank(value)) {
						// 生产日期
						dto.setProductionDate(sdf.parse(value));
					}
				}
				if (errorMsg != null) {
					break;
				}
				dto.setSupplierId(supplierId);
				dto.setCreateTime(now);
				dto.setLastUpdateTime(now);
				dto.setStat(1);
				masterLedger.get(master).add(dto);
			}
		}
		if (errorMsg != null) {
			// TODO 反馈用户错误信息
		} else {
			// TODO 导入批次
		}

		return null;
	}
}
