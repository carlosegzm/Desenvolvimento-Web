package br.com.filmix.api.mapper;

import br.com.filmix.api.dto.AvaliacaoDTO;
import br.com.filmix.api.model.Avaliacao;
import org.springframework.stereotype.Component;

@Component
public class AvaliacaoMapper {

    public Avaliacao map(AvaliacaoDTO avaliacaoDTO) {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setId(avaliacaoDTO.getId());
        avaliacao.setDataAvaliacao(avaliacaoDTO.getDataAvaliacao());
        avaliacao.setNota(avaliacaoDTO.getNota());
        avaliacao.setFilme(avaliacaoDTO.getFilme());
        avaliacao.setUsuario(avaliacaoDTO.getUsuario());
        avaliacao.setComentario(avaliacaoDTO.getComentario());

        return avaliacao;
    }

    public AvaliacaoDTO map(Avaliacao avaliacao) {
        AvaliacaoDTO avaliacaoDTO = new AvaliacaoDTO();
        avaliacaoDTO.setId(avaliacao.getId());
        avaliacaoDTO.setDataAvaliacao(avaliacao.getDataAvaliacao());
        avaliacaoDTO.setNota(avaliacao.getNota());
        avaliacaoDTO.setFilme(avaliacao.getFilme());
        avaliacaoDTO.setUsuario(avaliacao.getUsuario());
        avaliacaoDTO.setComentario(avaliacao.getComentario());

        return avaliacaoDTO;
    }


}
