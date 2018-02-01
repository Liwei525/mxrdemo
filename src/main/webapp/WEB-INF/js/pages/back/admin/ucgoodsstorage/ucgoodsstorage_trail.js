$(function(){
	$('li[id^=order-]').hover(function(){
      id = splitGet(this.id) ;
      $(".list-" + id).slideDown(600) ;
    },function(){
      id = splitGet(this.id) ;
      $(".list-" + id).slideUp(600) ;
    });
})
