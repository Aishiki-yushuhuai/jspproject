<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>九台云平台</title>
<jsp:include page="/util/import.jsp"></jsp:include>
</head>
<body>
	<div class="t_top hidden-xs hidden-sm">
			<div class="container">
				<c:if test="${ ! empty sessionScope.username }">
						<div class="t_top_l fl">欢迎${sessionScope.username}</div>
					</c:if>
					<c:if test="${empty sessionScope.username }">
						<div class="t_top_l fl">欢迎使用</div>
					</c:if>
					
					
					<c:if test="${ empty sessionScope.username }">
					<a href="login.html">
						<div class="t_top_r fr">登录</div>
						<div class="t_top_r fr">注册</div>
					</a>
					</c:if>
					<c:if test="${ ! empty sessionScope.username }">
						<a href="edit.user">
							<div class="t_top_r fr">修改</div>
					  	</a>
					  	<a href="out.user">
							<div class="t_top_r fr" id="out">退出</div>
					  	</a>
					</c:if>
			</div>
		</div>
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<nav class="navbar navbar-default" role="navigation">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
								<a class="navbar-brand" href="index.html">
									<img class="img-responsive" src="static/images/logo.jpg">
								</a>
						</div>
						<div class="collapse navbar-collapse fr" id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav">
								<li><a href="index.html?menuId=0">网站首页</a></li>
								<li><a href="list.info?menuId=1&index=1" >企业资源</a></li>
								<li><a href="list.info?menuId=2&index=1" >设备资源</a></li>
								<li><a href="list.info?menuId=3&index=1" >专家资源</a></li>
								<li><a href="list.info?menuId=4&index=1" >培训资源</a></li>
								<li><a href="list.rev?menuId=5&index=1">评价资源</a></li>
								<li><a href="news.html">平台动态</a></li>
								<li><a href="list.our?menuId=6">联系我们</a></li>
							</ul>
						</div>
					</nav>
				</div>
			</div>
		</div>
		<div class="nrbanner">
			<img src="static/images/nrbanner.jpg" alt="" class="img-responsive">
		</div>
		<div class="content">
			<div class="container">
				<div class="row clearfix">
					<div class="col-md-9 mainc" aos="zoom-out">
						<div class="mbx">							
							当前位置：<a href="index.html">网站首页</a> > <a href="">修改信息</a>
						</div>
				
								<c:if test="${! empty requestScope.message}">
										<font color="red">${requestScope.message}</font>
								</c:if>
								<c:if test="${! empty requestScope.message2}">
										<font color="red">${requestScope.message2}</font>
								</c:if>

								<c:if test="${! empty requestScope.user}">
									<c:set var="id" value="${requestScope.user.id}"></c:set>
									<c:set var="username" value="${requestScope.user.username}"></c:set>
									<c:set var="oldName" value="${requestScope.user.username}"></c:set>
									<c:set var="password" value="${requestScope.user.password}"></c:set>
									<c:set var="phone" value="${requestScope.user.phone}"></c:set>
								</c:if>
								<c:if test="${requestScope.user == null}">
									<c:set var="id" value="${param.id}"></c:set>
									<c:set var="username" value="${param.username}"></c:set>
									<c:set var="oldName" value="${param.oldName}"></c:set>
									<c:set var="password" value="${param.password}"></c:set>
									
								</c:if>
								
								
									<form action="update.user" >
										<input type="hidden" name="id" value="${id}">
										<input type="hidden" name="oldName" value="${oldName}">
										<table class="table table-hover">
										
										<tbody>
											
											<tr>
												<td>用户名</td>
												<td><input type="text" name="username" value="${username }"></td>
											</tr>
											<tr>
												<td>原密码</td>
												<td><input type="password" name="bfpassword" ></td>
											</tr>
											<tr>
												<td>密码</td>
												<td><input type="password" name="password" ></td>
											</tr>
											<c:if test="${! empty requestScope.user.phone}">
											
											</c:if>
											<tr>
												<td><button type="submit" >修改</button></td>
											</tr>
										</tbody>
									</table>
								</form>
						
					
						
					</div>
				</div>
			</div>
		</div>
	
		
		<div class="footer2 hidden-xs hidden-sm">
			<div class="container">
				<div class="row clearfix">
					<div class="footd col-md-12 column text-center">
						<p>xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx</p>
						<p>&copy; 2021 CRX&nbsp;&nbsp;ICP备XXXXXXXX号&nbsp;&nbsp;技术支持：<a href="" title=""
							 target="_blank">xxxxxxxxxxxxxx</a></p>
					</div>
				</div>
			</div>
		</div>
		
	<script>
		AOS.init({
			easing: 'ease-out-back',
			duration: 1000,
			once: true
		});
	</script>
	<script type="text/javascript">
		$(function() {
			$("#out").click(function() {
				return confirm("确定要退出吗")
			})
		})
	</script>
	<script type="text/javascript">
function checkIP(){//js表单验证方法
   var text=document.getElementById("url").value;//通过id获取需要验证的表单元素的值
   if(text==""){//当上面获取的值为空时
     alert("不能为空哦！");//弹出提示
     return false;//返回false（不提交表单）
   }
   return true;//提交表单
}
</script>
	
</body>
</html>