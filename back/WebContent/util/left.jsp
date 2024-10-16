<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- LEFT SIDEBAR -->
		<div id="sidebar-nav" class="sidebar">
			<div class="sidebar-scroll">
				<nav>
					<ul class="nav">
						<li><a href="index.html?menuId=8" <c:if test="${sessionScope.menuId == 8}">class="active"</c:if>><i class="lnr lnr-home"></i> <span>首页</span></a></li>
						<li>
							<a href="list.user?menuId=0" <c:if test="${sessionScope.menuId == 0}">class="active"</c:if>><i class="lnr lnr-user"></i>
								<span>用户管理</span>
						 	</a>
						 </li>
						<li><a href="list.info?menuId=1" <c:if test="${sessionScope.menuId == 1}">class="active"</c:if>><i class="lnr lnr-bullhorn"></i> <span>企业管理</span></a></li>
						<li><a href="list.info?menuId=2" <c:if test="${sessionScope.menuId == 2}">class="active"</c:if>><i class="lnr lnr-chart-bars"></i> <span>设备管理</span></a></li>
						<li><a href="list.info?menuId=3" <c:if test="${sessionScope.menuId == 3}">class="active"</c:if>><i class="lnr lnr-cog"></i> <span>专家管理</span></a></li>
						<li><a href="list.info?menuId=4" <c:if test="${sessionScope.menuId == 4}">class="active"</c:if>><i class="lnr lnr-alarm"></i> <span>培训管理</span></a></li>
						<li><a href="list.review?menuId=5" <c:if test="${sessionScope.menuId == 5}">class="active"</c:if>><i class="lnr lnr-file-empty"></i> <span>评价管理</span></a></li>
						<li><a href="list.wec?menuId=6" <c:if test="${sessionScope.menuId == 6}">class="active"</c:if>><i class="lnr lnr-dice"></i> <span>联系我们</span></a></li>
						<li><a href="list.pic?menuId=7" <c:if test="${sessionScope.menuId == 7}">class="active"</c:if>><i class="lnr lnr-text-format"></i> <span>图片管理</span></a></li>
					</ul>
				</nav>
			</div>
		</div>
		<!-- END LEFT SIDEBAR -->