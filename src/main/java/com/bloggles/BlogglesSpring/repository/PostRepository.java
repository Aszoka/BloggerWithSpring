package com.bloggles.BlogglesSpring.repository;

import com.bloggles.BlogglesSpring.model.blogs.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
