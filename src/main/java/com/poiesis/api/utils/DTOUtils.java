package com.poiesis.api.utils;

import com.poiesis.api.dto.CommentDTO;
import com.poiesis.api.dto.PostDTO;
import com.poiesis.api.dto.UserDTO;
import com.poiesis.api.model.Comment;
import com.poiesis.api.model.Post;
import com.poiesis.api.model.User;

public class DTOUtils {
    public static Post getPostFromDTO(PostDTO postDTO){
        Post post = new Post();
        post.setTitle(postDTO.title);
        post.setUserId(postDTO.userId);
        post.setContent(postDTO.content);
        return post;
    }

    public static User getUserFromDTO(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.name);
        user.setEmail(userDTO.email);
        user.setCommentList(userDTO.commentList);
        user.setPassword(userDTO.password);
        user.setPictureUrl(userDTO.pictureUrl);
        user.setPostList(userDTO.postList);
        user.setDescription(userDTO.description);
        return user;
    }

    public static Comment getCommentFromDTO(CommentDTO commentDTO){
        Comment comment = new Comment();
        comment.setContent(commentDTO.content);
        comment.setPostId(commentDTO.postId);
        comment.setUserId(commentDTO.userId);
        comment.setUserName(commentDTO.userName);
        return comment;
    }

}
