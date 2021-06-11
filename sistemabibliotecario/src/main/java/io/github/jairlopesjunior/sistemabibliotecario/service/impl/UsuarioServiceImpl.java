package io.github.jairlopesjunior.sistemabibliotecario.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Carrega os usuarios do Banco de Dados
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return User
                .builder()
                .username("jair")
                .password(passwordEncoder.encode("senha"))
                .roles("USER", "ADMIN")
                .build();
    }
}
