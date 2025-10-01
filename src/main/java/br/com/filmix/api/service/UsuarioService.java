package br.com.filmix.api.service;

import br.com.filmix.api.dto.UsuarioRequestDTO;
import br.com.filmix.api.dto.UsuarioResponseDTO;
import br.com.filmix.api.exception.RegraDeNegocioException;
import br.com.filmix.api.mapper.UsuarioMapper;
import br.com.filmix.api.model.Usuario;
import br.com.filmix.api.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UsuarioResponseDTO registrar(UsuarioRequestDTO dto) {
        if (usuarioRepository.findByEmail(dto.email()).isPresent()) {
            throw new RegraDeNegocioException("O email informado já está em uso");
        }
        Usuario usuario = usuarioMapper.toEntity(dto);

        String senhaCriptografada = passwordEncoder.encode(dto.senha());
        usuario.setSenhaHash(senhaCriptografada);

        usuarioRepository.save(usuario);
        return usuarioMapper.toResponseDTO(usuario);
    }
}
