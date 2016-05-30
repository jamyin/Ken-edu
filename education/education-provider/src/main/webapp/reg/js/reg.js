function laodcommittee(){
	$.ajax({
		url:'area/committee?type=2',
		type:"POST",
		dataType:'json',
		success:function(data){
			var items = data.data
			var committeeList = $("#committeeList");
			committeeList.empty();
			$.each(data.data, function(index, item) {
				committeeList.append("<input name='committees' style='margin:5px;' type='checkbox' value='"+item['id']+"'>"+item['name']+"</input>")
			});
			
		}
	});
};