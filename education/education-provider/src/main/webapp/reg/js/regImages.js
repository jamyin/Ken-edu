$(function(){
	//图片上传
	$("#id-input-file-1").uploadify({
        'uploader': 'reg/uploadify/uploadify.swf',
        'script':"file/upload.htm",
        'cancelImg': 'reg/uploadify/cancel.png',
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
            	$("#file-1").attr("value","工商营业执照-"+dataObj.filePath)            	            	
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
                $("#file-2").val("餐饮服务许可证-"+dataObj.filePath)            	            	
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
                $("#file-3").val("食品流通许可证-"+dataObj.filePath)            	            	
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
                $("#file-4").val("食品生产许可证-"+dataObj.filePath)            	            	
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