<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
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
		function iFrameHeight() {   
			var ifm= document.getElementById("iframepage");   
			var subWeb = document.frames ? document.frames["iframepage"].document : ifm.contentDocument;   
			if(ifm != null && subWeb != null) {
			   ifm.height = subWeb.body.scrollHeight;
			   //ifm.width = subWeb.body.scrollWidth;
			}   
		}  
		
		function directTo(){
			
		}
</script>
</head>

<body>
	<div class="wrap-body">
		<div id='cssmenu' class="align-center">
			<ul>
				<li class="active"><a href='javascrpit:void(0)' onclick="directTo('1')"><span>首页</span></a></li>
				<li><a href='index.jsp'><span>学术</span></a></li>
				<li class="last"><a href='index.jsp'><span>随便记记</span></a></li>
				<li class="last"><a href='index.jsp'><span>about me</span></a></li>
			</ul>
		</div>
		<iframe src="<%=basePath %>dispatcher/homePage.action" id="iframepage" frameborder="0"
			scrolling="no" marginheight="0" marginwidth="0" style="width:100%;"
			onLoad="iFrameHeight()"></iframe>
	</div>
</body>
</html>