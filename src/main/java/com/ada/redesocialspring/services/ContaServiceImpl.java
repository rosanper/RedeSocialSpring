package com.ada.redesocialspring.services;

import com.ada.redesocialspring.Exceptions.ContaNotFoundException;
import com.ada.redesocialspring.dto.ContaDTO;
import com.ada.redesocialspring.entities.Conta;
import com.ada.redesocialspring.entities.Usuario;
import com.ada.redesocialspring.repositories.ContaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ContaServiceImpl implements ContaService{

    private final ContaRepository contaRepository;

    private final UsuarioService usuarioService;

    @Override
    public List<Conta> getAllContas() {
        return contaRepository.findAll();
    }

    @Override
    public Conta getContaById(String id) {
        return contaRepository.findById(id).orElseThrow(ContaNotFoundException::new);
    }

    @Override
    public Conta createConta(ContaDTO contaDTO) {
        Usuario usuario = usuarioService.getUsuarioById(contaDTO.getUsuarioId());
        Conta conta = Conta.builder()
                .id(UUID.randomUUID().toString())
                .login(contaDTO.getLogin())
                .senha(contaDTO.getSenha())
                .usuario(usuario)
                .build();
        return contaRepository.save(conta);
    }

    @Override
    public Conta updateConta(String id, ContaDTO contaDTO) {
        Conta conta = getContaById(id);

        if(!conta.getUsuario().getId().equals(contaDTO.getUsuarioId())){
            Usuario novoUsuario = usuarioService.getUsuarioById(contaDTO.getUsuarioId());
            conta.setUsuario(novoUsuario);
        }

        conta.setLogin(contaDTO.getLogin());
        conta.setSenha(conta.getSenha());

        return contaRepository.save(conta);
    }

    @Override
    public void deleteConta(String id) {
        Conta conta = getContaById(id);
        contaRepository.delete(conta);
    }
}
