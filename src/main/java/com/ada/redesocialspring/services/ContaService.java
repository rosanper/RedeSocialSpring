package com.ada.redesocialspring.services;

import com.ada.redesocialspring.dto.ContaDTO;
import com.ada.redesocialspring.entities.Conta;


import java.util.List;

public interface ContaService {
    List<Conta> getAllContas();
    Conta getContaById(String id);
    Conta createConta(ContaDTO contaDTO);
    Conta updateConta(String id, ContaDTO contaDTO);
    void deleteConta(String id);
}
