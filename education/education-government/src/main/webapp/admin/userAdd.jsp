<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	$(function() {
		parent.$.messager.progress('close');
		$('#form').form({
			url : '${pageContext.request.contextPath}/userController/add',
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
					parent.$.modalDialog.openner_dataGrid.datagrid('reload');//之所以能在这里调用到parent.$.modalDialog.openner_dataGrid这个对象，是因为user.jsp页面预定义好了
					parent.$.modalDialog.handler.dialog('close');
				} else {
					parent.$.messager.alert('错误', result.msg, 'error');
				}
			}
		});
	});
	
	


	

	
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false" title="" style="overflow: hidden;">
		<form id="form" method="post">
			<table class="table table-hover table-condensed">
				<tr>
					<th>编号</th>
					<td><input name="id" type="text" class="span2" value="${user.id}" readonly="readonly"></td>
					<th>登录名称</th>
					<td><input name="userAccount" type="text" placeholder="请输入登录名称" class="easyui-validatebox span2" data-options="required:true" value=""></td>
				</tr>
				
				<tr>
					<th>员工姓名</th>
					<td><input name="name" type="text" placeholder="请输入员工姓名" class="easyui-validatebox span2" data-options="required:true"></td>
					<th>员工编号</th>
					<td><input name="userNo" type="text" placeholder="请输入员工编号" class="easyui-validatebox span2" data-options="required:true" ></td>
				</tr>
				<tr>
				<th>年龄</th>
					<td><input name="age" type="text" placeholder="请输入年龄" class="easyui-validatebox span2" data-options="required:true" ></td>
					<th>性别</th>
				<td><select name="gender" class="easyui-combobox"  data-options="width:140,height:29,editable:false,panelHeight:'auto'"  data-options="required:true"><option value="1">男</option><option value="2">女</option></select></td>
				</tr>
				<tr>
				<th>邮箱</th>
					<td><input name="email" type="text" placeholder="请输入邮箱" class="easyui-validatebox span2"  ></td>
			    <th>密码</th>
					<td><input name="password" type="password" placeholder="请输入密码" class="easyui-validatebox span2" data-options="required:true"></td>
				</tr>
			</table>
		</form>
	</div>
</div>