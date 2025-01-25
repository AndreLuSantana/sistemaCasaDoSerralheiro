package com.AndreDev.SistemaCasaSerralheiro.Services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.AndreDev.SistemaCasaSerralheiro.domain.Usuario;
import com.AndreDev.SistemaCasaSerralheiro.repositories.UsuarioRepository;
import com.AndreDev.SistemaCasaSerralheiro.security.UserSS;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<Usuario> user = usuarioRepository.findByLogin(login);
        if (user.isPresent()) {
            return new UserSS(user.get().getId(), user.get().getLogin(), user.get().getSenha(), user.get().getFuncoes());
        }
        throw new UsernameNotFoundException(login);
    } 
}
