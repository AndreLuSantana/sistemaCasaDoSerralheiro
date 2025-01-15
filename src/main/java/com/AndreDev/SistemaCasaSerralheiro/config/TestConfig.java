package com.AndreDev.SistemaCasaSerralheiro.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.AndreDev.SistemaCasaSerralheiro.domain.Usuario;
import com.AndreDev.SistemaCasaSerralheiro.domain.enums.Funcao;
import com.AndreDev.SistemaCasaSerralheiro.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {
        
        Usuario admin = new Usuario(null, "Administrador", "admin", "123456", Funcao.ADMIN);
        Usuario user = new Usuario(null, "Usuario Comum", "user", "123456", Funcao.VENDEDOR);

        usuarioRepository.save(admin);
        usuarioRepository.save(user);
    }
}
