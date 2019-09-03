package com.poiesis.demo.repository;

import com.poiesis.demo.model.Comment;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {
        Comment findBy_id(ObjectId _id);
}
