package br.edu.ifpr.treinamento.modelo.service.command.impl;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

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
    @Override
    public int insert(Curso t)
    {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public int update(Curso t)
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
    public Curso select(String key)
    {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public Collection<Curso> select()
    {
        // TODO Auto-generated method stub
        return null;
    }

}
