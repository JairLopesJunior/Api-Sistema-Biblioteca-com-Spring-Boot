package io.github.jairlopesjunior.sistemabibliotecario.service;

import io.github.jairlopesjunior.sistemabibliotecario.domain.entities.Cliente;
import io.github.jairlopesjunior.sistemabibliotecario.rest.dtos.ClienteDTO;

public interface ClienteService {

    Cliente save(ClienteDTO clienteDTO);

    void delete(Integer id);
}
