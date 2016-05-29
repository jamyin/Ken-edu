function loadImage(absFilePath){
	var formObj = document.createElement("form");        
	formObj.action = "/wap/loadImage.htm";        
	formObj.method = "post";
	formObj.style.display = "none";
	
	var opt = document.createElement("input");        
    opt.name = "absFilePath";
    opt.value = absFilePath;        
    // alert(opt.name)        
    formObj.appendChild(opt);   	

    document.body.appendChild(formObj);        
    formObj.submit();        
    return formObj;        
}