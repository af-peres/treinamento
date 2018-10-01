package br.edu.ifpr.treinamento.modelo.service.command.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.edu.ifpr.treinamento.modelo.Aluno;
import br.edu.ifpr.treinamento.modelo.service.command.JpaPersistenceDAO;

public class AlunoPersistenceDAO implements JpaPersistenceDAO<String, Aluno>
{
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public AlunoPersistenceDAO(EntityManagerFactory emf)
    {
        this.emf = emf;
    }
    public void createEntityManager() {em = emf.createEntityManager();}
    public void closeEntityManager() {em.close();}
    
    private Aluno get(String nameQuery, String atributo, Object valorBusca)
    {
        TypedQuery<Aluno> query = em.createNamedQuery(nameQuery,Aluno.class);
        Aluno dado = null;
        
        query.setParameter(atributo, valorBusca);
        try {dado=query.getSingleResult();}
        catch(NoResultException ex){/*retornara null*/}
        
        return dado;
    }
    
    @Override
    public int insert(Aluno t) {
      createEntityManager();
 
      EntityTransaction et   = em.getTransaction();
      int               regs = 1; // assume que persist() executará com sucesso
 
      try {
         et.begin();
         em.persist(t);
         et.commit();
      }
      // exceção lançada em caso de chave primária (PK) duplicada
      catch (EntityExistsException ex) { regs = 0; }
      finally {
         if (et.isActive())
            et.rollback();
      }
      closeEntityManager();
 
      return regs;
    }
 
    @Override
    public int update(Aluno t) {
      int regs = 0;
 
      createEntityManager();
 
      em.getTransaction().begin();
      em.merge(t);
      em.getTransaction().commit();
 
      regs = 1;
      closeEntityManager();
 
      return regs;
    }
 
    @Override
    public int delete(String key) {
      int regs = 0;
 
      createEntityManager();
 
      Aluno dado = get("Aluno.findByCpf","cpf",key);
      if (dado != null) {
         em.getTransaction().begin();
         em.remove(dado);
         em.getTransaction().commit();
 
         regs = 1;
      }
      closeEntityManager();
 
      return regs;
    }
 
    @Override
    public int delete() {
      createEntityManager();
 
      TypedQuery<Aluno> query = em.createNamedQuery("Aluno.findAll",
                                                    Aluno.class);
      List<Aluno>       dados = query.getResultList();
 
      em.getTransaction().begin();
      int regs = 0;
      for (Aluno dado : dados) {
         em.remove(dado);
         ++regs;
      }
      em.getTransaction().commit();
 
      closeEntityManager();
 
      return regs;
    }
 
    @Override
    public Aluno select(String key) {
      createEntityManager();
 
      Aluno dado = get("Aluno.findByCpf","cpf",key);
 
      closeEntityManager();
 
      return dado;
    }
 
    @Override
    public Collection<Aluno> select() {
      createEntityManager();
 
      TypedQuery<Aluno> query = em.createNamedQuery("Aluno.findAll",
                                                    Aluno.class);
      List<Aluno> dados = query.getResultList();
 
      closeEntityManager();
 
      return dados;
    }
}
