/**
 * Angular Module, configuration
 */
var app=angular.module("app",['ngRoute'])
app.config(function($routeProvider){
	$routeProvider
	.when('/addjob',{controller:'JobCtrl',templateUrl:'views/jobform.html'})
	//this view can access all $scope variables and $scope functions defined in JobCtrl 
	.when('/getalljobs',{controller:'JobCtrl',templateUrl:'views/joblist.html'})
	.otherwise({templateUrl:'views/home.html'})
})