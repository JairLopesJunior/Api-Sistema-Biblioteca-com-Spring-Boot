package io.github.jairlopesjunior.sistemabibliotecario.domain.entities;

import io.github.jairlopesjunior.sistemabibliotecario.domain.enums.StatusPedido;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "livro_sequence")
    @SequenceGenerator(name="livro_sequence", sequenceName= "liv_seq")
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome_livro", length = 100, nullable = false)
    @Size(message = "O nome do livro não pode ultrapassar {max} caracteres.", max = 100)
    private String nomeLivro;

    @Column(name = "autor", length = 100, nullable = false)
    @Size(message = "O autor do livro não pode ultrapassar {max} caracteres.", max = 100)
    private String autor;

    @Column(name = "ano_livro")
    private LocalDate anoLivro;

    @Column(name = "genero", length = 100, nullable = false)
    @Size(message = "O gênero do livro não pode ultrapassar {max} caracteres.", max = 100)
    private String genero;

    @Column(name = "editora", length = 100, nullable = false)
    @Size(message = "A editora do livro não pode ultrapassar {max} caracteres.", max = 100)
    private String editora;

    @Column(name = "pagina", length = 5, nullable = false)
    private Integer pagina;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusPedido status;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
