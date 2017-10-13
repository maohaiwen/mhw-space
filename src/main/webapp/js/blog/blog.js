var blog = {
	pageNo:1,
	pageSize:20,
	init:function(field, url, jsonIn){
		if(typeof(jsonIn) == "undefined"){
			jsonIn = new Object();
		}
		jsonIn.pageNo = blog.pageNo;
		if(jsonIn.pageSize == null){
			jsonIn.pageSize = blog.pageSize;
		}
		$.get(url, jsonIn, function(data){
			if(data == null){
				return;
			}
			if(data.code != 200){
				alert(data.message);
				return;
			}
			blog.writeIntoDom(field, data.data.list);
		})
	},
	writeIntoDom:function(field, list){
		if(list == null || list.length == 0){
			return;
		}
		var domStr = "";
		for(var i = 0 ; i < list.length ; i ++){
			var blog = list[i];
			domStr += "<div class='blog_inner' onclick=\"blog.toBlogDetail(" + blog.id + ")\">";
			domStr +=    "<ul>";
			domStr +=      "<li class='blog_ago'>" + blog.addTimeAgo + "</li>";
			domStr +=      "<li class='blog_title'>" + blog.title + "</li>";
			domStr +=      "<li class='blog_attach'>点赞（" + blog.praiseCount + "） 评论（" + blog.commentCount + "）</li>";
			domStr +=    "</ul>";
			domStr += "</div>";
		}
		$("#" + field).html(domStr);
	},
	toBlogDetail: function(id){
		window.open(basePath + "study/toBlogDetail.action?id=" + id);
	}
}
