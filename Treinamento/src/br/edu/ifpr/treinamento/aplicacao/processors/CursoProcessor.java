package br.edu.ifpr.treinamento.aplicacao.processors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import br.edu.ifpr.treinamento.modelo.Curso;
import br.edu.ifpr.treinamento.modelo.Instrutor;
import br.edu.ifpr.treinamento.modelo.Modulo;
import br.edu.ifpr.treinamento.modelo.service.JpaService;
import br.edu.ifpr.treinamento.modelo.service.command.JpaPersistenceDAOType;
import br.edu.ifpr.treinamento.modelo.service.command.impl.CursoPersistenceDAO;
import br.edu.ifpr.treinamento.modelo.service.command.impl.InstrutorPersistenceDAO;
import br.edu.ifpr.treinamento.modelo.types.CursoSituacaoType;

public class CursoProcessor {
    private JpaService js = null;
    private CursoPersistenceDAO ps =null;
    private InstrutorPersistenceDAO psi = null;
  
    public CursoProcessor(JpaService js) {
      this.js = js;
      this.ps = (CursoPersistenceDAO)
              this.js.persistenceCommandFactory(JpaPersistenceDAOType.CURSO);
    this.psi = (InstrutorPersistenceDAO)
               this.js.persistenceCommandFactory(JpaPersistenceDAOType.INSTRUTOR);
    }
  
    private void print(Curso dado) {
       System.out.println(dado==null?"NENHUM CURSO ENCONTRADO":dado);
    }
  
    private void print(List<Curso> dados) {
       System.out.println("TOTAL [" + dados.size() + "]");
       for (Curso dado : dados) {
          print(dado);
       }
    }
  
    private void populate(List<Curso> dados)
    {
        Random r = new Random(); 
        List<Instrutor> is = new ArrayList<>(psi.select());
        
        List<Modulo> moduloMatematica = Arrays.asList(new Modulo("Estatistica", 3, new Date(), is.get(r.nextInt(is.size()))),
                new Modulo("Calculo I", 4, new Date(), is.get(r.nextInt(is.size()))),
                new Modulo("Calculo II", 6, new Date(), is.get(r.nextInt(is.size()))),
                new Modulo("Calculo III", 5, new Date(), is.get(r.nextInt(is.size()))),
                new Modulo("Matematica Discreta", 3, new Date(), is.get(r.nextInt(is.size())))
                );
        

        List<Modulo> moduloPortugues = Arrays.asList(new Modulo("Gramatica", 2, new Date(), is.get(r.nextInt(is.size()))),
                new Modulo("Ortografia", 1, new Date(), is.get(r.nextInt(is.size()))),
                new Modulo("Oficina De Textos I", 5, new Date(), is.get(r.nextInt(is.size()))),
                new Modulo("Oficina De Textos II", 2, new Date(), is.get(r.nextInt(is.size()))),
                new Modulo("Interpretação de Texto", 4, new Date(), is.get(r.nextInt(is.size())))
                );
        
        List<Modulo> moduloEngenharia = Arrays.asList(new Modulo("Calculo I", 3, new Date(), is.get(r.nextInt(is.size()))),
                new Modulo("Calculo II", 2, new Date(), is.get(r.nextInt(is.size()))),
                new Modulo("Fisica I", 1, new Date(), is.get(r.nextInt(is.size()))),
                new Modulo("Fisica II", 1, new Date(), is.get(r.nextInt(is.size()))),
                new Modulo("Termodinamica", 5, new Date(), is.get(r.nextInt(is.size())))
                );

        List<Modulo> moduloHardware = Arrays.asList(new Modulo("Arquitetura de computadores", 5, new Date(), is.get(r.nextInt(is.size()))),
                      new Modulo("Arquitetura de Nucleo", 6, new Date(), is.get(r.nextInt(is.size()))),
                      new Modulo("Arquitetura Kernell", 2, new Date(), is.get(r.nextInt(is.size())))
                      );
        List<Modulo> moduloSoftware = Arrays.asList(new Modulo("Engenharia de Software", 3, new Date(), is.get(r.nextInt(is.size()))),
                      new Modulo("Metodologias de Desenvolvimento", 2, new Date(), is.get(r.nextInt(is.size())))
                      );
        
        Curso c1 = new Curso("14536", "Matemática Avançada", CursoSituacaoType.INICIADO, moduloMatematica);
        Curso c2 = new Curso("38967", "Português", CursoSituacaoType.INICIADO, moduloPortugues);
        Curso c3 = new Curso("20194", "Engenharia", CursoSituacaoType.TERMINADO, moduloEngenharia);
        Curso c4 = new Curso("41627", "Hardware", CursoSituacaoType.INICIADO, moduloHardware);
        Curso c5 = new Curso("90871", "Software", CursoSituacaoType.TERMINADO, moduloSoftware);
                                                  
        dados.add(c1);
        dados.add(c2);
        dados.add(c3);
        dados.add(c4);
        dados.add(c5);
        }
  
