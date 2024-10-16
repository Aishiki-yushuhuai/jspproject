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
								<li class="active"><a href="list.rev?menuId=5&index=1">评价资源</a></li>
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
							当前位置：<a href="index.html">网站首页</a> > <a href="list.rev?menuId=5">评价资源</a>
						</div>
						<c:forEach items="${requestScope.pageHelper.data }" var="rev">
							<div class="col-md-12 mainnews">
									<div class="mnews clearfix">
										<div class="news_a fl">
											<div class="news_a_tit "><a href="">用户名：${rev.username }&nbsp;&nbsp;&nbsp;时间：${rev.time }</a></div>
											<div class="news_a_cont"><a href="">${rev.message }</a></div>
										</div>
									</div>
							</div>
						</c:forEach>
						
						<div class="col-md-12 pages">
						<c:if test="${!empty requestScope.pageHelper.data }">
								<ul>
									<c:if test="${requestScope.pageHelper.page != 1 }">
					                	<li><a href="list.rev?menuId=5&index=${requestScope.pageHelper.page - 1}">上一页</a></li>
					                </c:if>
					                <c:forEach begin="1" end="${requestScope.pageHelper.pageCount }" var="i">
						                <li <c:if test="${requestScope.infoList.page == i}">class="previous_s"</c:if>><a href="list.rev?menuId=5&index=${i}">${i }</a></li>
					                	
					                </c:forEach>
					                
					                <c:if test="${requestScope.pageHelper.page != requestScope.pageHelper.pageCount }">
					                	<li><a href="list.rev?menuId=5&index=${requestScope.pageHelper.page + 1}">下一页</a></li>
					                </c:if>
				              	</ul>
				        </c:if>
						</div>
						
						
						
						
						<c:if test="${ ! empty sessionScope.username }">
							${sessionScope.username}
							<form action="add.rev" method="post" onsubmit="return checkIP();">
								<input type="text" name="rev" id="url">
								<input type="hidden" name="username" value="${sessionScope.username}">
								<button type="submit" >提交</button>
								
							</form>
							<c:if test="${ ! empty requestScope.msg }">
									<font color="green" >评论成功</font>
							</c:if>
						</c:if>
						<c:if test="${empty sessionScope.username }">
							<p>评论请先登录</p>
						</c:if>
						
						
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