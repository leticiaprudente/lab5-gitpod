package br.gov.sp.fatec.lab5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.gov.sp.fatec.lab5.entity.Usuario;
import br.gov.sp.fatec.lab5.exception.RegistroNaoEncontradoException;


@Service
public class UsuarioService {
    @Autowired
    private Usuario usr_repository;

    @Autowired
    private PasswordEncoder passEnconder;

    
    public Iterable<Usuario> findAll(){
        return usr_repository.findAll();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Usuario buscarUsuarioPorId(String usr) {
        Usuario cli = usr_repository.findAById(usr);
        if (usr != null) {
            return usr;
        }
        throw new RegistroNaoEncontradoException("Id não encontrado");
        // return repository.findById(id).orElse(null);
    }

    public void save(Usuario usr) {
        usr_repository.save(usr);
    }

    public void delete(String usr) {
        usr_repository.deleteById(usr);
    }

    public Usuario update(Usuario usr) {
        return usr_repository.save(usr);
    }

    @PreAuthorize("isAuthenticated()")
    public Usuario buscarPorNome(String usuario) {
        Usuario usr = usr_repository.findById(usuario);
        if (usr!= null) {
            return usr;
        }
        throw new RegistroNaoEncontradoException("Nome não encontrado");
        // return repository.findByNome(nome);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public static Usuario cadastrarUsuario(String usr, String senha) {
        return null;
    }

    public Object buscarUsuarioPorUsr(String usr) {
        Usuario usr = usr_repository.findByNome(usr);
        if(usr!= null){
            return usr;
        }throw new RegistroNaoEncontradoException("Usuario  não encontrado"); 
    }
}