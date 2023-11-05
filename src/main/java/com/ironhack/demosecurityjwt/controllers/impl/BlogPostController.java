package com.ironhack.demosecurityjwt.controllers.impl;

import com.ironhack.demosecurityjwt.controllers.interfaces.BlogPostControllerInterface;
import com.ironhack.demosecurityjwt.models.BlogPost;
import com.ironhack.demosecurityjwt.repositories.BlogPostRepository;
import com.ironhack.demosecurityjwt.services.impl.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BlogPostController  {


    @Autowired
    BlogPostService blogPostService;


    /*----------------------- GET------------------------------ */

    @GetMapping("/posts")
    @ResponseStatus(HttpStatus.OK)
    public List<BlogPost> getPosts(){
        return blogPostService.getPosts();
    }

    /*----------------------- POST------------------------------ */

    @PostMapping("/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public BlogPost saveBlogPost(@RequestBody BlogPost blogPost){
        return blogPostService.saveBlogPost(blogPost);
    }


    /*----------------------- PUT------------------------------ */

    @PutMapping("/posts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBlogPost(@RequestBody BlogPost blogPost, @PathVariable Long id) {
        blogPostService.updateBlogPost(blogPost, id);
    }

    /*----------------------- DELETE------------------------------ */
    @DeleteMapping("/posts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBlogPost(@PathVariable Long id) {
        blogPostService.deleteBlogPost(id);
    }

}
