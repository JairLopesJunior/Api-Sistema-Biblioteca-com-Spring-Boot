package io.github.jairlopesjunior.sistemabibliotecario.service.impl;

import io.github.jairlopesjunior.sistemabibliotecario.domain.entities.Cliente;
import io.github.jairlopesjunior.sistemabibliotecario.domain.entities.Livro;
import io.github.jairlopesjunior.sistemabibliotecario.domain.enums.StatusPedido;
import io.github.jairlopesjunior.sistemabibliotecario.domain.repositories.ClienteRepository;
import io.github.jairlopesjunior.sistemabibliotecario.domain.repositories.LivroRepository;
import io.github.jairlopesjunior.sistemabibliotecario.rest.dtos.LivroDTO;
import io.github.jairlopesjunior.sistemabibliotecario.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class LivroServiceImpl implements LivroService {

    private final LivroRepository livroRepository;

    private final ClienteRepository clienteRepository;

    @Override
    public Livro save(LivroDTO livroDTO) {
        Cliente clienteEncontrado = clienteRepository.findById(livroDTO.getIdCliente())
                .orElseThrow( ()  -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Informe o codigo do cliente."));
        Livro livroConvertido = converterLivroDTO(clienteEncontrado ,livroDTO);
        return livroRepository.save(livroConvertido);
    }

    private Livro converterLivroDTO(Cliente clienteEncontrado, LivroDTO livroDTO){
        return Livro.builder()
                .nomeLivro(livroDTO.getNomeLivro())
                .autor(livroDTO.getAutor())
                .anoLivro(LocalDate.now())
                .genero(livroDTO.getGenero())
                .editora(livroDTO.getEditora())
                .pagina(livroDTO.getPagina())
                .status(StatusPedido.DISPONIVEL)
                .cliente(clienteEncontrado)
                .build();
    }
}
