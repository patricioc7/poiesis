package com.poiesis.api.controller;

import com.google.common.collect.Lists;
import com.poiesis.api.dto.PostDTO;
import com.poiesis.api.dto.responses.PostResponseDTO;
import com.poiesis.api.model.Post;
import com.poiesis.api.service.PostService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.poiesis.api.utils.DTOUtils.getPostFromDTO;

@RestController
@RequestMapping("/post")
public class PostController {
    private PostService postService;

    @Autowired
    PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public List<PostResponseDTO> getAllPosts(HttpServletRequest request) {
        List<PostResponseDTO> responseList = Lists.newArrayList();
        for (Post post : postService.getAllPost()) {
            PostResponseDTO postResponseDTO = new PostResponseDTO();
            postResponseDTO.userId = post.getUserId();
            postResponseDTO.content = post.getContent();
            postResponseDTO.postId = post.get_id().toString();
            responseList.add(postResponseDTO);
        }
        return responseList;
    }

    @PostMapping("/new")
    public PostResponseDTO newPost(@RequestBody PostDTO postDto) {
        Post postFromDTO = getPostFromDTO(postDto);
        PostResponseDTO prDTO = new PostResponseDTO();
        prDTO.content = postFromDTO.getContent();
        prDTO.userId = postFromDTO.getUserId();
        postService.savePost(postFromDTO);

        return prDTO;
    }

    @GetMapping("/user/{id}")
    public List<PostResponseDTO> getAllPostByUsere(@PathVariable("id") String id) {
        List<Post> allPostByUser = postService.getAllPostByUser(id);
        List<PostResponseDTO> responseList = Lists.newArrayList();
        for (Post post : allPostByUser) {
            PostResponseDTO postResponseDTO = new PostResponseDTO();
            postResponseDTO.userId = post.getUserId();
            postResponseDTO.content = post.getContent();
            postResponseDTO.postId = post.get_id().toString();
            responseList.add(postResponseDTO);
        }

        return responseList;
    }

    @GetMapping("/{id}")
    public PostResponseDTO getPost(@PathVariable("id") String id) {
        Post post = postService.getPost(new ObjectId(id));
        PostResponseDTO postResponseDTO = new PostResponseDTO();
        postResponseDTO.userId = post.getUserId();
        postResponseDTO.content = post.getContent();
        postResponseDTO.postId = post.get_id().toString();
        postResponseDTO.title = post.getName();
        return postResponseDTO;
    }
}
