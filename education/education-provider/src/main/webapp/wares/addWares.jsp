<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	var projectTree;
	var dept_id;
	$(function() {
		parent.$.messager.progress('close');


		$('#form')
				.form(
						{
							url : '${pageContext.request.contextPath}/waresController/insertWares?id='+$("#id").val(),
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


		
		
	
	
	


	
	
</script>
		<div class="easyui-layout" data-options="fit:true,border:false">
			<div data-options="region:'center',border:false" title=""
				style="overflow: hidden;">
				<form id="form" method="post">
				   <input id="id" name="id" type="hidden" value="${id}" />
					<table class="table table-hover table-condensed">
						<tr>

							<th>商品名称</th>
							<td><input name="waresName" type="text" id="userAccount"
								placeholder="请输入商品名称" class="easyui-validatebox span2"
								data-options="required:true" ></td>
							<th>规格</th>
							<td><input name="spec" type="text" placeholder="请输入邮箱"  id="email"
								class="easyui-validatebox span2"></td>

						</tr>
						<tr>
							<th>保质期</th>
							<td><input name="shelfLife" type="text" placeholder="请输入员工姓名" id="name"
								class="easyui-validatebox span2" data-options="required:true"></td>
							<th>保质期单位</th>
							<td><input name="unit" type="text" placeholder="请输入员工编号" id="userNo"
								class="easyui-validatebox span2" data-options="required:true"></td>
						</tr>
						<tr>
							<th>供应商名称</th>
							<td><input name="supplierName" type="text" placeholder="请输入年龄" id="age"
								class="easyui-validatebox span2" data-options="required:true"></td>
							<th>商品方向</th>
							<td><select name="way" class="easyui-combobox" id="way"
								data-options="width:140,height:29,editable:false,panelHeight:'auto'"
								data-options="required:true"><option value="0">采购品</option>
									<option value="1">产出品</option></select></td>
						</tr>
						<tr>
							<th>企业自定义代码</th>
						    <td><input name="customCode" type="text" placeholder="请输入手机号" id="phone"
								class="easyui-validatebox span2" data-options="required:true"></td>
							<th>产地</th>
							<td><input name="place" type="text" id="place"
								placeholder="请输入产地" class="easyui-validatebox span2"
								data-options="required:true"></td>
						</tr>
						<tr>
							<th>备注</th>
							<td><input name="remark" type="text" placeholder="请输入年龄" id="remark"
								class="easyui-validatebox span2" data-options="required:true"></td>
							<th>是否是菜肴</th>
							<td><select name="dishes" class="easyui-combobox" id="dishes"
								data-options="width:140,height:29,editable:false,panelHeight:'auto'"
								data-options="required:true"><option value="0">是</option>
									<option value="1">否</option></select></td>
						</tr>
						<tr>
							<th>图片</th>
							<td>	<input type="file" name="imgUrl"  id="imgUrl" onchange="setImagePreview(this,'minImg');" accept="image/*" />	</td>
						
						</tr>
					</table>
			
				</form>
			</div>

		</div>

