package com.poiesis.demo.dto;

import com.poiesis.demo.model.Post;

import java.util.List;

public class UserDTO {
    public String id;
    public String name;
    public String description;
    public String pictureUrl;
    public String email;
    public String password;
    public List<String> commentList;
    public List<String> postList;
}
