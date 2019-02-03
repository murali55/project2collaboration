package org.in.dataAccessObjImpl;

import org.hibernate.SessionFactory;
import org.in.dataAccessObj.JobDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
@Transactional
public class JobDaoImpl implements JobDao 
{
	public JobDaoImpl()
	{
		System.out.println("jobDaoImpl bean is created");
	}
	@Autowired
 private SessionFactory sessionFactory;
 
}
