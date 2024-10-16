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
				
					<div class="col-md-12">
						<!-- TABLE HOVER -->
						<div class="panel panel-headline">
							<div class="panel-heading" >
								<h3 class="panel-title">评论列表</h3>
							</div>
							<c:if test="${empty requestScope.pageHelper.data}">
								
									<div class="panel-heading">
										<h3 class="panel-title"><font color="red">无数据</font></h3>
									</div>
								
							</c:if>
							
						</div>
						
						<c:if test="${!empty requestScope.pageHelper.data}">
						
						<div class="panel">
							<div class="panel-body">
								
							
							
								<table class="table table-hover">
									<thead>
										<tr>
											<th>序号</th>
											<th>评论内容</th>
											<th>评价人</th>
											<th>评价时间</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${requestScope.pageHelper.data}" var="rew" varStatus="i">
											
											<tr>
												<td>${i.count }</td>
												<td>${rew.message }</td>
												<td>${rew.username }</td>
												<td>${rew.time }</td>
												<td>
													<c:url value="/delete.review" var="deleteUrl">
														<c:param name="id" value="${rew.id}"></c:param>
													</c:url> 
													<a href="${deleteUrl}">
														<button type="submit" class="btn btn-danger btn-xs" 
															>删除</button>
													</a>
												</td>
												<td><input type="hidden" name="id" value="${rew.id}"></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<h4>共：${ requestScope.pageHelper.pageCount}页，共：${ requestScope.pageHelper.totalRecords}条记录，当前第${ requestScope.pageHelper.page}页</h4>
								<div style="margin : 0 auto ;width:450px;  height: 450px">
									<ul class="pagination pagination-lg">
										<li><a href="list.review?menuId=5">首页</a></li>
										<c:if test="${requestScope.pageHelper.page != 1}">
											<li><a href="list.review?menuId=5&page=${requestScope.pageHelper.page - 1}">&laquo;</a></li>
										</c:if>
										<c:forEach begin="1" end="${requestScope.pageHelper.pageCount}" var="i">
											<li><a href="list.review?menuId=5&page=${i}">${i}</a></li>
										</c:forEach>
										<c:if test="${requestScope.pageHelper.page != requestScope.pageHelper.pageCount}">
											<li><a href="list.review?menuId=5&page=${requestScope.pageHelper.page + 1}">&raquo;</a></li>
										</c:if>
										<li><a href="list.review?menuId=5&page=${requestScope.pageHelper.pageCount}">尾页</a></li>
									</ul>
								</div>
							
							
							</div>
						</div>
						</c:if>
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
    $(".btn.btn-danger.btn-xs").click(function () {
        var content = $(this).parent().parent().parent().find("td:eq(1)").text();
        return confirm("确定要删除【"+ content +"】的信息吗")
    })
})
</script>
</html>