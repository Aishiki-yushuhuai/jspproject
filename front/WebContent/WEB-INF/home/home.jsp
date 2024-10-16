<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>九台云平台</title>
<jsp:include page="/util/import.jsp"></jsp:include>
<style>
		.dropbtn {
		    background-color: #4CAF50;
		    color: white;
		    padding: 16px;
		    font-size: 16px;
		    border: none;
		    cursor: pointer;
		}
		
		.dropbtn:hover, .dropbtn:focus {
		    background-color: #3e8e41;
		}
		
		.dropdown {
		    float: right;
		    position: relative;
		    display: inline-block;
		    
		}
		
		.dropdown-content {
			text-align: center;
		    display: none;
		    position: absolute;
		    background-color: #f9f9f9;
		    min-width: 138px;
		    overflow: auto;
		    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
		    right: 0;
		    z-index: 1;
		}
		
		.dropdown-content a {
		    color: black;
		    padding: 12px 16px;
		    text-decoration: none;
		    display: block;
		}
		
		.dropdown .a_list:hover {background-color: rgb(30, 130, 232)}
		
		.show {display:block;}
		.a_list{
			line-height: 30px;
		}
	</style>
</head>
<body>
		<div class="t_top hidden-xs hidden-sm">
			<div class="container">
				<div class="row clearfix">
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
								<li <c:if test="${sessionScope.menuId == 0}">class="active"</c:if>><a href="index.html?menuId=0">网站首页</a></li>
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
		<div class="carousel slide" id="carousel-547792">
			<ol class="carousel-indicators">
				<li class="active" data-slide-to="0" data-target="#carousel-547792">
				</li>
				<li data-slide-to="1" data-target="#carousel-547792">
				</li>
			</ol>
			<div class="carousel-inner">
				<div class="item active">
					<img alt="" src="static/images/banner1.jpg" />
				</div>
				<c:forEach items="${requestScope.picList.data }" var="pic">
