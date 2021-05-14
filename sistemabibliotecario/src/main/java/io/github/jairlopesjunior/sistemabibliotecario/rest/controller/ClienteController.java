package io.github.jairlopesjunior.sistemabibliotecario.rest.controller;

import io.github.jairlopesjunior.sistemabibliotecario.domain.entities.Cliente;
import io.github.jairlopesjunior.sistemabibliotecario.rest.dtos.ClienteDTO;
import io.github.jairlopesjunior.sistemabibliotecario.service.ClienteService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Salvar um Cliente.")
    @PostMapping
    public Cliente save(@RequestBody @Valid ClienteDTO cliente){
        return clienteService.save(cliente);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Deletar um Cliente.")
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        clienteService.delete(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Atualizar um Cliente.")
    @PutMapping("{id}")
    public void update(@PathVariable Integer id, @RequestBody @Valid ClienteDTO clienteDTO){
        clienteService.update(id, clienteDTO);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @ApiOperation("Buscar todos os Clientes.")
    @GetMapping
    public List<Cliente> getAll(){
        return clienteService.findAll();
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @ApiOperation("Buscar o Cliente pelo ID.")
    @GetMapping("{id}")
    public Cliente getById(@PathVariable Integer id){
        return clienteService.findById(id);
    }
}
