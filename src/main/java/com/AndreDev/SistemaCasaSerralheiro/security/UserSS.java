package com.AndreDev.SistemaCasaSerralheiro.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.AndreDev.SistemaCasaSerralheiro.domain.enums.Funcao;


public class UserSS implements UserDetails {
    private static final long serialVersionUID = 1L;

	
	private Long id;
	private String login;
	private String senha;
	private Collection<? extends GrantedAuthority> authorities;
	
	public UserSS(Long id, String login, String senha, Set<Funcao> funcoes) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.authorities = funcoes.stream().map(x -> new SimpleGrantedAuthority(x.getDescricao())).collect(Collectors.toSet());
	}

	public Long getId() {
		return id;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return login;
	}
} 