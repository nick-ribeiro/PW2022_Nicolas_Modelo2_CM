package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "aluguel")
public class Aluguel implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_aluguel", sequenceName = "seq_aluguel_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_aluguel", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Min(value = 0, message = "O valor não pode ser negativo")
    @Column(name = "valor", nullable = false)
    @NotNull(message = "O valor deve ser informado")
    private Double valor;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data do inicio do contrato deve ser informada")
    @Column(name = "inicioContrato", nullable = false)
    private Calendar inicioContrato;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data do fim do contrato deve ser informada")
    @Column(name = "fimContrato", nullable = false)
    private Calendar fimContrato;
    
    @Min(value = 0, message = "O dia do vencimento não pode ser negativo")
    @Column(name = "diaVencimento", nullable = false)
    @NotNull(message = "O dia do venciomento deve ser informado")
    private Integer diaVencimento;
    
    @NotNull(message = "A unidade condominal deve ser informada")
    @ManyToOne
    @JoinColumn(name = "unidadecondominal", referencedColumnName = "id", nullable = false)
    private UnidadeCondominal unidadeCondominal;
    
    @OneToMany(mappedBy = "aluguel", cascade = CascadeType.ALL, 
            orphanRemoval = true, fetch = FetchType.LAZY)
    List<Mensalidades> mensalidades = new ArrayList<>();
    
    public Aluguel() {
        
    }
    
    public void adicionarMensalidades(Mensalidades obj) {
        obj.setAluguel(this);
        this.getMensalidades().add(obj);
    }
    
    public void removerMensalidades(int index) {
        this.mensalidades.remove(index);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Calendar getInicioContrato() {
        return inicioContrato;
    }

    public void setInicioContrato(Calendar inicioContrato) {
        this.inicioContrato = inicioContrato;
    }

    public Calendar getFimContrato() {
        return fimContrato;
    }

    public void setFimContrato(Calendar fimContrato) {
        this.fimContrato = fimContrato;
    }

    public Integer getDiaVencimento() {
        return diaVencimento;
    }

    public void setDiaVencimento(Integer diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    public UnidadeCondominal getUnidadeCondominal() {
        return unidadeCondominal;
    }

    public void setUnidadeCondominal(UnidadeCondominal unidadeCondominal) {
        this.unidadeCondominal = unidadeCondominal;
    }

    public List<Mensalidades> getMensalidades() {
        return mensalidades;
    }

    public void setMensalidades(List<Mensalidades> mensalidades) {
        this.mensalidades = mensalidades;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final Aluguel other = (Aluguel) obj;
        return Objects.equals(this.id, other.id);
    }
}
