package io.github.jairlopesjunior.sistemabibliotecario.rest.dtos;

import io.github.jairlopesjunior.sistemabibliotecario.domain.entities.Cliente;
import io.github.jairlopesjunior.sistemabibliotecario.domain.enums.StatusPedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroDTO {

    @NotEmpty(message = "Campo nome do livro é obrigatório.")
    private String nomeLivro;

    @NotEmpty(message = "Campo autor é obrigatório.")
    private String autor;

    @NotEmpty(message = "Campo genero é obrigatório.")
    private String genero;

    @NotEmpty(message = "Campo editora é obrigatório.")
    private String editora;

    @NotNull(message = "Campo pagina é obrigatório.")
    private Integer pagina;

    @NotEmpty(message = "Campo status é obrigatório.")
    private StatusPedido status;

    private Cliente cliente;
}
