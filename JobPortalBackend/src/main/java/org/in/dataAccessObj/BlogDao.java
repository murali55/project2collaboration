package org.in.dataAccessObj;

import java.util.List;

import org.in.persistanceClzs.Blog;

public interface BlogDao 
{
 public void addBlog(Blog blog);
 public List<Blog> getBlogsApproved();
 public List<Blog> getBlogsWaitingForApproval();
 Blog getBlog(int blogPostId);
 void approveBlog(Blog blog);
 void rejectBlog(Blog blog);

}
