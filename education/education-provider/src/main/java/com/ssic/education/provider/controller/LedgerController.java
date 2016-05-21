package com.ssic.education.provider.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.ssic.education.common.pojo.ProWares;
import com.ssic.education.common.provider.utils.DataGrid;
import com.ssic.education.common.provider.utils.PageHelper;
import com.ssic.education.provider.dto.LedgerDto;
import com.ssic.education.provider.dto.TImsUsersDto;
import com.ssic.education.provider.pageModel.Json;
import com.ssic.education.provider.pageModel.LedgerModel;
import com.ssic.education.provider.pageModel.SessionInfo;
import com.ssic.education.provider.service.ILedgerService;
import com.ssic.education.provider.service.IWaresService;
import com.ssic.education.provider.util.ConfigUtil;
import com.ssic.education.provider.util.ProductClass;
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
	private IWaresService waresService;

	@Autowired
	private ILedgerService ledgerService;

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
		List<TImsUsersDto> driver = ledgerService.findAllDriver(user
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
		System.out.println(lm);
		List<LedgerDto> ledger = lm.getLedger();
		ledger.get(0).setSourceId(sourceId);
		ledgerService.saveLedger(ledger);
		j = new Json();
		j.setMsg("添加供应商成功");
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
		List<ProLedger> list = new ArrayList();
		Date now = new Date();
		for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
			ProLedger dto = new ProLedger();
			HSSFRow hssfRow = hssfSheet.getRow(rowNum);
			for (int i = 0; i < hssfRow.getLastCellNum(); i++) {
				HSSFCell cell = hssfRow.getCell(i);
				String value = ParseExcelUtil.getStringCellValue(cell);
				String name = null;
				String spec = null;
				String manufacturer = null;
				
				String supplierCode = null;
				String supplierName = null;
				if (i == 0) {
					// 进货日期
					// TODO parse date
					dto.setActionDate(actionDate);
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
					// TODO parse date
					dto.setUnit(value);
				} else if (i == 5) {
					// 生产日期
					// TODO parse date
					dto.setActionDate(actionDate);
				} else if (i == 6) {
					// 生产批号
					dto.setBatchNo(value);
				} else if (i == 7) {
					// 供应商编码
					supplierCode = value;
				} else if (i == 8) {
					// 供应商名称
					supplierName = value;
				} else if (i == 9) {
					// 追溯码
					dto.setTraceCode(value);
				}
			}
			if (dto != null) {
				// 检查参数
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
		}
		// 导入商品
		waresService.addProWares(list);

		// TODO 反馈用户错误信息
		return null;
	}
}
