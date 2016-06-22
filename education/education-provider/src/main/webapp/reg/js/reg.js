function laodcommittee(){
	$.ajax({
		url:'area/committee?type=2',
		type:"POST",
		async: false,
		dataType:'json',
		success:function(data){
			var items = data.data
			var committeeList = $("#committeeList");
			committeeList.empty();
			committeeList.append("<input id='chk_all'  style='margin:5px;' type='checkbox''>全选</input>")
			$.each(data.data, function(index, item) {
				committeeList.append("<input name='committees' style='margin:5px;' type='checkbox' value='"+item['id']+"'>"+item['name']+"</input>")
			});
			
			bindClickFunction();
			
		}
	});
};

function bindClickFunction(){
	$("#chk_all").click(function(){
	     $("input[name='committees']").prop("checked",$(this).prop("checked"));
	});
}