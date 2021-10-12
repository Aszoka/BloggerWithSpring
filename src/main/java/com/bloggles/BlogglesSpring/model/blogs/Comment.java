package com.bloggles.BlogglesSpring.model.blogs;

import com.bloggles.BlogglesSpring.model.users.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
@Entity
public class Comment {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @Column(name = "comment_id")
    private Long commentID;
    @Getter
   // @Column(name = "comment_author_id")
    private String commentAuthorID;
    @Getter
 //   @Column(name = "post_id")
    private Long postID;
    @Getter
    @Setter
    private String commentText;
    @Getter
  //  @Column(name = "reply_id")
    private Long replyID;
    @Getter
    private Timestamp sendingTime;

    @Getter
    @Setter
    @OneToMany(mappedBy = "comment")
    private List<Comment> replies;

    @Getter
    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @Getter
    @ManyToOne
    @JoinColumn(name = "comment_author_id")
    private User user;

    @Getter
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Comment() {
    }

    public Comment(Long commentID,
                   String commentAuthorID,
                   Long postID,
                   String commentText,
                   Long replyID,
                   Timestamp sendingTime) {
        this.commentID = commentID;
        this.commentAuthorID = commentAuthorID;
        this.postID = postID;
        this.commentText = commentText;
        this.replyID = replyID;
        this.sendingTime = sendingTime;

        replies = new LinkedList<>();
    }

    public Comment(Long commentID, String commentAuthorID, Long postID, String commentText) {
        this.commentID = commentID;
        this.commentAuthorID = commentAuthorID;
        this.postID = postID;
        this.commentText = commentText;

        replies = new LinkedList<>();
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentAuthorID='" + commentAuthorID + '\'' +
                ", commentText='" + commentText + '\'' +
                ", sendingTime=" + sendingTime +
                ", replies=" + replies +
                '}';
    }
}
