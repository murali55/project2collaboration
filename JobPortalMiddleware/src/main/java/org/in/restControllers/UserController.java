package org.in.restControllers;

import org.in.dataAccessObj.UserDao;
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
public class UserController 
{
	@Autowired 
 private UserDao userDao;
	@RequestMapping(value="/userReg",method=RequestMethod.POST)
	public ResponseEntity<?> userRegistration(@RequestBody User user)
     {
		try
		{
		userDao.userRegistration(user);
		}catch(Exception e)
			{
				ErrorClz errorClz = new ErrorClz(5,"could not insert user details" + e.getMessage());
			    return new ResponseEntity<ErrorClz>(errorClz,HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    return new ResponseEntity<User>(user,HttpStatus.OK);
		
		
		
	}
}
