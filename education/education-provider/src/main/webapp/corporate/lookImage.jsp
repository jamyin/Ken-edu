<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript">
	$(function(){
		var proLicenseList= '<%=request.getAttribute("ProLicenseList")%>';
		var list = JSON.parse(proLicenseList);
		for(var i in list){
			var licName=list[i].licName;
			if(licName=="工商营业执照"){
				$("#img1").attr("src",list[i].licPic);
			}
			if(licName=="身份证"){
				$("#img8").attr("src",list[i].licPic);
			}
			if(licName=="组织机构代码"){
				$("#img2").attr("src",list[i].licPic);
			}
			if(licName=="港澳居民来往内地通行证"){
				$("#img9").attr("src",list[i].licPic);
			}
			if(licName=="税务登记证"){
				$("#img3").attr("src",list[i].licPic);
			}
			if(licName=="台湾居民往来内地通行证"){
				$("#img10").attr("src",list[i].licPic);
			}
			if(licName=="食品流通许可证"){
				$("#img4").attr("src",list[i].licPic);
			}
			if(licName=="其他"){
				$("#img11").attr("src",list[i].licPic);
			}
			if(licName=="食品生产许可证"){
				$("#img5").attr("src",list[i].licPic);
			}
			if(licName=="餐饮服务许可证"){
				$("#img6").attr("src",list[i].licPic);
			}
			if(licName=="食品经营许可证"){
				$("#img7").attr("src",list[i].licPic);
			}
		}
	});
</script>
<div>
	<table>
		<tr>
			<th>企业三证</th>
		</tr>
		<tr>
			<td>
				<img width="200" id="img1" />	
			</td>
			<td>
				<img width="200" id="img2" />	
			</td>
			<td>
				<img width="200" id="img3" />	
			</td>
		</tr>
		<tr>
			<th>工商营业执照</th>
			<th>组织机构代码</th>
			<th>税务登记证</th>
		</tr>
		<tr>
			<th>许可证</th>
		</tr>
		
		<tr>
			<td>
				<img id="img4" />
			</td>
			<td>
				<img id="img5" />
			</td>
			<td>
				<img id="img6" />
			</td>
			<td>
				<img id="img7" />
			</td>
		</tr>
		<tr>
			<th>食品流通许可证</th>
			<th>食品生产许可证</th>
			<th>餐饮服务许可证</th>
			<th>食品经营许可证</th>
		</tr>
		<tr>
			<th>法定代表人/负责人/业主证件</th>
		</tr>
		<tr>
			<td>
				<img id="img8" />
			</td>	
			<td>
				<img id="img9" />
			</td>	
			<td>
				<img id="img10" />
			</td>	
		</tr>
		<tr>
		<th>身份证</th>
		<th>港澳居民来往内地通行证</th>
		<th>台湾居民往来内地通行证</th>
		</tr>
		<tr>
			<th>其他</th>
		</tr>
		<tr>
		<td>
		<img id="img11" />
		</td>
		</tr>
		<tr>
		<th>其他</th>
		</tr>
	</table>		
</div>