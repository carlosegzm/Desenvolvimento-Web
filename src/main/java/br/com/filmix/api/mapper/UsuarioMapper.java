package br.com.filmix.api.mapper;

import br.com.filmix.api.dto.UsuarioDTO;
import br.com.filmix.api.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario map(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setListaUsuario(usuarioDTO.getListaUsuario());
        usuario.setId(usuarioDTO.getId());
        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setAvaliacoes(usuarioDTO.getAvaliacoes());
        usuario.setFotoPerfil(usuarioDTO.getFotoPerfil());
        usuario.setSenhaHash(usuarioDTO.getSenhaHash());

        return usuario;
    }

    public UsuarioDTO map(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setListaUsuario(usuario.getListaUsuario());
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setNome(usuario.getNome());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setAvaliacoes(usuario.getAvaliacoes());
        usuarioDTO.setFotoPerfil(usuario.getFotoPerfil());
        usuarioDTO.setSenhaHash(usuario.getSenhaHash());

        return usuarioDTO;
    }

}
