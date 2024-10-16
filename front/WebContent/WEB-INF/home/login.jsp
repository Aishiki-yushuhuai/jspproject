<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录注册</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="static/css/stylelogin.css">
</head>
<body>
<div class="container">
       <div class="login-box">
            <div class="apple-btn login-apple">
                <li class="red-btn"></li>
                <li class="yellow-btn"></li>
                <li class="green-btn"></li>
            </div>
            <c:if test="${! empty requestScope.mess}">
            	<div class="title">
            		<font color="green" >${requestScope.mess}</font>
            	</div>
			</c:if>
			<c:if test="${! empty requestScope.message}">
            	<div class="title">
            		<font color="red" >${requestScope.message}</font>
            	</div>
			</c:if>
            <c:if test="${! empty requestScope.msg}">
            	<div class="title">
            		<font color="red" >${requestScope.msg}</font>
            	</div>
			</c:if>
            <div class="title">云平台登录</div>
            
			<form action="login.user" method="post">
				<div class="input">
					<input type="text" id="login-user" placeholder="请输入用户名" name="username">
				</div>
				<div class="input">
					<input type="password" id="login-password" placeholder="请输入密码" name="password">
				</div>
				<div >
					<button type="submit" class="btn login-btn">登录</button>
				</div>
			</form>
            <div class="change-box login-change">
                <div class="change-btn toSign">
                    	<span>去注册</span>
                </div>
            </div>
       </div>

       <div class="sign-box">
            <div class="apple-btn sign-apple">
                <li class="red-btn"></li>
                <li class="yellow-btn"></li>
                <li class="green-btn"></li>
            </div>
            <div class="title">云平台注册</div>
            <div class="title"><span id="username_msg"></span><span id="password_msg"></span><span id="password_msg"></span><span id="phone_msg"></span></div>
			<form action="sign.user" method="post">
            <div class="input2">
                <input type="text" id="sign-user" placeholder="请输入用户名" name="username" >
            </div>
            <div class="input2">
                <input type="password" id="sign-password1" placeholder="请输入密码" name="password" >
            </div>
            
			<div class="input2">
			    <input type="password" id="sign-password2" placeholder="请确认密码" name="repassword" >
			</div>
			
			<div class="input2">
			    <input type="text" id="sign-phone" placeholder="请输入手机号" name="phone" >
			</div>
			
			<div class="input3">
			    <input type="text" id="sign-code" placeholder="请输入验证码" name="code" >
	            <button type="button" class="btnc sign-btnc">获取验证码</button>
			</div>
			
            <div >
                <button type="submit" class="btn2 sign-btn2"  onclick="return checkForm()">注册</button>
            </div>
			</form>
            <div class="change-box sign-change">
                <div class="change-btn toLogin">
                    <span>去登录</span>
                </div>
            </div>
       </div>
    </div>
<script src="static/js/jquery-3.1.1.min.js"></script>
<script src="static/js/script.js"></script>
<script type="text/javascript">
        //是否为空
        function ifnull(txt){
            if(txt.length==0){
                return true;
            }
            var $reg=/\s+/;
            return $reg.test(txt);
        } 
        //在id为phone的元素失去焦点时进行邮箱的验证
        $(function() {
	        $("#sign-phone").blur(function(){
	            if(ifnull($(this).val())){
	                $("#phone_msg").html("手机号不能为空");
	            }else{
	                var $reg=/^\w{6,}$/;
	                if(!$reg.test($("#sign-phone").val())){
	                    $("#phone_msg").html("手机号格式错误！");
	                }else{
	                    $("#phone_msg").html("手机号格式正确");
	                }
	            }
	        })
        })
        //在id为username的元素失去焦点时进行用户名的验证
         $(function() {
	        $("#sign-user").blur(function(){
	            if(ifnull($(this).val())){
	                $("#username_msg").html("用户名不能为空");
	            }else{
	                var $reg=/^\w{6,}$/;
	                if(!$reg.test($("#sign-user").val())){
	                    $("#username_msg").html("用户名至少要6位哦");
	                }else{
	                    $("#username_msg").html("用户名格式正确");
	                }
	            }
	        })
         })
        //在id为password的元素失去焦点时进行密码的验证
        $(function() {
	        $("#sign-password1").blur(function(){
	            if(ifnull($(this).val())){
	                $("#password_msg").html("密码不能为空");
	            }else{
	                var $reg=/^\w{6,}$/;
	                if(!$reg.test($("#sign-password1").val())){
	                    $("#password_msg").html("密码至少要6位哦");
	                }else{
	                    $("#password_msg").html("密码格式正确");
	                }
	            }
	        })
        })
        //在id为repassword的元素失去焦点时进行密码的验证
        $(function() {
	        $("#sign-password2").blur(function(){
	            if(ifnull($(this).val())){
	                $("#repassword_msg").html("请确认密码");
	            }else{
	                if($("#sign-password2").val()!=$("#sign-password1").val()){
	                    $("#repassword_msg").html("两次密码不一致");
	                }else{
	                    $("#repassword_msg").html("两次密码一致");
	                }
	            }
	        })
        })
        //验证表单
        function checkForm(){
            //验证手机号
            if(ifnull($("#sign-phone").val())){
                $("#phone_msg").html("手机号不能为空！");
                return false;
            }else{
                var $reg=/^1\d{10}$/;
                if(!$reg.test($("#sign-phone").val())){
                    $("#phone_msg").html("手机号格式错误！");
                    return false;
                }
            }
            //验证用户名
            if(ifnull($("#sign-user").val())){
                $("#username_msg").html("用户名不能为空！");
                return false;
            }else{
                var $reg=/^\w{6,}$/;
                if(!$reg.test($("#sign-user").val())){
                    $("#username_msg").html("用户名至少6位");
                    return false;
                }
            }
            //验证密码
            if(ifnull($("#sign-password1").val())){
                $("#password_msg").html("密码不能为空");
                return false;
            }else{
                var $reg=/^\w{6,}$/;
                if(!$reg.test($("#sign-password1").val())){
                    $("#password_msg").html("密码至少6位");
                    return false;
                }
            }
            //确认密码是否为空
            if(ifnull($("#sign-password2").val())){
                $("#repassword_msg").html("请确认密码");
                return false;
            }
            //验证两次密码是否一致
            if($("#sign-password1").val()!=$("#sign-password2").val()){
                $("#repassword_msg").html("两次密码不一致");
                return false;
            }
            return true;
        }
    </script>
</body>
</html>