/**
 * Angular Module, configuration
 */
var app=angular.module("app",['ngRoute','ngCookies'])
app.config(function($routeProvider){
	$routeProvider
	.when('/addjob',{controller:'JobCtrl',templateUrl:'views/jobform.html'})
	.when('/getalljobs',{controller:'JobCtrl',templateUrl:'views/joblist.html'})
	.when('/registration',{controller:'UserCtrl',templateUrl:'views/registrationForm.html'})
	.when('/userLogin',{controller:'UserCtrl',templateUrl:'views/loginForm.html'})
	.otherwise({templateUrl:'views/home.html'})
	
})
app.run(function($rootScope, UserService, $location,$cookieStore){
	if($rootScope.user==undefined)
		$rootScope.user=$cookieStore.get('userDetails')

$rootScope.userlogout=function(){
		UserService.userlogout().then(
			function(response){
				delete $rootScope.user
				$cookieStore.remove('userDetails')
				$location.path('/userLogin')	
			},
			function(response){
				if(response.status==401)
                $location.path('/userLogin')	
			})
}
})


