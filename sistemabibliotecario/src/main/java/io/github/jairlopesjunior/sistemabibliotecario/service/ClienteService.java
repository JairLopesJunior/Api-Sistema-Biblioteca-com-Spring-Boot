package io.github.jairlopesjunior.sistemabibliotecario.service;

import io.github.jairlopesjunior.sistemabibliotecario.domain.entities.Cliente;
import io.github.jairlopesjunior.sistemabibliotecario.rest.dtos.ClienteDTO;

import java.util.Optional;

public interface ClienteService {

    Cliente save(ClienteDTO clienteDTO);

    Optional<Cliente> delete(Integer id);
}
