package io.github.jairlopesjunior.sistemabibliotecario.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    @NotEmpty(message = "Login é obrigatório.")
    private String login;

    @Column(nullable = false)
    @NotEmpty(message = "Senha é obrigatório.")
    private String senha;

    @Column
    private boolean admin;
}
