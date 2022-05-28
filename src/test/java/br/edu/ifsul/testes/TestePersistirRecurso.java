package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Recurso;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirRecurso {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Modelo2-ModelPU");
        EntityManager em = emf.createEntityManager();
        Recurso r = new Recurso();
        r.setDescricao("Multa Condominal - PJ");
        Recurso r2 = new Recurso();
        r2.setDescricao("Multa Condominal - PF");
        em.getTransaction().begin();
        em.persist(r);
        em.persist(r2);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
