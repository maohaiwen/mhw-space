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
	
</script>
</head>

<body>
	<div class="wrap-body">
		学术
	</div>

</body>
</html>