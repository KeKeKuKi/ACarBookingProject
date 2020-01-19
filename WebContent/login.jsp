<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/loginCss.css" type="text/css">
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
                loginform.passWord.select();
                return false;
            }
            var name = $("#name").val();
            var passWord = $("#pass").val();

            loginform.submit();

        }
      function cleanWrongMessage() {
        	$("#message").html("");
      }
    
    </script>
</head>

<body>

<div id="content">
    <div class="login-header">
        <span style="font-size: 26px;color: rgb(20,20,60);font-family:‘正楷’;margin-left: 30%">欢迎登录系统</span>
    </div>
    <form name="loginform" id="loginForm" action="${pageContext.request.contextPath}/LoginServlet" method="post">
    <input type="hidden" name="islogin" value="login"/>
        <div class="login-input-box">

            <span class="icon icon-user"></span>
            <input style="background-color: rgba(255, 255, 255, 0.6);" placeholder="在此输入账户" id="name" name="name" onfocus="cleanWrongMessage(); ">
            <br/>
        </div>

        <div class="login-input-box">
            <span class="icon icon-password"></span>
            <input type="password" style="background-color: rgba(255, 255, 255, 0.6);" placeholder="在此输入密码" name="passWord" id="pass" onfocus="cleanWrongMessage();">
        </div>
    </form>
    <div class="remember-box">
        <label>
            <p id="message" style="display:inline; margin-left:240px;color: red;font-size: 15px">${requestScope.mes}</p>
        </label>
    </div>
    <div class="login-button-box" >
        <button type="button" onclick="logincheck1();" class="btn btn-primary">立即登陆</button>
    </div>

    <a style="margin-left: 20px;color:rgb(255,255,255);text-decoration: none;" href="${pageContext.request.contextPath}/register.jsp" >立即注册</a>

</div>




</body>
</html>