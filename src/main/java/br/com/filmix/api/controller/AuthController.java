package br.com.filmix.api.controller;

import br.com.filmix.api.dto.LoginRequestDTO;
import br.com.filmix.api.dto.TokenResponseDTO;
import br.com.filmix.api.model.Usuario;
import br.com.filmix.api.security.TokenService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDTO> login(@RequestBody @Valid LoginRequestDTO dto) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dto.email(), dto.senha());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        Usuario usuarioLogado = (Usuario) authentication.getPrincipal();
        String tokenJWT = tokenService.gerarToken(usuarioLogado);

        return ResponseEntity.ok(new TokenResponseDTO(
                tokenJWT,
                usuarioLogado.getNome(),
                usuarioLogado.getEmail(),
                usuarioLogado.getRole().toString()));
    }

}
