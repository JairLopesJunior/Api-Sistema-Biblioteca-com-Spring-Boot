package io.github.jairlopesjunior.sistemabibliotecario.service;

import io.github.jairlopesjunior.sistemabibliotecario.domain.dtos.ClienteDTO;
import io.github.jairlopesjunior.sistemabibliotecario.domain.entities.Cliente;

public interface ClienteService {

    Cliente save(ClienteDTO clienteDTO);
}
