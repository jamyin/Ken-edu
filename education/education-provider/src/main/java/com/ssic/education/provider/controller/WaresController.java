package com.ssic.education.provider.controller;


import java.util.List;
import java.util.Map;

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
import com.ssic.education.common.pojo.ProWares;
import com.ssic.education.common.service.ICreateImageService;
import com.ssic.education.provider.dto.PageHelperDto;
import com.ssic.education.provider.dto.ProWaresDto;
import com.ssic.education.provider.pageModel.DataGrid;
import com.ssic.education.provider.pageModel.Json;
import com.ssic.education.provider.pageModel.PageHelper;
import com.ssic.education.provider.service.ICreatePhdtoService;
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
	    //MultipartFile imgUrl, String  productionName, String  productionMethod,ImageInfoDto image,HttpServletRequest request, HttpServletResponse response
	    public Json insertWares(ProWaresDto pro){  
	    	 Json j = new Json();
	    	 if (pro.getWaresName()==null ||  pro.getWaresName().equals(""))
	         {
	             j.setMsg("商品名称不能为空");
	             j.setSuccess(false);
	             return j;
	         }
	        /* if (pro.getShelfLife()==null || pro.getShelfLife().equals("") )
	         {
	             j.setMsg("保质期不能为空");
	             j.setSuccess(false);
	             return j;
	         }
	         if (pro.getUnit() == null || pro.getUnit().equals(""))
	         {
	             j.setMsg("单位不能为空");
	             j.setSuccess(false);
	             return j;
	         }*/
	         if (pro.getSpec()==null || pro.getSpec().equals(""))
	         {
	             j.setSuccess(false);
	             j.setMsg("商品规格不能为空");
	             return j;
	         }

	         /*if (pro.getWay()==null || pro.getWay().equals(""))
	         {
	             j.setSuccess(false);
	             j.setMsg("商品方向不能为空");
	             return j;
	         }
	         if (pro.getCustomCode()==null || pro.getCustomCode().equals(""))
	         {
	             j.setSuccess(false);
	             j.setMsg("企业自定义代码不能为空");
	             return j;
	         }	
	         
	         if (pro.getBarCode()==null || pro.getBarCode().equals(""))
	         {
	             j.setSuccess(false);
	             j.setMsg("商品条形码不能为空");
	             return j;
	         }*/
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
	    public Json updateWares(@RequestParam(value = "imgUrl") MultipartFile file,ProWaresDto pro,ImageInfoDto image,HttpServletRequest request, HttpServletResponse response){
	    	Json json = new Json();
	    	 Map<String, Object> map = createImageServiceImpl.createImage(image, file, request, response);
	         String imageurl = (String) map.get("image_url");
	         pro.setImage(imageurl);
	    	ProWares proWares =new ProWares();
	    	BeanUtils.copyProperties(pro, proWares);
	    	waresService.updateImsUsers(proWares);    	
	    	json.setMsg("修改信息成功");
	    	json.setSuccess(true);
	    	return json;
	    }
	 
	 
}
