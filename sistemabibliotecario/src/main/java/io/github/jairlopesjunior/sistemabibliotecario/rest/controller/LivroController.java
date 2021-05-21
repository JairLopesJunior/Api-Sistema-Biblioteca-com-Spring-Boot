package io.github.jairlopesjunior.sistemabibliotecario.rest.controller;

import io.github.jairlopesjunior.sistemabibliotecario.domain.entities.Livro;
import io.github.jairlopesjunior.sistemabibliotecario.rest.dtos.LivroDTO;
import io.github.jairlopesjunior.sistemabibliotecario.rest.dtos.LivroDTOSemId;
import io.github.jairlopesjunior.sistemabibliotecario.service.LivroService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

    private LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Salvar um Livro.")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Livro cadastrado com suceeso."),
            @ApiResponse(code = 400, message = "Erro de validação.")
    })
    @PostMapping
    public Livro save(@RequestBody @Valid LivroDTO livroDTO){
        return livroService.save(livroDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Deletar um Livro.")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Livro deletado com sucesso."),
            @ApiResponse(code = 404, message = "Livro não encontrado.")
    })
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        livroService.delete(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Atualizar um Livro.")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Livro atualizado com sucesso."),
            @ApiResponse(code = 404, message = "Livro não encontrado.")
    })
    @PutMapping("{id}")
    public void update(@RequestBody LivroDTOSemId livroDTO, @PathVariable Integer id){
        livroService.update(livroDTO, id);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @ApiOperation("Buscar todos os livros.")
    @ApiResponses({
            @ApiResponse(code = 202, message = "Livros encontrados com sucesso."),
            @ApiResponse(code = 404, message = "Nenhum livro encontrado.")
    })
    @GetMapping
    public List<Livro> getAll(){
        return livroService.findAll();
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @ApiOperation("Buscar o livro pelo ID.")
    @ApiResponses({
            @ApiResponse(code = 202, message = "Livro encontrado com sucesso."),
            @ApiResponse(code = 404, message = "Nenhum livro encontrado com este ID.")
    })
    @GetMapping("{id}")
    public Livro getById(@PathVariable Integer id){
        return livroService.findById(id);
    }
}
