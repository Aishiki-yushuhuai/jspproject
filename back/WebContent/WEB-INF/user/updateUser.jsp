<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shelley后台管理系统</title>
<jsp:include page="/util/css.jsp"></jsp:include>
</head>
<body>

	<div id="wrapper">
		<div id="sidebar-nav" class="sidebar">
			<div class="sidebar-scroll">
				<nav>
					
					<ul class="nav">
						<li><a href="list.user" class="active"><i class="lnr lnr-home"></i> <span
								class="active">修改用户</span></a></li>
					</ul>
					
				</nav>
			</div>
		</div>
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="brand">
				<a href="index.html"><img src="assets/img/logo-dark.png"
					alt="Klorofil Logo" class="img-responsive logo"></a>
			</div>
			<div class="container-fluid">
				<div class="navbar-btn">
					<button type="button" class="btn-toggle-fullwidth">
						<i class="lnr lnr-arrow-left-circle"></i>
					</button>
				</div>

				<div id="navbar-menu">
					<ul class="nav navbar-nav navbar-right">
						<li><i class="lnr lnr-user"></i> <span>用户</span></li>
						<li class="dropdown"><a href="list.user?menuId=0">
								<button type="button" class="btn btn-default">返回</button>
						</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<!-- END NAVBAR -->

		<div class="main">
			<!-- MAIN CONTENT -->
			<div class="main-content">
				<div class="container-fluid">

					<div class="col-md-12">
						<div class="panel">
							<div class="panel-body">

								<c:if test="${! empty requestScope.message}">
										<font color="red">${requestScope.message}</font>
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
									<c:set var="phone" value="${param.phone}"></c:set>
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
												<td>密码</td>
												<td><input type="text" name="password" value="${password }"></td>
											</tr>
											<tr>
												<td>手机号</td>
												<td><input type="text" name="phone" value="${phone }"></td>
											</tr>
											<tr>
												<td><button type="submit" class="btn btn-success btn-xs">修改</button></td>
											</tr>
										</tbody>
									</table>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/util/js.jsp"></jsp:include>
</body>
</html>