package io.github.jairlopesjunior.sistemabibliotecario.domain.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "cli_sequence")
    @SequenceGenerator(name="cli_sequence", sequenceName= "cli_seq")
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome", length = 100, nullable = false)
    @Size(message = "O nome do usuário não pode ultrapassar {max} caracteres.", max = 100)
    private String nome;

    @Column(name = "cpf", length = 11, nullable = false)
    @Size(message = "O cpf do usuário não pode ultrapassar {max} caracteres.", max = 11)
    private String cpf;

    @Column(name = "email", length = 100, nullable = false)
    @Size(message = "O email do usuário não pode ultrapassar {max} caracteres.", max = 100)
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Livro> livros;
}
