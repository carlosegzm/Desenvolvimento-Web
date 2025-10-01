package br.com.filmix.api.mapper;

import br.com.filmix.api.dto.UsuarioFilmeResponseDTO;
import br.com.filmix.api.model.UsuarioFilme;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UsuarioFilmeMapper {

    private final FilmeMapper filmeMapper;

    public UsuarioFilmeResponseDTO toResponseDTO(UsuarioFilme entity) {
        return new UsuarioFilmeResponseDTO(
                filmeMapper.toResponseDTO(entity.getFilme()),
                entity.isVisto()
        );
    }


}
