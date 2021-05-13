package io.github.jairlopesjunior.sistemabibliotecario.service;

import io.github.jairlopesjunior.sistemabibliotecario.domain.entities.Cliente;
import io.github.jairlopesjunior.sistemabibliotecario.rest.dtos.ClienteDTO;

import java.util.List;

public interface ClienteService {

    Cliente save(ClienteDTO clienteDTO);

    void delete(Integer id);

    void update(Integer id, ClienteDTO clienteDTO);

    List<Cliente> findAll();

    Cliente findById(Integer id);
}
