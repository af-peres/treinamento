package br.edu.ifpr.treinamento.aplicacao.processors;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.edu.ifpr.treinamento.modelo.Aluno;
import br.edu.ifpr.treinamento.modelo.Curso;
import br.edu.ifpr.treinamento.modelo.Matricula;
import br.edu.ifpr.treinamento.modelo.service.JpaService;
import br.edu.ifpr.treinamento.modelo.service.command.JpaPersistenceDAOType;
import br.edu.ifpr.treinamento.modelo.service.command.impl.AlunoPersistenceDAO;
import br.edu.ifpr.treinamento.modelo.service.command.impl.CursoPersistenceDAO;
import br.edu.ifpr.treinamento.modelo.service.command.impl.InstrutorPersistenceDAO;
import br.edu.ifpr.treinamento.modelo.service.command.impl.MatriculaPersistenceDAO;
import br.edu.ifpr.utils.date.DateTimeUtils;

public class MatriculaProcessor {
    
    private JpaService               js  = null;
    private MatriculaPersistenceDAO  psm = null;
    private CursoPersistenceDAO      psc = null;
    private AlunoPersistenceDAO      psa = null;
    private InstrutorPersistenceDAO  psi = null;
    
    public MatriculaProcessor(JpaService js) {
        this.js = js;
        this.psm = (MatriculaPersistenceDAO)
                  this.js.persistenceCommandFactory(JpaPersistenceDAOType.MATRICULA);
        this.psc = (CursoPersistenceDAO)
                   this.js.persistenceCommandFactory(JpaPersistenceDAOType.CURSO);
        
        this.psa = (AlunoPersistenceDAO)
                   this.js.persistenceCommandFactory(JpaPersistenceDAOType.ALUNO);
        
        this.psi = (InstrutorPersistenceDAO)
                   this.js.persistenceCommandFactory(JpaPersistenceDAOType.INSTRUTOR);
        
    }
    
    
    private void print(Matricula dado) {
        if (dado != null)System.out.println(dado);
        else System.out.println("MATRICULA NÃO EXISTENTE");
    }
    
    
    private void print(List<Matricula> dados) {
        System.out.println("TOTAL ["+ dados.size()+"]");
        
        for(Matricula dado: dados) {
            print(dado);
        }
    }
    
    
    private void populate(List<Matricula> dados) {
        //Preencher a cole��o dados
        //com, pelo menos 5 objetos
        //dados.add()
        
           List<Curso> curso = new ArrayList<>(psc.select());
           List<Aluno> aluno = new ArrayList<>(psa.select());
           
           Matricula dado = new Matricula(curso.get(1), aluno.get(5), DateTimeUtils.getDate(1995,5,16));
           dados.add(dado);
           
           dado = new Matricula(curso.get(1), aluno.get(6), DateTimeUtils.getDate(2007,5,9));
           dados.add(dado);
           
           dado = new Matricula(curso.get(2), aluno.get(4), DateTimeUtils.getDate(2017,11,21));
           dados.add(dado);
           
           dado = new Matricula(curso.get(3), aluno.get(3), DateTimeUtils.getDate(2011,4,2));
           dados.add(dado);
           
           dado = new Matricula(curso.get(4), aluno.get(7), DateTimeUtils.getDate(2014,8,10));
           dados.add(dado);

        
    }
    
    
    private int insert() {
        List<Matricula> dados = new ArrayList<>();
        populate(dados);
        
        int regs = 0;
        
        for(Matricula dado: dados) {
            regs += psm.insert(dado);//Ser� Modificado
        }
        return regs;
    }
    
    
    private void processInsert(boolean varios) {
        if(varios) {
            System.out.println("INCLUÍDOS ["+ insert()+"]");
            return;
        }
        
            List<Curso> curso = new ArrayList<>(psc.select());
            List<Aluno> aluno = new ArrayList<>(psa.select());
           
           Matricula dado = new Matricula(curso.get(4), aluno.get(1), DateTimeUtils.getDate(2017,5,23));
           
           int ret = psm.insert(dado);
           System.out.println("==> INCLUÍDO [" + ret + "] <==");

        
        
    }
    
    
    private void processUpdate(String valorBusca) {
        Matricula dado = psm.select(valorBusca);
        int res = 0;
        
        if(dado != null) {
            dado.setDataMatricula(new Date(10/04/2018));
            res = psm.update(dado);
        }
        if(res == 1) {
            System.out.println("ALTERADO ["+valorBusca+"]");
        }
        else
            System.out.println("["+valorBusca+"] NÃO ENCONTRADO");
    }
    
    
    private void processDelete(String valorBusca) {
        int deleted = psm.delete(valorBusca);
        
        if(deleted == 1) 
            System.out.println("EXCLUÍDO ["+valorBusca+"]");
        else
            System.out.println("["+valorBusca+"] NÃO ENCONTRADO]");
    }
    
    
    private void processDelete() {
        System.out.println("EXCLUÍDO ["+ psm.delete() +"]");
    }
    
    
    private void processSelect() {
        processSelect(null);
    }
    
    
    private void processSelect(String valorBusca) {
        if(valorBusca == null) {
            List<Matricula> dados = new ArrayList<>(psm.select());
            print(dados);
        }
        else print(psm.select(valorBusca));
    }
    
