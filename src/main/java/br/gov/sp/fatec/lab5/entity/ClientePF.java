package br.gov.sp.fatec.lab5.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "pf")
public class ClientePF extends Cliente {

    @Column(name = "cpf", length = 14)
    private String cpf;

    public ClientePF(){
    }

	public ClientePF(String string) {
        this.cpf=string;
    }

    @Override
    public String toString() {
        return "ClientePF{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", id=" + id +
                '}';
    }

    public void setNome(String string) {
        this.nome=string;
    }

    public void setEndereco(String end){
        this.endereco=end;
    }
}
