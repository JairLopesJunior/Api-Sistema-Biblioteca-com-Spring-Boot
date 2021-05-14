package io.github.jairlopesjunior.sistemabibliotecario.rest.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
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
