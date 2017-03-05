var myapp=angular.module('myApp', [
    "ui.router",
    "oc.lazyLoad"
])
//oc.lazyLoad配置
myapp.config(['$provide', '$compileProvider', '$controllerProvider', '$filterProvider', function($provide, $compileProvider, $controllerProvider, $filterProvider) {
	myapp.controller = $controllerProvider.register;
	myapp.directive = $compileProvider.directive;
	myapp.filter = $filterProvider.register;
	myapp.factory = $provide.factory;
	myapp.service = $provide.service;
	myapp.constant = $provide.constant;
}])
// 禁止模板缓存
myapp.run(function($rootScope, $templateCache) {
    $rootScope.$on('$routeChangeStart', function(event, next, current) {
        if (typeof(current) !== 'undefined'){
            $templateCache.remove(current.templateUrl);
        }
    });
});

myapp.config(function ($stateProvider, $urlRouterProvider) {
    // cfpLoadingBarProvider.includeSpinner = true;
    $urlRouterProvider.when("", "/index").when("/fontDetails/", "index").when("/appiInfo/", "index").otherwise("/index");
    $stateProvider
        .state("index", {
            url: "/index",
            views:{
                '':{
                    templateUrl: './html/common.html',
                    controller: function($state){
                        $state.go('index.mybookrack');
                    }
                }
            }
        })
        .state("index.mybookrack", {
            url: "/mybookrack",
            templateUrl: "./html/mybookrack.html",
            resolve:{
                deps:["$ocLazyLoad",function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        "./css/mybookrack.css",
                        "./js/iscroll.js"
                        ])
                }]
            }

        })
        .state("index.bookCity", {
            url: "/bookCity",
            templateUrl: "./html/bookCity.html",
            resolve:{
                deps:["$ocLazyLoad",function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        "./css/bookCity.css"
                        ])
                }]
            }

        })
        .state("index.category", {
            url: "/category",
            templateUrl: "./html/category.html",
            resolve:{
                deps:["$ocLazyLoad",function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        "./css/category.css"
                        ])
                }]
            }

        })
        .state("index.mine", {
            url: "/mine",
            templateUrl: "./html/mine.html",
            resolve:{
                deps:["$ocLazyLoad",function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        "./css/mine.css"
                        ])
                }]
            }
        })
        .state("login", {
            url: "/login",
            templateUrl: "./html/login.html",
            resolve:{
                deps:["$ocLazyLoad",function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        "./css/loginRegister.css"
                        ])
                }]
            }
        })
});

