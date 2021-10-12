package com.bloggles.BlogglesSpring.model.users;


import com.bloggles.BlogglesSpring.model.blogs.Blog;
import com.bloggles.BlogglesSpring.model.blogs.Comment;
import com.bloggles.BlogglesSpring.model.blogs.Post;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Getter
    @Column(name = "user_id")
    private Long user_id;
    @Getter
    @Column(unique = true , name = "username")
    private String username;
    @Getter
    @Setter
    @Column(name = "real_name")
    private String fullName;
    @Getter
    @Setter
    private String email_address;
    @Getter
    @Column(name = "time_of_reg")
    private Timestamp regTime;
    @Getter
    @Column(name = "profile_pic")
    private byte[] profilePic;
    @Getter
    @Setter
    @Column(name = "user_password")
    private String password;
    @Getter
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Getter
    @Setter
    @OneToMany(mappedBy = "user")
    private List<Blog> blogList;

    @Getter
    @Setter
    @OneToMany(mappedBy = "user")
    private List<Post> postList;

    @Getter
    @Setter
    @OneToMany(mappedBy = "user")
    private List<Comment> commentList;

    @Getter
    @Setter
    private  boolean enabled;

    /** constructor for reading from database*/

    public User() {
    }

    public String toString(){
        return  "Username: " + username + ", " +
                "Name: " + fullName + ", " +
                "Email address: " + email_address + ", " +
                role + "\n\t" +
                "Time of registration: " + regTime + ", " +
                blogList;
    }
}
