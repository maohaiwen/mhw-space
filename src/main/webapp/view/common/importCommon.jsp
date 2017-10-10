<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%> 
<link rel="stylesheet" href="<%=basePath %>css/zerogrid.css">
<link rel="stylesheet" href="<%=basePath %>css/style.css">
<link href="<%=basePath %>font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="<%=basePath %>css/menu.css">
<script src="<%=basePath %>js/jquery.min.js" type="text/javascript"></script>
<script src="<%=basePath %>js/script.js"></script>
<link href="<%=basePath %>owl-carousel/owl.carousel.css" rel="stylesheet">
<script src="<%=basePath %>owl-carousel/owl.carousel.js"></script>
