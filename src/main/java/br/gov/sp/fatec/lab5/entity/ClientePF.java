package br.gov.sp.fatec.lab5.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@DiscriminatorValue(value = "pf")
public class ClientePF extends Cliente {
    @JsonView(Views.Autenticado.class)
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
    public String getNome(){
        return nome;
    }
    public void setEndereco(String end){
        this.endereco=end;
    }

    public String getEndereco(){
        return endereco;
    }

    public void setId(Long id) {
        this.id=id;
    }

    public Long getId() {
        return id;
    }
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
