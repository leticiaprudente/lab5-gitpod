package br.gov.sp.fatec.lab5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.lab5.entity.Cliente;
import br.gov.sp.fatec.lab5.entity.ClientePF;
import br.gov.sp.fatec.lab5.exception.RegistroNaoEncontradoException;
import br.gov.sp.fatec.lab5.repository.ClienteRepository;
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Iterable<Cliente> findAll(){
        return repository.findAll();
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Cliente buscarUsuarioPorId(Long id){
        Cliente cli = repository.findAById(id);
        if(cli!= null){
            return cli;
        }throw new RegistroNaoEncontradoException("Id de usuário não encontrado"); 
        //return repository.findById(id).orElse(null);
    }


    public void save(Cliente cliente){
        repository.save(cliente);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Cliente update(Cliente cliente) {
        return repository.save(cliente);
    }
    @PreAuthorize("isAuthenticated()")
    public Cliente buscarPorNome(String nome) {
        Cliente cli = repository.findByNome(nome);
        if(cli!= null){
            return cli;
        }throw new RegistroNaoEncontradoException("Nome não encontrado"); 
        //return repository.findByNome(nome);
    }

    public static ClientePF cadastrarClientePF(String nome, String cpf, String endereco) {
        return null;
    }
}