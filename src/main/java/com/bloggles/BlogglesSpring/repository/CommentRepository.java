package com.bloggles.BlogglesSpring.repository;

import com.bloggles.BlogglesSpring.model.blogs.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
