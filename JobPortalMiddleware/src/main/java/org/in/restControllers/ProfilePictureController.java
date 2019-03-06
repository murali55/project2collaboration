package org.in.restControllers;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.in.dataAccessObj.ProfilePictureDao;
import org.in.persistanceClzs.ErrorClz;
import org.in.persistanceClzs.ProfilePicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ProfilePictureController {
	@Autowired
private ProfilePictureDao profilePictureDao;
	@RequestMapping(value="/uploadprofilepic", method=RequestMethod.POST)
	public ResponseEntity<?> saveOrUpdateProfilePicture(@RequestParam MultipartFile image, HttpSession session)
	{
		String email=(String)session.getAttribute("loginId");
		if(email==null){
			ErrorClz errorClz=new ErrorClz(6,"Please login...");
    		return new ResponseEntity<ErrorClz>(errorClz,HttpStatus.UNAUTHORIZED);//login.html
		}
		ProfilePicture profilePicture=new ProfilePicture();
		profilePicture.setEmail(email);
		try
		{
			profilePicture.setImage(image.getBytes());
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		profilePictureDao.saveOrUpdateProfilePicture(profilePicture);
		return new ResponseEntity<ProfilePicture>(profilePicture, HttpStatus.OK);
	}
	@RequestMapping(value="/getimage", method=RequestMethod.GET)
	public byte[] getProfilePicture(@RequestParam String email, HttpSession session)
	{
		String authEmail=(String)session.getAttribute("lodinId");
		if(authEmail==null){
    		return null;
		}
		ProfilePicture profilePicture= profilePictureDao.getProfilePicture(email);
		if(profilePicture == null)
			return null;
		else
			return profilePicture.getImage();
	}
	
}