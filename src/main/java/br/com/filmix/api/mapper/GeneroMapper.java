package br.com.filmix.api.mapper;

import br.com.filmix.api.dto.GeneroDTO;
import br.com.filmix.api.model.Genero;
import org.springframework.stereotype.Component;

@Component
public class GeneroMapper {

    public Genero map(GeneroDTO generoDTO) {
        Genero genero = new Genero();
        genero.setFilmes(generoDTO.getFilmes());
        genero.setId(generoDTO.getId());
        genero.setNome(generoDTO.getNome());

        return genero;
    }

    public GeneroDTO map(Genero genero) {
        GeneroDTO generoDTO = new GeneroDTO();
        generoDTO.setFilmes(genero.getFilmes());
        generoDTO.setId(genero.getId());
        generoDTO.setNome(genero.getNome());

        return generoDTO;
    }

}
