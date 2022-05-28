package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Aluguel;
import br.edu.ifsul.modelo.UnidadeCondominal;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirAluguel {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Modelo2-ModelPU");
        EntityManager em = emf.createEntityManager();
        Aluguel a = new Aluguel();
        UnidadeCondominal uc = em.find(UnidadeCondominal.class, 1);
        a.setValor(2500.0);
        a.setInicioContrato(Calendar.getInstance());
 
        Date dPag = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dPag);
        cal.add(Calendar.DATE, 30);
        a.setFimContrato(cal);
        a.setDiaVencimento(28);
        a.setUnidadeCondominal(uc);
        Aluguel a2 = new Aluguel();
        UnidadeCondominal uc2 = em.find(UnidadeCondominal.class, 2);
        a2.setValor(1100.0);
        a2.setInicioContrato(Calendar.getInstance());
        a2.setFimContrato(cal);
        a2.setDiaVencimento(28);
        a2.setUnidadeCondominal(uc2);
        em.getTransaction().begin();
        em.persist(a);
        em.persist(a2);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
