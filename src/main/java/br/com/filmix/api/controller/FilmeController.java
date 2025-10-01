package br.com.filmix.api.controller;

import br.com.filmix.api.dto.FilmeRequestDTO;
import br.com.filmix.api.dto.FilmeResponseDTO;
import br.com.filmix.api.service.FilmeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/filmes")
@AllArgsConstructor
public class FilmeController {

    private final FilmeService filmeService;

    @PostMapping
    public ResponseEntity<FilmeResponseDTO> criar(@RequestBody @Valid FilmeRequestDTO dto) {
        FilmeResponseDTO response = filmeService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<FilmeResponseDTO>> listarTodos() {
        List<FilmeResponseDTO> response = filmeService.listarTodos();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmeResponseDTO> buscarPorId(@PathVariable Long id) {
        FilmeResponseDTO response = filmeService.buscarPorId(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilmeResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid FilmeRequestDTO dto) {
        FilmeResponseDTO response = filmeService.atualizar(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        filmeService.deletar(id);
    }




}
