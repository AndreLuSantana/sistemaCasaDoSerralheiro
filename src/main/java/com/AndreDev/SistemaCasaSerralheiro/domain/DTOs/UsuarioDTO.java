package com.AndreDev.SistemaCasaSerralheiro.domain.DTOs;

import com.AndreDev.SistemaCasaSerralheiro.domain.Usuario;
import com.AndreDev.SistemaCasaSerralheiro.domain.enums.Funcao;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class UsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String login;
    private String senha;
    private Set<Integer> funcoes = new HashSet<>();

    public UsuarioDTO() {
    }

    public UsuarioDTO(Usuario obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.login = obj.getLogin();
        this.senha = obj.getSenha();
        this.funcoes = obj.getFuncoes().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Funcao> getFuncoes() {
        return funcoes.stream().map(Funcao::valueOf).collect(Collectors.toSet());
    }

    public void addPerfil(Funcao funcao) {
		this.funcoes.add(funcao.getCodigo());
	}

    // Método para converter DTO para entidade
    public Usuario toEntity() {
        return new Usuario(id, nome, login, senha, getFuncoes());
    }
}
