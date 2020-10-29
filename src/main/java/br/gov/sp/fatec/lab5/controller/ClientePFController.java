package br.gov.sp.fatec.lab5.controller;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.lab5.entity.Cliente;
import br.gov.sp.fatec.lab5.entity.ClientePF;
import br.gov.sp.fatec.lab5.entity.Views;
import br.gov.sp.fatec.lab5.service.ClienteService;

@CrossOrigin
@RestController
@RequestMapping("/clientesPF") 
public class ClientePFController {

    @Autowired
    private ClienteService cliservice;
    //List<Cliente> 

    @JsonView(Views.Publico.class)
    @GetMapping
    public ResponseEntity<Iterable<Cliente>> buscarTodos(){
        return ResponseEntity.ok(cliservice.findAll());
    }

    @JsonView(Views.Autenticado.class)
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarUsuarioPorId(@PathVariable Long id){
        //TODO: retornar 404 caso o id não exista
        //TODO: tratar erro caso id == null
        return ResponseEntity.ok(cliservice.buscarUsuarioPorId(id));
    }

    @JsonView(Views.Publico.class)
    @GetMapping("/nome")
    public ResponseEntity<Cliente> findByNome(@RequestParam String nome) {
        return ResponseEntity.ok(cliservice.buscarPorNome(nome));
    }

    @JsonView(Views.Autenticado.class)
    @PostMapping 
    public ResponseEntity salvar(@RequestBody ClientePF cliente) {
        cliente.setId(null);
        cliservice.save(cliente);
        //TODO: alterar para retornar a URL com id do recurso criado
        return ResponseEntity.ok(cliente);
    }

    @JsonView(Views.Autenticado.class)
    @PutMapping
    public ResponseEntity atualizar(@RequestBody ClientePF cliente){
        return ResponseEntity.accepted().body(cliservice.update(cliente));
    }
    
    @JsonView(Views.Autenticado.class)
    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id){

        // TODO: retornar 404 se o item a ser deletado não existir.
        cliservice.delete(id);
        return ResponseEntity.noContent().build();
    }
}
