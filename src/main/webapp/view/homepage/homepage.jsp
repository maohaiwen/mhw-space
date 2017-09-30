<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<jsp:include page="/view/common/importCommon.jsp"></jsp:include>
<!DOCTYPE html>
<head>

<!-- Basic Page Needs
  ================================================== -->
<meta charset="utf-8">
<title>maohaiwen</title>
<meta name="description" content="Free Responsive Html5 Css3 Templates ">
<meta name="author" content="#">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Access-Control-Allow-Origin" content="*">

<script type="text/javascript">
	
	var basePath = '<%=basePath%>';
	
	function submitMessage(){
		var name = $("#name").val();
		var message = $("#message").val();
		
		if($.trim(name) == "" || $.trim(message) == ""){
			alert("咱填完了再提交。");
			return;
		}
		var json = {"name": name, "content": message};
		$.post(basePath + "leaveMessage/addLeaveMessage.action", json, function(data){
			if(data.code == 200){
				alert("留言成功！");
			}else{
				alert(data.message);
			}
			$("#name,#message").val("");
		})
	}
	
	function openLogin(){
		openModalWithHeight("login_modal", 400);
	}
	
</script>
</head>

<body>
	<div class="wrap-body">
		<header class="">
			<div style="margin-left: 88%;">
				<a href="javascript:void(0)" onclick="openLogin()">登录</a>
			</div>
			<div class="logo">
				<hr class="line-1">
				<span>欢迎来到我的个人网站</span> <a href="#">maohaiwen</a>
				<hr class="line-1">
			</div>
			<div id="owl-slide" class="owl-carousel">
				<div class="item">
					<img src="<%=basePath%>images/slider1.jpg" />
				</div>
				<div class="item">
					<img src="<%=basePath%>images/slider2.jpg" />
				</div>
				<div class="item">
					<img src="<%=basePath%>images/slider3.jpg" />
				</div>
			</div>
		</header>
		<!--////////////////////////////////////Container-->
		<!--////////////////////////////////////Container-->
		<section id="container">
			<div class="wrap-container">
				<!-----------------Content-Box-------------------->
				<section class="content-box zerogrid">
					<div class="row wrap-box">
						<!--Start Box-->
						<h3 class="t-center">给我留个言啥的</h3>
						<div id="contact_form">
							<form name="form1" id="ff" method="post" action="contact.php">
								<label class="row">
									<div class="col-1-3">
										<div class="wrap-col">
											<input type="text" name="name" id="name" placeholder="姓名"
												required="required" />
										</div>
									</div>
								</label> <label class="row">
									<div class="wrap-col">
										<textarea name="message" id="message" class="form-control"
											rows="4" cols="25" required="required" placeholder="留言内容"></textarea>
									</div>
								</label>
								<center>
									<input class="sendButton" style="width: 20%;" type="button"
										onclick="submitMessage()" name="Submit" value="提交">
								</center>
							</form>
						</div>
					</div>
				</section>

			</div>
		</section>


		<!--////////////////////////////////////Footer-->
		<footer>
			<div class="zerogrid wrap-footer">
				<div class="row">
					<div class="bottom-social">
						<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
							class="fa fa-instagram"></i></a> <a href="#"><i
							class="fa fa-twitter"></i></a> <a href="#"><i
							class="fa fa-google-plus"></i></a> <a href="#"><i
							class="fa fa-pinterest"></i></a> <a href="#"><i
							class="fa fa-vimeo"></i></a> <a href="#"><i
							class="fa fa-linkedin"></i></a> <a href="#"><i
							class="fa fa-youtube"></i></a>
					</div>
				</div>
			</div>
		</footer>
		<script>
			$(document)
					.ready(
							function() {
								$("#owl-slide")
										.owlCarousel(
												{
													autoPlay : 3000,
													items : 1,
													itemsDesktop : [ 1199, 1 ],
													itemsDesktopSmall : [ 979,
															1 ],
													itemsTablet : [ 768, 1 ],
													itemsMobile : [ 479, 1 ],
													navigation : true,
													navigationText : [
															'<i class="fa fa-chevron-left fa-5x"></i>',
															'<i class="fa fa-chevron-right fa-5x"></i>' ],
													pagination : false
												});
							});
		</script>
	</div>

	<div id="login_modal" class="div_modal"
		style="width: 30%;min-width:768px; height: 16%; background: white; padding-top: 3%;">
		<label class="row">
			<div class="col-1-3">
				<div class="wrap-col">
					<input type="text" placeholder="用户名"
						style="width: 90%; height: 20px; margin-left: 5%;">
				</div>
			</div>
		</label> <label class="row">
			<div class="wrap-col">
				<input type="password" placeholder="密码"
					style="width: 90%; height: 20px; margin-left: 5%;">
			</div>
		</label>
		<center>
			<input class="sendButton" style="cursor:pointer;background:#575756;color:white;" type="button"
				onclick="submitMessage()" name="login" value="登录">
		</center>
	</div>
</body>
</html>