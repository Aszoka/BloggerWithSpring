package com.bloggles.BlogglesSpring.repository;

import com.bloggles.BlogglesSpring.model.template.Template;
import org.springframework.data.repository.CrudRepository;

public interface TemplateRepository extends CrudRepository<Template, String> {

}
