package com.AndreDev.SistemaCasaSerralheiro.domain.enums;

public enum StatusPagamento {
    PAGO(1, "PAGO"),
    EM_ABERTO(2, "EM ABERTO");

    private Integer codigo;
    private String descricao;

    private StatusPagamento(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static StatusPagamento valueOf(Integer codigo) {
        for (StatusPagamento status : StatusPagamento.values()) {
            if (status.getCodigo().equals(codigo)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Código de status de pagamento inválido: " + codigo);
    }
}
