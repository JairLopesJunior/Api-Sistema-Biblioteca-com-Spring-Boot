package io.github.jairlopesjunior.sistemabibliotecario.domain.repositories;

import io.github.jairlopesjunior.sistemabibliotecario.domain.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {
}
