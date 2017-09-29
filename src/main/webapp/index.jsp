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
		$("#ul_menus li").attr("class", "");
		$("#ul_menus li:eq(" + num + ")").attr("class", "active");
		$("#iframepage").attr("src", url);
	}

	function loadAllResources() {
		$.get(basePath + "resource/selectResourceList.action", function(data){
			if(data != null && data.length > 0){
				var domStr = "";
				for(var i = 0 ; i < data.length ; i++){
					domStr += "<li><a href='javascrpit:void(0)' onclick=directTo('" + data[i].resourceUrl + "','" + i + "') ><span>" + data[i].resourceName + "</span></a></li>";
				}
				$("#ul_menus").html(domStr);
				$("#ul_menus li:eq(0)").attr("class", "active");
			}
		});
	}
	
	$(function(){
		loadAllResources();
	})
	
</script>
</head>

<body>
	<div class="wrap-body">
		<div id='cssmenu' class="align-center">
			<ul id="ul_menus">
				
			</ul>
		</div>
		<iframe src="<%=basePath%>dispatcher/homePage.action" id="iframepage"
			frameborder="0" scrolling="no" marginheight="0" marginwidth="0"
			style="width: 100%;" onLoad="iFrameHeight()"></iframe>
	</div>
</body>
</html>