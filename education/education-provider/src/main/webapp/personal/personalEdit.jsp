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
							url : '${pageContext.request.contextPath}/userController/editMy',
							onSubmit : function() {
								var isValid = $(this).form('validate');
								var error_message = '';
							  
								
								
								
							
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
				   <input id="password" name="password" type="hidden" value="${user.password}" />
					<table class="table table-hover table-condensed">
						<tr>
							<th>姓名</th>
							<td><input name="name" type="text" id="name"
								placeholder="请输入姓名" class="easyui-validatebox span2"
								data-options="required:true"  value="${user.name}"></td>
							<th>用户名</th>
							<td><input name="userAccount" type="text" placeholder="请输入用户名"  id="userAccount"
								class="easyui-validatebox span2"  value="${user.userAccount}"></td>
						</tr>
						
						
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
<!-- <script type="text/javascript">
$(function(){
	$("td,th").css("vertical-align","middle");
	$('td input').css("margin-top","8px");
	$('table tr:first:child td').css("border-top","none");
});
</script>
 -->
