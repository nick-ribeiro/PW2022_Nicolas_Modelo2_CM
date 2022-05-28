package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Condominio;
import br.edu.ifsul.modelo.Recurso;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirCondominioRecurso {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Modelo2-ModelPU");
        EntityManager em = emf.createEntityManager();
        Condominio c = em.find(Condominio.class, 7);
        Recurso r = em.find(Recurso.class, 7);
        Condominio c2 = em.find(Condominio.class, 8);
        Recurso r2 = em.find(Recurso.class, 8);
        c.getRecurso().add(r);
        c2.getRecurso().add(r2);
        em.getTransaction().begin();
        em.persist(r);
        em.persist(r2);
        em.getTransaction().commit();
        em.close();
        emf.close();   
    }
}
