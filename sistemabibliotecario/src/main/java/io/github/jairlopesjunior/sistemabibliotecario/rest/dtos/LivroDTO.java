package io.github.jairlopesjunior.sistemabibliotecario.rest.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class LivroDTO {

    @NotNull(message = "Campo id do Cliente é obrigatorio.")
    @ApiModelProperty(name = "Id do Cliente", position = 0, example = "0, 1, 2, 3 ...")
    private Integer idCliente;

    @NotEmpty(message = "Campo nome do livro é obrigatório.")
    @ApiModelProperty(name = "as", position = 1, example = "Código Limpo, Java Como Programar ...")
    private String nomeLivro;

    @NotEmpty(message = "Campo autor é obrigatório.")
    @ApiModelProperty(name = "as", position = 2, example = "Fulano, Cicrano, Beltrano ...")
    private String autor;

    @NotEmpty(message = "Campo gênero é obrigatório.")
    @ApiModelProperty(name = "as", position = 3, example = "Romance, Drama ...")
    private String genero;

    @NotEmpty(message = "Campo editora é obrigatório.")
    @ApiModelProperty(name = "as", position = 4, example = "Companhia da Letras, Aleph ...")
    private String editora;

    @NotNull(message = "Campo página é obrigatório.")
    @ApiModelProperty(name = "as", position = 5, example = "100, 101, 102 ...")
    private Integer pagina;

}
