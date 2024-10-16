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
						<li><a class="active"><i class="lnr lnr-home"></i> <span
								class="active">添加次管理员</span></a></li>
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
						<li><i class="lnr lnr-user"></i> <span>${sessionScope.username }</span></li>
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
								<form action="add.user" >
									<table class="table table-hover" >
										
										<tbody>
											<tr>
												<c:if test="${! empty requestScope.message}">
															<font color="red">${requestScope.message}</font>
													</c:if>
												<td>用户名</td>
												<td>
													<input type="text" name="username"> 
												</td>
											<tr>
												<td>密码</td>
												<td><input type="text" name="password" ></td>
											</tr>
											<tr>
												<td>手机号</td>
												<td><input type="text" name="phone" ></td>
											</tr>
											<tr>
												<td>
													<button type="submit" class="btn btn-success btn-xs">添加</button>
												</td>
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