-					<div class="item">
						<img alt="" src="${pic.image }" />
					</div>
				</c:forEach>
			</div> 
			<a class="left carousel-control" href="#carousel-547792" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
			<a class="right carousel-control" href="#carousel-547792" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
			
		</div>
		<div class="fangan">
			<div class="container">
				<div class="row clearfix">
					<div class="col-md-12 column">
						<div class="row clearfix" aos="fade-up">
							<div class="tit col-md-12 column">
								<h3 class="text-center">
									企业资源
								</h3>
								<h4 class="text-center">
									已有<font color="red" size="6">${requestScope.menuId1}+</font>家合作伙伴
								</h4>
								<em></em>
							</div>
						</div>
						<div class="fanganc row clearfix">
							<div style="width: 1150px;height: 220px;">
								<c:forEach items="${requestScope.infoList1.data }" var="info1">
										<div class="col-md-4 column" aos="fade-up" aos-delay="000">
											<a href="product_article.html" class="fanganb">
												<div class="fanganimg"><img src="${info1.image }" alt="" class="img-responsive"></div>
											</a>
										</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="fangan">
			<div class="container">
				<div class="row clearfix">
					<div class="col-md-12 column">
						<div class="row clearfix" aos="fade-up">
							<div class="tit col-md-12 column">
								<h3 class="text-center">
									设备资源
								</h3>
								<h4 class="text-center">
									我们致力于扎根行业、深入场景进行产品设计和创新，为工业制造行业用户构建端到端的解决方案
								</h4>
								<em></em>
							</div>
						</div>
						<div class="fanganc row clearfix">
						<c:forEach items="${requestScope.infoList2.data }" var="info">
							<div class="col-md-4 column" aos="fade-up" aos-delay="000">
								<a href="product_article.html" class="fanganb">
									<div class="fanganimg"><img src="${info.image }" alt="" class="img-responsive"></div>
									<div class="fangantit">${info.message }</div>
									<div class="fanganinfo">${info.remark }</div>
								</a>
							</div>
						</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="fangan">
			<div class="container">
				<div class="row clearfix">
					<div class="col-md-12 column">
						<div class="row clearfix" aos="fade-up">
							<div class="tit col-md-12 column">
								<h3 class="text-center">
									专家资源
								</h3>
								<h4 class="text-center">
									我们致力于扎根行业、深入场景进行产品设计和创新，为工业制造行业用户构建端到端的解决方案
								</h4>
								<em></em>
							</div>
						</div>
						<div class="fanganc row clearfix">
						<c:forEach items="${requestScope.infoList3.data }" var="info">
							<div class="col-md-4 column" aos="fade-up" aos-delay="000">
								<a href="product_article.html" class="fanganb">
									<div class="fanganimg"><img src="${info.image }" alt="" class="img-responsive"></div>
									<div class="fangantit">${info.message }</div>
									<div class="fanganinfo">${info.remark }</div>
								</a>
							</div>
						</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
		
				<div class="fangan">
			<div class="container">
				<div class="row clearfix">
					<div class="col-md-12 column">
						<div class="row clearfix" aos="fade-up">
							<div class="tit col-md-12 column">
								<h3 class="text-center">
									培训资源
								</h3>
								<h4 class="text-center">
									我们致力于扎根行业、深入场景进行产品设计和创新，为工业制造行业用户构建端到端的解决方案
								</h4>
								<em></em>
							</div>
						</div>
						<div class="fanganc row clearfix">
						<c:forEach items="${requestScope.infoList4.data }" var="info">
							<div class="col-md-4 column" aos="fade-up" aos-delay="000">
								<a href="product_article.html" class="fanganb">
									<div class="fanganimg"><img src="${info.image }" alt="" class="img-responsive"></div>
									<div class="fangantit">${info.message }</div>
									<div class="fanganinfo">${info.remark }</div>
								</a>
							</div>
						</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="about">
			<div class="container">
				<div class="row clearfix">
					<div class="col-md-12 column">
						<div class="row clearfix" aos="fade-up">
							<div class="tit col-md-12 column">
								<h3 class="text-center">
									关于我们
								</h3>
								<h4 class="text-center">
									中国制造2025迎接智能时代新挑战
								</h4>
								<em></em>
							</div>
						</div>
						<div class="aboutc row clearfix">
							<div class="col-md-6 column" aos="fade-right">
								<div class="aboutb">
									<div class="abouttit">九台云平台</div>
									<em class="aboutem"></em>
									<div class="aboutinfo">九台云平台</div>
								</div>
							</div>
						</div>
						<div class="aboutd">
							<div class="aboutdsz col-md-3 col-sm-3 col-xs-6 column text-center" aos="flip-up">
								<div class="aboutds">${requestScope.menuId1 }<span>+</span></div>
								<div class="aboutdz">企业</div>
							</div>
							<div class="aboutdsz col-md-3 col-sm-3 col-xs-6 column text-center" aos="flip-up">
								<div class="aboutds">${requestScope.menuId2 }<span>+</span></div>
								<div class="aboutdz">专家</div>
							</div>
							<div class="aboutdsz col-md-3 col-sm-3 col-xs-6 column text-center" aos="flip-up">
								<div class="aboutds">${requestScope.menuId3 }<span>+</span></div>
								<div class="aboutdz">设备</div>
							</div>
							<div class="aboutdsz col-md-3 col-sm-3 col-xs-6 column text-center" aos="flip-up">
								<div class="aboutds">${requestScope.menuId4 }<span>+</span></div>
								<div class="aboutdz">培训</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="pinjia">
			<div class="pinjiadian">
				<div class="container">
					<div class="row clearfix">
						<div class="col-md-12 column">
							<div class="row clearfix" aos="zoom-in">
								<div class="tit col-md-12 column">
									<h3 class="text-center white">
										企业文化
									</h3>
									<h4 class="text-center white">
										*******
									</h4>
									<em></em>
								</div>
							</div>
						</div>
						<div class="clearfix"></div>
						<div class="pinjiaa col-md-8 column" aos="zoom-in-down">
							<div class="row clearfix">
								<div class="pinjiac">
									<div class="pinjiacyh text-center">企业愿景</div>
									<div class="pinjiacnr text-center">*********</div>
								</div>
							</div>
						</div>
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
				duration: 2000,
				once: true
			});
		</script>
		<script type="text/javascript">
			function myFunction() {
			    document.getElementById("myDropdown").style.display = "block";
			}
			function myFunction1() {
			    document.getElementById("myDropdown").style.display = "none";
			}
		</script>
	<script type="text/javascript">
		$(function() {
			$("#out").click(function() {
				return confirm("确定要退出吗")
			})
		})
	</script>
</body>
</html>