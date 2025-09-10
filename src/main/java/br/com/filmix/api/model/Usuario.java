package br.com.filmix.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "email", length = 200, unique = true, nullable = false)
    private String email;

    @Column(name = "senha_hash", length = 255, nullable = false)
    private String senhaHash;

    @Column(name = "foto_perfil", length = 255)
    private String fotoPerfil;

    @OneToMany(mappedBy = "usuario")
    private List<Avaliacao> avaliacoes;

    @ManyToMany
    @JoinTable(
            name = "usuario_lista_filmes",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "filme_id")
    )
    private Set<Filme> listaUsuario;

}
