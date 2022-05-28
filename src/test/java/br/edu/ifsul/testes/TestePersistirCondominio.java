package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Condominio;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirCondominio {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Modelo2-ModelPU");
        EntityManager em = emf.createEntityManager();
        Condominio c = new Condominio();
        c.setNome("Marcos Silva");
        c.setEndereco("R. Gen. Osório - Centro");
        c.setNumero("1065");
        c.setCep("99010140");
        Condominio c2 = new Condominio();
        c2.setNome("Renan Gomes");
        c2.setEndereco("Rua Bento Gonçalves - Centro");
        c2.setNumero("87");
        c2.setCep("99010010");
        em.getTransaction().begin();
        em.persist(c);
        em.persist(c2);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
