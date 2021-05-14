package io.github.jairlopesjunior.sistemabibliotecario.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
