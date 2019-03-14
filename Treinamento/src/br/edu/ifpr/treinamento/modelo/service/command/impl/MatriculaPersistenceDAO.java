package br.edu.ifpr.treinamento.modelo.service.command.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.edu.ifpr.treinamento.modelo.Matricula;
import br.edu.ifpr.treinamento.modelo.service.command.JpaPersistenceDAO;
import br.edu.ifpr.utils.formatter.CpfFormatter;

public class MatriculaPersistenceDAO implements JpaPersistenceDAO<String, Matricula>
{
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public MatriculaPersistenceDAO(EntityManagerFactory emf)
    {
        this.emf = emf;
    }
    public void createEntityManager() {em = emf.createEntityManager();}
    public void closeEM() {em.close();}
    private Matricula get(String namedQuery, String atributo, Object valorBusca) {
        TypedQuery<Matricula> query = em.createNamedQuery(namedQuery, Matricula.class);
        Matricula             dado  = null;
        
        query.setParameter(atributo, valorBusca);
        try {dado = query.getSingleResult();}
        catch(NoResultException ex) {/*retornara 'null' */}
        
        return dado;
    }

     @Override
        public int insert(Matricula t) {
          createEntityManager();
     
          EntityTransaction et   = em.getTransaction();
          int               regs = 1;
     
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
        public int update(Matricula t) {
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
     
          Matricula dado = get("Matricula.findByCpf","cpf",CpfFormatter.formatCpf(key));
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
     
          TypedQuery<Matricula> query = em.createNamedQuery("Matricula.findAll",
                                                            Matricula.class);
          List<Matricula>       dados = query.getResultList();
     
          em.getTransaction().begin();
          int regs = 0;
          for (Matricula dado : dados) {
             em.remove(dado);
             ++regs;
          }
          em.getTransaction().commit();
     
          closeEM();
     
          return regs;
        }
     
        @Override
        public Matricula select(String key) {
          createEntityManager();
     
          Matricula dado = get("Matricula.findByCpf","cpf",CpfFormatter.formatCpf(key));
     
          closeEM();
     
          return dado;
        }
     
        @Override
        public Collection<Matricula> select() {
          createEntityManager();
     
          TypedQuery<Matricula> query = em.createNamedQuery("Matricula.findAll",
                                                                       Matricula.class);
          List<Matricula> dados = query.getResultList();
     
          closeEM();
     
          return dados;
        }
}
