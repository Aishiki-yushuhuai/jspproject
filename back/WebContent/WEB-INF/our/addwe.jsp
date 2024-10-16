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
						<li><a class="active"><i class="lnr lnr-home"></i> 
						<span class="active">添加联系方式</span></a></li>
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
						<li class="dropdown"><a href="list.wec?menuId=6">
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
								<form action="add.wec" method="post" enctype="multipart/form-data">
								<input type="hidden" name="menuId" value="6">
									<table class="table table-hover" >
										<tbody>
											<tr>
												<td>联系图片</td>
												<td>
													<input type="file" name="file"> 
													
												</td>
											</tr>
											<tr>
												<td>联系人</td>
												<td><input type="text" name="person" ></td>
											</tr>
											<tr>
												<td>联系电话</td>
												<td><input type="text" name="telphone" ></td>
											</tr>
											<tr>
												<td>联系地址</td>
												<td><input type="text" name="address" ></td>
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