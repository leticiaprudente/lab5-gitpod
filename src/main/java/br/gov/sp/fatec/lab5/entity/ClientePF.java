package br.gov.sp.fatec.lab5.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue(value = "pf")
public class ClientePF extends Cliente {

    @Column(name = "cpf", length = 14)
    private String cpf;


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
