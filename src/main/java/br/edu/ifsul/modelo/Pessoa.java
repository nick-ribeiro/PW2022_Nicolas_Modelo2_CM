package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pessoa")
public class Pessoa implements Serializable{
    
    @Id
    @NotBlank(message = "O CPF não pode ser em branco")
    @Length(max = 14, message = "O CPF não pode ter mais que {max} caracteres")
    @Column(name = "cpf", length = 14, nullable = false)    
    private String cpf;
    
    @NotBlank(message = "O nome não pode ser em branco")
    @Length(max = 40, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", length = 40, nullable = false)
    private String nome;   
    
    @NotBlank(message = "O telefone não pode ser em branco")
    @Length(max = 11, message = "O telefone não pode ter mais que {max} caracteres")
    @Column(name = "telefone", length = 11, nullable = false)
    private String telefone;
    
    @Email(message = "O email deve ser informado")
    private String email;
    
    @NotBlank(message = "A senha deve ser informada")
    @Length(max = 20, message = "A senha não pode ter mais que {max} caracteres")    
    @Column(name = "senha", length = 20, nullable = false)    
    private String senha;
    
    @ManyToMany
    @JoinTable(name = "permissoes", 
            joinColumns = 
                    @JoinColumn(name = "cpf", referencedColumnName = "cpf", 
                            nullable = false), 
            inverseJoinColumns = 
                    @JoinColumn(name = "permissao", referencedColumnName = "nome", nullable = false))
    private Set<Permissao> permissoes = new HashSet<>();
    
   public Pessoa() {
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(Set<Permissao> permissoes) {
        this.permissoes = permissoes;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.cpf);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        return Objects.equals(this.cpf, other.cpf);
    } 
}
