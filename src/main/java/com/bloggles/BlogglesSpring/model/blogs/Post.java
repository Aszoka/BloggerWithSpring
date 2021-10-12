package com.bloggles.BlogglesSpring.model.blogs;

import com.bloggles.BlogglesSpring.model.users.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
@Entity
public class Post {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long postID;
    @Getter

    private String postAuthorID;
    @Getter

    private Long blogID;
    @Getter
    @Setter
    private String postTitle; // default 'no title',
    @Getter
    @Setter
    private String postBody;
    @Getter
    @Setter
    private PostType postType; //default 'normal'
    @Getter
    @Setter
    private boolean published;
    @Getter
    private Timestamp postingTime;

    @Getter
    @ManyToOne
    @JoinColumn(name = "post_blog_id")
    private Blog blog;
    @Getter
    @ManyToOne
    @JoinColumn(name = "post_author_id")
    private User user;

    @Getter
    @Setter
    @OneToMany(mappedBy = "post")
    private List<Comment> commentList;

    @Getter
    @Setter
    private Date edited;

    public Post() {
    }

    public Post(Long postID,
                String postAuthorID,
                Long blogID,
                String postTitle,
                String postBody,
                PostType postType,
                boolean published,
                Timestamp postingTime) {
        this.postID = postID;
        this.postAuthorID = postAuthorID;
        this.blogID = blogID;
        this.postTitle = postTitle;
        this.postBody = postBody;
        this.postType = postType;
        this.published = published;
        this.postingTime = postingTime;

        commentList = new LinkedList<>();
    }

    public Post(Long postID, String postAuthorID, Long blogID, String postTitle, String postBody) {
        this.postID = postID;
        this.postAuthorID = postAuthorID;
        this.blogID = blogID;
        this.postTitle = postTitle;
        this.postBody = postBody;

        commentList = new LinkedList<>();
    }

    public String toString(){
        return "Post written by: " + postAuthorID +
                " Post title: " + postTitle + "\n" +
                postBody + " Comments: " + commentList;
    }
}
