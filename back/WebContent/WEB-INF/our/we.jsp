<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shelley后台管理系统</title>
<jsp:include page="/util/css.jsp"></jsp:include>

</head>
<body>
	<!-- WRAPPER -->
	<div id="wrapper">
		<jsp:include page="/util/top.jsp"></jsp:include>
		<jsp:include page="/util/left.jsp"></jsp:include>

		<!-- MAIN -->
		<div class="main">
			<!-- MAIN CONTENT -->
			<div class="main-content">
				<div class="container-fluid">
						<div class="clearfix ">

							<div class="profile-main ">
								<!-- PROFILE HEADER -->
							<c:if test="${empty requestScope.pageHelper.data}">
								<div class="panel panel-headline">
									<div class="panel-heading">
										<h3 class="panel-title"><font color="red">无数据</font></h3>
									</div>
									
								</div>
								<div class="panel-body" align="left">
										<span class="input-group-btn" > 
										<a href="addedit.wec?menuId=6">
										<button type="submit" class="btn btn-primary">添加联系方式</button></a>
										</span>
									</div>
							</c:if>
							<c:forEach items="${requestScope.pageHelper.data}" var="we" varStatus="i">
								<div class="profile-header">
									<div class="overlay"></div>
									<div class="profile-main">
									<img src=" ${we.image }" alt="Avatar">
										<h3 class="name">联系我们</h3>
									</div>
									
								</div>
								<!-- END PROFILE HEADER -->
								<!-- PROFILE DETAIL -->
								<div class="profile-detail">
									<div class="profile-info">
										<h4 class="heading">联系人信息</h4>
										<ul class="list-unstyled list-justify">
											<li>联系人 <span>${we.person }</span></li>
											<li>联系电话 <span>${we.telphone }</span></li>
											<li>联系地址<span>${we.address }</span></li>
											<li>操作人 <span>${we.username }</span></li>
											<li>操作时间 <span>${we.time }</span></li>
										</ul>
									</div>
									
									<div class="text-center">
										
										<a href="delete.wec?id=${we.id}" class="btn btn-primary">删除</a>
									</div>
								</div>
								<!-- END PROFILE DETAIL -->
								</c:forEach>
							</div>
						</div>
				</div>
			<!-- END MAIN CONTENT -->
			</div>
		</div>
		<!-- END MAIN -->
		<div class="clearfix"></div>
		<footer>
			<div class="container-fluid">
				<p class="copyright">Copyright &copy; 2021.Shelley.Violet</p>
			</div>
		</footer>
	</div>
	<!-- END WRAPPER -->
	<jsp:include page="/util/js.jsp"></jsp:include>
</body>
<script type="text/javascript">
$(function () {
    $(".text-center").click(function () {
        return confirm("确定要删除联系人信息吗")
    })
})
</script>
</html>