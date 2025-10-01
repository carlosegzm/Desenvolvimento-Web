package br.com.filmix.api.mapper;

import br.com.filmix.api.dto.UsuarioRequestDTO;
import br.com.filmix.api.dto.UsuarioResponseDTO;
import br.com.filmix.api.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario toEntity(UsuarioRequestDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setFotoPerfil(dto.fotoPerfil());
        return usuario;
    }

    public UsuarioResponseDTO toResponseDTO(Usuario entity) {
        return new UsuarioResponseDTO(
                entity.getId(),
                entity.getNome(),
                entity.getEmail(),
                entity.getFotoPerfil()
        );
    }
}
