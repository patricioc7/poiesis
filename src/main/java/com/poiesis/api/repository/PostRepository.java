package com.poiesis.api.repository;

import com.poiesis.api.model.Post;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {
        Post findBy_id(ObjectId _id);


        List<Post> getPostByUserId(String userId);
}
