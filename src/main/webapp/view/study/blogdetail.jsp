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
	
	function doPraise(id){
		$.post(basePath + "study/doPraiseBlog.action", {"id": id}, function(data){
			if(data.code == 200){
				$(".praise_count").html("(" + data.data + ")");
			}else{
				alert(data.message);
			}
		})
	}
	
	function doComment(blogId){
		var comment = $("#text_comment").val();
		if($.trim(comment) == ""){
			alert("请填写完再提交。");
			return;
		}
		$.post(basePath + "study/doComment.action", {"blogId": blogId, "comment": comment}, function(data){
			if(data.code == 200){
				alert("评论成功！");
				$(".comment_count").html("(" + data.data + ")");
				$("#text_comment").val('');
				loadCommentList();
			}else{
				alert(data.message);
			}
		})
	}
	
	function loadCommentList(){
		var blogId = '${blog.id}';
		$.get(basePath + "study/selectCommentList.action", {"blogId": blogId}, function(data){
			if(data.code == 200){
				var commentList = data.data;
				if(commentList == null || commentList.length == 0){
					return;
				}
				doLoadCommentList(commentList);
			}else{
				alert(data.message);
			}
		})
	}
	
	function doLoadCommentList(commentList){
		var domStr = "";
		for(var i = 0 ; i < commentList.length ; i ++){
			var comment = commentList[i];
			var commentStr = "<div class='div_comment'>";
			commentStr +=    	"<ul>";
			commentStr +=    	  "<li>";
			commentStr +=           "<font color='#8DB6CD'>" + comment.userName + "  	" + "</font>";
			commentStr +=           "<font color='#AAAAAA' style='font-size:10px;'>" + comment.addTimeAgo + "</font>"
			commentStr +=         "</li>";
			commentStr +=         "<li>" + comment.commentDetail + "</li>";
			commentStr +=    	  "</ul>";
			commentStr +=    "</div>";
			
			domStr += commentStr;
		}
		$("#div_comment_list").html(domStr);
	}
	
	$(function(){
		loadCommentList();
	})
	
</script>

<style type="text/css">
.div_comment {width:100%;padding:10px 30px 10px 0;border-bottom:1px solid #F2F2F2}
</style>
</head>

<body>
	<div style="width:100%;">
		<div style="padding:20px 100px 30px 20px;height:80px;border-bottom : 1px solid #ADADAD;">
			<ul>
				<li style="font-weight:bold;font-size:20px;letter-spacing: 1px;font-family:微软雅黑">${blog.title }</li>
				<li style="font-size:10px;color:#8B8989">
				${blog.addTimeStr }
				&nbsp;&nbsp;&nbsp;
				点赞<span class="praise_count">(${blog.praiseCount })</span> 
				评论<span class="comment_count">(${blog.commentCount })</span>
				</li>
			</ul>
		</div>
		<div style="padding:0 100px 20px 20px">
		${blog.content }
		</div>
		<div id="div_praise" style="width:100%; text-align: center;padding-bottom:10px;">
			<img alt="点赞" onclick="doPraise('${blog.id}')" src="<%=basePath%>images/praise.png" style="width:70px;height:70px;cursor:pointer;" />
			<div id="div_praise_count" class="praise_count">(${blog.praiseCount })</div>
		</div>
		<div style="width:100%;padding-left:20px;"><font color="red" class="comment_count">${blog.commentCount}</font>条评论</div>
		<div id="div_comment" style="width:100%;padding:20px 30px 30px 20px;border-top: 1px solid #ADADAD;">
			评论：
			<div style="width:100%;height:150px;border:1px solid #ADADAD;">
				<textarea id="text_comment" placeholder="评论一下吧......" style="width:100%;height:100px;margin:0;
					padding:0;border:0;resize :none;font-size:16px;padding:5px 5px 5px 5px;"></textarea>
				<div style="width:100%;text-align: right;background:#DEDEDE;">
					<button class="btn_comment" onclick="doComment('${blog.id}')">评论</button>
				</div>
			</div>
		</div>
		<div id="div_comment_list" style="width:100%;border-top:1px solid #ADADAD;padding: 10px 30px 50px 20px;">
			
		</div>
	</div>
</body>
</html>