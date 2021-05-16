package io.github.jairlopesjunior.sistemabibliotecario.domain.entities;

import io.github.jairlopesjunior.sistemabibliotecario.domain.enums.StatusPedido;
import lombok.*;

import javax.persistence.*;
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

    @Column(name = "nome_livro")
    private String nomeLivro;

    @Column(name = "autor")
    private String autor;

    @Column(name = "ano_livro")
    private LocalDate anoLivro;

    @Column(name = "genero")
    private String genero;

    @Column(name = "editora")
    private String editora;

    @Column(name = "pagina")
    private Integer pagina;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusPedido status;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
