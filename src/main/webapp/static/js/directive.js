myapp.directive('body',function () {
	return{
		restrict:"C",
		link:function (scope,ele,attrs) {
			ele.css("height",ele.height()+"px");
		}
	}
});
//myapp.directive("bookModal",function () {
//	return{
//		restrict:"C",
//		link:function (scope,ele,attrs) {
//		}
//	}
//})