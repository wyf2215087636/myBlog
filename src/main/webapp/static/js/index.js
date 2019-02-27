$(function(){
    $("#re").click(function(){
    	
    	var myReg=/^[a-zA-Z0-9_-]+@([a-zA-Z0-9]+\.)+(com|cn|net|org)$/;
    	var myemail=$("#email").val();
    	var username=$("#username").val();
    	var mail_yzm=$("#mail_yzm").val();
    	var reply_info=$("#reply_info").val();
    	var posts_id=$("#posts_id").val();
    	if(myemail!=""&&myReg.test(myemail)){
    		var url="/details/comment";
    		var params = {useremail:myemail,username:username,mail_yzm:mail_yzm,reply_info:reply_info,posts_id:posts_id};
    		$.post(url,params,function(data){
    			alert(data.message);
    			refresh();
    		},"json");
    	}else if(!myReg.test(myemail)){
    		alert("邮箱格式错误");
    	}else{
    		alert("邮箱不可为空");
    	}
    });
    var canInterval = true;
    $("#so").click(function(){
    	var sec = 60;
    	var interval = null;
    	var aso = $("#so");
    	if(canInterval){
    		
    		$("#comment").attr("action","/details/mail");
        	var myReg=/^[a-zA-Z0-9_-]+@([a-zA-Z0-9]+\.)+(com|cn|net|org)$/;
        	var myemail=$("#email").val();
        	if(myemail!=""&&myReg.test(myemail)){
        		var url="/details/mail";
        		var params = {useremail:myemail};
        		$.post(url,params,function(data){
        			if(data.code == -1){
        				
        				sec = parseInt(Number(data.message.substring(4))/1000);
        				console.log(sec);
        				console.log(data.message.substring(4));
        				console.log(data.message);
        				data.message = data.message.substring(0,4);
        			}
        			alert(data.message);
        			if(data.code == 1){
        				
        			}
        		},"json");
        		canInterval = false;
        		interval = setInterval(() => {
    				sec -= 1;
    				if(sec == 0){
    					canInterval = true;
    					clearInterval(interval);
    					aso.text("发送验证码");
    				}else{
    					aso.text(sec+" s");
    				}
    			}, 1000);
        	}else if(!myReg.test(myemail)){
        		alert("邮箱格式错误");
        	}else{
        		alert("邮箱不可为空");
        	}
        	
    		
    	}
    	
    	
    	
    	
    	
    	
    	
    });
    
    $("#myinfo").mouseover(function(){
		$("#mydata").css("display","block");
	});
    
    $("#myinfo").mouseout(function(){
		$("#mydata").css("display","none");
	});
    $(".one").mouseover(function(){
    	$(this).css("background","#cccccc");
    });
    $(".one").mouseout(function(){
    	$(this).css("background","white");
    });
    
    //login页面
	function hasClass(elem, cls) {
		  cls = cls || '';
		  if (cls.replace(/\s/g, '').length == 0) return false; //当cls没有参数时，返回false
		  return new RegExp(' ' + cls + ' ').test(' ' + elem.className + ' ');
		}
		 
		function addClass(ele, cls) {
		  if (!hasClass(ele, cls)) {
		    ele.className = ele.className == '' ? cls : ele.className + ' ' + cls;
		  }
		}
		 
		function removeClass(ele, cls) {
		  if (hasClass(ele, cls)) {
		    var newClass = ' ' + ele.className.replace(/[\t\r\n]/g, '') + ' ';
		    while (newClass.indexOf(' ' + cls + ' ') >= 0) {
		      newClass = newClass.replace(' ' + cls + ' ', ' ');
		    }
		    ele.className = newClass.replace(/^\s+|\s+$/g, '');
		  }
		}
			document.querySelector(".login-button").onclick = function(){
					addClass(document.querySelector(".login"), "active")
					setTimeout(function(){
						addClass(document.querySelector(".sk-rotating-plane"), "active")
						document.querySelector(".login").style.display = "none"
					},800)
					setTimeout(function(){
						removeClass(document.querySelector(".login"), "active")
						removeClass(document.querySelector(".sk-rotating-plane"), "active")
						document.querySelector(".login").style.display = "block"
						var url="/loginload";
						var adminname=$("#adminname").val();
						var adminpass=$("#adminpass").val();
						var params={adminname:adminname,adminpass:adminpass};
						$.post(url,params,function(data){
							
							if(data.code==1){
								var boardDiv = "<div style='z-index: 3;position:absolute;width: 200px;border-radius: 5px;height: 70px;line-height:70px;text-align:center;background-color:rgba(0,0,0,0.5);box-shadow: 0px 0px 5px #333333;top: 40%;left: 53.9%;margin-top: -250px;margin-left: -175px;color:white;font-size:15px;' id='load'>"+data.message+"<\/div>"; 
								$(document.body).append(boardDiv); 
								$("#load").fadeIn(2000);
								$("#load").fadeOut(2000);
								setTimeout(function(){
									$("#load").remove();
									window.location.href="/admin";
								},700);
								
							}else{
									var boardDiv = "<div style='z-index: 3;position:absolute;width: 200px;border-radius: 5px;height: 70px;line-height:70px;text-align:center;background-color:rgba(0,0,0,0.5);box-shadow: 0px 0px 5px #333333;top: 40%;left: 53.9%;margin-top: -250px;margin-left: -175px;color:white;font-size:15px;' id='load'>"+data.message+"<\/div>"; 
									$(document.body).append(boardDiv); 
									$("#load").fadeIn(2000);
									$("#load").fadeOut(2000);
									setTimeout(function(){
										$("#load").remove();
									},4000);
							}
							
						},"json");
					},2000)
			}

			
    $(function() {
        
        md_edit = editormd("blog_mdedit", { //注意1：这里的就是上面的DIV的id属性值
            placeholder : "欢迎使用 飞讯 博客",
            width : "100%",
            height : 700,
            syncScrolling : "single",
            emoji : true,
            path : "static/editor/lib/", //注意2：你的路径
            saveHTMLToTextarea : true,
            tocm : true, // Using [TOCM]
            tex : true, // 开启科学公式TeX语言支持，默认关闭
            flowChart : true, // 开启流程图支持，默认关闭
            /* 上传图片配置 */
            imageUpload : true,
            imageFormats : [ "jpg", "jpeg", "gif", "png", "bmp", "webp" ],
            imageUploadURL : "/editorMDUpload", //注意你后端的上传图片服务地址
        });
        
        $(".btn-blog-save").click(function() {
        	$("#blog_md").text($(".editormd-preview").text());
        	$("#blog_html").text($(".editormd-preview").html());
			console.log($(".editormd-preview").html());
			console.log($(".editormd-preview").text());
			alter("发帖成功");
		});
        
        $('#deletePosts').click(function(){
        	$('#deletePosts_form').submit();
        });
    });
   
});

function refresh(){
    window.location.reload();//刷新当前页面.
}