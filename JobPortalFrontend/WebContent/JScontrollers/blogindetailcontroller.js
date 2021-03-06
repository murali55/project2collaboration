/**
 * BlogInDetailCtrl
 */
app.controller('BlogIndetailCtrl',function($scope,BlogService,$routeParams,$location,$sce){
	var blogId=$routeParams.blogId 
	$scope.isRejected= false
	BlogService.getBlog(blogId).then(
			function(response){
				$scope.blog=response.data 
				$scope.content=$sce.trustAsHtml($scope.blog.blogContent)
			},
			function(response){
				if(response.status==401)
					$location.path('/userLogin')
			})
	
		$scope.approveBlog=function(blog){
		   BlogService.approveBlog(blog).then(
				   function(response){
					   $location.path('/blogswaiting')
				   },
				   function(response){
					   if(response.status==401)
						   $location.path('/userLogin')
				   })
	    }	
			
       $scope.rejectBlog=function(blogId,rejectionReason){
    	   BlogService.rejectBlog(blogId,rejectionReason).then(
    			   function(response){
    				   $location.path('/blogswaiting')
    			   },
    			   function(response){
    				   if(response.status==401)
						   $location.path('/userLogin')
    			   })
       }	
       BlogService.hasUserLikedBlog(blogId).then(
    			function(response){
    			 if(response.data=='')
    				 $scope.isLiked=false 
    				 else
    					 $scope.isLiked=true 
    		    },
    		    function(response){
    			if(response.status==401)
    				$location.path('/login')
    		    })
       $scope.updateLikes=function(blogId){
    	   BlogService.updateLikes(blogId).then(
    		function(response){
    			$scope.isLiked=!$scope.isLiked
    			$scope.blog=response.data
    		},	   
    	    function(response){
    			if(response.status==401)
					   $location.path('/login')
    		}
    	   )
       }
       
       $scope.addBlogComment=function(commentTxt,blogPost){
    	   $scope.blogComment={}
    	   $scope.blogComment.commentTxt=commentTxt
    	   $scope.blogComment.blogPost=blogPost
    	   console.log($scope.blogComment)
    	   BlogService.addBlogComment($scope.blogComment).then(
    			   function(response){
    				   $scope.commentTxt=''  
    				   $scope.blogComment=response.data 
    			   },
    			   function(response){
    				   if(response.status==401)
    					   $location.path('/login')
    			   })
       }
       
       $scope.getAllBlogComments=function(blogId){
    	   BlogService.getAllBlogComments(blogId).then(
    			   function(response){
    				   $scope.blogComments=response.data 
    			   },
    			   function(response){
    				   if(response.status==401)
    					   $location.path('/login')
    			   })
       }
})


