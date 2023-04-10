package com.ada.redesocialspring.controllers;

import com.ada.redesocialspring.dto.ContaDTO;
import com.ada.redesocialspring.entities.Conta;
import com.ada.redesocialspring.services.ContaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contas")
@RequiredArgsConstructor
public class ContaController {

    private final ContaService contaService;

    @GetMapping
    public List<Conta> getAll(){
        return contaService.getAllContas();
    }

    @GetMapping("{id}")
    public Conta getById(@PathVariable String id){
        return contaService.getContaById(id);
    }

    @PostMapping
    public Conta create(@Valid @RequestBody ContaDTO contaDTO){
        return contaService.createConta(contaDTO);
    }

    @PutMapping("{id}")
    public Conta update(@PathVariable String id, @Valid @RequestBody ContaDTO contaDTO){
        return contaService.updateConta(id, contaDTO);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        contaService.deleteConta(id);
    }

}
