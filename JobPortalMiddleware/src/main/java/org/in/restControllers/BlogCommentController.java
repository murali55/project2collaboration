package org.in.restControllers;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.in.dataAccessObj.BlogCommentDao;
import org.in.dataAccessObj.UserDao;
import org.in.persistanceClzs.BlogComment;
import org.in.persistanceClzs.ErrorClz;
import org.in.persistanceClzs.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BlogCommentController {
	@Autowired
private BlogCommentDao blogCommentDao;
	@Autowired
private UserDao userDao;
    @RequestMapping(value="/addblogcomment",method=RequestMethod.POST)
	public ResponseEntity<?> addBlogComment(HttpSession session,@RequestBody BlogComment blogComment){
		String email=(String)session.getAttribute("loginId");
		if(email==null){
			ErrorClz errorClz=new ErrorClz(5,"Please login..");
			return new ResponseEntity<ErrorClz>(errorClz,HttpStatus.UNAUTHORIZED);
		}
		User commentedBy=userDao.getUser(email);
		blogComment.setCommentedBy(commentedBy);
		blogComment.setCommentedOn(new Date());
		blogCommentDao.addBlogComment(blogComment);
		return new ResponseEntity<BlogComment>(blogComment,HttpStatus.OK);
	}
    @RequestMapping(value="/getblogcomments/{blogId}",method=RequestMethod.GET)
    public ResponseEntity<?> getAllBlogComments(HttpSession session,@PathVariable int blogId){
    	String email=(String)session.getAttribute("loginId");
		if(email==null){
			ErrorClz errorClz=new ErrorClz(5,"Please login..");
			return new ResponseEntity<ErrorClz>(errorClz,HttpStatus.UNAUTHORIZED);
		}
    		List<BlogComment> blogComments=	blogCommentDao.getAllBlogComments(blogId);
    		return new ResponseEntity<List<BlogComment>>(blogComments,HttpStatus.OK);
    	
    }
}