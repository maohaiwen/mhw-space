<%@page import="com.mhw.space.model.user.UserEntity"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
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
<jsp:include page="/view/common/importCommon.jsp"></jsp:include>
<script type="text/javascript" language="javascript">

	var basePath = '<%=basePath%>';

	function iFrameHeight() {
		var ifm = document.getElementById("iframepage");
		var subWeb = document.frames ? document.frames["iframepage"].document
				: ifm.contentDocument;
		if (ifm != null && subWeb != null) {
			ifm.height = subWeb.body.scrollHeight;
			//ifm.width = subWeb.body.scrollWidth;
		}
	}

	function directTo(url, num) {
		if(url != null && url != ""){
			$("#ul_menus li").attr("class", "");
			$("#ul_menus li:eq(" + num + ")").attr("class", "active");
			$("#iframepage").attr("src", basePath + url);
		}
	}

	function loadAllResources() {
		$.get(basePath + "resource/selectResourceList.action", function(data){
			if(data.code == 200){
				data = data.data;
				if(data != null && data.length > 0){
					var domStr = "";
					for(var i = 0 ; i < data.length ; i++){
						domStr += "<li><a href='javascrpit:void(0)' onclick=directTo('" + data[i].resourceUrl + "','" + i + "') ><span>" + data[i].resourceName + "</span></a></li>";
					}
					$("#ul_menus").html(domStr);
					$("#ul_menus li:eq(0)").attr("class", "active");
				}
			}
		});
	}
	
	function openLogin(){
		openModalWithHeight("login_modal", 400);
	}
	
	function doLogin(){
		var userName = $("#userName").val();
		if($.trim(userName) == ""){
			alert("请填写用户名");
			return;
		}
		var passWord = $("#passWord").val();
		if($.trim(passWord) == ""){
			alert("请填写密码");
			return;
		}
		
		var json = {"userName": userName, "passWord": passWord};
		$.post(basePath + "user/doLogin.action", json, function(data){
			alert(data.message);
			if(data.code == 200){
				loadUserMsg();
				closeModal("login_modal");
			}
			$("#userName,#passWord").val("");
		})
	}
	
	function loadUserMsg(){
		$.get(basePath + "user/getUserFromSession.action", function(data){
			if(data.code = 200){
				$("#loginArea").html(data.data.realName);
			}else{
				$("#loginArea").html("<a href=\"javascript:void(0)\" onclick=\"openLogin()\">登录</a>");
			}
		})
	}
	
	$(function(){
		loadAllResources();
		loadUserMsg();
	})
	
</script>
</head>

<body>
	<div class="wrap-body">
		<div id='cssmenu' class="align-center">
			<ul id="ul_menus">
				
			</ul>
		</div>
		<div id="loginArea" style="position:absolute;margin-left: 85%;">
			<a href="javascript:void(0)" onclick="openLogin()">登录</a>
		</div>
		<iframe src="<%=basePath%>dispatcher/homePage.action" id="iframepage"
			frameborder="0" scrolling="no" marginheight="0" marginwidth="0"
			style="width: 100%;z-index:-1;" onLoad="iFrameHeight()"></iframe>
	</div>
	
	<div id="login_modal" class="div_modal"
		style="width: 30%;min-width:300px; height: 16%; background: white; padding-top: 3%;z-index: 9999;">
		<label class="row" style="background: white;">
			<div class="col-1-3" style="background: white;">
				<div class="wrap-col" style="background: white;">
					<input id="userName" type="text" placeholder="用户名"
						style="width: 90%; height: 20px; margin-left: 5%;margin-top:0px;margin-bottom:0px;">
				</div>
			</div>
		</label> 
		<label class="row" style="background: white;margin-top:0px;margin-bottom:0px;padding-top:20px;padding-bottom:20px;">
			<div class="col-1-3">
				<input id="passWord" type="password" placeholder="密码"
					style="width: 90%; height: 20px; margin-left: 5%;margin-top:0px;margin-bottom:0px;">
			</div>
		</label>
		<center>
			<input class="sendButton" style="cursor:pointer;background:#575756;color:white;margin-top:0px;margin-bottom:0px;" type="button"
				onclick="doLogin()" name="login" value="登录">
		</center>
	</div>
</body>
</html>