package io.github.jairlopesjunior.sistemabibliotecario.service.impl;

import io.github.jairlopesjunior.sistemabibliotecario.domain.entities.Cliente;
import io.github.jairlopesjunior.sistemabibliotecario.domain.repositories.ClienteRepository;
import io.github.jairlopesjunior.sistemabibliotecario.rest.dtos.ClienteDTO;
import io.github.jairlopesjunior.sistemabibliotecario.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public Cliente save(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTO.getNome());
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setEmail(clienteDTO.getEmail());
        return clienteRepository.save(cliente);
    }

    @Override
    public void delete(Integer id) {
        clienteRepository.findById(id)
                .map(cliente -> {
                    clienteRepository.delete(cliente);
                    return cliente;
                }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));
    }

    @Override
    public void update(Integer id, ClienteDTO clienteDTO) {
        clienteRepository.findById(id)
                .map(clienteExistente -> {
                    clienteExistente.setNome(clienteDTO.getNome());
                    clienteExistente.setEmail(clienteDTO.getEmail());
                    clienteExistente.setCpf(clienteDTO.getCpf());
                    return clienteRepository.save(clienteExistente);
                }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findById(Integer id) {
        return clienteRepository.findById(id)
                .orElseThrow( ()  -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));
    }


}
