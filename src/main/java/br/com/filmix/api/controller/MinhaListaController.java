package br.com.filmix.api.controller;

import br.com.filmix.api.model.Usuario;
import br.com.filmix.api.service.UsuarioFilmeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/minha-lista")
@AllArgsConstructor
public class MinhaListaController {

    private final UsuarioFilmeService usuarioFilmeService;

    @PostMapping("/filmes/{filmeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void adicionarFilmeNaLista(@PathVariable Long filmeId) {
        Usuario usuarioLogado = new Usuario();
        usuarioLogado.setId(1L);

        usuarioFilmeService.adicionarFilmeNaLista(filmeId, usuarioLogado);
    }










}
