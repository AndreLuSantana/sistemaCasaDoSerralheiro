package com.AndreDev.SistemaCasaSerralheiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AndreDev.SistemaCasaSerralheiro.domain.Usuario;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    // Método para buscar usuário por login
    Optional<Usuario> findByLogin(String login);
    
    // Método para verificar se existe usuário com determinado login
    boolean existsByLogin(String login);
}
