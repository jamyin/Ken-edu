$(function(){
	var customerId = "000d804f-ffdc-432a-b9b7-85307a611423";
	$.ajax({
		url:'/wap/scMenu/search.htm?customerId='+customerId,
		type:"POST",
		dataType:'json',
		success:function(data){
			if(data.status==200){
				$(".menu_box").empty();
				var objHtml = "";
				$.each(data.data, function(index, item) {
					objHtml+="<div class='row breakfrist'>";
					objHtml+="<h2><i>"+item['packageName']+"</i><span>Breakfrist</span><a href='###'>点评</a></h2>";
					objHtml+="<ul>";
					objHtml+="<li><img src='/static/img/food_simple.jpg' border='0'><p>红枣莲子银耳粥</p><span>原料：银耳5g; 莲子5g; 红枣 5g</span></li>";
					objHtml+="</ul>";
					objHtml+="<ul class='nutrition'>";
					objHtml+="<li>能量（kcal）: 867.6</li>";
					objHtml+="<li>蛋白质（g）: 36.9</li>";
					objHtml+="<li>脂肪（g）: 26.3</li>";
					objHtml+="<li>碳水合合物（g）: 128</li>";
					objHtml+="</ul>";
					objHtml+="</div>";
				});				
				$(".menu_box").html(objHtml);
			}else{
				
			}
			
		}
	});	
});