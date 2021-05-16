package io.github.jairlopesjunior.sistemabibliotecario.rest.controller;

import io.github.jairlopesjunior.sistemabibliotecario.domain.entities.Livro;
import io.github.jairlopesjunior.sistemabibliotecario.rest.dtos.LivroDTO;
import io.github.jairlopesjunior.sistemabibliotecario.service.LivroService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

    private LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Livro save(@RequestBody @Valid LivroDTO livroDTO){
        return livroService.save(livroDTO);
    }

//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @DeleteMapping("{id}")
}
