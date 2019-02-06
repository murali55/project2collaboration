package org.in.dataAccessObjImpl;

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
Session session = sessionFactory.getCurrentSession();
session.save(user);
}

}
