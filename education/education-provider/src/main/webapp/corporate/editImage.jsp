<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<style>
.panel-body {
	font-size: 20px !important;
}
.table th, .table td {
    border-top: none!important;
}
.panel-body.panel-body-noheader.panel-body-noborder.layout-body {
	padding:20px!important;
}
.text-license {
	font-size: 18px !important;
	font-weight:normal!important;
}
</style>
<script type="text/javascript">
$(function(){
    $("img").click(function(){
        var width = $(this).width();
        if(width==150)
        {
            $(this).width(300);
            $(this).height(300);
        }
        else
        {
            $(this).width(150);
            $(this).height(150);
        }
    });
});
	
	$(function() {
		parent.$.messager.progress('close');
		var proLicenseList= '<%=request.getAttribute("ProLicenseList")%>';
		var list = JSON.parse(proLicenseList);
		for(var i in list){
			var licName=list[i].licName;
			if(list[i].licPic!=""){
				if(licName=="工商营业执照"){
					$("#img1").attr("src",list[i].licPic);
				}
				/* if(licName=="身份证"){
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
				} */
				if(licName=="餐饮服务许可证"){
					$("#img6").attr("src",list[i].licPic);
				}
				/* if(licName=="食品经营许可证"){
					$("#img7").attr("src",list[i].licPic);
				} */
			}
		}
		$('#updateImage')
				.form(
						{
							url : '${pageContext.request.contextPath}/corporateController/alterImage',
							onSubmit : function() {

								parent.$.messager.progress({
									title : '提示',
									text : '数据处理中，请稍后....'
								});
								var isValid = $(this).form('validate');
								if (!isValid) {
									parent.$.messager.progress('close');
								}

								return isValid;
							},
							success : function(result) {
								parent.$.messager.progress('close');
								result = $.parseJSON(result);

								if (result.success) {
									window.parent.document.getElementById('indexContext').src="${pageContext.request.contextPath}/corporateController/manager";
									parent.$.modalDialog.handler.dialog('close'); 
								} else {
									parent.$.messager.alert('错误', result.msg,
											'error');
								}
							}
						});

	});
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false" title=""
		style="overflow-x: hidden; overflow-y: auto;">
		<form id="updateImage" method="post" enctype="multipart/form-data">
				<table class="table table-hover table-condensed">
				<%-- <tr>
					<th colspan="2">企业三证</th>
				</tr>
				<tr>
					<th class="text-license">工商营业执照</th>
					<td><input type="file" name="imgUrl1" id="imgUrl1"
						accept="image/*" /></td>
					<th class="text-license">组织机构代码</th>
					<td><input type="file" name="imgUrl2" id="imgUrl2"
						accept="image/*" /></td>
				</tr>
				<tr>
					<td colspan="2"><img id="img1"  width="150px" height="150px" src="${pageContext.request.contextPath}/icon/150x150.png"></img></td>
					<td colspan="2"><img id="img2"   width="150px" height="150px" src="${pageContext.request.contextPath}/icon/150x150.png"></img></td>
				</tr>
				<tr>
					<th class="text-license">税务登记证</th>
					<td><input type="file" name="imgUrl3" id="imgUrl3"
						accept="image/*" /></td>
				</tr>
				<tr>
					<td colspan="2"><img id="img3"  width="150px" height="150px" src="${pageContext.request.contextPath}/icon/150x150.png"></img ></td>
				</tr>
				<tr>
					<th colspan="2">法定代表人/负责人/业主证件</th>
				</tr>
				<tr>
					<th class="text-license">身份证</th>
					<td><input type="file" name="imgUrl8" id="imgUrl8"
						accept="image/*" /></td>
					<th class="text-license">港澳居民来往内地通行证</th>
					<td><input type="file" name="imgUrl9" id="imgUrl9"
						accept="image/*" /></td>
				</tr>
				<tr>
					<td colspan="2"><img id="img8"  width="150px" height="150px" src="${pageContext.request.contextPath}/icon/150x150.png"></img></td>
					<td colspan="2"><img id="img9"   width="150px" height="150px" src="${pageContext.request.contextPath}/icon/150x150.png"></img></td>
				</tr>
				<tr>
					<th class="text-license">台湾居民往来内地通行证</th>
					<td><input type="file" name="imgUrl10" id="imgUrl10"
						accept="image/*" /></td>
				</tr>
				<tr>
					<td colspan="2"><img id="img10"  width="150px" height="150px" src="${pageContext.request.contextPath}/icon/150x150.png"></img></td>
				</tr>
				<tr>
					<th>许可证</th>
					<th></th>
				</tr>
				<tr>
					<th class="text-license">食品流通许可证</th>
					<td><input type="file" name="imgUrl4" id="imgUrl4"
						accept="image/*" /></td>
					<th class="text-license">食品生产许可证</th>
					<td><input type="file" name="imgUrl5" id="imgUrl5"
						accept="image/*" /></td>
				</tr>
				<tr>
					<td colspan="2"><img id="img4"  width="150px" height="150px" src="${pageContext.request.contextPath}/icon/150x150.png"></img></td>
					<td colspan="2"><img id="img5"  width="150px" height="150px"  src="${pageContext.request.contextPath}/icon/150x150.png"></img></td>
				</tr>
				<tr>
					<th class="text-license">餐饮服务许可证</th>
					<td><input type="file" name="imgUrl6" id="imgUrl6"
						accept="image/*" /></td>
					<th class="text-license">食品经营许可证</th>
					<td><input type="file" name="imgUrl7" id="imgUrl7"
						accept="image/*" /></td>
				</tr>
				<tr>
					<td colspan="2"><img id="img6" width="150px" height="150px" src="${pageContext.request.contextPath}/icon/150x150.png"></img></td>
					<td colspan="2"><img id="img7"   width="150px" height="150px" src="${pageContext.request.contextPath}/icon/150x150.png"></img></td>
				</tr>
				<tr>
					<th>其他</th>
					<th></th>
				</tr>
				<tr>
					<th class="text-license">其他</th>
					<td><input type="file" name="imgUrl11" id="imgUrl11"
						accept="image/*" /></td>
				</tr>
				<tr>
					<td colspan="2"><img id="img11"   width="150px" height="150px" src="${pageContext.request.contextPath}/icon/150x150.png"></img></td>
				</tr> --%>
				
				<tr>
					<th class="text-license">餐饮服务许可证</th>
					<td><input type="file" name="imgUrl6" id="imgUrl6"
						accept="image/*" /></td>
				</tr>
				<tr>
					<td colspan="2"><img id="img6"   width="150px" height="150px" src="${pageContext.request.contextPath}/icon/150x150.png"></img></td>
				</tr>
				<tr>
					<th class="text-license">工商营业执照</th>
					<td><input type="file" name="imgUrl1" id="imgUr1"
						accept="image/*" /></td>
				</tr>
				<tr>
					<td colspan="2"><img id="img1"   width="150px" height="150px" src="${pageContext.request.contextPath}/icon/150x150.png"></img></td>
				</tr>
			</table>
		</form>
	</div>

</div>

