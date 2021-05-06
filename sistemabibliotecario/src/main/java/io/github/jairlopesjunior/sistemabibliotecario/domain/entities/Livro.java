package io.github.jairlopesjunior.sistemabibliotecario.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "tb_livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome_livro")
    @NotEmpty(message = "Campo nome do livro é obrigatório.")
    private String nomeLivro;

    @Column(name = "autor")
    @NotEmpty(message = "Campo autor é obrigatório.")
    private String autor;

    @Column(name = "ano_livro")
    private LocalDate anoLivro;

    @Column(name = "genero")
    @NotEmpty(message = "Campo genero é obrigatório.")
    private String genero;

    @Column(name = "editora")
    @NotEmpty(message = "Campo editora é obrigatório.")
    private String editora;

    @Column(name = "pagina")
    @NotNull(message = "Campo pagina é obrigatório.")
    private Integer pagina;

    @Column(name = "status")
    @NotEmpty(message = "Campo status é obrigatório.")
    private String status;
}
