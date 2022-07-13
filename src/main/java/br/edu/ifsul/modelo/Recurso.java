package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "recurso")
public class Recurso implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_recurso", sequenceName = "seq_recurso_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_recurso", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "A descrição deve ser informado")
    @Length(max = 30, message = "A descrição não pode ter mais que {max} caracteres")
    @Column(name = "descricao", length = 30, nullable = false)
    private String descricao;
    
    @ManyToMany
    @JoinTable(name = "recurso_condominio",
            joinColumns = 
                    @JoinColumn(name = "recurso", referencedColumnName = "id", 
                            nullable = false),
            inverseJoinColumns = 
                    @JoinColumn(name = "condominio", referencedColumnName = "id", 
                            nullable = false)
            )            
    private List<Condominio> condominios = new ArrayList<>();

    public Recurso() {
        
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Condominio> getCondominios() {
        return condominios;
    }

    public void setCondominios(List<Condominio> condominios) {
        this.condominios = condominios;
    }
}
