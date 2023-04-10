package com.ada.redesocialspring.services;

import com.ada.redesocialspring.Exceptions.UsuarioNotFoundException;
import com.ada.redesocialspring.dto.EnderecoDTO;
import com.ada.redesocialspring.dto.UsuarioDTO;
import com.ada.redesocialspring.entities.Usuario;
import com.ada.redesocialspring.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService{

    private final UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getUsuarioById(String id) {
        return usuarioRepository.findById(id).orElseThrow(UsuarioNotFoundException::new);
    }

    @Override
    public Usuario createUsuario(UsuarioDTO usuarioDTO) {
        RestTemplate restTemplate1 = new RestTemplate();
        String url = "https://viacep.com.br/ws/"+ usuarioDTO.getCep() +"/json/";
        EnderecoDTO enderecoDTO = restTemplate1.getForObject(url, EnderecoDTO.class);


        Usuario usuario = Usuario.builder()
                .id(UUID.randomUUID().toString())
                .nome(usuarioDTO.getNome())
                .sobrenome(usuarioDTO.getSobrenome())
                .cpf(usuarioDTO.getCpf())
                .dataNascimento(LocalDate.parse(usuarioDTO.getDataNascimento(), DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .cep(enderecoDTO.getCep())
                .logradouro(enderecoDTO.getLogradouro())
                .cidade(enderecoDTO.getCidade())
                .estado(enderecoDTO.getEstado())
                .build();


        return usuarioRepository.save(usuario);

    }

    @Override
    public Usuario updateUsuario(String id, UsuarioDTO usuarioDTO) {
        Usuario usuario = getUsuarioById(id);
        usuario.setNome(usuarioDTO.getNome());
        usuario.setSobrenome(usuarioDTO.getSobrenome());
        usuario.setCpf(usuarioDTO.getCpf());
        usuario.setDataNascimento(LocalDate.parse(usuarioDTO.getDataNascimento(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        return usuarioRepository.save(usuario);
    }

    @Override
    public void deleteUsuario(String id) {
        Usuario usuario = getUsuarioById(id);
        usuarioRepository.delete(usuario);
    }


}
