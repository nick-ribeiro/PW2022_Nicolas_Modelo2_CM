package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Locatario;
import br.edu.ifsul.modelo.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirLocatario {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Modelo2-ModelPU");
        EntityManager em = emf.createEntityManager();
        Locatario l = new Locatario();
        Pessoa p = em.find(Pessoa.class, 9);
        l.setNome("Joao Silva");
        l.setCpf("12345678910");
        l.setTelefone("55991021123");
        l.setEmail("joaosilva@gmail.com");
        l.setRenda(10000.0);
        l.setLocalTrabalho("R. Teixeira Soares - Centro");
        l.setTelefoneTrabalho("5599102234");      
        Locatario l2 = new Locatario();
        Pessoa p2 = em.find(Pessoa.class, 10);
        l2.setNome("Luana Souza");
        l2.setCpf("98765432109");
        l2.setTelefone("54997076843");
        l2.setEmail("luanasouza@gmail.com");
        l2.setRenda(15000.0);
        l2.setLocalTrabalho("Av. Brasil Oeste - Boqueirão");
        l2.setTelefoneTrabalho("5431092211"); 
        em.getTransaction().begin();
        em.persist(l);
        em.persist(l2);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
