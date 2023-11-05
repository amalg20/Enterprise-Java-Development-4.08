package com.ironhack.demosecurityjwt.controllers.interfaces;


import com.ironhack.demosecurityjwt.models.BlogPost;

import java.util.List;

public interface BlogPostControllerInterface {

    List<BlogPost> getPosts();
    BlogPost saveBlogPost(BlogPost blogPost);

    void deletePost(Long id);

}
