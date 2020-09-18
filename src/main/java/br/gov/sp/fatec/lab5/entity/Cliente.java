package br.gov.sp.fatec.lab5.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
@Entity
@Table(name = "cli_cliente")

@AttributeOverride(name = "id", column = @Column(name = "cli_id"))
public abstract class Cliente extends Identificador {

    protected String nome;
    protected String endereco;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
    protected List<Pedido> pedidos = new ArrayList<>();
}
