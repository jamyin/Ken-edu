function loadImage(_this){
	var absFilePath = $(_this).attr("data-path");
	var name = $(_this).attr("data-name"); 
	var formObj = document.createElement("form");        
	formObj.action = "/wap/loadImage.htm";        
	formObj.method = "post";
	formObj.style.display = "none";
	
	var opt = document.createElement("input");        
    opt.name = "absFilePath";
    opt.value = absFilePath;
    
	var opt = document.createElement("input");        
    opt.name = "name";
    opt.value = name;       
    // alert(opt.name)        
    formObj.appendChild(opt);   	

    document.body.appendChild(formObj);        
    formObj.submit();        
    return formObj;        
}