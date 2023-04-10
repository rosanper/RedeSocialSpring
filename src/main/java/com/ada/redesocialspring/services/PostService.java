package com.ada.redesocialspring.services;

import com.ada.redesocialspring.dto.ContaDTO;
import com.ada.redesocialspring.dto.PostDTO;
import com.ada.redesocialspring.entities.Conta;
import com.ada.redesocialspring.entities.Post;

import java.util.List;

public interface PostService {

    List<Post> getAllPosts();
    Post getPostById(String id);
    Post createPost(String contaId,PostDTO postDTO);
    void deletePost(String id);

    List<Post> getPostByConta(String contaId);
}
