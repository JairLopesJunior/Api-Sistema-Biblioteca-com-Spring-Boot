package io.github.jairlopesjunior.sistemabibliotecario.service;

import io.github.jairlopesjunior.sistemabibliotecario.domain.entities.Livro;
import io.github.jairlopesjunior.sistemabibliotecario.rest.dtos.LivroDTO;
import io.github.jairlopesjunior.sistemabibliotecario.rest.dtos.LivroDTOSemId;

public interface LivroService {

    Livro save(LivroDTO livroDTO);

    void delete(Integer id);

    void update(LivroDTOSemId livroDTO, Integer id);
}
