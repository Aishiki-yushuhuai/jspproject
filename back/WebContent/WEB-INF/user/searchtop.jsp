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
							<!-- LEFT COLUMN -->
							<div class="profile-main ">
								<!-- PROFILE HEADER -->
							<c:forEach items="${requestScope.pageHelper.data}" var="user" varStatus="i">
								<div class="profile-header">
									<div class="overlay"></div>
									<div class="profile-main">
									<img src="assets/img/user-medium.png" class="img-circle" alt="Avatar">
										<h3 class="name">${user.username }</h3>
										<span class="online-status status-available">在线</span>
									</div>
									
								</div>
								<!-- END PROFILE HEADER -->
								<!-- PROFILE DETAIL -->
								<div class="profile-detail">
									<div class="profile-info">
										<h4 class="heading">我的信息</h4>
										<ul class="list-unstyled list-justify">
											<li>用户名 <span>${user.username }</span></li>
											<li>密码 <span>${user.password }</span></li>
											<li>备注<span><c:if test="${user.status == 1}">主管理员</c:if>
													<c:if test="${user.status == 2}">次管理员</c:if></span></li>
											<li>操作人 <span>${user.managerName }</span></li>
											<li>操作时间 <span>${user.time }</span></li>
										</ul>
									</div>
									
									<div class="profile-info">
										<h4 class="heading">关于</h4>
										<p><c:if test="${user.status == 1}">主管理员不可添加，不可删除</c:if>
													<c:if test="${user.status == 2}">次管理员，只可管理用户信息</c:if></p>
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

</html>