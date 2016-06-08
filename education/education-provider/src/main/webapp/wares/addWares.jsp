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

							<th>*商品名称</th>
							<td><input name="waresName" type="text" id="waresName"
								placeholder="请输入商品名称" class="easyui-validatebox span2"
								data-options="required:true" ></td>
							<th>*规格</th>
							<td><input name="spec" type="text" placeholder="请输入规格"  id="spec"
								class="easyui-validatebox span2"  data-options="required:true"></td>

						</tr>
						<tr>
							<th>*保质期</th>
							<td><input name="shelfLife" type="text" placeholder="请输入保质期" id="shelfLife"
								class="easyui-validatebox span2"  data-options="required:true" ></td>
							<th>*保质期单位</th>
							<td><select id="unit" class="easyui-combobox" name="unit"  data-options="width:140,height:29,editable:false,panelHeight:'auto'"
								data-options="required:true">
							    <option value="年">年</option>   
							    <option value="月">月</option>   
							    <option value="日">日</option>   							  
							    <option value="小时">小时</option>   							  
							</select></td>
						</tr>
						
						<tr>
							<th>产品编码</th>
						    <td><input name="customCode" type="text" placeholder="请输入自定义代码" id="customCode"
								class="easyui-validatebox span2" ></td>
							<th>产地</th>
							<td><input name="place" type="text" id="place"
								placeholder="请输入产地" class="easyui-validatebox span2"
								></td>
						</tr>
						<tr>
						<th>生产企业</th>
							<td><input name="manufacturer" type="text" placeholder="请输入供应商名称" id="manufacturer"
								class="easyui-validatebox span2" ></td>
							<th>*商品分类</th>
							<td><select id="waresType" class="easyui-combobox" name="waresType"  data-options="width:140,height:29,editable:false,panelHeight:'auto'"
								data-options="required:true">
								<option value="">请选择商品分类</option>
							    <option value="1">畜产品及其制品</option>   
							    <option value="2">禽及其产品、制品</option>   
							    <option value="3">蔬菜</option>   
							    <option value="4">乳及乳制品</option>   
							    <option value="5">油脂及其制品</option>   
							    <option value="6">水产及其制品</option>   
							    <option value="7">冷冻饮品</option>   
							    <option value="8">水果</option>   
							    <option value="9">粮食和粮食制品</option>   
							    <option value="10">豆类及其制品</option>   
							    <option value="11">食用菌和藻类</option>   
							    <option value="12">可可和巧克力制品及糖果</option>   
							    <option value="13">焙烤食品</option>   
							    <option value="14">甜味料</option>   
							    <option value="15">调味品</option>   
							    <option value="16">特殊膳食用食品</option>   
							    <option value="17">饮料类</option>   
							    <option value="18">酒类</option>   
							    <option value="19">添加剂类</option>   
							    <option value="20">其他类</option>   
							</select> </td>
							
						</tr>
						<tr>
							<th>英文名</th>
							<td>	<input name="enName" type="text" id="enName"
								placeholder="请输入英文名" class="easyui-validatebox span2"
								></td>
							<th>产品包装条形码</th>
							<td><input name="barCode" type="text" id="barCode"
								placeholder="请输入条形码" class="easyui-validatebox span2"
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
</script> -->
