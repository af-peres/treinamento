package br.edu.ifpr.treinamento.modelo.service.command.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.edu.ifpr.treinamento.modelo.Modulo;
import br.edu.ifpr.treinamento.modelo.service.command.JpaPersistenceDAO;

public class ModuloPersistenceDAO implements JpaPersistenceDAO<String, Modulo>
{
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public ModuloPersistenceDAO(EntityManagerFactory emf)
    {
        this.emf = emf;
    }
    public void createEntityManager() {em = emf.createEntityManager();}
    public void closeEM() {em.close();}
    private Modulo get(String namedQuery, String atributo, Object valorBusca) {
        TypedQuery<Modulo> query = em.createNamedQuery(namedQuery, Modulo.class);
        Modulo dado = null;
        
        query.setParameter(atributo, valorBusca);
        try { dado = query.getSingleResult(); }
        catch (NoResultException ex) { /* retornará 'null' */ }
        
        return dado;
    }

    @Override
    public int insert(Modulo t) {
        
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
    public int update(Modulo t) {
        
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

          Modulo dado = get("Modulo.findByNome","nome",key);
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

          TypedQuery<Modulo> query = em.createNamedQuery("Modulo.findAll",
                                                        Modulo.class);
          List<Modulo>       dados = query.getResultList();

          em.getTransaction().begin();
          int regs = 0;
          for (Modulo dado : dados) {
             em.remove(dado);
             ++regs;
          }
          em.getTransaction().commit();

          closeEM();

          return regs;
        
    }

    @Override
    public Modulo select(String key) {
        
        createEntityManager();

          Modulo dado = get("Modulo.findByNome","nome",key);

          closeEM();

          return dado;
        
    }

    @Override
    public Collection<Modulo> select() {
        
        createEntityManager();

          TypedQuery<Modulo> query = em.createNamedQuery("Modulo.findAll",
                                                        Modulo.class);
          List<Modulo> dados = query.getResultList();

          closeEM();

          return dados;
        
    }

}
