package com.ironhack.demosecurityjwt.services.interfaces;

import com.ironhack.demosecurityjwt.models.BlogPost;

import java.util.List;

public interface BlogPostServiceInterface {

    List<BlogPost> getPosts();
    BlogPost saveBlogPost(BlogPost blogPost);

    void updateBlogPost(BlogPost blogPost, Long id);
    void deleteBlogPost(Long id);
}
