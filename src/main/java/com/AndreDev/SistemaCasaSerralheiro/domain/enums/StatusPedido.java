package com.AndreDev.SistemaCasaSerralheiro.domain.enums;

public enum StatusPedido {
    FINANCEIRO(1, "AGUARDANDO FINANCEIRO"),
    SEPARACAO(2, "EM SEPARAÇÃO"),
    CONFERENCIA(3, "EM CONFERÊNCIA"),
    ENTREGA(4, "EM ROTA DE ENTREGA"),
    DIVERGENTE(5, "PEDIDO DIVERGENTE"),
    AUSENTE(6, "CLIENTE AUSENTE"),
    FINALIZADO(7, "PEDIDO FINALIZADO");

    private Integer codigo;
    private String descricao;

    private StatusPedido(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static StatusPedido valueOf(Integer codigo) {
        for (StatusPedido status : StatusPedido.values()) {
            if (status.getCodigo().equals(codigo)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Código de status do pedido inválido: " + codigo);
    }
}
