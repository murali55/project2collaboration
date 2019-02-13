package org.in.dataAccessObjImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.in.dataAccessObj.UserDao;
import org.in.persistanceClzs.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
@Transactional
public class UserDaoImpl implements UserDao
{
@Autowired
private SessionFactory sessionFactory;

public void userRegistration(User user)
{
	System.out.println("userReg"+user);

Session session = sessionFactory.getCurrentSession();
session.save(user);
}
public boolean isEmailUnique(String email) {
	System.out.println("emailUn "+email);
	Session session=sessionFactory.getCurrentSession();
	
	User user=(User)session.get(User.class,email);
	System.out.println("emailS "+email);
	System.out.println("userC "+user);

	if(user==null) //if email is unique
		return true;
	
		else //if email is not unique

			return false;
}

public boolean isPhoneNbrUnique(String phoneNbr){
	System.out.println("phoneNbr ");

	Session session=sessionFactory.getCurrentSession();
	Query query=session.createQuery("from User where phoneNbr=:pnumber");
	query.setString("pnumber", phoneNbr);
	User user=(User)query.uniqueResult();
	if(user==null)//phonenumber is unique
		return true;
	else 
		return false;
	
}
public User login(User user) {
	Session session= sessionFactory.getCurrentSession();
	Query query= session.createQuery("from User where email=:email and password=:password");
	query.setString("email", user.getEmail());
	query.setString("password",user.getPassword());
	User validUser= (User)query.uniqueResult();
	return validUser;
}
public void updateUser(User validUser) {
	Session session =sessionFactory.getCurrentSession();
	session.update(validUser);
	
}
public User getUser(String email) {
	Session session= sessionFactory.getCurrentSession();
	User user=(User)session.get(User.class, email);
	return user;
}

}
