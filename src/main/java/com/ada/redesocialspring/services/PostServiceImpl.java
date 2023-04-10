package com.ada.redesocialspring.services;

import com.ada.redesocialspring.Exceptions.PostNotFoundException;
import com.ada.redesocialspring.dto.PostDTO;
import com.ada.redesocialspring.entities.Conta;
import com.ada.redesocialspring.entities.Post;
import com.ada.redesocialspring.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    private final ContaService contaService;

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(String id) {
        return postRepository.findById(id).orElseThrow(PostNotFoundException::new);
    }

    @Override
    public Post createPost(String contaId, PostDTO postDTO) {

        Conta conta = contaService.getContaById(contaId);

        Post post = Post.builder().id(UUID.randomUUID().toString())
                .conteudo(postDTO.getConteudo())
                .dataHora(LocalDateTime.now())
                .conta(conta)
                .build();

        return postRepository.save(post);
    }


    @Override
    public void deletePost(String id) {
        Post post = getPostById(id);
        postRepository.delete(post);
    }

    @Override
    public List<Post> getPostByConta(String contaId) {
        List<Post> posts = postRepository.findByContaId(contaId);
        return posts;
    }
}
