package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirPessoa {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Modelo2-ModelPU");
        EntityManager em = emf.createEntityManager();
        Pessoa p = new Pessoa();
        p.setNome("Joao Silva");
        p.setCpf("123-456-789.10");
        p.setEmail("joaosilva@gmail.com");
        p.setTelefone("55991021123");
        Pessoa p2 = new Pessoa();
        p2.setNome("Luana Souza");
        p2.setCpf("987-654-321.09");
        p2.setEmail("luanasouza@gmail.com");
        p2.setTelefone("54997076843");
        em.getTransaction().begin();
        em.persist(p);
        em.persist(p2);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
