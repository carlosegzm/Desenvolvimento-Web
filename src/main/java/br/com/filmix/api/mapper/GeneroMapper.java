package br.com.filmix.api.mapper;

import br.com.filmix.api.dto.GeneroRequestDTO;
import br.com.filmix.api.dto.GeneroResponseDTO;
import br.com.filmix.api.model.Genero;
import org.springframework.stereotype.Component;

@Component
public class GeneroMapper {

    public Genero toEntity(GeneroRequestDTO dto) {
        Genero genero = new Genero();
        genero.setNome(dto.nome());
        return genero;
    }

    public GeneroResponseDTO toResponseDTO(Genero entity) {
        return new GeneroResponseDTO(entity.getId(), entity.getNome());
    }

}