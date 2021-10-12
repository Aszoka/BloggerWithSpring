package com.bloggles.BlogglesSpring.repository;

import com.bloggles.BlogglesSpring.model.blogs.Blog;
import org.springframework.data.repository.CrudRepository;

public interface BlogRepository extends CrudRepository<Blog, Long> {
}
