<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript">

	$(function() {
		parent.$.messager.progress('close');
		$('#formEdit').form(
						{																	
							url : '${pageContext.request.contextPath}/waresController/updateWares',
							onSubmit : function() {
								var isValid = $(this).form('validate');
								var error_message = '';
							    var userAccount = $("#waresName").val();
								if(userAccount==''){
									error_message=error_message + '商品名称不能为空,';
								}
								var name = $("#spec").val();
								if(name==''){
									error_message = error_message +'商品规格不能为空,'; 
								}
								
								var userNo = $("#shelfLife").val();
								if(userNo==''){
									error_message = error_message +'商品保质期不能为空,'; 
								}
								
								var age = $("#unit").val();
								if(age==''){
									error_message = error_message +'单位不能为空,'; 
								}
								
								
							
								if(error_message!=''){
									parent.$.messager.alert('错误', error_message.substring(0, error_message.length-1), 'error');
									isValid=false;
								}
								
								parent.$.messager.progress({
									title : '提示',
									text : '数据处理中，请稍后....'
								});
								
								if (!isValid) {
									parent.$.messager.progress('close');
								}
								
								return isValid;
							},
							success : function(result) {
								parent.$.messager.progress('close');
								result = $.parseJSON(result);
								console.log(result);
								if (result.success) {
									parent.$.modalDialog.openner_dataGrid
											.datagrid('reload');//之所以能在这里调用到parent.$.modalDialog.openner_dataGrid这个对象，
									parent.$.modalDialog.handler
											.dialog('close');
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
				style="overflow: hidden;">
				<form id="formEdit" method="post" >
				   <input id="id" name="id" type="hidden" value="${id}" />
					<table class="table table-hover table-condensed">
						<tr>
							<th>商品名称</th>
							<td><input name="waresName" type="text" id="waresName"
								placeholder="请输入商品名称" class="easyui-validatebox span2"
								data-options="required:true"  value="${wdto.waresName}"></td>
							<th>规格</th>
							<td><input name="spec" type="text" placeholder="请输入规格"  id="spec"
								class="easyui-validatebox span2"  value="${wdto.spec}"></td>
						</tr>
						<tr>
							<th>保质期</th>
							<td><input name="shelfLife" type="text" placeholder="请输入保质期" id="shelfLife"
								class="easyui-validatebox span2" data-options="required:true" value="${wdto.shelfLife}"></td>
							<th>保质期单位</th>
							<td><input name="unit" type="text" placeholder="请输入单位" id="unit"
								class="easyui-validatebox span2" data-options="required:true" value="${wdto.unit}"></td>
						</tr>
						<tr>
							<th>供应商名称</th>
							<td><input name="supplierName" type="text" placeholder="请输入供应商名称" id="supplierName"
								class="easyui-validatebox span2" data-options="required:true" value="${wdto.supplierName}"></td>
							<th>商品方向</th>
							<td><select name="way" class="easyui-combobox" id="way"
								data-options="width:140,height:29,editable:false,panelHeight:'auto'"
								data-options="required:true"><option value="0">采购品</option>
									<option value="1">产出品</option></select></td>
						</tr>
						<tr>
							<th>企业自定义代码</th>
						    <td><input name="customCode" type="text" placeholder="请输入自定义代码" id="customCode"
								class="easyui-validatebox span2" data-options="required:true" value="${wdto.customCode}"></td>
							<th>产地</th>
							<td><input name="place" type="text" id="place"
								placeholder="请输入产地" class="easyui-validatebox span2"
								data-options="required:true" value="${wdto.place}"></td>
						</tr>
						<tr>
							<th>条形码</th>
							<td><input name="barCode" type="text" id="barCode"
								placeholder="请输入条形码" class="easyui-validatebox span2"
								data-options="required:true" value="${wdto.barCode}"></td>
							<th>是否是菜肴</th>
							<td><select name="dishes" class="easyui-combobox" id="dishes"
								data-options="width:140,height:29,editable:false,panelHeight:'auto'" 
								data-options="required:true">
								<c:if test="${wdto.dishes==true}">
									<option value="0">否</option></c:if>
				                <c:if test="${wdto.dishes==false}"><option value="0">是</option>
									</c:if></select>
								
									</td>
										
							
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
