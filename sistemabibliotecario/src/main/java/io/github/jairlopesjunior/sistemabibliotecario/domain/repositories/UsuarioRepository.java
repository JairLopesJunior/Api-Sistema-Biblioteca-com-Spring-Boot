package io.github.jairlopesjunior.sistemabibliotecario.domain.repositories;

import io.github.jairlopesjunior.sistemabibliotecario.domain.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByLogin(String login);
}
