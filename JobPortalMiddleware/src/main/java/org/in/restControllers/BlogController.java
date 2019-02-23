package org.in.restControllers;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.in.dataAccessObj.BlogDao;
import org.in.dataAccessObj.UserDao;
import org.in.persistanceClzs.Blog;
import org.in.persistanceClzs.ErrorClz;
import org.in.persistanceClzs.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {
@Autowired
private BlogDao blogDao;
@Autowired
private UserDao userDao;
@RequestMapping(value="/addBlog", method=RequestMethod.POST)
ResponseEntity<?> addBlog(@RequestBody Blog blog, HttpSession session){
String email=(String)session.getAttribute("loginId");
if(email==null)
{
	ErrorClz errorClz= new ErrorClz(1,"please login");
	return new ResponseEntity<ErrorClz>(errorClz, HttpStatus.UNAUTHORIZED);
}
blog.setPostedOn(new Date());
User author= userDao.getUser(email);
blog.setAuthor(author);
try {
blogDao.addBlog(blog);	
}
catch(Exception e) {
	 ErrorClz errorClz= new ErrorClz(2,"blog could not post."+e.getMessage());
	 return new ResponseEntity<ErrorClz>(errorClz, HttpStatus.INTERNAL_SERVER_ERROR);
}
return new ResponseEntity<Void>(HttpStatus.OK);
}

@RequestMapping(value="/blogsApproved", method=RequestMethod.GET)
ResponseEntity<?> getBlogsApproved(HttpSession session){
    String email=(String)session.getAttribute("loginId");
 if(email==null)
    {
		ErrorClz errorClz= new ErrorClz(3,"please login");
		return new ResponseEntity<ErrorClz>(errorClz, HttpStatus.UNAUTHORIZED);
	}
	List<Blog> blogs=blogDao.getBlogsApproved();
	return new ResponseEntity<List<Blog>>(blogs, HttpStatus.OK);
}
@RequestMapping(value="/blogsWaiting", method=RequestMethod.GET)
ResponseEntity<?> getWaitingForApproval(HttpSession session){
    String email=(String)session.getAttribute("loginId");
 if(email==null)
    {
		ErrorClz errorClz= new ErrorClz(4,"please login");
		return new ResponseEntity<ErrorClz>(errorClz, HttpStatus.UNAUTHORIZED);
	}
  User user= userDao.getUser(email);
  if(!user.getRole().equals("ADMIN")) {
	   ErrorClz errorClz= new ErrorClz(5,"please login");
	   return new ResponseEntity<ErrorClz>(errorClz, HttpStatus.UNAUTHORIZED);
	}
  List<Blog> blogsWaiting=blogDao.getBlogsWaitingForApproval();
  return new ResponseEntity<List<Blog>>(blogsWaiting, HttpStatus.OK);
}
}

