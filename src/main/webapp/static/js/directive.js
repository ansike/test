myapp.directive('body', function() {
    return {
        restrict: "C",
        link: function(scope, ele, attrs) {
            ele.css("height", ele.height() + "px");
        }
    }
});
myapp.directive("bookModal", function() {
    return {
        restrict: "C",
        link: function(scope, ele, attrs) {
            $(".book-modal").on("touchstart", function(eve) {
                eve = eve.originalEvent.touches[0];
                var left = eve.clientX,
                    len;
                $(document).on("touchmove", function(eve) {
                    eve = eve.originalEvent.touches[0];
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
myapp.directive("bookBody", function() {
    return {
        restrict: "AE",
        link: function(scope, ele, attrs) {
            $(".left,.right").on("click", function() {
                $(ele)[0].scrollTop = 0;
            });
            var line = parseInt($(ele).width() / 16);
            var he = parseInt($(ele).height() / 25);
            scope.size = line * he;
            
            $(".center").on("click",function(){
            	$(".modal-con").css("display","flex");
            })
        }
    }
})
myapp.directive("modalCon", function() {
    return {
        restrict: "C",
        link: function(scope, ele, attrs, app) {
            var num,nowchapter, length,len;
            
            scope.$watch(function() {
                if (attrs.chapter != "") {
                    num = attrs.chapter;
                    length =(200 / (num-1)).toFixed(4);
                    nowchapter=attrs.nowchapter;
                    if(length!=""||length!=undefined){
                    	len=(nowchapter-1)*length
                        if (len >= -5 && len <= 195) {
                        	$(".ball").css("left", len + "px");
                        }else if(len>200){
                        	$(".ball").css("left", "195px");
                        }
                    }
                }
            })
            $(".ball").on(
                "touchstart",
                function(eve) {
                	
                    eve = eve.originalEvent.touches[0];
                    var x = eve.clientX;
                    var that = $(this);
                    var left = that.position().left;
                    $(document).on("touchmove", function(eve) {
                        eve = eve.originalEvent.touches[0];
                        len = eve.clientX - x + left;
                       
                        if (len >= -5 && len < 195) {
                            that.css("left", len + "px");
                        }
                    })
                    $(document).on(
                        "touchend",
                        function() {
                            $(document).off("touchmove");
                            $(document).off("touchend");
                            
                            var half = length / 2;
                            var index=0;
                            
                            for (i = 0; i < num; i++) {
                                if (len > (i * length - half) && len < (i * length + half)) {
                                    len = i * length;
                                    index=i;
                                }
                            }
                            
                            if (len >= -5 && len < 195) {
                                that.css("left", len + "px");
                            }else if(len>195){
                            	that.css("left", "195px");
                            	index=--num;
                            }
                            
                            scope.turnChapter(++index);
                            	
                        })
                })
                $(".mo_content").on("click",function(){
                	$(".modal-con").hide();
                })

        }
    }
})
