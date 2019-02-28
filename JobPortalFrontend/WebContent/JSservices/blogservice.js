/**
 * BlogPostService
 */
app.factory('BlogService',function($http){
	var blogService={}
	var BASE_URL ="http://localhost:8080/JobPortalMiddleware"
	
	blogService.addBlog=function(blog){
		return $http.post(BASE_URL + "/addBlog",blog)  
	}
	
	blogService.getBlogsApproved=function(){
	 	return $http.get(BASE_URL + "/blogsApproved")
	}
	
	blogService.getBlogsWaiting=function(){
		return $http.get(BASE_URL + "/blogsWaiting")
	}
	blogService.getBlog=function(blogId){
		alert('call the middleware to get the data')
		return $http.get(BASE_URL + "/getblog/"+blogId)
	}
	
	blogService.approveBlog=function(blog){
		return $http.put(BASE_URL + "/approveblog",blog)
	}
	
	blogService.rejectBlog=function(blog){
		return $http.put(BASE_URL + "/rejectblog",blog)
	}
	blogService.hasUserLikedBlog=function(blogId){
		return $http.get(BASE_URL + "/hasuserlikedblog/"+blogId)
	}
	
	blogService.updateLikes=function(blogId){
		return $http.put(BASE_URL + "/updatelikes/"+blogId)
	}
	
	blogService.addBlogComment=function(blogComment){
		return $http.post(BASE_URL + "/addblogcomment",blogComment)
	}
	blogService.getAllBlogComments=function(blogId){
		return $http.get(BASE_URL + "/getblogcomments/"+blogId);
	}
	
	return blogService;
})