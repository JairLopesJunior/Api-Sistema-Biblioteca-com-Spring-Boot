package io.github.jairlopesjunior.sistemabibliotecario.rest.dtos;

import io.github.jairlopesjunior.sistemabibliotecario.domain.enums.StatusPedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroDTO {

    @NotNull(message = "Campo id do Cliente é obrigatorio.")
    private Integer idCliente;

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

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

}
