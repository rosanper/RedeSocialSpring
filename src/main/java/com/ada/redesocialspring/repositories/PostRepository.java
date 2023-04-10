package com.ada.redesocialspring.repositories;

import com.ada.redesocialspring.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {
    List<Post> findByContaId(String contaId);
}