    private int insert() {
       List<Curso> dados = new ArrayList<>();
       populate(dados);
       int regs = 0;
       for (Curso dado : dados) {
          regs += ps.insert(dado);
       }
       return regs;
    }
  
    private void processInsert(boolean varios) {
       if (varios) {
          System.out.println("INCLUIDOS [" + insert() + "]");
          return;
       }
       
       Random r = new Random(); 
       List<Instrutor> is = new ArrayList<>(psi.select());
  
       List<Modulo> moduloSoftware = Arrays.asList(new Modulo("Engenharia de Software", 3, new Date(), is.get(r.nextInt(is.size()))),
               new Modulo("Metodologias de Desenvolvimento", 2, new Date(), is.get(r.nextInt(is.size())))
               );
 
       Curso curso = new Curso("14537", "Matemática Avançada II", CursoSituacaoType.INICIADO, moduloSoftware);
  
       System.out.println("INCLUIDO [" + ps.insert(curso) + "]");
    }
  
    private void processUpdate(String valorBusca) {
        Curso dado = ps.select(valorBusca);
        int res = 0;
        
        if(dado != null) {
            dado.setSituacao(CursoSituacaoType.TERMINADO);
                                    //Modifica qualquer info de dado
            res = ps.update(dado); //Ser� modificado
        }
        if(res == 1) {
            System.out.println("ALTERADO ["+valorBusca+"]");
        }
        else
            System.out.println("["+valorBusca+"] NÃO ENCONTRADO");
    }
  
    private void processDelete(String valorBusca) {
       int deleted = ps.delete(valorBusca);
  
       if (deleted == 1) {
          System.out.println("EXCLUIDO [" + valorBusca + "]");
       }
       else {
          System.out.println("[" + valorBusca + "] nao encontrado");
       }
    }
  
    private void processDelete() {
       int deleted = ps.delete();
       System.out.println("EXCLUIDOS [" + deleted + "]");
    }
  
    private void processSelect() {
       processSelect(null);
    }
  
    private void processSelect(String valorBusca) {
       if (valorBusca == null) {
          List<Curso> dados = new ArrayList<>(ps.select());
          print(dados);
       }
       else {
          print(ps.select(valorBusca));
       }
    }
  
    public void processCursos() {
       System.out.println("\n\n\n### PROCESSANDO CURSOS : INICIO ###");
  
       System.out.println("\n===> EXCLUIR CURSOS <===");
       processDelete();
  
       System.out.println("\n===> INCLUIR CURSOS <===");
       processInsert(true);
  
       System.out.println("\n===> BUSCAR CURSOS <===");
       processSelect();
  
       System.out.println("\n===> EXCLUIR CURSOS <===");
       processDelete();
  
       System.out.println("\n===> BUSCAR CURSOS <===");
       processSelect();
  
       System.out.println("\n===> INCLUIR CURSOS <===");
       processInsert(true);
  
       System.out.println("\n===> BUSCAR CURSOS <===");
       processSelect();
  
       System.out.println("\n===> INCLUIR CURSO <===");
       processInsert(false);
  
       System.out.println("\n===> BUSCAR CURSOS <===");
       processSelect();
  
       String codigo = "20194";
       System.out.println("\n===> BUSCAR CURSO EXISTENTE [" + codigo + "] <===");
       processSelect(codigo);
  
       codigo = "11111111111";
       System.out.println("\n===> BUSCAR CURSO NAO EXISTENTE [" + codigo + "] <===");
       processSelect(codigo);
  
       codigo = "20194";
       System.out.println("\n===> ALTERAR CURSO EXISTENTE [" + codigo + "] <===");
       processUpdate(codigo);
  
       codigo = "11111111111";
       System.out.println("\n===> ALTERAR CURSO NAO EXISTENTE [" + codigo + "] <===");
       processUpdate(codigo);
  
       System.out.println("\n===> BUSCAR CURSOS <===");
       processSelect();
  
       codigo = "22222222222";
       System.out.println("\n===> EXCLUIR CURSO NÃO EXISTENTE [" + codigo + "] <===");
       processDelete(codigo);
  
       codigo = "20194";
       System.out.println("\n===> EXCLUIR CURSO EXISTENTE [" + codigo + "] <===");
       processDelete(codigo);
  
       System.out.println("\n===> BUSCAR CURSOS <===");
       processSelect();
  
       System.out.println("\n===> EXCLUIR CURSOS <===");
       processDelete();
  
       System.out.println("\n===> INCLUIR CURSOS <===");
       processInsert(true);
  
       System.out.println("\n===> BUSCAR CURSOS <===");
       processSelect();
  
       System.out.println("\n### PROCESSANDO CURSOS : FIM ###\n");
    }
}