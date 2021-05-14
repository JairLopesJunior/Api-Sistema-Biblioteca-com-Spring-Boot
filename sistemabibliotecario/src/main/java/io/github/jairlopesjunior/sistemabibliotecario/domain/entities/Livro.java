package io.github.jairlopesjunior.sistemabibliotecario.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
