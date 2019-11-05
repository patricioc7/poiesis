package com.poiesis.api.utils;

import com.poiesis.api.dto.PostDTO;
import com.poiesis.api.dto.UserDTO;
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
}
