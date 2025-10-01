package br.com.filmix.api.controller;

import br.com.filmix.api.dto.AvaliacaoRequestDTO;
import br.com.filmix.api.dto.AvaliacaoResponseDTO;
import br.com.filmix.api.model.Usuario;
import br.com.filmix.api.service.AvaliacaoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/filmes/{filmeId}/avaliacoes")
@AllArgsConstructor
public class AvaliacaoController {

    private final AvaliacaoService avaliacaoService;

    @PostMapping
    public ResponseEntity<AvaliacaoResponseDTO> criar(@PathVariable Long id, @RequestBody @Valid AvaliacaoRequestDTO dto) {
        Usuario usuarioLogado = new Usuario();
        usuarioLogado.setId(1L);

        AvaliacaoResponseDTO response = avaliacaoService.criar(id, dto, usuarioLogado);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<AvaliacaoResponseDTO>> listarPorFilme(@PathVariable Long filmeId) {
        List<AvaliacaoResponseDTO> response = avaliacaoService.listarPorFilme(filmeId);
        return ResponseEntity.ok(response);
    }

}
