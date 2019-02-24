/**
 *   /getblogwaitingforapproval/:blogpostid
 * BlogInDetailCtrl
 *   select * from blogpost where blogpostid=?
 */
app.controller('BlogIndetailCtrl',function($scope,BlogService,$routeParams,$location,$sce){
	var blogId=$routeParams.blogId //param name is defined in app.config in when statment
	BlogService.getBlog(blogId).then(
			function(response){
				$scope.blog=response.data //single blogpost object
				$scope.content=$sce.trustAsHtml($scope.blog.blogContent)
			},
			function(response){
				if(response.status==401)
					$location.path('/userLogin')
			})
	
		$scope.approveBlog=function(blog){
		   BlogService.approveBlog(blog).then(
				   function(response){//when the blogpost approval status is updated successfully
					   $location.path('/blogswaiting')
				   },
				   function(response){
					   if(response.status==401)
						   $location.path('/userLogin')
				   })
	    }	
			
       $scope.rejectBlog=function(blog){
    	   BlogService.rejectBlog(blog).then(
    			   function(response){
    				   $location.path('/blogswaiting')
    			   },
    			   function(response){
    				   if(response.status==401)
						   $location.path('/userLogin')
    			   })
       }	  
})


