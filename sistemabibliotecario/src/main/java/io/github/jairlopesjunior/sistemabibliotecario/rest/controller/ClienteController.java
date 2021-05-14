package io.github.jairlopesjunior.sistemabibliotecario.rest.controller;

import io.github.jairlopesjunior.sistemabibliotecario.domain.entities.Cliente;
import io.github.jairlopesjunior.sistemabibliotecario.rest.dtos.ClienteDTO;
import io.github.jairlopesjunior.sistemabibliotecario.service.ClienteService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiResponses({
            @ApiResponse(code = 201, message = "Cliente cadastrado com sucesso."),
            @ApiResponse(code = 400, message = "Erro de validação.")
    })
    @PostMapping
    public Cliente save(@RequestBody @Valid ClienteDTO cliente){
        return clienteService.save(cliente);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Deletar um Cliente.")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Cliente deletado com sucesso."),
            @ApiResponse(code = 404, message = "Cliente não encontrado.")
    })
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        clienteService.delete(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Atualizar um Cliente.")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Cliente atualizado com sucesso."),
            @ApiResponse(code = 404, message = "Cliente não encontrado.")
    })
    @PutMapping("{id}")
    public void update(@PathVariable Integer id, @RequestBody @Valid ClienteDTO clienteDTO){
        clienteService.update(id, clienteDTO);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @ApiOperation("Buscar todos os Clientes.")
    @ApiResponses({
            @ApiResponse(code = 202, message = "Clientes encontrados com sucesso."),
            @ApiResponse(code = 404, message = "Nenhum cliente encontrado.")
    })
    @GetMapping
    public List<Cliente> getAll(){
        return clienteService.findAll();
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @ApiOperation("Buscar o Cliente pelo ID.")
    @ApiResponses({
            @ApiResponse(code = 202, message = "Cliente encontrado com sucesso."),
            @ApiResponse(code = 404, message = "Nenhum cliente encontrado com este ID.")
    })
    @GetMapping("{id}")
    public Cliente getById(@PathVariable Integer id){
        return clienteService.findById(id);
    }
}
