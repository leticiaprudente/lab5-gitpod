package br.gov.sp.fatec.lab5.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;

import java.util.ArrayList;
import java.util.List;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
@Entity
@Table(name = "cli_cliente")

@AttributeOverride(name = "id", column = @Column(name = "cli_id"))
public abstract class Cliente extends Identificador {
    @JsonView(Views.Publico.class)
    protected String nome;
    @JsonView(Views.Autenticado.class)
    protected String endereco;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
    protected List<Pedido> pedidos = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    @JsonView(Views.Autenticado.class)
    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
    
}
