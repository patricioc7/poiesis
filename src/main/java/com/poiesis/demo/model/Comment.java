package com.poiesis.demo.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Comment {

    @Id
    public ObjectId _id;

    public Comment() {
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }
}
