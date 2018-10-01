package br.edu.ifpr.treinamento.modelo.service.command.impl;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

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
    @Override
    public int insert(Modulo t)
    {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public int update(Modulo t)
    {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public int delete(String key)
    {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public int delete()
    {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public Modulo select(String key)
    {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public Collection<Modulo> select()
    {
        // TODO Auto-generated method stub
        return null;
    }
}
