package br.gov.sp.fatec.lab5.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ite_item")
@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "ite_id"))
public class Item extends Identificador {

    private String nome;
    private Double preco;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "for_id")
    private Fornecedor fornecedor;

    public Item(String string, double d, Fornecedor object) {
        this.nome=string;
        this.preco=d;
        this.fornecedor=object;
	}

	@Override
    public String toString() {
        return "Item{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", id=" + id +
                '}';
    }

    public Double getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }
}
