package br.com.filmix.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "filmes")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo",length = 255, unique = true, nullable = false)
    private String titulo;

    @Column(name = "sinopse", length = 255)
    private String sinopse;

    @Column(name = "diretor", length = 100)
    private String diretor;

    @Column(name = "ano_lancamento")
    private LocalDate anoLancamento;

    @Column(name = "foto_filme", length = 255)
    private String fotoFilme;

    @OneToMany(mappedBy = "filme")
    private List<Avaliacao> avaliacoes;

    @ManyToMany
    @JoinTable(
            name = "filme_genero",
            joinColumns = @JoinColumn(name = "filme_id"),
            inverseJoinColumns = @JoinColumn(name = "genero_id")
    )
    private Set<Genero> generos;

    @ManyToMany(mappedBy = "listaUsuario")
    private Set<Usuario> usuariosComEsteFilmeNaLista;




}
