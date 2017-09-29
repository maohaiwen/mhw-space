<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Access-Control-Allow-Origin" content="*">  
<title>Insert title here</title>
<link rel="stylesheet" href="<%=basePath %>css/zerogrid.css">
<link rel="stylesheet" href="<%=basePath %>css/style.css">
<link href="<%=basePath %>font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="<%=basePath %>css/menu.css">
<script src="<%=basePath %>js/jquery.min.js" type="text/javascript"></script>
<script src="<%=basePath %>js/script.js"></script>
<link href="<%=basePath %>owl-carousel/owl.carousel.css" rel="stylesheet">
<script src="<%=basePath %>owl-carousel/owl.carousel.js"></script>
</head>
</html>