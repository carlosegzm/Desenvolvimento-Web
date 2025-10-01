package br.com.filmix.api.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AvaliacaoRequestDTO(
        @NotNull @Min(0) @Max(10)
        Float nota,

        @Size(max = 2000)
        String comentario
) {
}
