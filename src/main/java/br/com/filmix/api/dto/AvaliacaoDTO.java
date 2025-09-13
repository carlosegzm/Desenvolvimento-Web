package br.com.filmix.api.dto;

import br.com.filmix.api.model.Filme;
import br.com.filmix.api.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoDTO {

    private Long id;
    private float nota;
    private String comentario;
    private LocalDateTime dataAvaliacao;
    private Usuario usuario;
    private Filme filme;

}
