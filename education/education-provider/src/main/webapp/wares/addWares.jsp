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
.textbox .textbox-text {
	 cursor:pointer;
}
</style>

<script type="text/javascript">

	$(function() {
		parent.$.messager.progress('close');


		$('#form')
				.form(
						{
							url : '${pageContext.request.contextPath}/waresController/insertWares',
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
		<div class="easyui-layout" data-options="fit:true,border:false"  >
			<div data-options="region:'center',border:false" title=""
				style="padding:20px;">
				<form id="form" method="post"  >
				   <input id="id" name="id" type="hidden" value="${id}" />
					<table class="table table-hover table-condensed"  >
						<tr>

							<th><font color="red">*</font>原料名称</th>
							<td><input name="waresName" type="text" id="waresName"
								placeholder="请输入商品名称" class="easyui-validatebox span2"
								data-options="required:true" ></td>
							<th><font color="red">*</font>数量单位</th>
						    <td><input name="amountUnit" type="text" placeholder="数量单位" id="amountUnit"
								class="easyui-validatebox span2"  data-options="required:true"></td>

						</tr>
					
						
						<tr>
						<th>规格</th>
							<td><input name="spec" type="text" placeholder="请输入规格"  id="spec"
								class="easyui-validatebox span2"  ></td>
						
							<th>产地</th>
							<td><input name="place" type="text" id="place"
								placeholder="请输入产地" class="easyui-validatebox span2"
								></td>
						</tr>
							<tr>
							<th><font color="red">*</font>保质期</th>
							<td><input name="shelfLife" type="text" placeholder="请输入保质期" id="shelfLife"
								class="easyui-validatebox span2"  data-options="required:true" ></td>
							<th><font color="red">*</font>保质期单位</th>
							<td><select id="unit" class="easyui-combobox" name="unit"  data-options="width:140,height:29,editable:false,panelHeight:'auto'"
								data-options="required:true">
								<option value="">请选择保质期单位</option>
							    <option value="年">年</option>   
							    <option value="月">月</option>   
							    <option value="日">日</option>   							  
							    <option value="小时">小时</option>   							  
							</select></td>
						</tr>
						<tr>
						<th><font color="red">*</font>生产企业</th>
							<td><input name="manufacturer" type="text" placeholder="请输入供应商名称" id="manufacturer"
								class="easyui-validatebox span2" data-options="required:true" ></td>
							<th><font color="red">*</font>原料分类</th>
							<td><select id="waresType" class="easyui-combobox" name="waresType"  data-options="width:140,height:29,editable:false,panelHeight:'auto'"
								data-options="required:true">
								<option value="">请选择原料分类</option>
							    <option value="1">粮食及其制品</option>   
							    <option value="2">畜产品及其制品</option>   
							    <option value="3">禽及其产品、制品</option>   
							    <option value="4">蔬菜</option>   
							    <option value="5"> 水果</option>   
							    <option value="6">水产品</option>   
							    <option value="7">豆制品</option>   
							    <option value="8">乳品</option>   
							    <option value="9">食用油</option>   
							    <option value="10">其它类别的食品和食用农产品</option>     
							</select> </td>
							
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
</script> -->
