package br.com.filmix.api.dto;

import java.time.LocalDateTime;

public record AvaliacaoResponseDTO(
        Long id,
        Float nota,
        String comentario,
        LocalDateTime dataAvaliacao,
        UsuarioSimplificadoDTO usuario,
        FilmeSimplificadoDTO filme
) {
}
