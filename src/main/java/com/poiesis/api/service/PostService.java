package com.poiesis.api.service;

import com.poiesis.api.model.Post;
import com.poiesis.api.repository.PostRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public List<Post> getAllPost() {
        return repository.findAll();
    }

    public Post getPost(ObjectId postId) {
        Optional<Post> byId = repository.findById(postId.toString());
        return byId.get();
    }

    public Post savePost(Post post) {
        Post savedPost = repository.save(post);
        return savedPost;
    }

    public List<Post> getAllPostByUserId(ObjectId userId) {
        return repository.getPostByUserId(userId);
    }
}
