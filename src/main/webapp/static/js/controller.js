myapp.controller("myCtr", ['$location', '$rootScope', '$scope', '$window','$state','httpFactory',
    function($location, $rootScope, $scope, $window,$state,httpFactory) {

        // //监听路由变化，实现导航动态变化
        // $rootScope.$on('$stateChangeStart',
        // function(event, toState, toParams, fromState, fromParams) {
        // })
		// $scope.user=$rootScope.user;
		
        $scope.back = function() {
        	console.log($location.url());
            $window.history.back();
        }
        // 获取一本书，进行阅读
        $scope.getBook = function(bookId) {
            $state.go("book", {
                id: bookId
            });
        }
        // 获取url
        $scope.user
        $scope.$on("Ctr1NameChange",function (event, msg) {
        	$scope.user=msg;
// $scope.$broadcast("Ctr1NameChangeFromParrent", msg);
        });
        httpFactory.query("/user/checkLogin").then(function(res){
        	$scope.user=res;
        })
        
        
    }
]);

myapp.controller("loginCtr", [
    "$scope",
    "httpFactory","$state","$rootScope",
    function($scope, httpFactory,$state,$rootScope) {
        // 登陆注册切换
        $scope.isLogin=true;
        $scope.toggleLogin=function () {
            $scope.isLogin?$scope.isLogin=false:$scope.isLogin=true;
        }
        $scope.checkPhone=function(phone){
        	var reg = /^(13[0-9]|14[579]|15[0-9]|17[0-9]|18[0-9])[0-9]{8}$/;
        	if(reg.test(phone)){
        		return true;
        	}
    		toastr.info("请重新输入正确的手机号！");
        	return false;
        }
        $scope.login = function() {
        	if(!$scope.checkPhone(phone.value)){
        		return;
        	}
        	if(password.value.length<6){
        		toastr.info("密码至少为6位！");
        		return;
        	}
        	if(comfirmCode.value.length<4){
        		toastr.info("密码为4位！");
        		return;
        	}
        	$scope.Params = {
                    "phone": phone.value,
                    "password": password.value,
                    "randomCode": comfirmCode.value,
                    "rememberMe":true
                }
            httpFactory.query("/user/checkUser", "post", $scope.Params)
                .then(function(res) {
                	if(res.code=="200"){
                		$scope.$emit("Ctr1NameChange", $scope.Params);
                		$state.go("index.mine")
                	}else{
                		toastr.error(res.msg);
                	}
                }, function(res) {
                	toastr.error(res.message);
                })
        }
        $scope.register = function() {
        	if(!$scope.checkPhone(phone.value)){
        		return;
        	}
        	if(password.value.length<6){
        		toastr.info("密码至少为6位！");
        		return;
        	}
        	if(comfirmCode.value.length<4){
        		toastr.info("验证码为4位！");
        		return;
        	}
        	$scope.Params = {
                    "phone": phone.value,
                    "password": password.value,
                    "randomCode": comfirmCode.value,
                    "rememberMe":true
                }
        	httpFactory.query("/user/register", "post", $scope.Params)
            .then(function(res) {
            	if(res.code=="200"){
            		httpFactory.query("/user/checkUser", "post", $scope.Params)
            		$scope.$emit("Ctr1NameChange", $scope.Params);
            		$state.go("index.mine")
            	}else{
            		toastr.error(res.msg);
            	}
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
        
    }
])
myapp.controller("bookCityCtr", ["$scope", "httpFactory", "$state",
    function($scope, httpFactory, $state) {
        $state.go("index.bookCity.boy");
        httpFactory.query("/tag/bookCity","get").then(function(res){
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
    $scope.text = "加载中。。。";

    var params = {
        id: $stateParams.id
    }
    httpFactory.query("/book/getBook", "get", params).then(function(res) {
    	
        var fileName = "0001.txt";
        $scope.bookName=res.bookName;
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
myapp.controller("detailsCtr", ["$scope", "$state", "$stateParams",
    "httpFactory", details
]);
function details($scope, $state, $stateParams, httpFactory) {
    httpFactory.query("/book/getBook","get",{"id":$stateParams.bookId}).then(function (res) {
        $scope.book=res;
        $scope.bookId=$stateParams.bookId;
    },function (res) {
        // error
    })
}


myapp.controller("cateList",["$state","$scope","$stateParams","httpFactory",function($state,$scope,$stateParams,httpFactory){
    	 httpFactory.query("/tag/getBooksByTagId","get",{tagId:$stateParams.tagId}).then(function(res){
         	$scope.name=res.name;
    		 $scope.books=res.data;
         })
}])