package io.github.jairlopesjunior.sistemabibliotecario.rest.controller;

import io.github.jairlopesjunior.sistemabibliotecario.domain.entities.Livro;
import io.github.jairlopesjunior.sistemabibliotecario.rest.dtos.LivroDTO;
import io.github.jairlopesjunior.sistemabibliotecario.rest.dtos.LivroDTOSemId;
import io.github.jairlopesjunior.sistemabibliotecario.service.LivroService;
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
    @PostMapping
    public Livro save(@RequestBody @Valid LivroDTO livroDTO){
        return livroService.save(livroDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        livroService.delete(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("{id}")
    public void update(@RequestBody LivroDTOSemId livroDTO, @PathVariable Integer id){
        livroService.update(livroDTO, id);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping
    public List<Livro> getAll(){
        return livroService.findAll();
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("{id}")
    public Livro getById(@PathVariable Integer id){
        return livroService.findById(id);
    }
}
