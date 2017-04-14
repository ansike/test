
myapp.factory("httpFactory",['$http','$q',function($http,$q){
	return {
		query:function(url,method,params){
			var deffered=$q.defer();
			$http({
				url:url,
				method:method,
				params:params
			}).success(function(res){
				deffered.resolve(res);
			}).error(function(res){
				deffered.reject(res);
			})
			return deffered.promise;
		}
	}
}]);
//myapp.factory("GetBook",['httpFactory','$q',function (httpFactory,$q) {
//	return {
//		getBook:function (bookId) {
//			var deffered=$q.defer();
//			var params={
//				id:bookId
//			}
//			debugger
//			httpFactory.query("/book/getBook","get",params).then(function (res) {
//				console.log(res);
//				deffered.resolve(res+"");
//			},function (res) {
//				deffered.resolve(res);
//			})
//			return deffered.promise;
//		}
//	}
//}])