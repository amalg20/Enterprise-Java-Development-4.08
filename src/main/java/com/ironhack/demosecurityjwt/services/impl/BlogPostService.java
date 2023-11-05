package com.ironhack.demosecurityjwt.services.impl;

import com.ironhack.demosecurityjwt.models.BlogPost;
import com.ironhack.demosecurityjwt.repositories.BlogPostRepository;
import com.ironhack.demosecurityjwt.services.interfaces.BlogPostServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class BlogPostService implements BlogPostServiceInterface {

    @Autowired
    BlogPostRepository blogPostRepository;


    @Override
    public List<BlogPost> getPosts() {
        return blogPostRepository.findAll();
    }

    @Override
    public BlogPost saveBlogPost(BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }


    @Override
    public void updateBlogPost(BlogPost blogPost, Long id) {
        Optional<BlogPost> blogPostOptional = blogPostRepository.findById(id);
        if (blogPostOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        BlogPost blogPost1 = blogPostOptional.get();
        blogPost.setId(blogPost1.getId());
        blogPostRepository.save(blogPost);
    }

    @Override
    public void deleteBlogPost(Long id) {
        Optional<BlogPost> userOptional = blogPostRepository.findById(id);
        if (userOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        blogPostRepository.deleteById(id);
    }
}
