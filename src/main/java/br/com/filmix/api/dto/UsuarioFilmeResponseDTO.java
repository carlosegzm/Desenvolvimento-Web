package br.com.filmix.api.dto;

public record UsuarioFilmeResponseDTO(
        FilmeResponseDTO filme,
        boolean visto
) {
}
