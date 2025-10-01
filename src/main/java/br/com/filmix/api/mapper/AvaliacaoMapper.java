package br.com.filmix.api.mapper;

import br.com.filmix.api.dto.AvaliacaoRequestDTO;
import br.com.filmix.api.dto.AvaliacaoResponseDTO;
import br.com.filmix.api.dto.FilmeSimplificadoDTO;
import br.com.filmix.api.dto.UsuarioSimplificadoDTO;
import br.com.filmix.api.model.Avaliacao;
import org.springframework.stereotype.Component;

@Component
public class AvaliacaoMapper {

    public Avaliacao toEntity(AvaliacaoRequestDTO dto) {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setNota(dto.nota());
        avaliacao.setComentario(dto.comentario());
        return avaliacao;
    }

    public AvaliacaoResponseDTO toResponseDTO(Avaliacao entity) {
        UsuarioSimplificadoDTO usuarioDTO = new UsuarioSimplificadoDTO(
                entity.getUsuario().getId(),
                entity.getUsuario().getNome()
        );

        FilmeSimplificadoDTO filmeDTO = new FilmeSimplificadoDTO(
                entity.getFilme().getId(),
                entity.getFilme().getTitulo()
        );

        return new AvaliacaoResponseDTO(
                entity.getId(),
                entity.getNota(),
                entity.getComentario(),
                entity.getDataAvaliacao(),
                usuarioDTO,
                filmeDTO
        );
    }

}
