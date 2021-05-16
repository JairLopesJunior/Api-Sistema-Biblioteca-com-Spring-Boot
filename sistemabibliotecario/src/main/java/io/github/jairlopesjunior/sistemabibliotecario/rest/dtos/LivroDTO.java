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
    @ApiModelProperty(name = "idCliente", value = "Id do Cliente", example = "0, 1, 2, 3 ...", position = 0)
    private Integer idCliente;

    @NotEmpty(message = "Campo nome do livro é obrigatório.")
    @ApiModelProperty(name = "nomeLivro", value = "Nome do Livro", example = "Código Limpo, Java Como Programar ...", position = 1)
    private String nomeLivro;

    @NotEmpty(message = "Campo autor é obrigatório.")
    @ApiModelProperty(name = "autor", value = "Autor", example = "Fulano, Cicrano, Beltrano ...", position = 2)
    private String autor;

    @NotEmpty(message = "Campo gênero é obrigatório.")
    @ApiModelProperty(name = "genero", value = "Gênero", example = "Romance, Drama ...", position = 3)
    private String genero;

    @NotEmpty(message = "Campo editora é obrigatório.")
    @ApiModelProperty(name = "editora", value = "Editora", example = "Companhia da Letras, Aleph ...", position = 4)
    private String editora;

    @NotNull(message = "Campo página é obrigatório.")
    @ApiModelProperty(name = "pagina", value = "Página", example = "100, 101, 102 ...", position = 5)
    private Integer pagina;

    @ApiModelProperty(name = "anoLivro", value = "Ano do Livro", example = "2021-05-05 ...", position = 6)
    private LocalDate anoLivro;

}
