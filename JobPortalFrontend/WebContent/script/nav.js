 
(function ($){	
"use strict";	
	
	
	
	$(window).on('scroll',function() {    
		   var scroll = $(window).scrollTop();
		   if (scroll < 100) {
		    $("#nav-bar").removeClass("sticky");
		   }else{
		    $("#nav-bar").addClass("sticky");
		   }
		  });
})(jQuery);



  
  