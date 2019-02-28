package org.in.dataAccessObj;

import java.util.List;

import org.in.persistanceClzs.BlogComment;

public interface BlogCommentDao {
	void addBlogComment(BlogComment blogComment);
	List<BlogComment> getAllBlogComments(int blogPostId);
}
