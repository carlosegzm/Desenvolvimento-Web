package br.com.filmix.api.controller;

import br.com.filmix.api.dto.UsuarioRequestDTO;
import br.com.filmix.api.dto.UsuarioResponseDTO;
import br.com.filmix.api.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/registrar")
    public ResponseEntity<UsuarioResponseDTO> registrar(@RequestBody @Valid UsuarioRequestDTO dto) {
        UsuarioResponseDTO response = usuarioService.registrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
