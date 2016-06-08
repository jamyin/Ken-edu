<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<style>
.panel-body {
	font-size: 18px !important;
	
}
.table th, .table td {
    border-top: none!important;
}
.panel-body.panel-body-noheader.panel-body-noborder.layout-body {
	padding:20px!important;
}
</style>
<style>
.panel-body {
	font-size: 18px !important;
}
</style>
<script type="text/javascript">


$(function() {
	
	var proLicenseList= '<%=request.getAttribute("ProLicenseList")%>';
	var list = JSON.parse(proLicenseList);
	for(var i in list){
		var licName=list[i].licName;
		if(licName=="商品图片"){
			$("#img1_8").removeAttr("hidden");
			$("#img1").attr("src",list[i].licPic);
		}
	
		if(licName=="检测检验报告"){
			$("#img2_9").removeAttr("hidden");
			$("#img2").attr("src",list[i].licPic);
		}
		
		if(licName=="生产许可证"){
			$("#img3_10").removeAttr("hidden");
			$("#img3").attr("src",list[i].licPic);
		}
	
		
	}


		$('#updateImage').form(
						{			
							url : '${pageContext.request.contextPath}/waresController/alterImage',
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
									
									//$("#projectForm").submit();
									
									parent.$.modalDialog.openner_dataGrid
											.datagrid('reload');//之所以能在这里调用到parent.$.modalDialog.openner_dataGrid这个对象，是因为user.jsp页面预定义好了
									parent.$.modalDialog.handler
											.dialog('close');
								} else {
									parent.$.messager.alert('错误', result.msg,
											'error');
								}
							}
						});
	
	});

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

</script>
		<div class="easyui-layout" data-options="fit:true,border:false">
		<%-- 	<div data-options="region:'center',border:false" title=""
				style="overflow: hidden;">
				<form id="updateImage" method="post"  enctype="multipart/form-data">
				   <input id="id" name="id" type="hidden" value="${id}" />
				   <c:forEach  var="list"  items="${ProLicenseList}">
					<table>
							<tr>			
							<td>商品图片</td>
								<td><input type="file" name="spImgUrl"  id="spImgUrl"  accept="image/*" />	</td>	
							<c:if test="${list.licName=='商品图片' }"> 
									<td><img  src="${list.licPic }"  width="150px" height="150px"></td>
									</c:if>
									</tr>
					
					<tr>		<td>检测检验报告</td>
							<td><input type="file" name="jcImgUrl"  id="jcImgUrl"  accept="image/*" /></td>
								<c:if test="${list.licName=='检测检验报告' }"> 
									<td><img  src="${list.licPic }"   width="150px" height="150px"></td>
									</c:if>
							
								</tr>
							<tr><td>	生产许可证</td>
							<td>	<input type="file" name="scImgUrl"  id="jcImgUrl"  accept="image/*" /></td>	
								<c:if test="${list.licName=='生产许可证' }"> 
									<td><img  src="${list.licPic }"    width="150px" height="150px"></td>
									</c:if>
							
							</tr>
						
		
			</table>
			</c:forEach>
				</form> --%>
				
				<div data-options="region:'center',border:false" title=""
		style="overflow-x: hidden; overflow-y: auto;">
		<form id="updateImage" method="post" enctype="multipart/form-data">
		   <input id="id" name="id" type="hidden" value="${id}" />
			<table class="table table-hover table-condensed">
	
				<tr>
					<th>商品图片</th>
					<td><input type="file" name="spImgUrl" id="spImgUrl"
						accept="image/*" /></td>
				
				</tr>
				<tr  id="img1_8">
					<td colspan="2"><img id="img1"   width="150px" height="150px"  src="${pageContext.request.contextPath}/icon/图片未上传200x200.png"></img></td>
					
				</tr>
				<tr>
					<th>检测检验报告</th>
					<td><input type="file" name="jcImgUrl" id="jcImgUrl"
						accept="image/*" /></td>
				
				</tr>
				<tr  id="img2_9">
					<td colspan="2"><img id="img2"   width="150px" height="150px"  src="${pageContext.request.contextPath}/icon/图片未上传200x200.png"></img></td>
				
				</tr>
				<tr>
					<th>生产许可证</th>
					<td><input type="file" name="scImgUrl" id="scImgUrl"
						accept="image/*" /></td>
				
				</tr>
				<tr  id="img3_10">
					<td colspan="2"><img id="img3"  width="150px" height="150px" src="${pageContext.request.contextPath}/icon/图片未上传200x200.png"></img></td>
				
				</tr>
			
			</table>

		</form>
	</div>
				
				
			</div>

		</div>

