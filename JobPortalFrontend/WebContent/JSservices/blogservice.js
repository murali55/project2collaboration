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
	
	
	return blogService;
})