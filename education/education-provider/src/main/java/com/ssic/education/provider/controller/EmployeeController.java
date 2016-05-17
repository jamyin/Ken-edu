package com.ssic.education.provider.controller;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.base.datasource.DataSourceHolderUtil;
import com.ssic.education.provider.dto.PageHelperDto;
import com.ssic.education.provider.dto.ProEmployeeDto;
import com.ssic.education.provider.dto.ProWaresDto;
import com.ssic.education.provider.pageModel.DataGrid;
import com.ssic.education.provider.pageModel.Json;
import com.ssic.education.provider.pageModel.PageHelper;
import com.ssic.education.provider.service.IEmployeeService;
import com.ssic.education.provider.service.IWaresService;
import com.ssic.util.UUIDGenerator;


@Controller
@RequestMapping("employeeController")
public class EmployeeController {
	@Autowired
	private  IEmployeeService  employeeServic;
	
	@Autowired
	private IWaresService  waresService;
	
	 @RequestMapping("/manager")
	    public String manager(HttpServletRequest request)
	    {
	     /*   String nginxPath = PropertiesUtils.getProperty("nginx.url");
	        request.setAttribute("nginxPath", nginxPath);*/
	       return  "employee/employeeList";
	    }
	 
	 /**
	  * 从业人员信息查询
	  * @param waresDto
	  * @param ph
	  * @return
	  */
	 @RequestMapping("/dataGrid")
	    @ResponseBody
		public DataGrid dataGrid(ProEmployeeDto pe ,PageHelper ph) {
				DataGrid dataGrid = new DataGrid();
				PageHelperDto phdto = new PageHelperDto();
		        phdto.setOrder(ph.getOrder());
		        phdto.setPage(ph.getPage());
		        phdto.setRows(ph.getRows());
		        phdto.setSort(ph.getSort());
		        phdto.setBeginRow((ph.getPage() - 1) * ph.getRows());		 	
		        List<ProEmployeeDto> peList=employeeServic.findAllEmployee(pe,phdto);	
		        
		        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		       
		      
		        for (ProEmployeeDto proEmployeeDto : peList) {
		        	  String HealthCodeDate = formatter.format(proEmployeeDto.getHealthCodeDate());
		        	  String TrainCodeDate = formatter.format(proEmployeeDto.getTrainCodeDate());
		        	
		        	  proEmployeeDto.setHealthCodeDateString(HealthCodeDate);
		        	  proEmployeeDto.setTrainCodeDateString(TrainCodeDate);
				}
		        //查询数量
		        dataGrid.setRows(peList);
		        dataGrid.setTotal(Long.valueOf(peList.size()));
		        return dataGrid;
			
		}
	 
	
		/**
		 * 跳转到添加页面
		 * @param request
		 * @return
		 */
		 @RequestMapping("/addEmployee")
		    public String addEmployee(HttpServletRequest request){
		    	request.setAttribute("id", UUIDGenerator.getUUID());
		    	return "employee/addEmployee";
		    }
		 
		 
		 
		 @RequestMapping("/insertEmployee")
		    @ResponseBody
		    //MultipartFile imgUrl, String  productionName, String  productionMethod,ImageInfoDto image,HttpServletRequest request, HttpServletResponse response
		    public Json insertEmployee(ProEmployeeDto pe){  
		    	 Json j = new Json();
		    	 if (pe.getName()==null ||  pe.getName().equals(""))
		         {
		             j.setMsg("名称不能为空");
		             j.setSuccess(false);
		             return j;
		         }
		
		         if (pe.getGender()==null || pe.getGender().equals(""))
		         {
		             j.setSuccess(false);
		             j.setMsg("性别不能为空");
		             return j;
		         }

		     
		         if (pe.getIdType()==null || pe.getIdType().equals(""))
		         {
		             j.setSuccess(false);
		             j.setMsg("身份证号码不能为空");
		             return j;
		         }	       
		         if (pe.getIdCode()==null || pe.getIdCode().equals(""))
		         {
		             j.setSuccess(false);
		             j.setMsg("商品类型不能为空");
		             return j;
		         }	     
		         
		         if (pe.getMobile()==null || pe.getMobile().equals(""))
		         {
		             j.setSuccess(false);
		             j.setMsg("商品类型不能为空");
		             return j;
		         }	    
		         DataSourceHolderUtil.setToMaster();
		         String supplierId=waresService.findSupplierIdByName(pe.getSupplierName());
		         pe.setSupplierId(supplierId);
		        
		         employeeServic.insertEmployee(pe);
		    	 j.setMsg("新增商品成功");
		    	 j.setSuccess(true);
		    	 return j;
		    	
		    }
		 
	 
	 
}
