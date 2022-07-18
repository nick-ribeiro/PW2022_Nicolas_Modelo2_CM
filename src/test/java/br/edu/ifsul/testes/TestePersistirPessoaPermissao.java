package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Permissao;
import br.edu.ifsul.modelo.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirPessoaPermissao {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Modelo2-ModelPU");
        EntityManager em = emf.createEntityManager();
        Pessoa p = em.find(Pessoa.class, "123-456-789.10");
        Permissao per = em.find(Permissao.class, "ZELADOR");
        p.getPermissoes().add(per);
        Pessoa p2 = em.find(Pessoa.class, "987-654-321.09");
        Permissao per2 = em.find(Permissao.class, "SINDICO");
        Permissao per3 = em.find(Permissao.class, "MORADOR");
        p2.getPermissoes().add(per2);
        p2.getPermissoes().add(per3);
        em.getTransaction().begin();
        em.persist(p);
        em.persist(p2);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
