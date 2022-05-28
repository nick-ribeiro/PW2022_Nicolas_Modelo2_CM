package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "locatario")
public class Locatario extends Pessoa implements Serializable{
    
    @Min(value = 0, message = "A renda não pode ser negativa")
    @Column(name = "renda", nullable = false)
    @NotNull(message = "A renda deve ser informada")
    private Double renda;
    
    @NotBlank(message = "O local de trabalho não pode ser em branco")
    @Length(max = 50, message = "O local de trabalho não pode ter mais que {max} caracteres")
    @Column(name = "localTrabalho", length = 50, nullable = false)
    private String localTrabalho;
    
    @NotBlank(message = "O telefone do trabalho não pode ser em branco")
    @Length(max = 11, message = "O telefone do trabalho não pode ter mais que {max} caracteres")
    @Column(name = "telefoneTrabalho", length = 11, nullable = false)
    private String telefoneTrabalho;
    
    public Locatario() {
        
    }

    public Double getRenda() {
        return renda;
    }

    public void setRenda(Double renda) {
        this.renda = renda;
    }

    public String getLocalTrabalho() {
        return localTrabalho;
    }

    public void setLocalTrabalho(String localTrabalho) {
        this.localTrabalho = localTrabalho;
    }

    public String getTelefoneTrabalho() {
        return telefoneTrabalho;
    }

    public void setTelefoneTrabalho(String telefoneTrabalho) {
        this.telefoneTrabalho = telefoneTrabalho;
    }
}
