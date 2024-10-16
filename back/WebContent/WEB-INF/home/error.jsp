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
	<div id="wrapper">
		<jsp:include page="/util/top.jsp"></jsp:include>
		<jsp:include page="/util/left.jsp"></jsp:include>
		
		<!-- MAIN -->
		<div class="main">
			<!-- MAIN CONTENT -->
			<div class="main-content">
				<div class="container-fluid">
				
					<div class="col-md-12">
						<!-- TABLE HOVER -->
						<div class="panel panel-headline">
							<div class="panel-heading">
										
								<h3 class="panel-title"><font color="red">${requestScope.size}</font></h3>
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