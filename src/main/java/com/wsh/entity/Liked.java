package com.wsh.entity;

public class Liked {
    private Integer id;

    private String likeUser;

    private String likedQuestion;

    private String likedComment;

    private String likedReply;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLikeUser() {
        return likeUser;
    }

    public void setLikeUser(String likeUser) {
        this.likeUser = likeUser == null ? null : likeUser.trim();
    }

    public String getLikedQuestion() {
        return likedQuestion;
    }

    public void setLikedQuestion(String likedQuestion) {
        this.likedQuestion = likedQuestion == null ? null : likedQuestion.trim();
    }

    public String getLikedComment() {
        return likedComment;
    }

    public void setLikedComment(String likedComment) {
        this.likedComment = likedComment == null ? null : likedComment.trim();
    }

    public String getLikedReply() {
        return likedReply;
    }

    public void setLikedReply(String likedReply) {
        this.likedReply = likedReply == null ? null : likedReply.trim();
    }
}