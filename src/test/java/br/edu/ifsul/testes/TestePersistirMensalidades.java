package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Aluguel;
import br.edu.ifsul.modelo.Mensalidades;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirMensalidades {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Modelo2-ModelPU");
        EntityManager em = emf.createEntityManager();
        Mensalidades m = new Mensalidades();
        Aluguel a = em.find(Aluguel.class, 2);
        m.setValor(2500.0);
        m.setVencimento(Calendar.getInstance());
        m.setValorPagamento(2500.0);
        
        Date dPag = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dPag);
        cal.add(Calendar.DATE, 30);
        m.setDataPagamento(cal);
        a.adicionarMensalidades(m);
        Mensalidades m2 = new Mensalidades();
        Aluguel a2 = em.find(Aluguel.class, 3);
        m2.setValor(1100.0);
        m2.setVencimento(Calendar.getInstance());
        m2.setValorPagamento(1100.0);
        m2.setDataPagamento(cal);
        a2.adicionarMensalidades(m2);
        em.getTransaction().begin();
        em.persist(m);
        em.persist(m2);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
