(function ($) {
    $.extend($.fn, {
        phoneupload: function (settings) {
            var options = $.extend({
                //fileType: "gif|jpg|jpeg|png|bmp",                       //允许的文件格式
                uploadUrl: "/api/upload.htm",      //上传URL地址
                //deleteUrl: "/ajax/handler.ashx?action=deletefile",      //删除URL地址
                width: "100",                                              //图片显示的宽度
                height: 100,                                            //图片显示的高度
                imgSelector: ".imgdiv",                                  //图片选择器
                uploadData: {},                                         //上传时需要附加的参数
                deleteData: {},                                         //删除时需要附加的参数
                deleteFn: function ($parent, showMessage) {             //删除图片的方法(默认方法使用POST提交)
                    methods.deleteImage($parent, showMessage);
                },
                beforeSubmitFn: "beforeUpload",                         //上传前执行的方法 原型 beforeSubmit(arr, $form, options);
                successFn: "uploadSuccess",                             //上传成功后执行的方法 uploadSuccess(response, statusText, xhr, $this)
                errorFn: "uploadError"                                  //上传失败后执行的方法
            }, settings);
            console.log("id::",settings.uploadData.id);
            //上传准备函数
            var methods = {
                //验证文件格式
                checkFile: function (filename) {
                    var pos = filename.lastIndexOf(".");
                    var str = filename.substring(pos, filename.length);
                    var str1 = str.toLowerCase();
                    if (typeof options.fileType !== 'string') { options.fileType = "gif|jpg|jpeg|png|bmp"; }
                    var re = new RegExp("\.(" + options.fileType + ")$");
                    return re.test(str1);
                },
                //创建表单
                createForm: function () {
                    var $form = document.createElement("form");
                    $form.action = options.uploadUrl;
                    $form.method = "post";
                    $form.enctype = "multipart/form-data";
                    $form.style.display = "none";
                    //将表单加当document上，
                    document.body.appendChild($form);  //创建表单后一定要加上这句否则得到的form不能上传。document后要加上body,否则火狐下不行。
                    return $($form);
                },
                //创建图片
                createImage: function () {
                    //不能用 new Image() 来创建图片，否则ie下不能改变img 的宽高
                    var img = $(document.createElement("img"));
                    //img.attr({ "title": "！" });
                    if (options.width !== "") {
                        img.attr({ "width": options.width });
                    }
                    if (options.height !== "") {
                        img.attr({ "height": options.height });
                    }
                    return img;
                },
                showImage: function (filePath, objId) {
                    var $img = methods.createImage();
                    //$parent.find(options.imgSelector).find("img").remove();
                    //$("#"+objId).remove();
                    //要先append再给img赋值，否则在ie下不能缩小宽度。
                    //$img.appendTo($parent.find(options.imgSelector));
                    $("#"+objId).attr("src", filePath);
                    //this.bindDelete($parent);
                },
                bindDelete: function ($parent) {
                    $parent.find(options.imgSelector).find("img").bind("dblclick", function () {
                        //options.deleteFn($parent, true);
                    });
                },
                deleteImage: function ($parent, showMessage) {
                    var $fileInput = $parent.find("input:hidden");
                    if ($fileInput.val() !== "") {
                        var data = $.extend(options.deleteData, { filePath: $fileInput.val(), t: Math.random() });
                        $.post(options.deleteUrl, data, function (response) {
                            if (showMessage) { layer.msg(response.MessageContent) }
                            if (response.MessageType == 1) {
                                $fileInput.val("");
                                $parent.find(options.imgSelector).find("img").remove();
                            }
                        }, "JSON");
                    }
                },
                onload: function ($parent) {
                    var hiddenInput = $parent.find("input:hidden");
                    if (typeof hiddenInput !== "undefined" && hiddenInput.val() !== "") {
                        var img = methods.createImage();
                        if ($parent.find(options.imgSelector).find("img").length > 0) { $parent.find(options.imgSelector).find("img").remove(); }
                        //要先append再给img赋值，否则在ie下不能缩小宽度。 
                        img.appendTo($parent.find(options.imgSelector));
                        img.attr("src", hiddenInput.val());
                        //methods.bindDelete($parent);
                    }
                }
            };
            //上传主函数
            this.each(function () {
                var $this = $(this);
                methods.onload($this.parent());
                $this.bind("click", function () {
                	console.log("come here.......");
                    var $fileInput = $(this).parent().find("input:file");
                    var fileBox = $fileInput.parent();
                    console.log("come here.......===",$fileInput);
                    if ($fileInput.val() === "") {
                        layer.msg("请选择要上传的图片！");
                        return false;
                    }
//                    debugger;
                    //验证图片
                    if (!methods.checkFile($fileInput.val())) {
                        layer.msg("文件格式不正确，只能上传格式为：gif,jpg,jpeg,png,bmp的文件。");
                        return false;
                    }
                    //若隐藏域中有图片，先删除图片
                    if ($fileInput.val() !== "") {
                        //options.deleteFn($this.parent(), false);
                        //methods.deleteImage($this.parent(), false);
                    }

                    //创建表单
                    var $form = methods.createForm();

                    //把上传控件附加到表单
                    $fileInput.appendTo($form);
                    /*fileBox.html("<img src=\"/images/loading.gif\" />   正在上传...  ");
                    $this.attr("disabled", true);*/

                    //构建ajaxSubmit参数
                    var data = {};
                    data.data = options.uploadData;
                    data.type = "POST";
                    data.dataType = "text";
                    //上传前
                    data.beforeSubmit = function (arr, $form, options) {
                    	console.log("-----1-----"+arr);
                        var beforeSubmitFn;
                        try { beforeSubmitFn = eval(options.beforeSubmitFn) } catch (err) { };
                        if (beforeSubmitFn) {
                            var $result = beforeSubmitFn(arr, $form, options);
                            if (typeof ($result) == "boolean")
                                return $result;
                        }
                    };
                    //上传失败
                    data.error = function (response, statusText, xhr, $form) {
                    	console.log("-----2-----"+response);
                        var errorFn;
                        try { errorFn = eval(options.errorFn) } catch (err) { };
                        if (errorFn) {
                            errorFn(response.responseText, statusText, xhr, $this);
                        }
                    };
                    //上传成功
                    data.success = function (response, statusText, xhr, $form) {
                    	var myObject = eval('(' + response + ')');
                    	console.log("-----3-----"+myObject.status);
                        //response = eval("(" + response + ")");
                    	//console.log(myObject);
                    	var fileId = settings.uploadData.id;
                    	console.log("fileId::",settings.uploadData.id);
//	                        if (myObject.status == 200) {
//	                        	//console.log("--"+myObject.message);
//	                            methods.showImage(myObject.data.url, "phoneUserImage");
//	                            
//	                            $("#phoneHfThumbnail").val(myObject.data.url);
//	                            $("#phoneUserImageS").attr("src",myObject.data.url);
//	                            //$this.parent().find("input:hidden").val(myObject.message);
//	
//	                            var successFn;
//	                            try { successFn = eval(options.successFn) } catch (err) { };
//	                            //console.log("successFn"+successFn);
//	                            if (successFn) {
//	                                $.ajaxSetup({ cache: false });//这个不能少，否则ie下会提示下载
//	                                successFn(response, statusText, xhr, $this);
//	                            }
//	                        } else {
//	                        	fileBox.html("");
//	                        	parent.layer.alert(myObject.message, {icon: 1});
//	                        	//layer.msg(myObject.message, 1, 1);//alert("系统错误！");
//	                            //alert(myObject.MessageContent);
//	                        }
//	                        $this.attr("disabled", false);
	                        $("[name='"+fileId+"']").append("<input id=\""+fileId+"\" type=\"file\" value=\""+myObject.data.url+"\" onchange=\"selectfun(this)\" name=\"file\">");
	                        $("[name='"+fileId+"']").closest('li').find('.file').html('上传成功<i>浏览</i>')
//	                        $('#phoneFile').on("change",function(){
//	                    		$("#phoneQuery").click();
//	                    	});
                        //fileBox.html("<input type=\"file\" name=\"file\"/>");
                        //<a href="javascript:;" class="file">选择文件<input type="file" name="file" id=""></a>
                        
                      /*  var objHtml = "";
                        fileBox.html(objHtml);
                        $form.remove();
                        $("#file_permit_ex").html("<input name='file' id='reg_permit' onchange='showImg()' style='opacity:0; filter:alpha(opacity=0); width: 90px;height:50px;' type='file'></input>");
                        $(".uploadbtn").html("<label class='fileToUpload' for='fileToUpload'>头像上传</label><input type='file'  name='file' id='fileToUpload' style='display:none'/>");
                        $("#fileToUpload").change(function () {
                            $("#query").click();
                            
                        });*/
                        
                    };
                    try {
                    	console.log("date:;;;;;;;",data);
                        //开始ajax提交表单
                        $form.ajaxSubmit(data);
                    } catch (e) {
//                        layer.msg(e.message);
                    	console.error(e);
                    }
                });
            });
        }
    });
})(jQuery)

