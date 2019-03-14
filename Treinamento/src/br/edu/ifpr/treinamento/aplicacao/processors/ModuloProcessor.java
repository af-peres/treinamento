package br.edu.ifpr.treinamento.aplicacao.processors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

import br.edu.ifpr.treinamento.modelo.Instrutor;
import br.edu.ifpr.treinamento.modelo.Modulo;
import br.edu.ifpr.treinamento.modelo.service.JpaService;
import br.edu.ifpr.treinamento.modelo.service.command.JpaPersistenceDAOType;
import br.edu.ifpr.treinamento.modelo.service.command.impl.InstrutorPersistenceDAO;
import br.edu.ifpr.treinamento.modelo.service.command.impl.ModuloPersistenceDAO;

public class ModuloProcessor
{
    private ModuloPersistenceDAO persistenceDAO = null;
    private InstrutorPersistenceDAO persistanceInst = null;

    public ModuloProcessor(JpaService js)
    {
                this.persistenceDAO = (ModuloPersistenceDAO) js.persistenceCommandFactory(JpaPersistenceDAOType.MODULO);
                this.persistanceInst = (InstrutorPersistenceDAO) js.persistenceCommandFactory(JpaPersistenceDAOType.INSTRUTOR);
    }

    private void print(Modulo dado)
    {
        System.out.println(dado==null?"NENHUM MODULO ENCONTRADO":dado);
    }

    private void print(Collection<Modulo> dados)
    {
        System.out.println("TOTAL [" + dados.size() + "]");
        for (Modulo dado : dados)
        {
            print(dado);
        }
    }

    private void populate(List<Modulo> dados)
    {
        Random              r = new Random();
        List<Instrutor>     is = new ArrayList<> (persistanceInst.select());
        
        Modulo m1 = new Modulo("Estátistica", 6, new Date(118, 9, 3), is.get(r.nextInt(is.size())));
        Modulo m2 = new Modulo("Processamento Gráfico", 6, new Date(118, 9, 3), is.get(r.nextInt(is.size())));
        Modulo m3 = new Modulo("Cálculo 1", 6, new Date(118, 9, 3), is.get(r.nextInt(is.size())));
        Modulo m4 = new Modulo("Cálculo 2", 6, new Date(118, 9, 3), is.get(r.nextInt(is.size())));
        Modulo m5 = new Modulo("Física", 12, new Date(118, 9, 3), is.get(r.nextInt(is.size())));
        Modulo m6 = new Modulo("Lógica", 6, new Date(118, 9, 3), is.get(r.nextInt(is.size())));
        Modulo m7 = new Modulo("Algoritmos", 6, new Date(118, 9, 3), is.get(r.nextInt(is.size())));
        Modulo m8 = new Modulo("Fundamentos da Computação", 6, new Date(118, 9, 3), is.get(r.nextInt(is.size())));
        Modulo m9 = new Modulo("Arquitetura de Computadores", 12, new Date(118, 9, 3), is.get(r.nextInt(is.size())));
        Modulo m10 = new Modulo("Engenharia de Software", 12, new Date(118, 9, 3), is.get(r.nextInt(is.size())));

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

    private int insert()
    {
        List<Modulo> dados = new ArrayList<>();
        populate(dados);
        int regs = 0;
        for (Modulo dado : dados)
        {
            regs += persistenceDAO.insert(dado);
        }
        return regs;
    }

    private void processInsert(boolean varios)
    {
        if (varios)
        {
            System.out.println("INCLUIDOS [" + insert() + "]");
            return;
        }

            Random          r = new Random();
            List<Instrutor> is = new ArrayList<> (persistanceInst.select());
    
            Modulo modulo = new Modulo ("MÓDULO TESTE", 5, new Date(), is.get(r.nextInt(is.size())));

        System.out.println("INCLUIDO [" + persistenceDAO.insert(modulo) + "]");
    }

    private void processUpdate(String valorBusca, Modulo newDados)
    {
        Modulo dado = persistenceDAO.select(valorBusca);
        int res = 0;
        if (dado != null)
        {
            dado.setDuracao(newDados.getDuracao());
            dado.setInicio(newDados.getInicio());
            dado.setInstrutor(newDados.getInstrutor());
            dado.setNome(newDados.getNome());
            res = 1;
        }
        if (res == 1)
        {
            System.out.println("ALTERADO [" + valorBusca + "]");
        } else
        {
            System.out.println("[" + valorBusca + " NÃO ENCONTRADO");
        }
    }

    private void processDelete(String valorBusca)
    {
        int deleted = persistenceDAO.delete(valorBusca);

        if (deleted == 1)
        {
            System.out.println("EXCLUIDO [" + valorBusca + "]");
        } else
        {
            System.out.println("[" + valorBusca + "] nao encontrado");
        }
    }

    private void processDelete()
    {
        int deleted = persistenceDAO.delete();
        System.out.println("EXCLUIDOS [" + deleted + "]");
    }

    private void processSelect()
    {
        processSelect(null);
    }

    private void processSelect(String valorBusca)
    {
        if (valorBusca == null)
        {
            List<Modulo> dados = new ArrayList<>(persistenceDAO.select());
            print(dados);
        } else
        {
            print(persistenceDAO.select(valorBusca));
        }
    }

    public void processModulos()
    {
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

        String nome = "Algoritmos";
        System.out.println("\n===> BUSCAR MODULO EXISTENTE [" + nome + "] <===");
        processSelect(nome);

        nome = "Lero-lero";
        System.out.println("\n===> BUSCAR MODULO NAO EXISTENTE [" + nome + "] <===");
        processSelect(nome);

        nome = "Algoritmos";

        Modulo modulo = new Modulo("Algoritmos Alterado", 0, null, null);
        System.out.println("\n===> ALTERAR MODULO EXISTENTE [" + nome + "] <===");
        processUpdate(nome, modulo);

        nome = "teste inexistente";
        System.out.println("\n===> ALTERAR MODULO NAO EXISTENTE [" + nome + "] <===");
        processUpdate(nome, modulo);

        System.out.println("\n===> BUSCAR MODULOS <===");
        processSelect();

        nome = "lalalala";
        System.out.println("\n===> EXCLUIR MODULO NÃO EXISTENTE [" + nome + "] <===");
        processDelete(nome);

        nome = "Algoritmos";
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