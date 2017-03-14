myapp.controller("myCtr", ['$location', '$rootScope', '$scope',
    function($location, $rootScope, $scope) {

        // //监听路由变化，实现导航动态变化
        // $rootScope.$on('$stateChangeStart',
        // function(event, toState, toParams, fromState, fromParams) {
        // })

    }
]);

myapp.controller("loginCtr", [
    "$scope",
    "httpFactory",
    function($scope, httpFactory) {
        $scope.login = function() {
            $scope.Params = {
                phone: $scope.phone,
                password: $scope.password,
                randomCode: $scope.randomCode
            }
            httpFactory.query("/user/checkUser", "post", $scope.Params)
                .then(function(res) {

                    console.log(res);
                }, function(res) {
                    console.log(res)
                })
        }

    }
])

myapp.controller("mybookrackCtr", [
    "$scope",
    "httpFactory",
    "$state",
    function($scope, httpFactory, $state) {
        // 获取所有书
        $scope.params = {
            name: ""
        }
        httpFactory.query("/book/getAllBooks", "get", $scope.params).then(
            function(res) {
                $scope.books = res.list;
                console.log(res);
            },
            function() {

            });
        // 获取一本书，进行阅读
        $scope.getBook = function(bookId) {
            $state.go("book", { id: bookId });

        }
    }
])
myapp.controller("bookCityCtr", ["$scope", "httpFactory", "$state",
    function($scope, httpFactory, $state) {
        $state.go("index.bookCity.boy");

    }
])
myapp.controller("categoryCtr", ["$scope", "httpFactory", "$state",
    function($scope, httpFactory, $state) {

        httpFactory.query("/tag/getAllTags", "get").then(function(res) {
            console.log(res);
            $scope.newAddBook = 1000;
            $scope.allBooks = 0;
            for (var k in res.nums) {
                $scope.allBooks += res.nums[k];
            }
            // 获取所有的分类和图书数量
            $scope.categories = res.tags;
            $scope.nums = res.nums;
        }, function() {

        })

    }
]);
myapp.controller("bookCtr", ["$scope", "$state", "$stateParams", "httpFactory", book]);

function book($scope, $state, $stateParams, httpFactory) {
    $scope.text = "sdadssa";

    var params = {
        id: $stateParams.id
    }
    httpFactory.query("/book/getBook", "get", params).then(
        function(res) {
            httpFactory.query(res.url, "get").then(function(resp) {
            	//从directive中获取页面大小，并且计算好页面字数
            	var pageSize=$scope.size;
                var length = parseInt(resp.length / pageSize);
                $scope.AllPage = length;
                
                $scope.array = [];
                for (var i = 0; i < length; i++) {
                    $scope.array.push(resp.substr(i*pageSize, pageSize));
                }
                $scope.text = $scope.array[0];
                $scope.nowPage = 1;

                $scope.turnPage = function(params) {
                	
                    if (params == "-1") {
                        if ($scope.nowPage <= 1) {
                            console.log("已经到达下限");
                            return;
                        } else {
                            $scope.nowPage--;
                            $scope.text="";
                            $scope.text = $scope.array[$scope.nowPage-1];
                        }
                    } else if (params == "1") {
                        if ($scope.nowPage >= $scope.AllPage) {
                            console.log("已经到达上限");
                            return;
                        } else {
                            $scope.nowPage++;
                            $scope.text="";
                            $scope.text = $scope.array[$scope.nowPage-1];
                           
                        }
                    }

                }



            }, function(resp) {
                console.log("error")
            })
        },
        function(res) {
            console.log("error")
        })


}
