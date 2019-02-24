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
	
	
	return blogService;
})