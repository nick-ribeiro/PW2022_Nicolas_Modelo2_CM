package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "unidadecondominal")
public class UnidadeCondominal implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_unidadecondominal", sequenceName = "seq_unidadecondominal_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_unidadecondominal", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "O número não pode ser em branco")
    @Length(max = 10, message = "O número não pode ter mais que {max} caracteres")
    @Column(name = "numero", length = 10, nullable = false)
    private String numero;
    
    @Column(name = "descricao", columnDefinition = "text")
    private String descricao;
    
    @Min(value = 0, message = "A área não pode ser negativa")
    @Column(name = "area", nullable = false)
    @NotNull(message = "A área deve ser informada")
    private Double area;
    
    @Min(value = 0, message = "O número do quarto não pode ser negativo")
    @Column(name = "numeroQuarto", nullable = false)
    @NotNull(message = "O número do quarto deve ser informado")
    private Integer numeroQuarto;
    
    @NotNull(message = "O condominio deve ser informado")
    @ManyToOne
    @JoinColumn(name = "condominio", referencedColumnName = "id", nullable = false)
    private Condominio condominio;
    
    @NotNull(message = "A pessoa deve ser informada")
    @ManyToOne
    @JoinColumn(name = "pessoa", referencedColumnName = "cpf", nullable = false)
    private Pessoa pessoa;
    
    public UnidadeCondominal() {
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final UnidadeCondominal other = (UnidadeCondominal) obj;
        return Objects.equals(this.id, other.id);
    }
}
