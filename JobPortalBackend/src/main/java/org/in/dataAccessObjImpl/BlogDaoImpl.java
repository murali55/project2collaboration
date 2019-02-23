package org.in.dataAccessObjImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.in.dataAccessObj.BlogDao;
import org.in.persistanceClzs.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
 @Repository
 @Transactional
public class BlogDaoImpl implements BlogDao {
@Autowired
private SessionFactory sessionFactory;
	public void addBlog(Blog blog) {
    Session session= sessionFactory.getCurrentSession();
    session.save(blog);
	}

	public List<Blog> getBlogsApproved() {
	Session session= sessionFactory.getCurrentSession();
	Query query= session.createQuery("from Blog where approved=true");
	List<Blog> blogsApproved =query.list();
		return blogsApproved;
	}

	public List<Blog> getBlogsWaitingForApproval() {
		Session session= sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Blog where approved=false");
		List<Blog> blogsWaitingForApproval= query.list();
		return blogsWaitingForApproval;
	}

}
