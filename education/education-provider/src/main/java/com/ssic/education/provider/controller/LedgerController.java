package com.ssic.education.provider.controller;

import java.io.IOException;
import java.io.OutputStream;
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
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.ssic.education.utils.util.PageData;
import com.ssic.education.utils.util.Tools;

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

	@RequestMapping("/importPage")
	public String importPage(HttpServletRequest request) {
		return "ledger/ledgerImport";
	}

	/**
	 * 查询配货
	 * 
	 * @param ld
	 * @param session
	 * @param ph
	 * @author chenminghai
	 * @return
	 */
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

	/**
	 * 添加配货
	 * 
	 * @param lm
	 * @param session
	 * @author chenminghai
	 * @return
	 */
	@RequestMapping("/saveLedger")
	@ResponseBody
	public Json saveLedger(LedgerModel lm, HttpSession session) {
		Json j = new Json();
		TImsUsersDto user = (TImsUsersDto) session.getAttribute("user");
		if (user == null) {
			j.setMsg("尚未登录");
			j.setSuccess(false);
			return j;
		}
		String sourceId = user.getSourceId();
		List<LedgerDto> ledgers = lm.getLedger();
		ledgers.get(0).setSourceId(sourceId);
		// 配送日期
		Date actionDate = ledgers.get(0).getActionDate();
		if (actionDate == null) {
			j.setMsg("配送日期不能为空");
			j.setSuccess(false);
			return j;
		}
		// 配送点
		String receiverId = eduSchoolSupplierService.findSchoolIdByReceiverId(
				ledgers.get(0).getReceiverName(), ledgers.get(0).getSourceId());
		if (receiverId == null) {
			j.setMsg("不存在的配送点");
			j.setSuccess(false);
			return j;
		}
		// 配送号
		int w = ledgerService.findWareBatchNo(ledgers.get(0).getWareBatchNo(),
				ledgers.get(0).getSourceId());
		if (w != 0) {
			j.setMsg("已存在的配送号");
			j.setSuccess(false);
			return j;
		}
		// 驾驶员
		if (ledgers.get(0).getUserId().equals("")) {
			ledgers.get(0).setUserId(null);
		}
		String masterId = UUID.randomUUID().toString();
		// 标识
		int i = 0;
		String str = "";
		for (LedgerDto ledger : ledgers) {
			if (ledger.getMark() != 1) {
				str += i + ",";
				i += 1;
				continue;
			}
			// 原料
			if (ledger.getName() == null) {
				j.setMsg("原料不能为空");
				j.setSuccess(false);
				return j;
			}
			ledger.setWareBatchNo(ledgers.get(0).getWareBatchNo());
			ledger.setActionDate(actionDate);
			ledger.setReceiverId(receiverId);
			ledger.setReceiverName(ledgers.get(0).getReceiverName());
			ledger.setSourceId(sourceId);
			ledger.setCreator(user.getId());
			ledger.setUpdater(user.getId());
			ledger.setMasterId(masterId);
			// 查询原料是否存在
			if (StringUtils.isBlank(ledger.getAmountUnit())) {
				j.setMsg(ledger.getName() + "数量单位不能为空");
				j.setSuccess(false);
				return j;
			}
			if (StringUtils.isBlank(ledger.getProductionName())) {
				j.setMsg(ledger.getName() + "生产企业不能为空");
				j.setSuccess(false);
				return j;
			}
			ProWares warer = waresService.findProWarsByNameSpecManu(
					ledger.getName(), ledger.getAmountUnit(),
					ledger.getProductionName(), sourceId);
			if (warer == null) {
				j.setMsg(ledger.getName() + "不存在的原料");
				j.setSuccess(false);
				return j;
			}
			ledger.setSpce(warer.getSpec());
			ledger.setWaresId(warer.getId());
			// 进货与生产日期比较
			if (ledger.getProductionDate() != null) {
				if (!ledgers.get(0).getActionDate()
						.after(ledger.getProductionDate())) {
					if (!ledgers.get(0).getActionDate()
							.equals(ledger.getProductionDate())) {
						j.setMsg(ledger.getName() + "错误的进货日期或生产日期");
						j.setSuccess(false);
						return j;
					}
				}
			}
			String num = ledger.getQuantity();
			if (!num.matches("^[1-9][0-9]*(\\.)?[0-9]{0,2}$")) {
				j.setMsg(ledger.getName() + "错误的采购数量");
				j.setSuccess(false);
				return j;
			}
			// 查询提供者
			if (StringUtils.isBlank(ledger.getSupplierName())) {
				j.setMsg(ledger.getName() + "原料提供者不能为空");
				j.setSuccess(false);
				return j;
			}
			String supplierId = supplierService
					.findSupplierIdBySourceId(ledger);
			ledger.setSupplierId(supplierId);
			if (ledger.getSupplierId() == null) {
				j.setMsg(ledger.getName() + "原料提供者不存在");
				j.setSuccess(false);
				return j;
			}
			ledger.setCreateTime(new Date());
			ledger.setLastUpdateTime(ledger.getCreateTime());
			ledger.setStat(1);
			ledger.setHaulStatus(0);
			i += 1;
		}
		int x = 0;
		if (str != "") {
			for (String b : str.split(",")) {
				ledgers.remove(Integer.parseInt(b) - x);
				x++;
			}
		}
		if (ledgers.size() == 0) {
			j.setMsg("不能没有原料");
			j.setSuccess(false);
			return j;
		}
		ledgerService.saveLedger(ledgers);
		j.setMsg("添加配货成功");
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

	/**
	 * 配货详情
	 * 
	 * @param masterId
	 * @param request
	 * @param session
	 * @author chenminghai
	 * @return
	 */
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

	/**
	 * 更新配货
	 * 
	 * @param lm
	 * @param session
	 * @author chenminghai
	 * @return
	 */
	@RequestMapping(value = "/ledgerEdit")
	@ResponseBody
	public Json updataLedger(LedgerModel lm, HttpSession session) {
		Json j = new Json();
		TImsUsersDto user = (TImsUsersDto) session.getAttribute("user");
		if (user == null) {
			j.setMsg("尚未登录");
			j.setSuccess(false);
			return j;
		}
		String sourceId = user.getSourceId();
		List<LedgerDto> ledgers = lm.getLedger();
		List<LedgerDto> listls = ledgerService.findLedgerByMasterId(
				user.getSourceId(), ledgers.get(0).getMasterId());
		if (listls.size() == 0) {
			j.setMsg("不存在的配送");
			j.setSuccess(false);
			return j;
		}
		if (listls.get(0).getHaulStatus() == 2) {
			j.setMsg("不能修改此配送");
			j.setSuccess(false);
			return j;
		}
		ledgers.get(0).setSourceId(sourceId);
		// 配货日期
		Date actionDate = ledgers.get(0).getActionDate();
		if (actionDate == null) {
			j.setMsg("配送日期不能为空");
			j.setSuccess(false);
			return j;
		}
		// 配送点
		String receiverId = eduSchoolSupplierService.findSchoolIdByReceiverId(
				ledgers.get(0).getReceiverName(), ledgers.get(0).getSourceId());
		if (receiverId == null) {
			j.setMsg("不存在的配送点");
			j.setSuccess(false);
			return j;
		}
		// 驾驶员
		if (ledgers.get(0).getUserId().equals("")) {
			ledgers.get(0).setUserId(null);
		}
		List<LedgerDto> list = ledgerService.findLedgerByMasterId(
				user.getSourceId(), ledgers.get(0).getMasterId());
		if (list.get(0).getHaulStatus() == 1&&ledgers.get(0).getHaulStatus() != 0) {
			if (ledgers.get(0).getUserId() == null
					|| !ledgers.get(0).getUserId()
							.equals(list.get(0).getUserId())) {
				j.setMsg("配送中不能更改驾驶员");
				j.setSuccess(false);
				return j;
			}
		}
		if (ledgers.get(0).getUserId() != null) {
			List<TImsUsersDto> drivers = userService.findAllDriver(user
					.getSourceId());
			int z = 0;
			if (drivers.size() != 0) {
				for (TImsUsersDto o : drivers) {
					if (ledgers.get(0).getUserId().equals(o.getId())) {
						ledgers.get(0).setUserId(o.getId());
						ledgers.get(0).setUserName(o.getName());
						z += 1;
						break;
					}
				}
			}
			if (z == 0) {
				ledgers.get(0).setUserId(null);
			}
		}
		if (ledgers.get(0).getHaulStatus() == 1||ledgers.get(0).getHaulStatus() == 2) {
			if (ledgers.get(0).getUserId() == null) {
				j.setMsg("不能没有驾驶员");
				j.setSuccess(false);
				return j;
			}
		}
		// 标识
		int n = 0;
		String str = "";
		for (LedgerDto ledger : ledgers) {
			if (ledger.getMark() != 1) {
				str += n + ",";
				n += 1;
				continue;
			}
			// 原料
			if (ledger.getName() == null) {
				j.setMsg("原料不能为空");
				j.setSuccess(false);
				return j;
			}
			ledger.setMasterId(ledgers.get(0).getMasterId());
			ledger.setWareBatchNo(ledgers.get(0).getWareBatchNo());
			ledger.setActionDate(actionDate);
			ledger.setReceiverId(receiverId);
			ledger.setReceiverName(ledgers.get(0).getReceiverName());
			ledger.setHaulStatus(ledgers.get(0).getHaulStatus());
			ledger.setSourceId(sourceId);
			if (StringUtils.isBlank(ledger.getAmountUnit())) {
				j.setMsg(ledger.getName() + "原料数量单位不能为空");
				j.setSuccess(false);
				return j;
			}
			if (StringUtils.isBlank(ledger.getProductionName())) {
				j.setMsg(ledger.getName() + "生产企业不能为空");
				j.setSuccess(false);
				return j;
			}
			ProWares warer = waresService.findProWarsByNameSpecManu(
					ledger.getName(), ledger.getAmountUnit(),
					ledger.getProductionName(), sourceId);
			if (warer == null) {
				j.setMsg(ledger.getName() + "不存在的原料");
				j.setSuccess(false);
				return j;
			}
			ledger.setSpce(warer.getSpec());
			ledger.setWaresId(warer.getId());
			// 生产日期与进货日期
			if (ledger.getProductionDate() != null) {
				if (!ledgers.get(0).getActionDate()
						.after(ledger.getProductionDate())) {
					if (!ledgers.get(0).getActionDate()
							.equals(ledger.getProductionDate())) {
						j.setMsg(ledger.getName() + "错误的进货日期或生产日期");
						j.setSuccess(false);
						return j;
					}
				}
			}
			// 采购数量
			String num = ledger.getQuantity();
			if (!num.matches("^[1-9][0-9]*(\\.)?[0-9]{0,2}$")) {
				j.setMsg(ledger.getName() + "错误的采购数量");
				j.setSuccess(false);
				return j;
			}
			if (StringUtils.isBlank(ledger.getSupplierName())) {
				j.setMsg(ledger.getName() + "原料提供者不能为空");
				j.setSuccess(false);
				return j;
			}
			String supplierId = supplierService
					.findSupplierIdBySourceId(ledger);
			ledger.setSupplierId(supplierId);
			if (ledger.getSupplierId() == null) {
				j.setMsg(ledger.getName() + "原料提供者不存在");
				j.setSuccess(false);
				return j;
			}
			ledger.setCreator(user.getId());
			ledger.setCreateTime(new Date());
			ledger.setUpdater(user.getId());
			ledger.setLastUpdateTime(new Date());
			ledger.setStat(1);
			n += 1;
		}
		int x = 0;
		if (str != "") {
			for (String b : str.split(",")) {
				LedgerDto remove = ledgers.remove(Integer.parseInt(b) - x);
				x++;
			}
		}
		if (ledgers.size() == 0) {
			j.setMsg("不能没有原料");
			j.setSuccess(false);
			return j;
		}
		ledgerService.updataLedger(ledgers);
		j.setMsg("修改配货成功");
		j.setSuccess(true);
		return j;
	}

	/**
	 * 删除配货
	 * 
	 * @param masterId
	 * @param session
	 * @author chenminghai
	 * @return
	 */
	@RequestMapping("/deleteLedger")
	@ResponseBody
	public Json deleteLedger(String masterId, HttpSession session) {
		Json j = new Json();
		TImsUsersDto user = (TImsUsersDto) session.getAttribute("user");
		if (user == null) {
			j.setMsg("尚未登录");
			j.setSuccess(false);
			return j;
		}
		List<LedgerDto> list = ledgerService.findLedgerByMasterId(
				user.getSourceId(), masterId);
		if (list.size() == 0) {
			j.setMsg("不存在的配送");
			j.setSuccess(false);
			return j;
		}
		if (list.get(0).getHaulStatus() == 2) {
			j.setMsg("不能删除此配送");
			j.setSuccess(false);
			return j;
		}
		int r = ledgerService.deleteLedger(user.getSourceId(), masterId);
		j.setMsg("删除配送成功");
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
	public Json importExcel(@RequestParam("filename") MultipartFile file,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ParseException {
		Json j = new Json();
		SessionInfo info = (SessionInfo) request.getSession().getAttribute(
				ConfigUtil.SESSIONINFONAME);
		// 当前登录用户所属提供者的id
		if (info == null) {
			j.setMsg("尚未登录");
			j.setSuccess(false);
			return j;
		}
		String supplierId = info.getSupplierId();
		String errorMsg = null;
		Map<ProLedgerMaster, List<ProLedger>> masterLedger = new LinkedHashMap();

		// 读取excel
		try (Workbook wb = WorkbookFactory.create(file.getInputStream());) {
			Sheet sheet = wb.getSheetAt(0);
			if (sheet == null) {
				return null;
			}

			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.M.d");

			Map<String, ProLedgerMaster> noMaster = new HashMap();

			// 缓存所有司机，数据量不大
			List<TImsUsersDto> drivers = userService.findAllDriver(supplierId);
			for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
				if (errorMsg != null) {
					break;
				}
				ProLedgerMaster master = null;
				ProLedger dto = new ProLedger();
				Row row = sheet.getRow(rowNum);
				String name = null;
				String amountUnit = null;

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
							errorMsg = "第" + (rowNum + 1) + "行数据不正确，配货号不能为空。";
							break;
						}
						// 配货号
						int w = ledgerService
								.findWareBatchNo(value, supplierId);
						if (w != 0) {
							errorMsg = "第" + (rowNum + 1) + "行数据不正确，配货号已存在。";
							break;
						}
						master = noMaster.get(value);
						if (master == null) {
							master = new ProLedgerMaster();
							master.setWareBatchNo(value);
							master.setSourceId(supplierId);
							master.setHaulStatus(0);
							master.setStat(1);
							master.setCreator(info.getId());
							master.setCreateTime(now);
							master.setUpdater(info.getId());
							master.setLastUpdateTime(now);
							noMaster.put(value, master);
							masterLedger.put(master, new ArrayList());
						}
					}
					if (i == 1) {
						if (master.getActionDate() == null) {
							if (StringUtils.isBlank(value)) {
								errorMsg = "第" + (rowNum + 1)
										+ "行数据不正确，配送日期不能为空。";
								break;
							}
							// 进货日期
							try {
								master.setActionDate(sdf.parse(value));
							} catch (ParseException e) {
								errorMsg = "第" + (rowNum + 1)
										+ "行数据不正确，配送日期格式不正确。";
								break;
							}
						} else {
							if (!master.getActionDate()
									.equals(sdf.parse(value))) {
								errorMsg = "第" + (rowNum + 1)
										+ "行数据不正确，配送日期不正确。";
								break;
							}

						}
					} else if (i == 2) {
						if (StringUtils.isBlank(value)) {
							errorMsg = "第" + (rowNum + 1) + "行数据不正确，原料名称不能为空。";
							break;
						}
						// 名称
						name = value;
						dto.setName(name);
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
							errorMsg = "第" + (rowNum + 1) + "行数据不正确，数量单位不能为空。";
							break;
						}
						// 数量单位
						amountUnit = value;
					} else if (i == 5) {
						// 配货点
						String receiverId = eduSchoolSupplierService
								.findSchoolIdByReceiverId(value, supplierId);
						if (master.getReceiverId() == null) {
							if (StringUtils.isBlank(value)) {
								errorMsg = "第" + (rowNum + 1)
										+ "行数据不正确，配货点不能为空。";
								break;
							}
							if (receiverId == null) {
								errorMsg = "第" + (rowNum + 1)
										+ "行数据不正确，配货点不存在。";
								break;
							}
							master.setReceiverId(receiverId);
							master.setReceiverName(value);
						} else {
							if (!master.getReceiverId().equals(receiverId)) {
								errorMsg = "第" + (rowNum + 1)
										+ "行数据不正确，配货点不正确。";
								break;
							}
						}
					} else if (i == 6 && StringUtils.isNotBlank(value)) {
						// 根据name取司机
						if (master.getUserId() == null) {
							for (TImsUsersDto o : drivers) {
								if (value.equals(o.getName())) {
									master.setUserId(o.getId());
									master.setDriverName(value);
									break;
								}
							}
						} else {
							for (TImsUsersDto o : drivers) {
								if (value.equals(o.getName())) {
									if (!o.getId().equals(master.getUserId())) {
										errorMsg = "第" + (rowNum + 1)
												+ "行数据不正确，驾驶员不正确。";
										break;
									}
								}
							}
						}
					} else if (i == 7) {
						// 原料供货者
						if (StringUtils.isBlank(value)) {
							errorMsg = "第" + (rowNum + 1) + "行数据不正确，原料供货者不能为空。";
							break;
						}
						ProSupplier ps = supplierService.getSupplierByName(
								value, supplierId);

						if (ps == null) {
							errorMsg = "第" + (rowNum + 1) + "行数据不正确，原料供货者不存在。";
							break;
						}
						dto.setSupplierId(ps.getId());
						dto.setSupplierName(ps.getSupplierName());
					} else if (i == 8) {
						// 生产单位
						// 查找原料
						if (StringUtils.isBlank(value)) {
							errorMsg = "第" + (rowNum + 1) + "行数据不正确，生产单位不能为空。";
							break;
						}
						ProWares pw = waresService.findProWarsByNameSpecManu(
								name, amountUnit, value, supplierId);
						if (pw == null) {
							errorMsg = "第" + (rowNum + 1) + "行数据不正确，原料不存在。";
							break;
						} else {
							dto.setSpce(pw.getSpec());
							dto.setWaresId(pw.getId());
							dto.setAmountUnit(pw.getAmountUnit());
							dto.setProductionName(pw.getManufacturer());
						}
					} else if (i == 9 && StringUtils.isNotBlank(value)) {
						// 生产日期
						if (sdf.parse(value).after(master.getActionDate())) {
							errorMsg = "第" + (rowNum + 1) + "行数据不正确，生产日期不正确。";
							break;
						}
						dto.setProductionDate(sdf.parse(value));
					}
				}
				if (errorMsg != null) {
					break;
				}
				dto.setCreator(info.getId());
				dto.setCreateTime(now);
				dto.setUpdater(info.getId());
				dto.setLastUpdateTime(now);
				dto.setStat(1);
				masterLedger.get(master).add(dto);
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
			ledgerService.importLedger(masterLedger);
		}
		j.setMsg("添加成功");
		j.setSuccess(true);
		return j;
	}

	@RequestMapping(value = "/excel")
	@ResponseBody
	public ModelAndView exportExcel(LedgerDto ld, HttpServletRequest request,
			HttpServletResponse response) {
		SessionInfo info = (SessionInfo) request.getSession().getAttribute(
				ConfigUtil.SESSIONINFONAME);
		if (info == null) {
			return null;
		}
		ld.setSourceId(info.getSupplierId());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.M.d");
		Date date = new Date();
		String filename = Tools.date2Str(date, "yyyyMMddHHmmss");
		HSSFSheet sheet;
		HSSFCell cell;
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ filename + ".xls");
		Workbook workbook = new HSSFWorkbook();
		sheet = (HSSFSheet) workbook.createSheet("配货管理");
		try {
			List<String> titles = new ArrayList<String>();
			titles.add("配货号");
			titles.add("配货日期");
			titles.add("原料名称");
			titles.add("数量");
			titles.add("数量单位");
			titles.add("配货点");
			titles.add("驾驶员");
			titles.add("原料供货者");
			titles.add("生产单位");
			titles.add("生产日期");
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
			Map<ProLedgerMaster, List<ProLedger>> map = ledgerService
					.findExportProSupplier(ld);
			List<PageData> varList = new ArrayList<PageData>();
			List<TImsUsersDto> drivers = userService.findAllDriver(info
					.getSupplierId());
			if (!CollectionUtils.sizeIsEmpty(map)) {
				for (ProLedgerMaster plm : map.keySet()) {
					String driver = null;
					for (TImsUsersDto user : drivers) {
						if (user.getId().equals(plm.getUserId())) {
							driver = user.getName();
						}
					}
					for (ProLedger pl : map.get(plm)) {
						PageData vpd = new PageData();
						vpd.put("var1", plm.getWareBatchNo());
						vpd.put("var2", sdf.format(plm.getActionDate())
								.toString());
						vpd.put("var3", pl.getName());
						vpd.put("var4", pl.getQuantity());
						vpd.put("var5", pl.getSpce());
						vpd.put("var6", plm.getReceiverName());
						vpd.put("var7", driver);
						vpd.put("var8", pl.getSupplierName());
						vpd.put("var9", pl.getProductionName());
						vpd.put("var10", sdf.format(pl.getProductionDate())
								.toString());
						varList.add(vpd);
					}
				}
			}
			for (int i = 0; i < varList.size(); i++) {
				HSSFRow row = sheet.createRow(i + 1);
				PageData vpd = varList.get(i);
				for (int j = 0; j < len; j++) {
					String varstr = vpd.getString("var" + (j + 1)) != null ? vpd
							.getString("var" + (j + 1)) : "";
					cell = row.createCell(j);
					if (j != 3) {
						HSSFCellStyle cellStyle2 = (HSSFCellStyle) workbook
								.createCellStyle();
						HSSFDataFormat format = (HSSFDataFormat) workbook
								.createDataFormat();
						cellStyle2.setDataFormat(format.getFormat("@"));
						cell.setCellStyle(cellStyle2);
						cell.setCellType(HSSFCell.CELL_TYPE_STRING);
						cell.setCellValue(varstr);
						continue;
					}
					cell.setCellStyle(contentStyle);
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

	// @RequestMapping("download")
	// public void download(HttpServletRequest request,
	// HttpServletResponse response) {
	// String fileName = "配货管理.xlsx";
	// BufferedInputStream bis = null;
	// BufferedOutputStream bos = null;
	// String p = request.getSession().getServletContext().getRealPath("/")
	// + "\\templates\\" + fileName;
	// try {
	// bis = new BufferedInputStream(new FileInputStream(new File(request
	// .getSession().getServletContext().getRealPath("/")
	// + "\\templates\\" + fileName)));
	// bos = new BufferedOutputStream(response.getOutputStream());
	// String encodedfileName = null;
	// String agent = request.getHeader("USER-AGENT");
	// if (null != agent && -1 != agent.indexOf("MSIE")) {// IE
	// encodedfileName = java.net.URLEncoder.encode(fileName, "UTF-8");
	// } else if (null != agent && -1 != agent.indexOf("Mozilla")) {
	// encodedfileName = new String(fileName.getBytes("UTF-8"),
	// "iso-8859-1");
	// } else {
	// encodedfileName = java.net.URLEncoder.encode(fileName, "UTF-8");
	// }
	// response.setHeader("Content-Disposition", "attachment; filename=\""
	// + encodedfileName + "\"");
	// int byteRead = 0;
	// byte[] buffer = new byte[8192];
	// while ((byteRead = bis.read(buffer, 0, 8192)) != -1) {
	// bos.write(buffer, 0, byteRead);
	// }
	//
	// bos.flush();
	// bis.close();
	// bos.close();
	// } catch (Exception e) {
	// }
	// }
}
