package br.com.filmix.api.service;

import br.com.filmix.api.exception.RecursoNaoEncontradoException;
import br.com.filmix.api.exception.RegraDeNegocioException;
import br.com.filmix.api.model.Filme;
import br.com.filmix.api.model.Usuario;
import br.com.filmix.api.model.UsuarioFilme;
import br.com.filmix.api.repository.FilmeRepository;
import br.com.filmix.api.repository.UsuarioFilmeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UsuarioFilmeService {

    private final UsuarioFilmeRepository usuarioFilmeRepository;
    private final FilmeRepository filmeRepository;

    @Transactional
    public void adicionarFilmeNaLista(Long filmeId, Usuario usuarioLogado) {
        Filme filme = filmeRepository.findById(filmeId).orElseThrow(() -> new RecursoNaoEncontradoException("Filme com ID " + filmeId + " não encontrado"));

        boolean jaExiste = usuarioFilmeRepository.existsByUsuarioAndFilme(usuarioLogado, filme);
        if (jaExiste) {
            throw new RegraDeNegocioException("Este filme já existe na sua lista");
        }

        UsuarioFilme usuarioFilme = new UsuarioFilme();
        usuarioFilme.setUsuario(usuarioLogado);
        usuarioFilme.setFilme(filme);

        usuarioFilmeRepository.save(usuarioFilme);
    }

}
