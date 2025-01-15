package com.AndreDev.SistemaCasaSerralheiro.domain.DTOs;

import com.AndreDev.SistemaCasaSerralheiro.domain.Usuario;
import com.AndreDev.SistemaCasaSerralheiro.domain.enums.Funcao;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String login;
    private Funcao funcao;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Usuario obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.login = obj.getLogin();
        this.funcao = obj.getFuncao();
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

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    // Método para converter DTO para entidade
    public Usuario toEntity() {
        return new Usuario(id, nome, login, null, funcao);
    }
}
