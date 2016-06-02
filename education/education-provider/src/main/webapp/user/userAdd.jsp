<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.panel-body {
	font-size: 18px !important;
}
.table th, .table td {
    border-top: none!important;
}
</style>
<script type="text/javascript">

	$(function() {
		parent.$.messager.progress('close');


		$('#form')
				.form(
						{
							url : '${pageContext.request.contextPath}/userController/add',
						 
							
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
				 
					<table class="table table-hover table-condensed">
						<tr>

							<th>*姓名</th>
							<td><input name="name" type="text" id="name"
								placeholder="请输入姓名" class="easyui-validatebox span2"
								data-options="required:true" ></td>
							<th>*用户名</th>
							<td>
							<input name="userAccount" type="text" placeholder="请输入用户名"  id="userAccount"
								class="easyui-validatebox span2"  data-options="required:true"></td>

						</tr>
						<tr>
							<th>密码</th>
							<td><input name="password" type="password" placeholder="请输入密码" id="password"
								class="easyui-validatebox span2" ></td>
								<th>确认密码</th>
							<td><input name="password2" type="password" placeholder="请确认密码" id="password2"
								class="easyui-validatebox span2" ></td>
							
						</tr>
						<tr>
						<th>*账户权限</th>
						<td>
						<label><input id ="guanliyuan"  name="userType" type="radio" value="0"  data-options="required:true"/>管理员 </label> </td>
						<td>
						<label><input  id ="jiashiyuan"   name="userType" type="radio" value="1"  data-options="required:true"/>驾驶员</label> 
						</td>
						</tr>
						<tr>
							<th>手机</th>
						    <td><input name="userNo" type="text" placeholder="请输入手机号" id="userNo"
								class="easyui-validatebox span2" ></td>
							<th>邮箱</th>
							<td><input name="email" type="text" id="email"
								placeholder="请输入邮箱" class="easyui-validatebox span2"
								></td>
						</tr>
										
					</table>
			
				</form>
			</div>

		</div>
<script type="text/javascript">
$(function(){
	$("td,th").css("vertical-align","middle");
	$('td input').css("margin-top","8px");
	$('table tr:first:child td').css("border-top","none");
});
</script>
