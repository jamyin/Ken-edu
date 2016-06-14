$(function(){
	loadscMenu();
});

function selectGradeList(thisObj){
	$("#gradeId").val($(thisObj).val());
	loadscMenu();
}

function jumpUrl(_this){
	var customerId = $(_this).val();
	$("#customerId").val(customerId);
	window.location.href = "/wap/school/school/"+customerId+".htm";
}

function loadscMenu(){
	var customerId = $("#customerId").val();
	var timeDate = $('#sel_date').val();
	var gradeType = $('#gradeId').val();
	var dataParams = {customerId:customerId,timeDate:timeDate,type:gradeType};
	$.ajax({
		url:'/wap/scMenu/search.htm',
		type:"POST",
		data:dataParams,
		dataType:'json',
		success:function(data){
			if(data.status==200){
				$(".menu_box").empty();
				var objHtml = "";
				$.each(data.data, function(index, item) {
					objHtml+="<div class='row breakfrist'>";
					objHtml+="<h2><i>";
					//0：早餐，1：午餐，2：午后甜点，3：晚餐，4：夜宵  
					if(item['supplyPhase']==0){
						objHtml+="早餐";
					}else if(item['supplyPhase']==1){
						objHtml+="午餐";
					}else if(item['supplyPhase']==2){
						objHtml+="午后甜点";
					}else if(item['supplyPhase']==3){
						objHtml+="晚餐";
					}else if(item['supplyPhase']==4){
						objHtml+="夜宵 ";
					}
					
					//</i><span>Breakfrist</span><div class="scorce_box"><img src="static/img/star3.png" border="0"><span>124.2</span></div><a href="###">点评</a></h2>
					//objHtml+="</i><span></span><img src='/static/img/star"+item['packageStar']+".png' border='0'><a href='/wap/comment/join/"+item['id']+".htm'>点评</a></h2>";
					objHtml+="</i><span></span><div class='scorce_box'><img src='/static/img/star"+item['packageStar']+".png' border='0'><span>"+item['packageStar']+"</span></div><a href='/wap/comment/join/"+item['id']+".htm'>";
					if(item['evaluated']){
						objHtml+="重新点评";	
					}else{
						objHtml+="点评";
					}
					objHtml+="</a></h2>";
					objHtml+="<ul><li><span>";
					var proDishesDtos = item['proDishesDtos'];
					if(proDishesDtos!=null){
						$.each(proDishesDtos, function(index_d, itemD) {
							//<img src='/static/img/food_simple.jpg' border='0'>
							objHtml+=itemD['name']+" ";
						});						
					}
					
					objHtml+="</span></li></ul>";
					objHtml+="<ul class='nutrition'>";
					var proNutritionalDtos = item['proNutritionalDtos'];
					if(proNutritionalDtos!=null){
						$.each(proNutritionalDtos, function(index_n, itemN) {
							objHtml+="<li>"+itemN['name']+"("+itemN['unit']+"): "+itemN['weight']+"</li>";
						});						
					}					
/*						objHtml+="<li>能量（kcal）: 867.6</li>";
						objHtml+="<li>蛋白质（g）: 36.9</li>";
						objHtml+="<li>脂肪（g）: 26.3</li>";
						objHtml+="<li>碳水合合物（g）: 128</li>";
*/					objHtml+="</ul>";
					objHtml+="</div>";
				});				
				$(".menu_box").html(objHtml);
			}else{
				
			}
			
		}
	});	
};