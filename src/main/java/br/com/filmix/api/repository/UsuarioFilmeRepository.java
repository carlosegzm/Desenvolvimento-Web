package br.com.filmix.api.repository;

import br.com.filmix.api.model.Filme;
import br.com.filmix.api.model.Usuario;
import br.com.filmix.api.model.UsuarioFilme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioFilmeRepository extends JpaRepository<UsuarioFilme, Long> {
    boolean existsByUsuarioAndFilme(Usuario usuario, Filme filme);
}
