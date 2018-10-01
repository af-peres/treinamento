package br.edu.ifpr.treinamento.aplicacao.processors;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpr.treinamento.modelo.Modulo;
import br.edu.ifpr.treinamento.modelo.service.JpaService;
import br.edu.ifpr.treinamento.modelo.service.command.JpaPersistenceDAOType;
import br.edu.ifpr.treinamento.modelo.service.command.impl.ModuloPersistenceDAO;

public class ModuloProcessor {
    private JpaService              js             = null;
    private ModuloPersistenceDAO persistenceDAO = (ModuloPersistenceDAO) this.js.persistenceCommandFactory(JpaPersistenceDAOType.MODULO);
  
    public ModuloProcessor(JpaService js) {
       this.js = js;
       this.persistenceDAO = null;
    }
  
    private void print(Modulo dado) {
       System.out.println(dado);
    }
  
    private void print(List<Modulo> dados) {
       System.out.println("TOTAL [" + dados.size() + "]");
       for (Modulo dado : dados) {
          print(dado);
       }
    }
  
    private void populate(List<Modulo> dados) {
       // (String nome, Integer duracao, Date inicio, Instrutor instrutor)
       Modulo m1 = new Modulo("", 0, null, null);
       Modulo m2 = new Modulo("", 0, null, null);
       Modulo m3 = new Modulo("", 0, null, null);
       Modulo m4 = new Modulo("", 0, null, null);
       Modulo m5 = new Modulo("", 0, null, null);
       Modulo m6 = new Modulo("", 0, null, null);
       Modulo m7 = new Modulo("", 0, null, null);
       Modulo m8 = new Modulo("", 0, null, null);
       Modulo m9 = new Modulo("", 0, null, null);
       Modulo m10 = new Modulo("", 0, null, null);
  
       dados.add(m1);
       dados.add(m2);
       dados.add(m3);
       dados.add(m4);
       dados.add(m5);
       dados.add(m6);
       dados.add(m7);
       dados.add(m8);
       dados.add(m9);
       dados.add(m10);
  
    }
  
    private int insert() {
       List<Modulo> dados = new ArrayList<>();
       populate(dados);
       int regs = 0;
       for (Modulo dado : dados) {
          regs += persistenceDAO.insert(dado);
       }
       return regs;
    }
  
    private void processInsert(boolean varios) {
       if (varios) {
          System.out.println("INCLUIDOS [" + insert() + "]");
          return;
       }
  
       Modulo modulo = new Modulo("", 0, null, null);
  
       System.out.println("INCLUIDO [" + persistenceDAO.insert(modulo) + "]");
    }
  
    private void processUpdate(String valorBusca, Modulo newDados) {
       Modulo dado = persistenceDAO.select(valorBusca); // Sera modificado
       int res = 0;
       if (dado != null) {
          dado.setDuracao(newDados.getDuracao());
          dado.setInicio(newDados.getInicio());
          dado.setInstrutor(newDados.getInstrutor());
          dado.setNome(newDados.getNome());
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
          List<Modulo> dados = new ArrayList<>(/* ? */);
          print(dados);
       }
       else {
          print(new Modulo());
       } // sera modificado
    }
  
    public void processAlunos() {
       System.out.println("\n\n\n### PROCESSANDO MODULOS : INICIO ###");
  
       System.out.println("\n===> EXCLUIR MODULOS <===");
       processDelete();
  
       System.out.println("\n===> INCLUIR MODULOS <===");
       processInsert(true);
  
       System.out.println("\n===> BUSCAR MODULOS <===");
       processSelect();
  
       System.out.println("\n===> EXCLUIR MODULOS <===");
       processDelete();
  
       System.out.println("\n===> BUSCAR MODULOS <===");
       processSelect();
  
       System.out.println("\n===> INCLUIR MODULOS <===");
       processInsert(true);
  
       System.out.println("\n===> BUSCAR MODULOS <===");
       processSelect();
  
       System.out.println("\n===> INCLUIR MODULO <===");
       processInsert(false);
  
       System.out.println("\n===> BUSCAR MODULOS <===");
       processSelect();
  
       String nome = "blabla";
       System.out.println("\n===> BUSCAR MODULO EXISTENTE [" + nome + "] <===");
       processSelect(nome);
  
       nome = "11111111111";
       System.out.println("\n===> BUSCAR MODULO NAO EXISTENTE [" + nome + "] <===");
       processSelect(nome);
  
       nome = "53451383039";
  
       Modulo modulo = new Modulo("", 0, null, null);
       System.out.println("\n===> ALTERAR MODULO EXISTENTE [" + nome + "] <===");
       processUpdate(nome, modulo);
  
       nome = "11111111111";
       System.out.println("\n===> ALTERAR MODULO NAO EXISTENTE [" + nome + "] <===");
       processUpdate(nome, modulo);
  
       System.out.println("\n===> BUSCAR MODULOS <===");
       processSelect();
  
       nome = "22222222222";
       System.out.println("\n===> EXCLUIR MODULO NÃO EXISTENTE [" + nome + "] <===");
       processDelete(nome);
  
       nome = "73711832318";
       System.out.println("\n===> EXCLUIR MODULO EXISTENTE [" + nome + "] <===");
       processDelete(nome);
  
       System.out.println("\n===> BUSCAR MODULOS <===");
       processSelect();
  
       System.out.println("\n===> EXCLUIR MODULOS <===");
       processDelete();
  
       System.out.println("\n===> INCLUIR MODULOS <===");
       processInsert(true);
  
       System.out.println("\n===> BUSCAR MODULOS <===");
       processSelect();
  
       System.out.println("\n### PROCESSANDO MODULOS : FIM ###\n");
    }
}