package io.github.jairlopesjunior.sistemabibliotecario.rest.dtos;

import io.github.jairlopesjunior.sistemabibliotecario.domain.enums.StatusPedido;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel
public class LivroDTO {

    @NotNull(message = "Campo id do Cliente é obrigatorio.")
    @ApiModelProperty(position = 0)
    private Integer idCliente;

    @NotEmpty(message = "Campo nome do livro é obrigatório.")
    @ApiModelProperty(position = 1)
    private String nomeLivro;

    @NotEmpty(message = "Campo autor é obrigatório.")
    @ApiModelProperty(position = 2)
    private String autor;

    @NotEmpty(message = "Campo gênero é obrigatório.")
    @ApiModelProperty(position = 3)
    private String genero;

    @NotEmpty(message = "Campo editora é obrigatório.")
    @ApiModelProperty(position = 4)
    private String editora;

    @NotNull(message = "Campo página é obrigatório.")
    @ApiModelProperty(position = 5)
    private Integer pagina;

    @Enumerated(EnumType.STRING)
    @ApiModelProperty(position = 6)
    private StatusPedido status;

}
