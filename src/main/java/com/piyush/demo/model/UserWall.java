package com.piyush.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created By : Piyush Kumar
 */

@Entity
@Table(name = "userPosts", schema = "", catalog = "users")
public class UserWall implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long postId;
    private Long userId;
    private String post;
    private Date postDate;

    public UserWall() {
    }

    public UserWall(Long postId, Long userId, String post, Date postDate) {
        this.postId = postId;
        this.userId = userId;
        this.post = post;
        this.postDate = postDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "postId", nullable = false, insertable = false, updatable = false)
    public Long getPostId() {
        return postId;
    }
    @Basic
    @Column(name = "userId", nullable = false, insertable = true, updatable = true)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "post", nullable = true, insertable = true, updatable = true)
    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Basic
    @Column(name = "postDate", nullable = false, insertable = true, updatable = true)
    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    @Override
    public String toString() {
        return "UserWall{" +
                "postId=" + postId +
                ", userId=" + userId +
                ", post='" + post + '\'' +
                ", postDate=" + postDate +
                '}';
    }
}
