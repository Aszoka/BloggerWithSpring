package com.bloggles.BlogglesSpring.repository;
import org.springframework.data.repository.CrudRepository;

import com.bloggles.BlogglesSpring.model.users.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long>{
    List<User> findAll();
    User findUserByUsername(String username);
}
