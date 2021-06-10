package io.github.jairlopesjunior.sistemabibliotecario.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //  Realiza a autenticação dos USUARIOS
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    // Realiza a autorização dos USUARIOS
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
    }
}
