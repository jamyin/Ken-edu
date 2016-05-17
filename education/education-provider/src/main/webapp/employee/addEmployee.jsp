<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">

	$(function() {
		parent.$.messager.progress('close');


		$('#form')
				.form(
						{
							url : '${pageContext.request.contextPath}/employeeController/insertEmployee',
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
				<form id="form" method="post"  >
				   <input id="id" name="id" type="hidden" value="${id}" />
					<table class="table table-hover table-condensed">
						<tr>

							<th>姓名</th>
							<td><input name="name" type="text" id="name"
								placeholder="请输入员工姓名" class="easyui-validatebox span2"
								data-options="required:true" ></td>
							<th>性别</th>
							<td><select id="gender" class="easyui-combobox" name="gender"  data-options="width:140,height:29,editable:false,panelHeight:'auto'"
								data-options="required:true">
							    <option value="1">男</option>   
							    <option value="2">女</option>   							       							  
							</select></td>

						</tr>
						<tr>
						<th>身份证类型</th>
							<td><select id="idType" class="easyui-combobox" name="idType"  data-options="width:140,height:29,editable:false,panelHeight:'auto'"
								data-options="required:true">
							    <option value="1">居民身份证</option>   
							    <option value="2">护照</option>   
							    <option value="3">台湾居民来往大陆通行证</option>   							  
							    <option value="4">港澳居民来往内陆通行证</option>   							  
							    <option value="5">外国人居留证</option>   							  
							</select></td>
							<th>身份证件号码</th>
							<td><input name="idCode" type="text" placeholder="请输入身份证件号码" id="idCode"
								class="easyui-validatebox span2" ></td>						
						</tr>
						
						<tr>
						<th>手机号</th>
							<td><input name="mobile" type="text" placeholder="请输入手机号" id="mobile"
								class="easyui-validatebox span2" ></td>
							<th>商品分类</th>
							<td><select id="position" class="easyui-combobox" name="position"  data-options="width:140,height:29,editable:false,panelHeight:'auto'"
								data-options="required:true">
							    <option value="1">厨师长</option>   
							    <option value="2">负责人</option>   
							    <option value="3">食品安全管理人员（专职）</option>   
							    <option value="4">食品安全管理人员（兼职）</option>   
							    <option value="5">原料采购人员</option>   
							    <option value="6">分餐人员</option>   
							    <option value="7">专间操作人员</option>   
							    <option value="8">餐饮具消毒人员</option>   
							    <option value="9">餐饮主管人员</option>   
							    <option value="10">厨师</option>   							     
							    <option value="11">其他</option>   
							</select> </td>
							
						</tr>
						<tr>
							<th>工号</th>
							<td><input name="workNum" type="text" placeholder="请输入工号" id="workNum"
								class="easyui-validatebox span2" ></td>
							<th>健康证号码</th>
							<td><input name="healthCode" type="text" placeholder="请输入工号" id="healthCode"
								class="easyui-validatebox span2" ></td>
						</tr>
						<tr>
							<th>企业自定义代码</th>
						    <td><input name="customCode" type="text" placeholder="请输入自定义代码" id="customCode"
								class="easyui-validatebox span2" ></td>
							<th>产地</th>
							<td><input name="place" type="text" id="place"
								placeholder="请输入产地" class="easyui-validatebox span2"
								></td>
						</tr>
						<tr>
							<th>英文名</th>
							<td>	<input name="enName" type="text" id="enName"
								placeholder="请输入英文名" class="easyui-validatebox span2"
								></td>
							<th>条形码</th>
							<td><input name="barCode" type="text" id="barCode"
								placeholder="请输入条形码" class="easyui-validatebox span2"
								></td>
								
						</tr>					
					</table>
			
				</form>
			</div>

		</div>

