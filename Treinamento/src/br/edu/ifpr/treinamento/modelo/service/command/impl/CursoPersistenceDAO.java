package br.edu.ifpr.treinamento.modelo.service.command.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.edu.ifpr.treinamento.modelo.Curso;
import br.edu.ifpr.treinamento.modelo.service.command.JpaPersistenceDAO;

public class CursoPersistenceDAO implements JpaPersistenceDAO<String, Curso>
{
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public CursoPersistenceDAO(EntityManagerFactory emf)
    {
        this.emf = emf;
    }
    public void createEntityManager() {em = emf.createEntityManager();}
    public void closeEM() {em.close();}
    
private Curso get(String namedQuery, String atributo, Object valorBusca) {
        
        TypedQuery<Curso> query = em.createNamedQuery(namedQuery, Curso.class);
        Curso             dado  = null;
        
        query.setParameter(atributo, valorBusca);
        try {dado = query.getSingleResult();}
        catch(NoResultException ex) {/*retornara 'null' */}
        
        return dado;
    }

     @Override
        public int insert(Curso t) {
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
          closeEM();
     
          return regs;
        }
     
        @Override
        public int update(Curso t) {
          int regs = 0;
     
          createEntityManager();
     
          em.getTransaction().begin();
          em.merge(t);
          em.getTransaction().commit();
     
          regs = 1;
          closeEM();
     
          return regs;
        }
     
        @Override
        public int delete(String key) {
          int regs = 0;
     
          createEntityManager();
     
          Curso dado = get("Curso.findByCodigo","codigo",key);
          if (dado != null) {
             em.getTransaction().begin();
             em.remove(dado);
             em.getTransaction().commit();
     
             regs = 1;
          }
          closeEM();
     
          return regs;
        }
     
        @Override
        public int delete() {
          createEntityManager();
     
          TypedQuery<Curso> query = em.createNamedQuery("Curso.findAll",
                                                        Curso.class);
          List<Curso>       dados = query.getResultList();
     
          em.getTransaction().begin();
          int regs = 0;
          for (Curso dado : dados) {
             em.remove(dado);
             ++regs;
          }
          em.getTransaction().commit();
     
          closeEM();
     
          return regs;
        }
     
        @Override
        public Curso select(String key) {
          createEntityManager();
     
          Curso dado = get("Curso.findByCodigo","codigo",key);
     
          closeEM();
     
          return dado;
        }
     
        @Override
        public Collection<Curso> select() {
          createEntityManager();
     
          TypedQuery<Curso> query = em.createNamedQuery("Curso.findAll",
                                                        Curso.class);
          List<Curso> dados = query.getResultList();
     
          closeEM();
     
          return dados;
        }

}
