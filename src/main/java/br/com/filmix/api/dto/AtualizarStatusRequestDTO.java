package br.com.filmix.api.dto;

import jakarta.validation.constraints.NotNull;

public record AtualizarStatusRequestDTO(
        @NotNull(message = "O status 'visto' não pode ser nulo")
        Boolean visto
) {
}
