package com.poiesis.demo.utils;

import com.poiesis.demo.dto.PostDTO;
import com.poiesis.demo.dto.UserDTO;
import com.poiesis.demo.model.Post;
import com.poiesis.demo.model.User;

public class DTOUtils {
    public static Post getPostFromDTO(PostDTO postDTO){
        Post post = new Post();
        post.setName(postDTO.name);
        post.setUserId(postDTO.userId);
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
}
