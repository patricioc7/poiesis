package com.poiesis.api.model;

import jdk.nashorn.internal.ir.annotations.Reference;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Comment {

    @Id
    private ObjectId _id;

    private String postId;

    private String userId;

    private String userName;

    private String content;

    public Comment() {
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }
}
