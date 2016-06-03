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
<script type="text/javascript">

	$(function() {
		parent.$.messager.progress('close');
		$('#formEdit').form(
						{																	
							url : '${pageContext.request.contextPath}/userController/edit',
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
				   <input id="id" name="id" type="hidden" value="${user.id}" />
					<table class="table table-hover table-condensed">
						<tr>
							<th>*姓名</th>
							<td><input name="name" type="text" id="name"
								placeholder="请输入姓名" class="easyui-validatebox span2"
								data-options="required:true"  value="${user.name}"></td>
							<th>*用户名</th>
							<td><input name="userAccount" type="text" placeholder="请输入用户名"  id="userAccount"  data-options="required:true"
								class="easyui-validatebox span2"  value="${user.userAccount}"></td>
						</tr>
							<tr>
							<th>密码</th>
							<td><input name="password" type="password" id="password"
								placeholder="请输入密码" class="easyui-validatebox span2"   hidden="${user.password}"   value="${user.password}"
								 ></td>
							<th>确认密码</th>
							<td><input name="password2" type="password" placeholder="请确认密码"  id="password2"  hidden="${user.password}" value="${user.password}"
								class="easyui-validatebox span2"  ></td>
						</tr>
						<c:if test="${user.isAdmin==0}">
							<tr>
							<th>*账户权限</th>
								
								<c:if test="${user.userType=='0'}">
								<td>
								<label><input name="userType" type="radio"  id="userType0"  value="0"  checked="checked"/>管理员 </label> </td>
								<td>
								<label><input name="userType" type="radio"  id="userType1"  value="1"  />驾驶员</label> 
								</td>
								</c:if>
								<c:if test="${user.userType=='1'}">
								<td>
								<label><input name="userType" type="radio"  id="userType0"  value="0"  />管理员 </label> </td>
								<td>
								<label><input name="userType" type="radio"  id="userType1"  value="1"  checked="checked"/>驾驶员</label> </td>
								</c:if>
						</tr>
						</c:if>
						<tr>
							<th>手机</th>
						    <td><input name="userNo" type="text" placeholder="请输入手机号" id="userNo"
								class="easyui-validatebox span2"  value="${user.userNo}"></td>
							<th>邮箱</th>
							<td><input name="email" type="text" id="email"
								placeholder="请输入邮箱" class="easyui-validatebox span2" value="${user.email}"
								></td>
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
<!-- <script type="text/javascript">
$(function(){
	$("td,th").css("vertical-align","middle");
	$('td input').css("margin-top","8px");
	$('table tr:first:child td').css("border-top","none");
});
</script> -->
