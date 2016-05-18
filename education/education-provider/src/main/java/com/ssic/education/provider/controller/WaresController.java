package com.ssic.education.provider.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ssic.base.datasource.DataSourceHolderUtil;
import com.ssic.education.common.dto.ImageInfoDto;
import com.ssic.education.common.pojo.ProLicense;
import com.ssic.education.common.pojo.ProWares;
import com.ssic.education.common.provider.dto.SupplierDto;
import com.ssic.education.common.provider.service.ISupplierService;
import com.ssic.education.common.service.ICreateImageService;
import com.ssic.education.provider.dto.PageHelperDto;
import com.ssic.education.provider.dto.ProWaresDto;
import com.ssic.education.provider.pageModel.DataGrid;
import com.ssic.education.provider.pageModel.Json;
import com.ssic.education.provider.pageModel.PageHelper;
import com.ssic.education.provider.service.ICreatePhdtoService;
import com.ssic.education.provider.service.IProLicenseService;
import com.ssic.education.provider.service.IWaresService;
import com.ssic.education.provider.util.ProductClass;
import com.ssic.education.utils.util.BeanUtils;
import com.ssic.education.utils.util.PropertiesUtils;
import com.ssic.util.UUIDGenerator;

@Controller
@RequestMapping("/waresController")
public class WaresController  extends BaseController {
	@Autowired
	private IWaresService  waresService;
	 @Autowired
	  private ICreatePhdtoService createPhdtoService;
	 @Autowired
	    private   ICreateImageService  createImageServiceImpl;
	 
	 	@Autowired
	    private   IProLicenseService   proLicenseServiceImpl;
	 	@Autowired
		private ISupplierService supplierService;
	 
	 @RequestMapping("/manager")
	    public String manager(HttpServletRequest request)
	    {
	     /*   String nginxPath = PropertiesUtils.getProperty("nginx.url");
	        request.setAttribute("nginxPath", nginxPath);*/
	       return  "wares/warseList";
	    }
	/**
	 * 查询原料详情
	 * @param waresDto
	 * @param ph
	 * @return gao
	 */
	@RequestMapping("/dataGrid")
    @ResponseBody
	public DataGrid dataGrid(ProWaresDto waresDto ,PageHelper ph) {
		
	
			DataGrid dataGrid = new DataGrid();
			PageHelperDto phdto = new PageHelperDto();
	        phdto.setOrder(ph.getOrder());
	        phdto.setPage(ph.getPage());
	        phdto.setRows(ph.getRows());
	        phdto.setSort(ph.getSort());
	        phdto.setBeginRow((ph.getPage() - 1) * ph.getRows());		 	
	        List<ProWaresDto> pdtoList=	waresService.findAllWares(waresDto,phdto);
	       for (ProWaresDto proWaresDto : pdtoList) {
	    	   
	    	   String name = ProductClass.getName(proWaresDto.getWaresType());
	    	   proWaresDto.setWaresTypeName(name);
		}
	        //查询数量
	        dataGrid.setRows(pdtoList);
	        dataGrid.setTotal(Long.valueOf(pdtoList.size()));
	        return dataGrid;		
	}
	/**
	 * 添加商品
	 * @param request
	 * @return
	 */
	 @RequestMapping("/addWares")
	    public String addWares(HttpServletRequest request){
	    	request.setAttribute("id", UUIDGenerator.getUUID());
	    	return "wares/addWares";
	    }
	
	 /**
	  * 数据合法判断并插入数据库
	  * @param user
	  * @param userId
	  * @param isExistManager
	  * @return
	  */
	 @RequestMapping("/insertWares")
	    @ResponseBody
	    //
	    public Json insertWares(ProWaresDto pro){  
	    	 Json j = new Json();
	    	 if (pro.getWaresName()==null ||  pro.getWaresName().equals(""))
	         {
	             j.setMsg("商品名称不能为空");
	             j.setSuccess(false);
	             return j;
	         }
	
	         if (pro.getSpec()==null || pro.getSpec().equals(""))
	         {
	             j.setSuccess(false);
	             j.setMsg("商品规格不能为空");
	             return j;
	         }


	         if (pro.getWaresType()==null || pro.getWaresType().equals(""))
	         {
	             j.setSuccess(false);
	             j.setMsg("商品类型不能为空");
	             return j;
	         }	       
	       
	         DataSourceHolderUtil.setToMaster();
	         String supplierId=waresService.findSupplierIdByName(pro.getSupplierName());
	         pro.setSupplierId(supplierId);
	        
	         waresService.insertWares(pro);
	    	 j.setMsg("新增商品成功");
	    	 j.setSuccess(true);
	    	 return j;
	    	
	    }
	 
