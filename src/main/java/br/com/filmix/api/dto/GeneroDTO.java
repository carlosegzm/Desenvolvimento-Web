package br.com.filmix.api.dto;

import br.com.filmix.api.model.Filme;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeneroDTO {

    private Long id;
    private String nome;
    private Set<Filme> filmes;

}
