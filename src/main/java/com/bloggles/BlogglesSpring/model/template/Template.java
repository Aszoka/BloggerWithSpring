package com.bloggles.BlogglesSpring.model.template;

import com.bloggles.BlogglesSpring.model.blogs.Blog;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Template {

    @Id
    @Getter
    @Column(name = "template_id")
    private String templateID;
    @Getter
    private String category;
    @Getter
    private String colorTheme;
    @Getter
    private byte[] background_picture;

    @Getter
    @OneToMany(mappedBy = "template")
    private List<Blog> blogList;

    public Template() {
    }

    public Template(String templateID, String category, String colorTheme) {
        this.templateID = templateID;
        this.category = category;
        this.colorTheme = colorTheme;
    }
}
