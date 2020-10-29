package br.gov.sp.fatec.lab5.controller;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.lab5.entity.Usuario;
import br.gov.sp.fatec.lab5.entity.Views;
import br.gov.sp.fatec.lab5.service.UsuarioService;

@CrossOrigin
@RestController
@RequestMapping("/login") 
public class UsuarioController {
    @Autowired
    private UsuarioService usr_service;

    @JsonView(Views.Autenticado.class)
    @GetMapping
    public ResponseEntity<Iterable<Usuario>> buscarTodosUsuarios(){
        return ResponseEntity.ok(usr_service.findAll());
    }

    @JsonView(Views.Autenticado.class)
    @GetMapping("/{usuario}")
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable String usr) {

        return ResponseEntity.ok(usr_service.buscarUsuarioPorUsr(usr));
    }
}