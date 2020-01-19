<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/register.css" type="text/css">
<script src="${pageContext.request.contextPath }/static/js/jquery-1.2.6.js"></script>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome login!</title>


    <script type="application/javascript">
        function logincheck1(){
            if($("#name").val()==""){
                alert("请输入用户名！");
                loginform.name.select();
                return false;
            }
            if($("#pass").val()==""){
                alert("请输入密码");
                loginform.pass.select();
                return false;
            }
            if($("#pass2").val()==""){
                alert("请再次输入密码！");
                loginform.pass2.select();
                return false;
            }
            if($("#email").val()==""){
                alert("请输入邮箱");
                loginform.email.select();
                return false;
            }
            if($("#phonember").val()==""){
                alert("请输入电话号码！");
                loginform.phonember.select();
                return false;
            }
            if($("#emailkey").val()==""){
                alert("请输入邮箱验证码");
                loginform.emailkey.select();
                return false;
            }
            
            if($("#emailkey").val()!=$("#nowemailkey").val()){
                alert("邮箱验证码不正确！");
                loginform.emailkey.select();
                return false;
            }
            
            loginform.submit();

        }
        
        function sendeamilkey() {
        	var email = $("#email").val();
        	$.ajax({
                url:"${pageContext.request.contextPath }/SendEmailKey",
                async:true,
                method:"post",
                data:{email:email},
                success:function (result) {
                	if(result!="wrron"){
                		$("#nowemailkey").val(result);
                    	alert("验证码已发送至邮件，请注意查收！");
                	}else {
                		alert("请检查您的邮箱输入是否有误！");
					}
                	
                },
                error:function () {
                    alert("系统异常,请稍后重试！");
                }
            }) 
		}
        
        
        function cleanWrongMessage() {
        	$("#name").css("background-color","rgb(255,255,255)");
		}
        
        function checkusername() {
        	var name = $("#name").val();
        	$.ajax({
                url:"${pageContext.request.contextPath }/CheckUserName",
                async:true,
                method:"post",
                data:{name:name},
                success:function (result) {
                	if(result=="false"){
                		alert("该用户名已存在！");
                		$("#name").val("");
                		$("#name").css("background-color","rgb(255,200,200)");
                		loginform.name.select();
                	}
                },
                error:function () {
                    alert("系统异常,请稍后重新尝试注册！");
                }
            }) 
		}
        
        function checkpass() {
			if($("#pass").val()!=$("#pass2").val()){
				alert("两次密码输入不一致！");
				$("#pass").val("");
				$("#pass2").val("");
				loginform.pass.select();
			}
		}
       
    </script>


</head>

<body>

<div id="content">
    <div class="login-header">
        <span style="font-size: 26px;color: rgb(20,20,60);font-family:‘正楷’;margin-left: 30%">欢迎注册系统</span>
    </div>
    <form name="loginform" id="loginForm" action="${pageContext.request.contextPath}/Register" method="post">
    <input type="hidden" name="islogin" value="login"/>
        <div class="login-input-box">
            <span class="icon icon-user"></span>
            <input style="background-color: rgba(255, 255, 255, 0.6);" placeholder="在此输入账户" id="name" name="name" onfocus="cleanWrongMessage()" onchange="checkusername()">
            <br/>
        </div>

        <div class="login-input-box">
            <span class="icon icon-password"></span>
            <input type="password" style="background-color: rgba(255, 255, 255, 0.6);" placeholder="在此输入密码" name="pass" id="pass" onfocus="cleanWrongMessage();">
        </div>
        
        <div class="login-input-box">
            <span class="icon icon-password"></span>
            <input type="password" style="background-color: rgba(255, 255, 255, 0.6);" placeholder="再次确认密码" name="pass2" id="pass2" onfocus="cleanWrongMessage();" onchange="checkpass()">
        </div>
        
        <div class="login-input-box">
            <span class="icon icon-user"></span>
            <input style="background-color: rgba(255, 255, 255, 0.6);" placeholder="在此输入邮箱" id="email" name="email" onfocus="cleanWrongMessage(); ">
            
            <br/>
        </div>
        
        <div class="login-input-box">
        	<div class="login-button-box" >
       			<button type="button" onclick="sendeamilkey()" class="btn btn-primary">发送邮箱验证码</button>
       			<input type="hidden" id = "nowemailkey" value="">
    		</div>
            <span class="icon icon-user"></span>
            <input style="background-color: rgba(255, 255, 255, 0.6);" placeholder="邮箱验证码" id="emailkey" name="emailkey" onfocus="cleanWrongMessage(); ">
            <br/>
        </div>
        
        <div class="login-input-box">
            <span class="icon icon-user"></span>
            <input style="background-color: rgba(255, 255, 255, 0.6);" placeholder="在此输入电话号码" id="phonember" name="phonember" onfocus="cleanWrongMessage(); ">
            <br/>
        </div>
    </form>
    <div class="login-button-box" >
        <button type="button" onclick="logincheck1();" class="btn btn-primary">立即注册</button>
    </div>
    <div class="logon-box">
        <a href="${pageContext.request.contextPath }/login.jsp" style="color: white; font-size: 16px;">去登录>></a>
    </div>
    
</div>




</body>
</html>