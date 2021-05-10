package io.github.jairlopesjunior.sistemabibliotecario.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    @NotEmpty(message = "Campo nome é obrigatório.")
    private String nome;

    @CPF(message = "Campo cpf é obrigatório.")
    private String cpf;

    @Email(message = "Campo email é obrigatório.")
    private String email;

}
