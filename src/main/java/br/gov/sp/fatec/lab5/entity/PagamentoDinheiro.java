package br.gov.sp.fatec.lab5.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pag_pagamento_dinheiro")
public class PagamentoDinheiro extends Pagamento {

    private Double desconto;

    public Double getValor() {
        return this.valor - (this.valor * (desconto / 100));
    }

    @Override
    public String toString() {
        return "PagamentoDinheiro{" +
                "desconto=" + desconto +
                ", valor=" + valor +
                ", pedido=" + pedido +
                ", id=" + id +
                '}';
    }
}