    public void processMatriculas() {
          System.out.println("\n\n\n### PROCESSANDO MATRICULAS : INÍCIO ###");
     
          System.out.println("\n===> EXCLUIR MATRICULAS <===");
          processDelete();
     
          System.out.println("\n===> INCLUIR MATRICULAS <===");
          processInsert(true);
     
          System.out.println("\n===> BUSCAR MATRICULAS <===");
          processSelect();
     
          System.out.println("\n===> EXCLUIR MATRICULAS <===");
          processDelete();
     
          System.out.println("\n===> BUSCAR MATRICULAS <===");
          processSelect();
     
          System.out.println("\n===> INCLUIR MATRICULAS <===");
          processInsert(true);
     
          System.out.println("\n===> BUSCAR MATRICULAS <===");
          processSelect();
     
          System.out.println("\n===> INCLUIR MATRICULAS <===");
          processInsert(false);
     
          System.out.println("\n===> BUSCAR MATRICULAS <===");
          processSelect();
     
          String cpf = "75865989162";
          System.out.println("\n===> BUSCAR MATRICULA EXISTENTE [" + cpf + "] <===");
          processSelect(cpf);
     
          cpf = "12345678909";
          System.out.println("\n===> BUSCAR MATRICULA NÃO EXISTENTE [" + cpf + "] <===");
          processSelect(cpf);
     
          cpf = "75865989162";
          System.out.println("\n===> ALTERAR MATRICULA EXISTENTE [" + cpf + "] <===");
          processUpdate(cpf);
     
          cpf = "12345678909";
          System.out.println("\n===> ALTERAR MATRICULA NÃO EXISTENTE [" + cpf + "] <===");
          processUpdate(cpf);
     
          System.out.println("\n===> BUSCAR MATRICULA <===");
          processSelect();
     
          cpf = "12345678909";
          System.out.println("\n===> EXCLUIR MATRICULA NÃO EXISTENTE [" + cpf + "] <===");
          processDelete(cpf);
     
          cpf = "75865989162";
          System.out.println("\n===> EXCLUIR MATRICULA EXISTENTE [" + cpf + "] <===");
          processDelete(cpf);
     
          System.out.println("\n===> BUSCAR MATRICULA <===");
          processSelect();
     
          System.out.println("\n===> EXCLUIR MATRICULA <===");
          processDelete();
     
          System.out.println("\n===> INCLUIR MATRICULA <===");
          processInsert(true);
     
          System.out.println("\n===> BUSCAR MATRICULA <===");
          processSelect();
     
          System.out.println("\n### PROCESSANDO MATRICULA : FIM ###\n");
    }

}
