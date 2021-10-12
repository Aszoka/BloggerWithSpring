package com.bloggles.BlogglesSpring.service;

import com.bloggles.BlogglesSpring.model.users.User;
import com.bloggles.BlogglesSpring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {

    UserRepository userRep;

    @Autowired
    public void setUserRep(UserRepository userRep) {
        this.userRep = userRep;
    }

    public List<User> getUsers(){
        return userRep.findAll();
    }

    // kipróbáláshoz
    public User getUser(String username){
        return userRep.findUserByUsername(username);
    }

    public User getUser(User searchingUser,String username){
        // ide jönne a logika, hogy ki jogosult?
        if(searchingUser.getUsername().equals(username) ||
                searchingUser.getRole().getLabel().equals("admin") ||
                searchingUser.getRole().getLabel().equals("moderator")){
            return userRep.findUserByUsername(username);
        }
        System.out.println("You don't have permission to access this info");
        return null;
    }
}
