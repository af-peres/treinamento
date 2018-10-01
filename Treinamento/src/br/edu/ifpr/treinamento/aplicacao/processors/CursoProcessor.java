package br.edu.ifpr.treinamento.aplicacao.processors;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpr.treinamento.modelo.Curso;
import br.edu.ifpr.treinamento.modelo.service.JpaService;
import br.edu.ifpr.treinamento.modelo.service.command.JpaPersistenceDAOType;
import br.edu.ifpr.treinamento.modelo.service.command.impl.CursoPersistenceDAO;

public class CursoProcessor {
    private JpaService              js             = null;
    private CursoPersistenceDAO persistenceDAO = (CursoPersistenceDAO) this.js.persistenceCommandFactory(JpaPersistenceDAOType.CURSO);
  
    public CursoProcessor(JpaService js) {
       this.js = js;
       this.persistenceDAO = null;
    }
  
    private void print(Curso dado) {
       System.out.println(dado);
    }
  
    private void print(List<Curso> dados) {
       System.out.println("TOTAL [" + dados.size() + "]");
       for (Curso dado : dados) {
          print(dado);
       }
    }
  
    private void populate(List<Curso> dados) {
       // (String codigo, String nome, CursoSituacaoType situacao)
       Curso c1 = new Curso("","", null);
       Curso c2 = new Curso("","", null);
       Curso c3 = new Curso("","", null);
       Curso c4 = new Curso("","", null);
       Curso c5 = new Curso("","", null);
       Curso c6 = new Curso("","", null);
       Curso c7 = new Curso("","", null);
       Curso c8 = new Curso("","", null);
       Curso c9 = new Curso("","", null);
       Curso c10 = new Curso("","", null);
      
  
       dados.add(c1);
       dados.add(c2);
       dados.add(c3);
       dados.add(c4);
       dados.add(c5);
       dados.add(c6);
       dados.add(c7);
       dados.add(c8);
       dados.add(c9);
       dados.add(c10);
  
    }
  
    private int insert() {
       List<Curso> dados = new ArrayList<>();
       populate(dados);
       int regs = 0;
       for (Curso dado : dados) {
          regs += persistenceDAO.insert(dado);
       }
       return regs;
    }
  
    private void processInsert(boolean varios) {
       if (varios) {
          System.out.println("INCLUIDOS [" + insert() + "]");
          return;
       }
  
       Curso curso = new Curso("","", null);
  
       System.out.println("INCLUIDO [" + persistenceDAO.insert(curso) + "]");
    }
  
    private void processUpdate(String valorBusca, Curso newDados) {
       Curso dado = persistenceDAO.select(valorBusca); // Sera modificado
       int res = 0;
       if (dado != null) {
          dado.setCodigo(newDados.getCodigo());
          dado.setNome(newDados.getNome());
          dado.setSituacao(newDados.getSituacao());
          res = 1;
       }
       if (res == 1) {
          System.out.println("ALTERADO [" + valorBusca + "]");
       }
       else {
          System.out.println("[" + valorBusca + " NÃO ENCONTRADO");
       }
    }
  
    private void processDelete(String valorBusca) {
       int deleted = persistenceDAO.delete(valorBusca);
  
       if (deleted == 0) {
          System.out.println("EXCLUIDO [" + valorBusca + "]");
       }
       else {
          System.out.println("[" + valorBusca + "] nao encontrado");
       }
    }
  
    private void processDelete() {
       int deleted = persistenceDAO.delete();
       System.out.println("EXCLUIDOS [" + deleted + "]");
    }
  
    private void processSelect() {
       processSelect(null);
    }
  
    private void processSelect(String valorBusca) {
       if (valorBusca == null) {
          List<Curso> dados = new ArrayList<>(/* ? */);
          print(dados);
       }
       else {
          print(new Curso());
       } // sera modificado
    }
  
    public void processAlunos() {
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
  
       String codigo = "25692096862";
       System.out.println("\n===> BUSCAR CURSO EXISTENTE [" + codigo + "] <===");
       processSelect(codigo);
  
       codigo = "11111111111";
       System.out.println("\n===> BUSCAR CURSO NAO EXISTENTE [" + codigo + "] <===");
       processSelect(codigo);
  
       codigo = "53451383039";
  
       Curso curso = new Curso("","", null);
       System.out.println("\n===> ALTERAR CURSO EXISTENTE [" + codigo + "] <===");
       processUpdate(codigo, curso);
  
       codigo = "11111111111";
       System.out.println("\n===> ALTERAR CURSO NAO EXISTENTE [" + codigo + "] <===");
       processUpdate(codigo, curso);
  
       System.out.println("\n===> BUSCAR CURSOS <===");
       processSelect();
  
       codigo = "22222222222";
       System.out.println("\n===> EXCLUIR CURSO NÃO EXISTENTE [" + codigo + "] <===");
       processDelete(codigo);
  
       codigo = "73711832318";
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