myapp.directive('body',function () {
	return{
		restrict:"C",
		link:function (scope,ele,attrs) {
			ele.css("height",ele.height()+"px");
		}
	}
});
myapp.directive("bookModal",function () {
	return{
		restrict:"C",
		link:function (scope,ele,attrs) {
			$(".book-modal").on("touchstart.aaa", function(eve) {
				eve = eve.originalEvent.touches[0];
				var left = eve.clientX, len;
				$(document).on("touchmove", function(eve) {
					eve=eve.originalEvent.touches[0];
					len = eve.clientX - left;
				})
				$(document).on("touchend", function() {
					$(document).off("touchmove");
					$(document).off("touchend");

					if (len > 50) {
						$(".book-modal .left").trigger("click");
					} else if (len < 0 && Math.abs(len) > 50) {
						$(".book-modal .right").trigger("click");
					}
				}) 
			})
		}
	}
})
myapp.directive("bookBody",function () {
	return{
		restrict:"AE",
		link:function (scope,ele,attrs) {
			var line=parseInt($(ele).width()/16);
			var he=parseInt($(ele).height()/25);
			scope.size=line*he;
			console.log(scope.size);
		}
	}
})