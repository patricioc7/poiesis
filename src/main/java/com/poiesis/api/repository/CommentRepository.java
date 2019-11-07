package com.poiesis.api.repository;

import com.poiesis.api.model.Comment;
import com.poiesis.api.model.Post;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentRepository extends MongoRepository<Comment, String> {
        Comment findBy_id(ObjectId _id);

        List<Comment> getCommentByUserId(String userId);
        List<Comment> getCommentByPostId(String postId);
}
