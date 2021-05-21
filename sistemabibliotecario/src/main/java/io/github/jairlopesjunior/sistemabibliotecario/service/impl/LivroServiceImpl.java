package io.github.jairlopesjunior.sistemabibliotecario.service.impl;

import io.github.jairlopesjunior.sistemabibliotecario.domain.entities.Cliente;
import io.github.jairlopesjunior.sistemabibliotecario.domain.entities.Livro;
import io.github.jairlopesjunior.sistemabibliotecario.domain.enums.StatusPedido;
import io.github.jairlopesjunior.sistemabibliotecario.domain.repositories.ClienteRepository;
import io.github.jairlopesjunior.sistemabibliotecario.domain.repositories.LivroRepository;
import io.github.jairlopesjunior.sistemabibliotecario.rest.dtos.LivroDTO;
import io.github.jairlopesjunior.sistemabibliotecario.rest.dtos.LivroDTOSemId;
import io.github.jairlopesjunior.sistemabibliotecario.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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

    @Override
    public void delete(Integer id) {
        livroRepository.findById(id)
                .map( livroEncontrado -> {
                    livroRepository.delete(livroEncontrado);
                    return livroEncontrado;
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado."));
    }

    @Override
    public void update(LivroDTOSemId livroDTO, Integer id) {
        livroRepository.findById(id)
                .map(livroEncontrado -> {
                    Livro livroConvertido = converterLivroDTO(livroDTO);
                    livroConvertido.setId(livroEncontrado.getId());
                    livroConvertido.setCliente(livroEncontrado.getCliente());
                    return livroRepository.save(livroConvertido);
                }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado."));
    }

    @Override
    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    @Override
    public Livro findById(Integer id) {
        return livroRepository.findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado."));
    }

    private Livro converterLivroDTO(Cliente clienteEncontrado, LivroDTO livroDTO){
        return Livro.builder()
                .nomeLivro(livroDTO.getNomeLivro())
                .autor(livroDTO.getAutor())
                .anoLivro(livroDTO.getAnoLivro())
                .genero(livroDTO.getGenero())
                .editora(livroDTO.getEditora())
                .pagina(livroDTO.getPagina())
                .status(StatusPedido.DISPONIVEL)
                .cliente(clienteEncontrado)
                .build();
    }

    private Livro converterLivroDTO(LivroDTOSemId livroDTO){
        return Livro.builder()
                .nomeLivro(livroDTO.getNomeLivro())
                .autor(livroDTO.getAutor())
                .anoLivro(livroDTO.getAnoLivro())
                .genero(livroDTO.getGenero())
                .editora(livroDTO.getEditora())
                .pagina(livroDTO.getPagina())
                .status(StatusPedido.DISPONIVEL)
                .build();
    }
}
