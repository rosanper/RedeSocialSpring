package com.ada.redesocialspring.repositories;

import com.ada.redesocialspring.entities.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContaRepository extends JpaRepository<Conta, String> {
}
