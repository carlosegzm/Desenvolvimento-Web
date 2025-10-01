package br.com.filmix.api.dto;

public record UsuarioResponseDTO(
        Long id,
        String nome,
        String email,
        String fotoPerfil
) {
}
