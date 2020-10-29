package br.gov.sp.fatec.lab5.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usr_usuario")
public class Usuario {

    @Id
    private String usuario;
    @Column
    private String senha;

    @ManyToMany
    @JoinTable(name = "usr_has_roles",
            joinColumns =
                {@JoinColumn(name = "usuario", referencedColumnName = "usuario")},
            inverseJoinColumns = {@JoinColumn(name = "role_name", referencedColumnName = "role_name")})
    private Set<Role> roles = new HashSet<>();

    public boolean addRole(Role role){
        return roles.add(role);
    }

    public boolean hasHole(String string){
        Object[] array = roles.toArray();
        for(Object role : array){
            Role temp = (Role) role;
            if (temp.getRole().equals(string)){
                return true;
            }
        }
        return false;
    }

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String nome) {
		this.usuario=nome;
		
	}


}
