package com.poiesis.demo.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;

import java.util.Date;
import java.util.List;

public class Post {

    @Id
    private ObjectId _id;
    private String name;

    @Reference
    private User op;



    @Reference
    private List<Comment> commentList;
    private Date creationDate;


    public Post(){
    }

    public ObjectId get_id() {
        return _id;
    }


    public void set_id(ObjectId _id) {
        this._id = _id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOp() {
        return op;
    }

    public void setOp(User op) {
        this.op = op;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
