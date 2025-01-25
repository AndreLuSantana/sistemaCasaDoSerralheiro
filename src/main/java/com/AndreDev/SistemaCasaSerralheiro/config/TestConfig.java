package com.AndreDev.SistemaCasaSerralheiro.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.AndreDev.SistemaCasaSerralheiro.domain.Usuario;
import com.AndreDev.SistemaCasaSerralheiro.domain.enums.Funcao;
import com.AndreDev.SistemaCasaSerralheiro.repositories.UsuarioRepository;

import java.util.Set;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception {
        
        Usuario admin = new Usuario(null, "Administrador", "admin", encoder.encode("123456"), Set.of(Funcao.ADMIN));
        Usuario user = new Usuario(null, "Usuario Comum", "user", encoder.encode("123456"), Set.of(Funcao.VENDEDOR, Funcao.FINANCEIRO));

        usuarioRepository.save(admin);
        usuarioRepository.save(user);
    }
}
