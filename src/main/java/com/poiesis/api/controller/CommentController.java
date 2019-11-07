package com.poiesis.api.controller;

import com.google.common.collect.Lists;
import com.poiesis.api.dto.CommentDTO;
import com.poiesis.api.dto.responses.CommentResponseDTO;
import com.poiesis.api.model.Comment;
import com.poiesis.api.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.poiesis.api.utils.DTOUtils.getCommentFromDTO;

@RestController
@RequestMapping("/comment")
public class CommentController {
    private CommentService commentService;


    @Autowired
    CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/")
    public List<CommentResponseDTO> getAllComments(HttpServletRequest request) {
        List<CommentResponseDTO> responseList = Lists.newArrayList();
        for (Comment comment : commentService.getAllComments()) {
            CommentResponseDTO crDTO = new CommentResponseDTO();
            crDTO.content = comment.getContent();
            crDTO.id = comment.get_id().toString();
            crDTO.postId = comment.getPostId();
            crDTO.userId = comment.getUserId();
            responseList.add(crDTO);
        }
        return responseList;
    }


    @PostMapping("/new")
    public CommentResponseDTO newComment(@RequestBody CommentDTO commentDTO) {
        Comment commentFromDTO = getCommentFromDTO(commentDTO);
        CommentResponseDTO crDTO = new CommentResponseDTO();
        crDTO.content = commentFromDTO.getContent();
        crDTO.postId = commentFromDTO.getPostId();
        crDTO.userId = commentFromDTO.getUserId();
        crDTO.userName = commentFromDTO.getUserName();
        commentService.saveComment(commentFromDTO);
        return crDTO;
    }

    @GetMapping("/bypost/{id}")
    public List<CommentResponseDTO> getPostComments(@PathVariable("id") String id) {
        List<CommentResponseDTO> responseList = Lists.newArrayList();
        for (Comment comment : commentService.getAllPostByPostId(id)) {
            CommentResponseDTO crDTO = new CommentResponseDTO();
            crDTO.content = comment.getContent();
            crDTO.id = comment.get_id().toString();
            crDTO.postId = comment.getPostId();
            crDTO.userId = comment.getUserId();
            crDTO.userName = comment.getUserName();
            responseList.add(crDTO);
        }
        return responseList;
    }

}
