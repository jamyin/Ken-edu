<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
   $(function() {
		parent.$.messager.progress('close');

		$('#pid').combotree({
			url : '${pageContext.request.contextPath}/addressController/tree',
			parentField : 'pid',
			lines : true,
			//panelHeight : '100px',
			onLoadSuccess : function() {
				parent.$.messager.progress('close');
			}
		});

		$('#form').form({
			url : '${pageContext.request.contextPath}/addressController/add',
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
					parent.$.modalDialog.openner_treeGrid.treegrid('reload');
					parent.$.modalDialog.handler.dialog('close');

					parent.$.messager.show({
						title : '提示',
						msg : result.msg
					});
				} else {
					parent.$.messager.alert('错误', result.msg, 'error');
				}
			}
		});
	});
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false" title=""
		style="overflow: hidden;">
		<form id="form" method="post">
			<table class="table table-hover table-condensed">
				<tr style="display: none;">
					<th>编号</th>
					<td><input name="id" type="text" class="span2"
						value="${addressDto.id}" readonly="readonly"></td>
				</tr>
				<tr>
					<th>区域名称</th>
					<td><input name="addressName" type="text"
						placeholder="请输入区域名称" class="easyui-validatebox span2"
						data-options="required:true" value=""></td>
				</tr>
				<tr>
					<th>上级区域</th>
					<td><select id="pid" name="pid"
						style="width: 140px; height: 29px;"></select><img
						src="${pageContext.request.contextPath}/style/images/extjs_icons/cut_red.png"
						onclick="$('#pid').combotree('clear');" /></td>
				</tr>
			</table>
		</form>
	</div>
</div>