	 /**
	  * 修改商品数据
	  */
	 @RequestMapping("/editWares")
	    public String editWares(HttpServletRequest request,String id){
		 ProWaresDto proWaresDto=new ProWaresDto();
		 proWaresDto.setId(id);
	        List<ProWaresDto> list = waresService.findWares(proWaresDto);
	        if (list != null && list.size() > 0)
	        {
	        	proWaresDto = list.get(0);
	        }
	        request.setAttribute("wdto", proWaresDto);
	        request.setAttribute("id", id);
	    	return "wares/editWares";
	    }
	 
	 /**
	  * 跳转到上传图片页面
	  * @param request
	  * @param id
	  * @return
	  */
	 @RequestMapping("/updateImage")
	    public String updateImage(HttpServletRequest request,String id){
		 ProWaresDto proWaresDto=new ProWaresDto();
		 proWaresDto.setId(id);
	        List<ProWaresDto> list = waresService.findWares(proWaresDto);
	        if (list != null && list.size() > 0)
	        {
	        	proWaresDto = list.get(0);
	        }
	        request.setAttribute("wdto", proWaresDto);
	        request.setAttribute("id", id);
	    	return "wares/updateImage";
	    }
	 
	 /**
	  * 删除商品数据
	  * @param waresDto
	  * @return
	  */
	 @RequestMapping("deleteWares")
	    @ResponseBody
	    public Json deleteWares(ProWaresDto waresDto)
	    {
	        Json j = new Json();
	        DataSourceHolderUtil.setToMaster();
	        waresService.deleteWares(waresDto);
	        j.setMsg("删除用户成功");
	        j.setSuccess(true);
	        return j;
	    }
	 
	 
	 /**
	  * 修改商品信息
	  * @param waresDto
	  * @return
	  */
	  @RequestMapping("/updateWares")
	    @ResponseBody
	    public Json updateWares(ProWaresDto pro){
	    	Json json = new Json();
	    	 String supplierId=waresService.findSupplierIdByName(pro.getSupplierName());
	         pro.setSupplierId(supplierId);
	         pro.setStat(1);
	    	ProWares proWares =new ProWares();
	    	BeanUtils.copyProperties(pro, proWares);
	    	waresService.updateImsUsers(proWares);    	
	    	json.setMsg("修改信息成功");
	    	json.setSuccess(true);
	    	return json;
	    }
	 /**
	  * 上传图片
	  */
	  @RequestMapping("/insterImage")
	    @ResponseBody
	    public Json updateImage(String id,@RequestParam(value = "spImgUrl") MultipartFile spImgUrl,@RequestParam(value = "jcImgUrl") MultipartFile jcImgUrl,@RequestParam(value = "scImgUrl") MultipartFile scImgUrl,ImageInfoDto image,HttpServletRequest request, HttpServletResponse response){
	    	Json json = new Json();
	    	   ProLicense  license =new ProLicense();
	    	 Map<String, Object> map1 = createImageServiceImpl.createImage(image, spImgUrl, request, response);
	    	 Map<String, Object> map2 = createImageServiceImpl.createImage(image, jcImgUrl, request, response);
	    	 Map<String, Object> map3 = createImageServiceImpl.createImage(image, scImgUrl, request, response);
	         //如果已经有图片则更新image_url			      
	         String imageurl1 = (String) map1.get("image_url");
	         String imageurl2 = (String) map2.get("image_url");
	         String imageurl3 = (String) map3.get("image_url");
	         List<String> list =new ArrayList<String>();
	         if(imageurl1!=null && imageurl1!=""){
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
	         if(imageurl2!=null && imageurl2!=""){
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
	         if(imageurl3!=null && imageurl3!=""){
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
		  * 查看图片
		  */
		 @RequestMapping("/lookImage")
		    public String lookImage(HttpServletRequest request,String id){
			 	ProLicense  license =new ProLicense();
			 	license.setRelationId(id);
			 	license.setCerSource((short)2);
		        List<ProLicense> ProLicenseList = proLicenseServiceImpl.lookImage(license);		   
		        request.setAttribute("ProLicenseList", ProLicenseList);		      
		    	return "wares/lookImage";
		    }
	 /* *//**
	   * lookSupplier
	   *//*
		 @RequestMapping("/lookSupplier")
		    public String lookSupplier(HttpServletRequest request,String id){
			 ProWaresDto dto =new ProWaresDto();
			 dto.setId(id);
		        List<SupplierDto> SupplierDtoList = supplierService.lookSupplier(id);		   
		        request.setAttribute("SupplierDtoList", SupplierDtoList);		      
		    	return "wares/lookSupplier";
		    }*/
	  
	  
}
