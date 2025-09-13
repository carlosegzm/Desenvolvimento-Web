package br.com.filmix.api.mapper;

import br.com.filmix.api.dto.FilmeDTO;
import br.com.filmix.api.model.Filme;
import org.springframework.stereotype.Component;

@Component
public class FilmeMapper {

    public Filme map(FilmeDTO filmeDTO) {
        Filme filme = new Filme();
        filme.setId(filmeDTO.getId());
        filme.setFotoFilme(filmeDTO.getFotoFilme());
        filme.setGeneros(filmeDTO.getGeneros());
        filme.setDiretor(filmeDTO.getDiretor());
        filme.setAvaliacoes(filmeDTO.getAvaliacoes());
        filme.setSinopse(filmeDTO.getSinopse());
        filme.setTitulo(filmeDTO.getTitulo());
        filme.setAnoLancamento(filmeDTO.getAnoLancamento());
        filme.setUsuariosComEsteFilmeNaLista(filmeDTO.getUsuariosComEsteFilmeNaLista());

        return filme;
    }

    public FilmeDTO map(Filme filme) {
        FilmeDTO filmeDTO = new FilmeDTO();
        filmeDTO.setId(filme.getId());
        filmeDTO.setFotoFilme(filme.getFotoFilme());
        filmeDTO.setGeneros(filme.getGeneros());
        filmeDTO.setDiretor(filme.getDiretor());
        filmeDTO.setAvaliacoes(filme.getAvaliacoes());
        filmeDTO.setSinopse(filme.getSinopse());
        filmeDTO.setTitulo(filme.getTitulo());
        filmeDTO.setAnoLancamento(filme.getAnoLancamento());
        filmeDTO.setUsuariosComEsteFilmeNaLista(filme.getUsuariosComEsteFilmeNaLista());

        return filmeDTO;
    }

}
