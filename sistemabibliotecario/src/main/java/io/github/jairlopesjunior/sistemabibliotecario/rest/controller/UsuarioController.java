package io.github.jairlopesjunior.sistemabibliotecario.rest.controller;

import io.github.jairlopesjunior.sistemabibliotecario.domain.entities.Usuario;
import io.github.jairlopesjunior.sistemabibliotecario.service.impl.UsuarioServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioServiceImpl usuarioService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping
    @ResponseStatus(HttpStatus.FAILED_DEPENDENCY)
    public Usuario salvar( @Valid @RequestBody Usuario usuario){
        String senhaCriptografada = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senhaCriptografada);
        return usuarioService.salvar(usuario);
    }
}
