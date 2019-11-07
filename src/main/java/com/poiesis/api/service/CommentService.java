package com.poiesis.api.service;

import com.poiesis.api.model.Comment;
import com.poiesis.api.repository.CommentRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository repository;

    public List<Comment> getAllComments() {
        return repository.findAll();
    }

    public List<Comment> getAllPostByUser(String userID) {
        return repository.getCommentByUserId(userID);
    }

    public Comment getComment(ObjectId postId) {
        Optional<Comment> byId = repository.findById(postId.toString());
        return byId.get();
    }

    public Comment saveComment(Comment comment) {
        Comment savedComment = repository.save(comment);
        return savedComment;
    }

    public List<Comment> getAllPostByPostId(String postId) {
        return repository.getCommentByPostId(postId);
    }
}
