package br.gov.sp.fatec.lab5.repository;

import br.gov.sp.fatec.lab5.entity.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
