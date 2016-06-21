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
.textbox .textbox-text {
	 cursor:pointer;
	 width:165px!important;
}
.textbox {
	width:165px!important;
}
</style>

<script type="text/javascript">

	$(function() {
		parent.$.messager.progress('close');
		$('#formEdit').form(
						{																	
							url : '${pageContext.request.contextPath}/waresController/updateWares',
							onSubmit : function() { 
								var isValid = $(this).form('validate');
								var error_message = '';
							    var userAccount = $("#waresName").val();
								if(userAccount==''){
									error_message=error_message + '商品名称不能为空,';
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
		<div class="easyui-layout" data-options="fit:true,border:false" style="padding:20px;">
			<div data-options="region:'center',border:false" title=""
				style="overflow: hidden;">
				<form id="formEdit" method="post" >
				   <input id="id" name="id" type="hidden" value="${id}" />
					<table class="table table-hover table-condensed">
						<tr>
							<th><font color="red">*</font>原料名称</th>
							<td><input name="waresName" type="text" id="waresName"
								placeholder="请输入商品名称" class="easyui-validatebox span2" style="width: 152px;"
								data-options="required:true"  value="${wdto.waresName}"></td>
							<th><font color="red">*</font>数量单位</th>
							<td><input name="amountUnit" type="text" placeholder="请输入数量单位" id="amountUnit"
								style="width: 152px;" class="easyui-validatebox span2" value="${wdto.amountUnit}"  data-options="required:true" ></td>
							
						</tr>
						<tr>
						<th>规格</th>
							<td><input name="spec" type="text" placeholder="请输入规格"  id="spec"
								style="width: 152px;" class="easyui-validatebox span2"  value="${wdto.spec}"  ></td>
							<th>生产企业</th>
							<td><input name="manufacturer" type="text" placeholder="请输入生产企业" id="manufacturer"
								style="width: 152px;" class="easyui-validatebox span2" value="${wdto.manufacturer}"></td>
							
							
						</tr>
						<tr>
							<th><font color="red">*</font>保质期</th>
							<td><input name="shelfLife" type="text" placeholder="请输入保质期" id="shelfLife"
								style="width: 152px;" class="easyui-validatebox span2" data-options="required:true" value="${wdto.shelfLife}"></td>
							<th><font color="red">*</font>保质期单位</th>
							<td><select id="unit" class="easyui-combobox" name="unit"  data-options="width:140,height:29,editable:false,panelHeight:'auto'"
								data-options="required:true">
							 <c:if test="${wdto.unit=='年'}">			
							    <option value="年">年</option>
							    <option value="月">月</option>   
							    <option value="日">日</option>   							  
							    <option value="小时">小时</option> 
							     </c:if>  
							     <c:if test="${wdto.unit=='月'}">								  
							    <option value="月">月</option>  
							    <option value="年">年</option>    
							    <option value="日">日</option>   							  
							    <option value="小时">小时</option> 
							    </c:if> 
							     <c:if test="${wdto.unit=='日'}">								      
							    <option value="日">日</option>   
							    <option value="年">年</option>   
							    <option value="月">月</option>  							  
							    <option value="小时">小时</option>
							    	 </c:if> 	
							     <c:if test="${wdto.unit=='小时'}">					  
								<option value="小时">小时</option>
								 <option value="年">年</option>   
							    <option value="月">月</option>   
							    <option value="日">日</option>   		
							     </c:if> 	
							        							  
							</select></td>
						</tr>
						
					
						<tr>
							<th>产地</th>
							<td><input name="place" type="text" id="place"
								style="width: 152px;" placeholder="请输入产地" class="easyui-validatebox span2"
								value="${wdto.place}"></td>
								<th><font color="red">*</font>原料分类</th>
						<td><select id="waresType" class="easyui-combobox" name="waresType"  data-options="width:140,height:29,editable:false,panelHeight:'auto'"
								data-options="required:true">								
								<c:if test="${wdto.waresType==1}">									
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
							     </c:if>
							      	<c:if test="${wdto.waresType==2}">
							      	   <option value="2">畜产品及其制品</option>   
							   <option value="1">粮食及其制品</option>   
							 
							    <option value="3">禽及其产品、制品</option>   
							    <option value="4">蔬菜</option>   
							    <option value="5"> 水果</option>   
							    <option value="6">水产品</option>   
							    <option value="7">豆制品</option>   
							    <option value="8">乳品</option>   
							    <option value="9">食用油</option>   
							    <option value="10">其它类别的食品和食用农产品</option>    
							    </c:if>   
							      	<c:if test="${wdto.waresType==3}">
							      	   <option value="3">禽及其产品、制品</option>   
							   <option value="1">粮食及其制品</option>   
							    <option value="2">畜产品及其制品</option>   
							 
							    <option value="4">蔬菜</option>   
							    <option value="5"> 水果</option>   
							    <option value="6">水产品</option>   
							    <option value="7">豆制品</option>   
							    <option value="8">乳品</option>   
							    <option value="9">食用油</option>   
							    <option value="10">其它类别的食品和食用农产品</option>   
							    </c:if>
							    	<c:if test="${wdto.waresType==4}">
							    	 <option value="4">蔬菜</option>   
							   <option value="1">粮食及其制品</option>   
							    <option value="2">畜产品及其制品</option>   
							    <option value="3">禽及其产品、制品</option>   
							   
							    <option value="5"> 水果</option>   
							    <option value="6">水产品</option>   
							    <option value="7">豆制品</option>   
							    <option value="8">乳品</option>   
							    <option value="9">食用油</option>   
							    <option value="10">其它类别的食品和食用农产品</option>   
							    </c:if>  
							    	<c:if test="${wdto.waresType==5}"> 
							    	 <option value="5"> 水果</option>   
							   <option value="1">粮食及其制品</option>   
							    <option value="2">畜产品及其制品</option>   
							    <option value="3">禽及其产品、制品</option>   
							    <option value="4">蔬菜</option>   
							   
							    <option value="6">水产品</option>   
							    <option value="7">豆制品</option>   
							    <option value="8">乳品</option>   
							    <option value="9">食用油</option>   
							    <option value="10">其它类别的食品和食用农产品</option>   
							    </c:if>
							    	<c:if test="${wdto.waresType==6}">  
							    	  <option value="6">水产品</option>   
							  <option value="1">粮食及其制品</option>   
							    <option value="2">畜产品及其制品</option>   
							    <option value="3">禽及其产品、制品</option>   
							    <option value="4">蔬菜</option>   
							    <option value="5"> 水果</option>   
							  
							    <option value="7">豆制品</option>   
							    <option value="8">乳品</option>   
							    <option value="9">食用油</option>   
							    <option value="10">其它类别的食品和食用农产品</option>   
							    </c:if> 
							    	<c:if test="${wdto.waresType==7}">
							    	 <option value="7">豆制品</option> 
							  <option value="1">粮食及其制品</option>   
							    <option value="2">畜产品及其制品</option>   
							    <option value="3">禽及其产品、制品</option>   
							    <option value="4">蔬菜</option>   
							    <option value="5"> 水果</option>   
							    <option value="6">水产品</option>   
							     
							    <option value="8">乳品</option>   
							    <option value="9">食用油</option>   
							    <option value="10">其它类别的食品和食用农产品</option>   
							    </c:if> 
							    	<c:if test="${wdto.waresType==8}">
							    	  <option value="8">乳品</option>   
							   <option value="1">粮食及其制品</option>   
							    <option value="2">畜产品及其制品</option>   
							    <option value="3">禽及其产品、制品</option>   
							    <option value="4">蔬菜</option>   
							    <option value="5"> 水果</option>   
							    <option value="6">水产品</option>   
							    <option value="7">豆制品</option>   
							  
							    <option value="9">食用油</option>   
							    <option value="10">其它类别的食品和食用农产品</option>   
							    </c:if>
							    	<c:if test="${wdto.waresType==9}">
							    	    <option value="9">食用油</option>   
							    <option value="1">粮食及其制品</option>   
							    <option value="2">畜产品及其制品</option>   
							    <option value="3">禽及其产品、制品</option>   
							    <option value="4">蔬菜</option>   
							    <option value="5"> 水果</option>   
							    <option value="6">水产品</option>   
							    <option value="7">豆制品</option>   
							    <option value="8">乳品</option>   
							
							    <option value="10">其它类别的食品和食用农产品</option>   
							      </c:if>
							    	<c:if test="${wdto.waresType==10}">
							    	<option value="10">其它类别的食品和食用农产品</option> 
							    <option value="1">粮食及其制品</option>   
							    <option value="2">畜产品及其制品</option>   
							    <option value="3">禽及其产品、制品</option>   
							    <option value="4">蔬菜</option>   
							    <option value="5"> 水果</option>   
							    <option value="6">水产品</option>   
							    <option value="7">豆制品</option>   
							    <option value="8">乳品</option>   
							    <option value="9">食用油</option>   
							      
							    </c:if>
							 
							</select> </td>
							</tr>
						<%-- <tr>
							
							<th>是否是菜肴</th>
							<td><select name="dishes" class="easyui-combobox" id="dishes"
								data-options="width:140,height:29,editable:false,panelHeight:'auto'" 
								data-options="required:true">
								<c:if test="${wdto.dishes==true}">
									<option value="0">否</option></c:if>
				                <c:if test="${wdto.dishes==false}"><option value="0">是</option>
									</c:if></select>
								
									</td>
						
						</tr> --%>
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
