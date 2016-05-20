<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	$(function() {
		parent.$.messager.progress('close');
		$('#form').form({
			url : '${pageContext.request.contextPath}/recycleOilControllor/saveRecycleOil',
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
		<form id="form" method="post" enctype="multipart/form-data">
			<table class="table table-hover table-condensed">
				<tr>
					<th>编号</th>
					<td><input name="id" type="text" class="span2"></td>
					<th>回收商</th>
					<td><input name="recycler" type="text" placeholder="回收商" class="easyui-validatebox span2" value="${Recycle }" data-options="required:true" readonly="readonly"></td>
				</tr>
				<tr>
					<th>回收日期</th>
					<td><input name="recycleDate" type="text" placeholder="点击选择日期" class="easyui-validatebox span2" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly"></td>
					<th>回收种类</th>
					<td><input name="type" type="text" placeholder="请输入回收种类" class="easyui-validatebox span2" data-options="required:true" ></td>
				</tr>
				<tr>
					<th>回收数量</th>
					<td><input name="amount" type="text" placeholder="请输入回收数量" class="easyui-validatebox span2" data-options="required:true" ></td>
					<th>回收人</th>
						<td><input name="recyclerName" type="text" placeholder="请输入回收人" class="easyui-validatebox span2" data-options="required:true" ></td>
				
				</tr>
				<tr>
					<th>单据</th>
						<td><input name="oilDocumentUrl" type="file" placeholder="请选择单据" class="easyui-validatebox span2" data-options="required:true" ></td>
				</tr>
			</table>
		</form>
	</div>
</div>