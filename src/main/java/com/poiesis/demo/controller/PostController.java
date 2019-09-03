package com.poiesis.demo.controller;

import com.poiesis.demo.model.Post;
import com.poiesis.demo.repository.PostRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Post")
public class PostController {
    @Autowired
    private PostRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Post> getAllPost() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Post getPostById(@PathVariable("id") ObjectId id) {
        return repository.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyPostById(@PathVariable("id") ObjectId id, @Valid @RequestBody Post Post) {
        Post.set_id(id);
        repository.save(Post);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Post createPost(@Valid @RequestBody Post Post) {
        Post.set_id(ObjectId.get());
        repository.save(Post);
        return Post;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable ObjectId id) {
        repository.delete(repository.findBy_id(id));
    }
}
