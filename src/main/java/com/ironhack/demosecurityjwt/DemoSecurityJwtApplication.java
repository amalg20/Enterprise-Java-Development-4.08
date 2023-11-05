package com.ironhack.demosecurityjwt;

import com.ironhack.demosecurityjwt.models.BlogPost;
import com.ironhack.demosecurityjwt.models.Role;
import com.ironhack.demosecurityjwt.models.User;
import com.ironhack.demosecurityjwt.services.impl.BlogPostService;
import com.ironhack.demosecurityjwt.services.impl.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class DemoSecurityJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSecurityJwtApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService, BlogPostService blogPostService) {
        return args -> {


            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));

            userService.saveUser(new User(null, "Aiko Tanaka", "aiko", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Jonas Schmidt", "jonas", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Cas Van Dijk", "cas", "1234", new ArrayList<>()));

            blogPostService.saveBlogPost(new BlogPost(null, "Boost Your Productivity with 10 Easy Tips", "Productivity - we all want it but it seems …", userService.getUser("aiko")));
            blogPostService.saveBlogPost(new BlogPost(null, "How to Focus", "Do you ever sit down to work and find yourself …", userService.getUser("aiko")));
            blogPostService.saveBlogPost(new BlogPost(null, "Learn to Speed Read in 30 Days", "Knowledge, not ability, is the great determiner of …", userService.getUser("jonas")));

            userService.addRoleToUser("aiko", "ROLE_USER");
            userService.addRoleToUser("aiko", "ROLE_ADMIN");
            userService.addRoleToUser("jonas", "ROLE_USER");
            userService.addRoleToUser("jonas", "ROLE_ADMIN");
            userService.addRoleToUser("cas", "ROLE_USER");

        };
    }

}
