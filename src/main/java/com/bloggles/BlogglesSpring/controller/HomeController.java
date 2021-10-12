package com.bloggles.BlogglesSpring.controller;

import com.bloggles.BlogglesSpring.model.users.User;
import com.bloggles.BlogglesSpring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/users")
    public List<User> users(){
        return userService.getUsers();
    }

    @RequestMapping("/user/{username}")
    public User searchUser(@PathVariable(value = "username") String username){
        // admin: emerenc
        //moderator: sanyi823
        //user: Poetrist
        User searchingUser = userService.getUser("Poetrist");
        return userService.getUser(searchingUser,username);
    }
}


