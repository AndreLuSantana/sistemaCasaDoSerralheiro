package com.AndreDev.SistemaCasaSerralheiro.domain.enums;

public enum Funcao {
    ADMIN(1, "ROLE_ADMIN"),
    VENDEDOR(2, "ROLE_VENDEDOR"),
    FINANCEIRO(3, "ROLE_FINANCEIRO"),
    SEPARADOR(4, "ROLE_SEPARADOR"),
    CONFERENTE(5, "ROLE_CONFERENTE"),
    MOTORISTA(6, "ROLE_MOTORISTA"),
    SUP_LOGISTICA(7, "ROLE_SUP_LOGISTICA");

    private Integer codigo;
    private String descricao;

    private Funcao(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Funcao valueOf(Integer codigo) {
        for (Funcao funcao : Funcao.values()) {
            if (funcao.getCodigo().equals(codigo)) {
                return funcao;
            }
        }
        throw new IllegalArgumentException("Código de função inválido: " + codigo);
    }
} 