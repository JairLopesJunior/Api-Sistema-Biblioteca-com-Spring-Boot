package io.github.jairlopesjunior.sistemabibliotecario.service.impl;

import io.github.jairlopesjunior.sistemabibliotecario.domain.entities.Usuario;
import io.github.jairlopesjunior.sistemabibliotecario.domain.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

@Service
public class UsuarioServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository repository;

    @Transactional
    public Usuario salvar(Usuario usuario){
        return repository.save(usuario);
    }

    // Carrega os usuarios do Banco de Dados
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario userFound =  repository.findByLogin(username)
                .orElseThrow( () -> new UsernameNotFoundException("Usuario não encontrado na base de dados."));

        String[] roles = userFound.isAdmin()
                ? new String[]{"ADMIN", "USER"} : new String[]{"USER"} ;

        return User
                .builder()
                .username(userFound.getLogin())
                .password(userFound.getSenha())
                .roles(roles)
                .build();
    }
}
