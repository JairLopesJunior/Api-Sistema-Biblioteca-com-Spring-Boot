package io.github.jairlopesjunior.sistemabibliotecario.rest.dtos;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    @NotEmpty(message = "Campo nome é obrigatório.")
    @Size(message = "O nome do usuário não pode ultrapassar {max} caracteres.", max = 100)
    @ApiModelProperty(name = "nome", value = "Nome do Cliente", example = "James Gosling", position = 0)
    private String nome;

    @CPF(message = "Campo cpf é obrigatório.")
    @ApiModelProperty(name = "cpf", value = "CPF do Cliente", example = "64736274857", position = 1)
    private String cpf;

    @Email(message = "Campo email é obrigatório.")
    @ApiModelProperty(name = "email", value = "Email do Cliente", example = "james.gosling@sum.com", position = 2)
    private String email;

}
