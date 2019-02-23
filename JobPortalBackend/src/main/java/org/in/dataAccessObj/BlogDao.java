package org.in.dataAccessObj;

import java.util.List;

import org.in.persistanceClzs.Blog;

public interface BlogDao 
{
 public void addBlog(Blog blog);
 public List<Blog> getBlogsApproved();
 public List<Blog> getBlogsWaitingForApproval();
}
