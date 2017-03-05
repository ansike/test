
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
}])