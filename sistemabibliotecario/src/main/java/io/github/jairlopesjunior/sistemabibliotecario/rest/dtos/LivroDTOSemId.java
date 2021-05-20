package io.github.jairlopesjunior.sistemabibliotecario.rest.dtos;

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
public class LivroDTOSemId {

    @NotEmpty(message = "Campo nome do livro é obrigatório.")
    @ApiModelProperty(name = "nomeLivro", value = "Nome do Livro", example = "Código Limpo, Java Como Programar ...", position = 0)
    private String nomeLivro;

    @NotEmpty(message = "Campo autor é obrigatório.")
    @ApiModelProperty(name = "autor", value = "Autor", example = "Fulano, Cicrano, Beltrano ...", position = 1)
    private String autor;

    @NotEmpty(message = "Campo gênero é obrigatório.")
    @ApiModelProperty(name = "genero", value = "Gênero", example = "Romance, Drama ...", position = 2)
    private String genero;

    @NotEmpty(message = "Campo editora é obrigatório.")
    @ApiModelProperty(name = "editora", value = "Editora", example = "Companhia da Letras, Aleph ...", position = 3)
    private String editora;

    @NotNull(message = "Campo página é obrigatório.")
    @ApiModelProperty(name = "pagina", value = "Página", example = "100, 101, 102 ...", position = 4)
    private Integer pagina;

    @ApiModelProperty(name = "anoLivro", value = "Ano do Livro", example = "2021-05-05 ...", position = 5)
    private LocalDate anoLivro;
}
