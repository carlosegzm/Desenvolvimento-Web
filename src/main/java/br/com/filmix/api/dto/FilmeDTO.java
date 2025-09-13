package br.com.filmix.api.dto;

import br.com.filmix.api.model.Avaliacao;
import br.com.filmix.api.model.Genero;
import br.com.filmix.api.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmeDTO {

    private Long id;
    private String titulo;
    private String sinopse;
    private String diretor;
    private LocalDate anoLancamento;
    private String fotoFilme;
    private List<Avaliacao> avaliacoes;
    private Set<Genero> generos;
    private Set<Usuario> usuariosComEsteFilmeNaLista;

}
