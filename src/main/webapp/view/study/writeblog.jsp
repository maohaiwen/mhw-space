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
<script type="text/javascript" charset="utf-8"
	src="<%=basePath%>js/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="<%=basePath%>js/ueditor/ueditor.all.min.js"></script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8"
	src="<%=basePath%>js/ueditor/lang/zh-cn/zh-cn.js"></script>

<!-- 创建编辑器并设置属性 -->

<script type="text/javascript">

	var basePath = '<%=basePath%>';

	//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
	//相见文档配置属于你自己的编译器
	var ue = UE.getEditor('editor', {
		initialFrameHeight : 300,
		initialFrameWeight : 100,
		imageUrl : '',
		imagePath : '',
		toolbars : [ [ 'undo', 'redo', '|', 'bold', 'forecolor',
				'removeformat', 'autotypeset', 'pasteplain', '|', '|',
				'justifyleft', 'justifycenter', '|', 'link', 'unlink', '|',
				'insertimage', 'insertvideo', '|', 'wordimage', '|',
				'inserttable', 'insertrow', 'deleterow', 'insertcol',
				'deletecol', 'mergecells', 'splittocells', '|', 'mybtn1',
				'mydialog1' ] ]
	});

	function doSubmitBlog() {
		var frm = ue.form;
		var title = $("#title").val();
		if ($.trim(title) == "") {
			alert("请填写标题！");
			return;
		}

		var content = $(frm).children("#ueditor_textarea_myContent").val();
		if ($.trim(content) == "") {
			alert("请填写内容！");
			return;
		}
		var jsonIn = {"title": title, "content": content};
		$.post(basePath + "study/insertBlog.action", jsonIn, function(data){
			if(data.code == 200){
				alert("博客发表成功！");
				closePage();
			}else{
				alert(data.message);
			}
		})
	}
</script>
</head>

<body>
	<form id="frm_blog" method="post">

		<div>
			标题：<input type="text" id="title" name="title" />
		</div>
		内容：
		<script type="text/plain" id="editor" name="myContent">
    </script>
		<input class="sendButton"
			style="cursor: pointer; background: #999999; color: white; margin-top: 0px; margin-bottom: 0px;"
			type="button" onclick="doSubmitBlog()" name="login" value="提交">
		<input class="sendButton"
			style="cursor: pointer; background: #999999; color: white; margin-top: 0px; margin-bottom: 0px;"
			type="button" onclick="doLogin()" name="login" value="取消">
	</form>
</body>
</html>