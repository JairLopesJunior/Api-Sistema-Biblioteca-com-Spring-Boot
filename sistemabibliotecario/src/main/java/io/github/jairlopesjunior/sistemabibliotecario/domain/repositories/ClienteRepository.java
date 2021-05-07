package io.github.jairlopesjunior.sistemabibliotecario.domain.repositories;

import io.github.jairlopesjunior.sistemabibliotecario.domain.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
