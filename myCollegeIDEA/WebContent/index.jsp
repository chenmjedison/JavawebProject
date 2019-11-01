<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>

<head>
<title>调查首页</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript">
	
	
	
	
			addEventListener("load", function() {
				setTimeout(hideURLbar, 0);
			}, false);

			function hideURLbar() {
				window.scrollTo(0, 1);
			}
		



</script>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/simpleCart.min.js">
	
</script>
<script src=""></script>
<!-- Custom Theme files -->
<link href="css/style1.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<!--webfont-->
<!--//webfont-->
<script src="js/jquery.easydropdown.js"></script>
<!-- Add fancyBox main JS and CSS files -->
<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
<link href="css/magnific-popup.css" rel="stylesheet" type="text/css">


<style>
</style>
</head>

<body>


	<div class="header">
		<div class="container">
			<div class="header-top">
				<div class="logo">
					<a href="">
						<h6>毕业生</h6>
						<h2>问卷调查</h2>
					</a>
				</div>
				<div class="header_right">
					<ul class="social">
						<li><a href=""> <i class="fb"> </i>
						</a></li>
						<li><a href=""><i class="tw"> </i> </a></li>
						<li><a href=""><i class="utube"> </i> </a></li>
						<li><a href=""><i class="pin"> </i> </a></li>
						<li><a href=""><i class="instagram"> </i> </a></li>
					</ul>
					<div class="lang_list">
						<a tabindex="4" class="dropdown" href="closeMethod" >
							<h3>安全退出</h3>
						</a>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="about_box">
				<ul class="login">
					<li class="login_text">
					<c:choose>
							<c:when test="${sessionScope.user == null}">
								<a href="login.jsp">登录</a>
							</c:when>
							<c:otherwise>
								${sessionScope.user.userName} 已登录
							</c:otherwise>
						</c:choose>
					<li class="wish"><a href="findAllPingLunIndex?currentPage=1">评论信息</a></li>
					<div class='clearfix'></div>
				</ul>
				<ul class="quick_access">
					<li class="view_cart"><a href="person.jsp">查看个人信息</a></li>
					
					<div class='clearfix'></div>
				</ul>
				<div class="search">
				<form action="findWenJuanByNameIndex?currentPage=1" method="post">
					<input type="text" id="wjName" name="wjName" onfocus="this.value = '';"
						onblur="if (this.value == '') {this.value = 'Search';}"> <input
						type="submit" value="">
						</form>
				</div>
			</div>
		</div>
	</div>
	<div class="main">
		<div class="content_box">
			<div class="container">
				<div class="row">
					<div class="col-md-3">
						<div class="menu_box">
							<h3 class="menu_head">分类列表</h3>
							<ul class="nav">
								<c:forEach var="list" items="${wenJuanList }">
									<li><a href="findAllTypeWenJuan?currentPage=1&wjType=${list.wjType }">${list.wjType }</a></li>
									</c:forEach>
								
							</ul>
						</div>

					</div>
					<div class="col-md-9">
						<h3 class="m_1">热门问卷</h3>
						<div class="content_grid">

							<c:forEach var="wenJuan"
								items="${pageInfo.list }" begin="0" end="2">

								<div class="col_1_of_3 span_1_of_3 simpleCart_shelfItem last_1">
									<a href="">
										<div class="inner_content clearfix">
											<div class="product_image">
												<img src="${goodsItem1.topImageUrl }" class="img-responsive"
													alt="" /><a href="findTiMuWenJuan?currentPage=1&wjId=${wenJuan.wjId }" class="button item_add item_1"> </a>
												<div class="product_container">
													<div class="cart-left">
														<p class="title">${wenJuan.wjName}</p>
													</div>
													<span class="amount item_price">
														</span>
													<div class="clearfix"></div>
												</div>
											</div>
										</div>
									</a>
								</div>

							</c:forEach>
							<br/>
											
							

							<div class="clearfix"></div>
						</div>
							<p ><page:pager url="${url}"
														totalPage="${pageInfo.lastPage}"
														currentPage="${pageInfo.pageNum}" /></p>
						<div class="content_grid">
							
							<div class="clearfix"></div>
						</div>

					</div>
				</div>
			</div>


			<div class="footer_bottom">
				<div class="container">
					<div class="copy">
						<p>
							Copyright &copy; 版权信息 <a href="http://www.cssmoban.com/"
								target="_blank" title="softeem">lanhai</a>
						</p>
					</div>
				</div>
			</div>



			<!-- 在数据显示完成之后,清除掉session中的内容 -->
			<c:remove var="indexGoodsList" scope="session" />
			<c:remove var="indexCategoryList" scope="session" />
</body>

</html>