( function( $ ) {
	$( document ).ready(function() {
		$('#cssmenu').prepend('<div id="menu-button">Menu</div>');
		$('#cssmenu #menu-button').on('click', function(){
			var menu = $(this).next('ul');
			if (menu.hasClass('open')) {
				menu.removeClass('open');
			}
			else {
				menu.addClass('open');
			}
		});
	});
} )( jQuery );

function openModal(divId, left, top){

}

function openModal(divId) {      
	// 计算机屏幕高度      
	var windowWidth = $(window).width();      
	// 计算机屏幕长度      
	var windowHeight = $(window).height();    
	openModalWithParams(divId, windowWidth, windowHeight)
}   

function openModalWithHeight(divId, windowHeight){
	// 计算机屏幕高度      
	var windowWidth = $(window).width();   
	openModalWithParams(divId, windowWidth, windowHeight);
}

function openModalWithParams(divId, windowWidth, windowHeight){
	// 获取传入的DIV      
	var $div_obj = $("#" + divId); 
	// 取得传入DIV的高度     
	var popupHeight = $div_obj.height();      
	// 取得传入DIV的长度      
	var popupWidth = $div_obj.width();            
	// // 添加并显示遮罩层      
	$("<div id='bg_zhezhao'></div>").width(windowWidth * 0.99).height(1200).click(function() {
		closeModal(divId);          
	}).appendTo("body").fadeIn(200);            
	// 显示弹出的DIV      
	$div_obj.css({"position": "absloute"}).animate({left : windowWidth / 2 - popupWidth / 2, top : windowHeight / 2 - popupHeight / 2,opacity : "show"}, "slow"); 
}

/*隐藏弹出DIV*/    
function closeModal(divId) {     
	$("#bg_zhezhao").remove();      
	$("#" + divId).animate({left : 0,top : 0,opacity : "hide"}, "slow");    
} 
function closePage(){
	if (navigator.userAgent.indexOf("MSIE") > 0) {
		if (navigator.userAgent.indexOf("MSIE 6.0") > 0) {
			window.opener = null;
			window.close();
		} else {
			window.open('', '_top');
			window.top.close();
		}
	}
	else if (navigator.userAgent.indexOf("Firefox") > 0) {
		window.location.href = 'about:blank ';
	} else {
		window.opener = null;
		window.open('', '_self', '');
		window.close();
	}
}

