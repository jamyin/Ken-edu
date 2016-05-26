<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript">

	$(function() {
		parent.$.messager.progress('close');
		$('#updateImage').form(
						{			
							url : '${pageContext.request.contextPath}/corporateController/alterImage',
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
									window.location.href="";
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
				<form id="updateImage" method="post"  enctype="multipart/form-data">
				   <input id="id" name="id" type="hidden" value="${id}" />
					<table class="table table-hover table-condensed">
					<tr>							
							<th>企业三证</th>
							<td>工商营业执照<input type="file" name="imgUrl1"  id="imgUrl1"  accept="image/*" />	</td>
							<td>组织机构代码<input type="file" name="imgUrl2"  id="imgUrl2"  accept="image/*" />	</td>
							<td>税务登记证<input type="file" name="imgUrl3"  id="imgUrl3"  accept="image/*" />	</td>
						</tr>
					<tr>							
							<th>商品图片</th>
							<td>	<input type="file" name="imgUrl4"  id="imgUrl4"  accept="image/*" />	</td>
							<td>	<input type="file" name="imgUrl5"  id="imgUrl5"  accept="image/*" />	</td>
							<td>	<input type="file" name="imgUrl6"  id="imgUrl6"  accept="image/*" />	</td>
						</tr>
						<tr>							
							<th>商品图片</th>
							<td>	<input type="file" name="imgUrl7"  id="imgUrl7"  accept="image/*" />	</td>
							<td>	<input type="file" name="imgUrl8"  id="imgUrl8"  accept="image/*" />	</td>
							<td>	<input type="file" name="imgUrl9"  id="imgUrl9"  accept="image/*" />	</td>
							<td>	<input type="file" name="imgUrl10"  id="imgUrl10"  accept="image/*" />	</td>
						</tr>
						<tr>

							<th>其他</th>
							<td><input type="file" name="imgUrl11"  id="imgUrl11"  accept="image/*" /></td>							
						</tr>
			</table>
			
				</form>
			</div>

		</div>

