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
<title>学术</title>
<meta name="description" content="Free Responsive Html5 Css3 Templates ">
<meta name="author" content="#">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Access-Control-Allow-Origin" content="*">
<link rel="stylesheet" href="<%=basePath %>js/blog/blog.css" />
<script type="text/javascript" charset="utf-8" src="<%=basePath%>js/blog/blog.js"></script>
<script type="text/javascript">
	
	var basePath = '<%=basePath%>';
	
	function openWriteBlog(){
		window.open(basePath + "dispatcher/toWriteBlog.action");
	}
	
	$(function(){
		blog.init("div_blog", basePath + "study/selectBlogPage.action");
	})
</script>
</head>

<body>
	<div class="blog_outer">
		<div style="padding-top:1%;padding-left:7%;">
			<a href="javascript:void(0)" onclick="openWriteBlog()">写博客</a>
		</div>

		<div style="overflow-y:scroll;height:1050px;">
		
			<div id="div_blog"></div>
			<div id="div_load_more" class='blog_inner' style='text-align:center;cursor:pointer;' onclick="blog.loadMore()">加载更多</div>
		</div>
	</div>
</body>
</html>