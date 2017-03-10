myapp.controller("myCtr", ['$location', '$rootScope', '$scope', function($location, $rootScope, $scope) {

//    //监听路由变化，实现导航动态变化
//    $rootScope.$on('$stateChangeStart',
//        function(event, toState, toParams, fromState, fromParams) {
//        })
}]);

myapp.controller("loginCtr", ["$scope", "httpFactory", function($scope, httpFactory) {
    $scope.login = function() {
        $scope.Params = {
            phone: $scope.phone,
            password: $scope.password,
            randomCode: $scope.randomCode
        }
        httpFactory.query("/user/checkUser", "post", $scope.Params).then(function(res) {

        	console.log(res);
        }, function(res) {
            console.log(res)
        })
    }

}])

myapp.controller("mybookrackCtr", ["$scope","httpFactory", function($scope,httpFactory) {
	$scope.params={
			name:""
	}
    httpFactory.query("/book/getAllBooks","get",$scope.params).then(function (res) {
        $scope.books=res.list;
    	console.log(res);
    },function () {
        
    })
}])
myapp.controller("bookCityCtr", ["$scope","httpFactory","$state", function($scope,httpFactory,$state) {
    $state.go("index.bookCity.boy");
    
}])
myapp.controller("categoryCtr", ["$scope","httpFactory","$state", function($scope,httpFactory,$state) {

    httpFactory.query("/tag/getAllTags","get").then(function (res) {
    	console.log(res);
    	$scope.newAddBook=1000;
    	$scope.allBooks=0;
    	for(var k in res.nums){
    		$scope.allBooks+=res.nums[k];
    	}
    	//获取所有的分类和图书数量
    	$scope.categories=res.tags;
    	$scope.nums=res.nums;
    },function () {
        
    })
    
}])