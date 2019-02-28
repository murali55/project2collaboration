package org.in.dataAccessObj;

import org.in.persistanceClzs.Blog;
import org.in.persistanceClzs.BlogLike;

public interface BlogLikeDao {
	BlogLike hasUserLikedBlog(int blogId,String email);
	Blog updateLikes(int blogId, String email);

}
