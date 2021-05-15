package io.github.jairlopesjunior.sistemabibliotecario.service.impl;

import io.github.jairlopesjunior.sistemabibliotecario.domain.entities.Livro;
import io.github.jairlopesjunior.sistemabibliotecario.domain.enums.StatusPedido;
import io.github.jairlopesjunior.sistemabibliotecario.domain.repositories.LivroRepository;
import io.github.jairlopesjunior.sistemabibliotecario.rest.dtos.LivroDTO;
import io.github.jairlopesjunior.sistemabibliotecario.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class LivroServiceImpl implements LivroService {

    private final LivroRepository livroRepository;

    @Override
    public Livro save(LivroDTO livroDTO) {
        Livro livroConvertido = converterLivroDTO(livroDTO);
        return livroRepository.save(livroConvertido);
    }

    private Livro converterLivroDTO(LivroDTO livroDTO){
        return Livro.builder()
                .nomeLivro(livroDTO.getNomeLivro())
                .autor(livroDTO.getAutor())
                .anoLivro(LocalDate.now())
                .genero(livroDTO.getGenero())
                .editora(livroDTO.getEditora())
                .pagina(livroDTO.getPagina())
                .status(StatusPedido.DISPONIVEL)
                .cliente(livroDTO.getCliente())
                .build();
    }
}
