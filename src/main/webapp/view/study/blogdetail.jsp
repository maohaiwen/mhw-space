<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
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
<title>学术</title>
<meta name="description" content="Free Responsive Html5 Css3 Templates ">
<meta name="author" content="#">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Access-Control-Allow-Origin" content="*">
<script type="text/javascript">
	
	var basePath = '<%=basePath%>';
	
</script>
</head>

<body>
	<div style="width:100%;">
		<div style="padding:2% 4% 5% 4%;height:4%;border-bottom : 1px solid #ADADAD;">
			<ul>
				<li style="font-weight:bold;font-size:20px;letter-spacing: 1px;font-family:微软雅黑">${blog.title }</li>
				<li style="font-size:3px;color:#8B8989">
				${blog.addTimeStr }
				&nbsp;&nbsp;&nbsp;
				点赞（${blog.praiseCount }） 
				评论（${blog.commentCount }）
				</li>
			</ul>
		</div>
		<div style="padding:0 4% 4% 4%;">
		${blog.content }
		</div>
	</div>
</body>
</html>