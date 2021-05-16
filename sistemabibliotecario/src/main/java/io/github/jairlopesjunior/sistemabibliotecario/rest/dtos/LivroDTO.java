package io.github.jairlopesjunior.sistemabibliotecario.rest.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class LivroDTO {

    @NotNull(message = "Campo id do Cliente é obrigatorio.")
    @ApiModelProperty(name = "idCliente", example = "0, 1, 2, 3 ...", value = "Id do Cliente", position = 0)
    private Integer idCliente;

    @NotEmpty(message = "Campo nome do livro é obrigatório.")
    @ApiModelProperty(name = "nomeLivro", example = "Código Limpo, Java Como Programar ...", value = "Nome do Livro", position = 1)
    private String nomeLivro;

    @NotEmpty(message = "Campo autor é obrigatório.")
    @ApiModelProperty(name = "autor", example = "Fulano, Cicrano, Beltrano ...", value = "Autor", position = 2)
    private String autor;

    @NotEmpty(message = "Campo gênero é obrigatório.")
    @ApiModelProperty(name = "genero", example = "Romance, Drama ...", value = "Gênero", position = 3)
    private String genero;

    @NotEmpty(message = "Campo editora é obrigatório.")
    @ApiModelProperty(name = "editora", example = "Companhia da Letras, Aleph ...", value = "Editora", position = 4)
    private String editora;

    @NotNull(message = "Campo página é obrigatório.")
    @ApiModelProperty(name = "pagina", example = "100, 101, 102 ...", value = "Página", position = 5)
    private Integer pagina;

    @ApiModelProperty(name = "anoLivro", example = "2021-05-05 ...", value = "Ano do Livro", position = 6)
    private LocalDate anoLivro;

}
