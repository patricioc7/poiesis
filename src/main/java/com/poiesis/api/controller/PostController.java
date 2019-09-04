package com.poiesis.api.controller;

import com.poiesis.api.dto.PostDTO;
import com.poiesis.api.model.Post;
import com.poiesis.api.service.PostService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.poiesis.api.utils.DTOUtils.getPostFromDTO;

@RestController
@RequestMapping("/Post")
public class PostController {
    private PostService postService;

    @Autowired
    PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public List<Post> getAllPosts(HttpServletRequest request) {
        return postService.getAllPost();
    }

    @PostMapping("/")
    public Post newPost(@RequestBody PostDTO postDto) {
        return postService.savePost(getPostFromDTO(postDto));
    }

    @GetMapping("/user/{id}")
    public List<Post> getAllPostByUser(HttpServletRequest request) {
        return postService.getAllPostByUserId(new ObjectId(request.getParameter("id")));
    }
}
