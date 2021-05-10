package io.github.jairlopesjunior.sistemabibliotecario.rest.controller;

import io.github.jairlopesjunior.sistemabibliotecario.domain.dtos.ClienteDTO;
import io.github.jairlopesjunior.sistemabibliotecario.domain.entities.Cliente;
import io.github.jairlopesjunior.sistemabibliotecario.domain.repositories.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ClienteController {

    private ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Cliente save(@RequestBody @Valid ClienteDTO cliente){
        return clienteRepository.save(cliente);
    }
}
