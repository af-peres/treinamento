package br.edu.ifpr.treinamento.modelo.service;

//TODO ARRUMAR
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.ifpr.treinamento.modelo.service.command.JpaPersistenceDAO;
import br.edu.ifpr.treinamento.modelo.service.command.JpaPersistenceDAOType;
import br.edu.ifpr.treinamento.modelo.service.command.impl.AlunoPersistenceDAO;
import br.edu.ifpr.treinamento.modelo.service.command.impl.CursoPersistenceDAO;
import br.edu.ifpr.treinamento.modelo.service.command.impl.InstrutorPersistenceDAO;
import br.edu.ifpr.treinamento.modelo.service.command.impl.MatriculaPersistenceDAO;
import br.edu.ifpr.treinamento.modelo.service.command.impl.ModuloPersistenceDAO;

public class JpaService
{
    public static final String PERSISTENCE_UNITNAME = "treinamento";
    private EntityManagerFactory emf = null;
    
    public void createEntityManagerFactory()
    {
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNITNAME);
        
    }
    
    public void closeEntityManagerFactory()
    {
        if(emf!=null)
            emf.close();
    }
    
    public JpaPersistenceDAO persistenceCommandFactory(JpaPersistenceDAOType tipo)
    {
        switch(tipo)
        {
        case ALUNO: return new AlunoPersistenceDAO(emf);
        case INSTRUTOR: return new InstrutorPersistenceDAO(emf);
        case MODULO: return new ModuloPersistenceDAO(emf);
        case CURSO: return new CursoPersistenceDAO(emf);
        case MATRICULA: return new MatriculaPersistenceDAO(emf);
        }
        return null;
    }
}