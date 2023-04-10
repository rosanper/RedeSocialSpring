package com.ada.redesocialspring.controllers;

import com.ada.redesocialspring.dto.PostDTO;
import com.ada.redesocialspring.entities.Post;
import com.ada.redesocialspring.services.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("posts")
@RequiredArgsConstructor
public class PostControler {

    private final PostService postService;

    @GetMapping
    public List<Post> verTimeLine(){
        return postService.getAllPosts();
    }


    @GetMapping("conta/{contaId}")
    public List<Post> verTimeLineConta(@PathVariable String contaId){
        return postService.getPostByConta(contaId);
    }

    @GetMapping("{id}")
    public Post getById(@PathVariable String id){
        return postService.getPostById(id);
    }

    @PostMapping("conta/{contaId}")
    public Post create(@PathVariable String contaId, @Valid @RequestBody PostDTO postDTO){
        return postService.createPost(contaId, postDTO);
    }


}
