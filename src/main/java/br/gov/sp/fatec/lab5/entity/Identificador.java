package br.gov.sp.fatec.lab5.entity;


import javax.persistence.*;

@MappedSuperclass

public abstract class Identificador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    @Override
    public String toString() {
        return "Identificador{" +
                "id=" + id +
                '}';
    }
}
