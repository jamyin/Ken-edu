package com.ssic.education.provider.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/schoolSupplierController")
public class SchoolSupplierController {
//
//	@Autowired
//	private ISchoolSupplierService schoolSupplierService;
//	
//	@RequestMapping("/manager")
//	public String manager(){
//		return "education/schoolSupplier/schoolSupplier";
//	}
//	
//	@RequestMapping("/dataGrid")
//	@ResponseBody
//	public DataGrid dataGrid(SchoolSupplierDto schoolSupplierDto,PageHelper ph){
//		DataGrid dataGrid = new DataGrid();
//		List<SchoolSupplierDto> listdto = schoolSupplierService.findByPage(schoolSupplierDto,ph); 
//		Integer count = schoolSupplierService.findCountByPage(schoolSupplierDto,ph);
//		dataGrid.setRows(listdto);	
//		dataGrid.setTotal(count.longValue());
//		return dataGrid;
//	}
//	
//	@RequestMapping("/addPage")
//	public String addPage(){
//		return "education/schoolSupplier/schoolSupplierAddPage";
//	}
//	
//	@RequestMapping("/editSchoolSupplierPage")
//	public String editSchoolSupplierPage(String supplierId,HttpServletRequest request){
//		SchoolSupplierDto schoolSupplierDto = new SchoolSupplierDto();
//		schoolSupplierDto.setId(supplierId);
//		List<SchoolSupplierDto> list = schoolSupplierService.findBy(schoolSupplierDto);
//		request.setAttribute("schoolSuppDto" , list.get(0));
//		return "education/schoolSupplier/schoolSupplierEditPage";
//	}
//	
//	@RequestMapping("/updateSchoolSupplier")
//	@ResponseBody
//	public Json updateSchoolSupplier(SchoolSupplierDto schoolSupplierDto){
//		Json json = new Json();
//		if(StringUtils.isEmpty(schoolSupplierDto.getId())){
//			json.setMsg("加工商ID不能为空");
//			json.setSuccess(false);
//			return json;
//		}
//		schoolSupplierService.updateschoolSupplier(schoolSupplierDto);
//		json.setMsg("更新加工商成功");
//		json.setSuccess(true);
//		return json;
//	}
//	
//	@RequestMapping("/insertSchoolSupplier")
//	@ResponseBody
//	public Json insertSchoolSupplier(SchoolSupplierDto schoolSupplierDto){//添加加工商基本信息
//		Json json = new Json();
//	
//	    if(StringUtils.isEmpty(schoolSupplierDto.getProjId())){
//	    	json.setMsg("项目ID不能为空!");
//	    	json.setSuccess(false);
//	    	return json;
//	    }
//		
//	    if(StringUtils.isEmpty(schoolSupplierDto.getSupplierName())){
//	    	json.setMsg("供应商名称不能为空!");
//	    	json.setSuccess(false);
//	    	return json;
//	    }
//	    
//	    if(StringUtils.isEmpty(schoolSupplierDto.getSupplierAddress())){
//	    	json.setMsg("供应商地址不能为空");
//	    	json.setSuccess(false);
//	    	return json;
//	    }
//	    
//	    if(StringUtils.isEmpty(schoolSupplierDto.getFoodLicense())){
//	    	json.setMsg("餐饮许可证不能为空");
//	        json.setSuccess(false);
//	        return json;
//	    }
//	    
//	    if(StringUtils.isEmpty(schoolSupplierDto.getBusinessLicense())){
//	    	json.setMsg("工商营业执照不能为空");
//	    	json.setSuccess(false);
//	    	return json;
//	    }
//	    
//	    if(StringUtils.isEmpty(schoolSupplierDto.getCorporation())){
//	    	json.setMsg("法人代表不能为空");
//	    	json.setSuccess(false);
//	    	return json;
//	    }
//	    
//	    if(StringUtils.isEmpty(schoolSupplierDto.getContactWay())){
//	    	json.setMsg("联系方式不能为空");
//	    	json.setSuccess(false);
//	    	return json;
//	    }
//	    schoolSupplierDto.setCreateTime(new Date());
//	    schoolSupplierDto.setId(UUIDGenerator.getUUID());
//	    schoolSupplierService.insertSchoolSupplier(schoolSupplierDto);
//		json.setMsg("添加成功");
//		json.setSuccess(true);
//		return json;
//	}
//	
//	//添加加工商对应的学校
//	
//	//添加加工商的地图地址
//	
//	//删除加工商,删除加工商学校关系
//	@RequestMapping("/deleteschoolSupplier")
//	@ResponseBody
//	public Json deleteschoolSupplier(String id){
//		Json json = new Json();
//		if(StringUtils.isEmpty(id)){
//			json.setMsg("加工商ID不能为空");
//			json.setSuccess(false);
//			return json;
//		}
//		DataSourceHolderUtil.setToMaster();
//		schoolSupplierService.deleteschoolSupplier(id);
//		json.setMsg("删除加工商成功");
//		json.setSuccess(true);
//		return json;
//	}
}
