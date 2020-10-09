package br.gov.sp.fatec.lab5.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "for_fornecedor")

@AttributeOverride(name = "id", column = @Column(name = "for_id"))
public class Fornecedor extends Identificador {

    private String nome;
    private String cnpj;

    @OneToMany(mappedBy = "fornecedor", fetch = FetchType.LAZY)
    private List<Item> items = new ArrayList<>();

    @Override
    public String toString() {
        return "Fornecedor{" +
                "nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", items=" + items +
                ", id=" + id +
                '}';
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    
    
}
