package br.gov.sp.fatec.lab5.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.UserDetailsServiceConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.lab5.entity.Role;
import br.gov.sp.fatec.lab5.entity.Usuario;
import br.gov.sp.fatec.lab5.exception.RegistroNaoEncontradoException;
import br.gov.sp.fatec.lab5.repository.RoleRepository;
import br.gov.sp.fatec.lab5.repository.UsuarioRepository;


@Service
public class UsuarioService extends UserDetailsService{
    @Autowired
    private UsuarioRepository usr_repository;

    @Autowired
    private PasswordEncoder pass_Enconder;

	@Autowired
	private RoleRepository role_repository;

    
    public Iterable<Usuario> findAll(){
        return usr_repository.findAll();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Usuario buscarUsuarioPorId(String id) {
        Usuario usr = usr_repository.findAById(id);
        if (usr != null) {
            return usr;
        }
        throw new RegistroNaoEncontradoException("Id não encontrado");
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
    public Usuario criarUsuario(String usuario, String senha, String role){
        Role nome_role = role_repository.findByNome(role);
        if(nome_role == null){
            nome_role = new Role();
            nome_role.setRole(role);
            role_repository.save(nome_role);
        }
        Usuario novoUsr = new Usuario();
        novoUsr.setUsuario(usuario);
        novoUsr.setSenha(pass_Enconder.encode(senha));
        novoUsr.setRoles(new HashSet<Role>());
        novoUsr.getRoles().add(nome_role);
        return novoUsr;
    }
    


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public static Usuario cadastrarUsuario(String usr, String senha) {
        return null;
    }


}