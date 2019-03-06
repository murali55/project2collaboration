package org.in.dataAccessObjImpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.in.dataAccessObj.ProfilePictureDao;
import org.in.persistanceClzs.ProfilePicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ProfilePictureDaoImpl implements ProfilePictureDao {
    @Autowired
	private SessionFactory sessionFactory;
	
	public void saveOrUpdateProfilePicture(ProfilePicture profilePicture) {
		Session s=sessionFactory.getCurrentSession();
		s.saveOrUpdate(profilePicture);
	}

	public ProfilePicture getProfilePicture(String email) {
		Session s=sessionFactory.getCurrentSession();
		ProfilePicture profilePicture=(ProfilePicture)s.get(ProfilePicture.class, email);
		return profilePicture;
	}

}