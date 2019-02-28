package org.in.dataAccessObjImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.in.dataAccessObj.BlogCommentDao;
import org.in.persistanceClzs.BlogComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
@Transactional
public class BlogCommentDaoImpl implements BlogCommentDao {
	@Autowired
	private SessionFactory sessionFactory;
	public void addBlogComment(BlogComment blogComment) {
		Session session=sessionFactory.getCurrentSession();
		session.save(blogComment);
	}

	public List<BlogComment> getAllBlogComments(int blogId) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from BlogComment where blog.blogId=?");
		query.setInteger(0, blogId);
		List<BlogComment> blogComments=query.list();
		return blogComments;
		
	}

}
