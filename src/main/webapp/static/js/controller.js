myapp.controller("myCtr", ['$location', '$rootScope', '$scope', '$window',
    function($location, $rootScope, $scope, $window) {

        // //监听路由变化，实现导航动态变化
        // $rootScope.$on('$stateChangeStart',
        // function(event, toState, toParams, fromState, fromParams) {
        // })
        $scope.back = function() {
            $window.history.back();
        }

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
            },
            function() {

            });
        // 获取一本书，进行阅读
        $scope.getBook = function(bookId) {
            $state.go("book", {
                id: bookId
            });

        }
    }
])
myapp.controller("bookCityCtr", ["$scope", "httpFactory", "$state",
    function($scope, httpFactory, $state) {
        $state.go("index.bookCity.boy");
        httpFactory.query("/tag/bookCity","get").then(function(res){
        	console.log(res);
        	$scope.boys=res["男生"];
        	$scope.girls=res["女生"];
        },function(){
        	
        })
        
        
        
    }
])
myapp.controller("categoryCtr", ["$scope", "httpFactory", "$state",
    function($scope, httpFactory, $state) {

        httpFactory.query("/tag/getAllTags", "get").then(function(res) {
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
myapp.controller("bookCtr", ["$scope", "$state", "$stateParams",
    "httpFactory", book
]);

function autoComplete(num) {
    num += "";
    if (num.length < 1 || num.length > 4) {
        return
    }
    switch (num.length) {
        case 1:
            return "000" + num + ".txt";
            break;
        case 2:
            return "00" + num + ".txt";
            break;
        case 3:
            return "0" + num + ".txt";
            break;
        case 4:
            return "" + num + ".txt";
            break;
        default:
            return "0001.txt";
            break;
    }
}

function book($scope, $state, $stateParams, httpFactory) {
    $scope.text = "sdadssa";

    var params = {
        id: $stateParams.id
    }
    httpFactory.query("/book/getBook", "get", params).then(function(res) {
        var fileName = "0001.txt";
        httpFactory.query(res.url + fileName, "get").then(function(resp) {
            $scope.text = resp;
            $scope.nowChapter = 1;
            $scope.AllChapter = res.chapterNum;

            $scope.turnChapter = function(params) {
                if (params == "sub") {
                    if ($scope.nowChapter <= 1) {
                        toastr.info("已经到达下限");
                        return;
                    } else {
                        $scope.nowChapter--;
                        fileName = autoComplete($scope.nowChapter);
                        httpFactory.query(res.url + fileName, "get").then(function(text) {
                            $scope.text = text;
                        })
                    }
                } else if (params == "add") {
                    if ($scope.nowChapter >= $scope.AllChapter) {
                        toastr.info("已经到达上限");
                        return;
                    } else {
                        $scope.nowChapter++;
                        fileName = autoComplete($scope.nowChapter);
                        httpFactory.query(res.url + fileName, "get").then(function(text) {
                            $scope.text = text;
                        })

                    }
                } else {
                    $scope.nowChapter = params;
                    fileName = autoComplete($scope.nowChapter);
                    httpFactory.query(res.url + fileName, "get").then(function(text) {
                        $scope.text = text;
                    })
                }

            }

            // 从directive中获取页面大小，并且计算好页面字数
            // ---------------------------------------整篇文章按页来分
            // var pageSize=$scope.size;
            // var length = parseInt(resp.length / pageSize);
            // $scope.AllPage = length;
            //                
            // $scope.array = [];
            // for (var i = 0; i < length; i++) {
            // $scope.array.push(resp.substr(i*pageSize, pageSize));
            // }
            // $scope.text = $scope.array[0];
            // $scope.nowPage = 1;
            //
            // $scope.turnPage = function(params) {
            //                  
            // if (params == "-1") {
            // if ($scope.nowPage <= 1) {
            // console.log("已经到达下限");
            // return;
            // } else {
            // $scope.nowPage--;
            // $scope.text="";
            // $scope.text = $scope.array[$scope.nowPage-1];
            // }
            // } else if (params == "1") {
            // if ($scope.nowPage >= $scope.AllPage) {
            // console.log("已经到达上限");
            // return;
            // } else {
            // $scope.nowPage++;
            // $scope.text="";
            // $scope.text = $scope.array[$scope.nowPage-1];
            //                           
            // }
            // }
            //
            // }
            // ---------------------------------------整篇文章按章来分

        }, function(resp) {
            console.log("error")
        })
    }, function(res) {
        console.log("error")
    })

}
