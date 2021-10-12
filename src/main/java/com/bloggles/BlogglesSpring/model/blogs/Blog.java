package com.bloggles.BlogglesSpring.model.blogs;


import com.bloggles.BlogglesSpring.model.template.Template;
import com.bloggles.BlogglesSpring.model.users.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "blog")
public class Blog {

        @Getter
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "blog_id")
        private Long blogID;
        @Getter
        private String blogTitle;
        @Getter
        private String author;
        @Getter

        private String templateID;

        @Getter
        @Setter
        @ManyToOne
        @JoinColumn(name = "blog_template_id")
        private Template template;

        @ManyToOne
        @JoinColumn(name = "blog_author_id")
        private User user;

        @Getter
        @Setter
        @OneToMany(mappedBy = "blog")
        private List<Post> postList;

    public Blog() {
    }

    public Blog(Long blogID, String blogTitle, String author, String templateID) {
            this.blogID = blogID;
            this.blogTitle = blogTitle;
            this.author = author;
            this.templateID = templateID;

            template = new Template();
            postList = new LinkedList<>();
        }

        public String toString(){
            return blogTitle + ", " +
                    " Author: " + author + ". " +
                    "Blog theme used: " + templateID;
        }
}
