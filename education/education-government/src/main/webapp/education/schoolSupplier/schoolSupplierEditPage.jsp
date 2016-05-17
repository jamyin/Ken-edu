<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	$(function() {
		parent.$.messager.progress('close');
		$('#form')
				.form(
						{
							url : '${pageContext.request.contextPath}/schoolSupplierController/updateSchoolSupplier',
							onSubmit : function() {
								/*var age = $("#age").val();
								if(age==''||isNaN(age)){
									parent.$.messager.alert('错误', '年龄必须为数字', 'error');
								}
								var depts*/
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

	jQuery.ajax({
		url : '${pageContext.request.contextPath}/projectController/findAll',
		type : 'POST',
		dataType : 'json',
		async : false,
		success : function(data) {
			var myObject = data;
			//var a= "<option value=\'-1\'>请选择</option>";
			var pid = $("#pid").val();
			
			var a = '';
			for (var i = 0; i < myObject.length; i++) {
				if(myObject[i].id==pid){
					a += "<option value=\'"+myObject[i].id+"\' selected>"
					+ myObject[i].projName + "</option>";
				}else{
					a += "<option value=\'"+myObject[i].id+"\'>"
					+ myObject[i].projName + "</option>";	
				}
				console.log(a);
			}
			$("#projId").html(a);
			initDept(myObject[0].id);
		}
	});
 
	
	
</script>
		<div class="easyui-layout" data-options="fit:true,border:false">
			<div data-options="region:'center',border:false" title=""
				style="overflow: hidden;">
				<form id="form" method="post">
				<input id="pid" name="pid"  type="hidden" value="${schoolSuppDto.projId}" />
				<input id="id" name="id" type="hidden" value="${schoolSuppDto.id}"/>
					<table class="table table-hover table-condensed">
						<tr>
							  <th>项目</th>
						      <td><select id="projId" name="projId"   data-options="editable:false" class="easyui-validatebox span2" ></select>
							  </td>
							<th>供应商名称</th>
							<td><input name="supplierName" type="text" placeholder="请输入供应商名称"  id="supplierName" value="${schoolSuppDto.supplierName}"
								class="easyui-validatebox span2"></td>

						</tr>
						<tr>
							<th>供应商地址</th>
							<td><input name="supplierAddress" type="text" placeholder="请输入供应商地址" id="supplierAddress" value="${schoolSuppDto.supplierAddress}"
								class="easyui-validatebox span2" data-options="required:true"></td>
							<th>餐饮许可证</th>
							<td><input name="foodLicense" type="text" placeholder="请输入餐饮许可证" id="foodLicense" value="${schoolSuppDto.foodLicense}"
								class="easyui-validatebox span2" data-options="required:true"></td>
						</tr>
						<tr>
							<th>工商营业执照</th>
							<td><input name="businessLicense" type="text" placeholder="请输入工商营业执照" id="businessLicense" value="${schoolSuppDto.businessLicense}"
								class="easyui-validatebox span2" data-options="required:true"></td>
							<th>法人代表</th>
							<td><input name="corporation" type="text" placeholder="请输入法人代表" id="corporation" value="${schoolSuppDto.corporation}"
								class="easyui-validatebox span2" data-options="required:true"></td>
						</tr>
						<tr>
							<th>联系方式</th>
						    <td><input name="contactWay" type="text" placeholder="请输入联系方式" id="contactWay" value="${schoolSuppDto.contactWay}"
								class="easyui-validatebox span2" data-options="required:true"></td>
							<th>&nbsp;</th>
							<td>&nbsp;</td>
						</tr>
					</table>
				</form>
			</div>

		</div>

<div id="toolbar" style="display: none;">

	<div style="height: 2px;"></div>

	<a onclick="redos();" href="javascript:void(0);"
		class="easyui-linkbutton"
		data-options="plain:true,iconCls:'resultset_next'">展开</a> <a
		onclick="undos();" href="javascript:void(0);"
		class="easyui-linkbutton"
		data-options="plain:true,iconCls:'resultset_previous'">折叠</a>
</div>
