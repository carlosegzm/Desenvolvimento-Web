package br.com.filmix.api.dto;

import br.com.filmix.api.model.Avaliacao;
import br.com.filmix.api.model.Filme;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private Long id;
    private String nome;
    private String email;
    private String senhaHash;
    private String fotoPerfil;
    private List<Avaliacao> avaliacoes;
    private Set<Filme> listaUsuario;

}
