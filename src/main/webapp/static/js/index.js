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