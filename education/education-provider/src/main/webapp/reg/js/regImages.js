function enterLicenNO(objThis,fileNum,LicenType){
	var filePath = $(objThis).attr("data-path");
	if (filePath==null || filePath==""){
		filePath = "";
	}
	var licenseNo = $(objThis).val();
	$("#file-"+fileNum).attr("value","工商营业执照#"+filePath+"#"+licenseNo+"#"+LicenType);
}

$(function(){
	//图片上传
	$("#id-input-file-1").uploadify({
        'uploader': 'reg/uploadify/uploadify.swf',
        'script':"file/upload.htm",
        'cancelImg': 'reg/uploadify/cancel.png',
        'queueID': 'fileQueue',
        'buttonImg':'reg//uploadify/uploadp.png',
        'auto': true,
        //'multi':true,
        'buttonText': 'select',
        'simUploadLimit' : 1,
        'sizeLimit':1024*1024*10,
        'queueSizeLimit' : 1,
        'fileDesc' : 'pictures',
        'fileExt': '*.gif;*.png;*.jpg;*.jpge',
        onComplete: function(event, queueID, fileObj, response, data) {
            var dataObj = eval("("+response+")");
            if(dataObj.status == 200){
            	var showUrl = dataObj.wwwdomain+dataObj.filePath;
            	var licenseNo1 = $("#licenseNo1").val();
            	$("#licenseNo1").attr("data-path",dataObj.filePath);
            	$("#file-1").attr("value","工商营业执照#"+dataObj.filePath+"#"+licenseNo1+"#4");
            	$("#license1").html("<a target='_' href='"+showUrl+"'>查看工商营业执照</a>");
            	$("#file-1").attr("checked","checked");
            }
        },
        onSelect:function(){
        },
        onError: function(event, queueID, fileObj) {
        	layer.alert("对不起," + fileObj.name + "上传失败!<br/>请选择小于10M的图片", {
				shade: [0.9, '#000'],
			    icon: 3,
			    time: 3000 //2秒关闭（如果不配置，默认是3秒）
			}); 
        }
    });
	
	$("#id-input-file-2").uploadify({
        'uploader': 'reg/uploadify/uploadify.swf',
        'script':"file/upload.htm",
        'cancelImg': 'reg/uploadify/cancel.png',
        'queueID': 'fileQueue',
        'buttonImg':'reg//uploadify/uploadp.png',
        'auto': true,
        //'multi':true,
        'buttonText': 'select',
        'simUploadLimit' : 1,
        'sizeLimit':1024*1024*10,
        'queueSizeLimit' : 1,
        'fileDesc' : 'pictures',
        'fileExt': '*.gif;*.png;*.jpg;*.jpge',
        onComplete: function(event, queueID, fileObj, response, data) {
            var dataObj = eval("("+response+")");
            if(dataObj.status == 200){
            	var showUrl = dataObj.wwwdomain+dataObj.filePath;
            	var licenseNo2 = $("#licenseNo2").val();
            	$("#licenseNo2").attr("data-path",dataObj.filePath);
                $("#file-2").val("餐饮服务许可证#"+dataObj.filePath+"#"+licenseNo2+"#0");
                $("#license2").html("<a target='_' href='"+showUrl+"'>查看餐饮服务许可证</a>");
                $("#file-2").attr("checked","checked");
            }
        },
        onSelect:function(){
        },
        onError: function(event, queueID, fileObj) {
        	layer.alert("对不起," + fileObj.name + "上传失败!<br/>请选择小于10M的图片", {
				shade: [0.9, '#000'],
			    icon: 3,
			    time: 3000 //2秒关闭（如果不配置，默认是3秒）
			}); 
        }
    });
	
	
	$("#id-input-file-3").uploadify({
        'uploader': 'reg/uploadify/uploadify.swf',
        'script':"file/upload.htm",
        'cancelImg': 'reg/uploadify/cancel.png',
        'buttonImg':'reg//uploadify/uploadp.png',
        'queueID': 'fileQueue',
        'auto': true,
        //'multi':true,
        'buttonText': 'select',
        'simUploadLimit' : 1,
        'sizeLimit':1024*1024*10,
        'queueSizeLimit' : 1,
        'fileDesc' : 'pictures',
        'fileExt': '*.gif;*.png;*.jpg;*.jpge',
        onComplete: function(event, queueID, fileObj, response, data) {
            var dataObj = eval("("+response+")");
            if(dataObj.status == 200){
            	var showUrl = dataObj.wwwdomain+dataObj.filePath;
            	var licenseNo3 = $("#licenseNo3").val();
            	$("#licenseNo3").attr("data-path",dataObj.filePath);
                $("#file-3").val("食品流通许可证#"+dataObj.filePath+"#"+licenseNo3+"#2");
                $("#license3").html("<a target='_' href='"+showUrl+"'>查看食品流通许可证</a>");
                $("#file-3").attr("checked","checked");
            }
        },
        onSelect:function(){
        },
        onError: function(event, queueID, fileObj) {
        	layer.alert("对不起," + fileObj.name + "上传失败!<br/>请选择小于10M的图片", {
				shade: [0.9, '#000'],
			    icon: 3,
			    time: 3000 //2秒关闭（如果不配置，默认是3秒）
			}); 
        }
    });
	
	$("#id-input-file-4").uploadify({
        'uploader': 'reg/uploadify/uploadify.swf',
        'script':"file/upload.htm",
        'cancelImg': 'reg/uploadify/cancel.png',
        'buttonImg':'reg/uploadify/uploadp.png',
        'queueID': 'fileQueue',
        'auto': true,
        //'multi':true,
        'buttonText': 'select',
        'simUploadLimit' : 1,
        'sizeLimit':1024*1024*10,
        'queueSizeLimit' : 1,
        'fileDesc' : 'pictures',
        'fileExt': '*.gif;*.png;*.jpg;*.jpge',
        onComplete: function(event, queueID, fileObj, response, data) {
            var dataObj = eval("("+response+")");
            if(dataObj.status == 200){
            	var showUrl = dataObj.wwwdomain+dataObj.filePath;
            	var licenseNo4 = $("#licenseNo4").val();
            	$("#licenseNo4").attr("data-path",dataObj.filePath);
                $("#file-4").val("食品生产许可证#"+dataObj.filePath+"#"+licenseNo4+"#3");
                $("#license4").html("<a target='_' href='"+showUrl+"'>查看食品生产许可证</a>");
                $("#file-4").attr("checked","checked");         	            	
            }
        },
        onSelect:function(){
        },
        onError: function(event, queueID, fileObj) {
        	layer.alert("对不起," + fileObj.name + "上传失败!<br/>请选择小于10M的图片", {
				shade: [0.9, '#000'],
			    icon: 3,
			    time: 3000 //2秒关闭（如果不配置，默认是3秒）
			}); 
        }
    });
	
});
