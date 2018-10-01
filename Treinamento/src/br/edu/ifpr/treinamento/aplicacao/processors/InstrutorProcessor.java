package br.edu.ifpr.treinamento.aplicacao.processors;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.edu.ifpr.treinamento.modelo.Endereco;
import br.edu.ifpr.treinamento.modelo.Instrutor;
import br.edu.ifpr.treinamento.modelo.Telefone;
import br.edu.ifpr.treinamento.modelo.service.JpaService;
import br.edu.ifpr.treinamento.modelo.service.command.JpaPersistenceDAOType;
import br.edu.ifpr.treinamento.modelo.service.command.impl.InstrutorPersistenceDAO;
import br.edu.ifpr.treinamento.modelo.types.EnderecoType;
import br.edu.ifpr.treinamento.modelo.types.PessoaType;
import br.edu.ifpr.treinamento.modelo.types.SexoType;
import br.edu.ifpr.treinamento.modelo.types.TelefoneType;
import br.edu.ifpr.treinamento.modelo.types.UfType;

public class InstrutorProcessor
{
    private JpaService js = null;
    private InstrutorPersistenceDAO ip = null;

    public InstrutorProcessor(JpaService js)
    {
        this.js = js;
        this.ip = (InstrutorPersistenceDAO) this.js.persistenceCommandFactory(JpaPersistenceDAOType.INSTRUTOR);
        this.js.persistenceCommandFactory(JpaPersistenceDAOType.INSTRUTOR);
    }

    private void print(Instrutor dado)
    {
        System.out.println(dado);
    }

    private void print(List<Instrutor> dados)
    {
        System.out.println("TOTAL [" + dados.size() + "]");
        for (Instrutor dado : dados)
        {
            print(dado);
        }
    }

    private void populate(List<Instrutor> dados)
    {
        // (Rua, numero, complemento, bairro, cep, Cidade, Estado, EnderecoType)
        Endereco e1 = new Endereco("Brasil", "78", "casa", "cafezal", "86045680", "Londrina", UfType.PARANA, EnderecoType.COMERCIAL);
        /*Endereco e2 = new Endereco("", "", "", "", "", "", null, null);
        Endereco e3 = new Endereco("", "", "", "", "", "", null, null);
        Endereco e4 = new Endereco("", "", "", "", "", "", null, null);
        Endereco e5 = new Endereco("", "", "", "", "", "", null, null);
        Endereco e6 = new Endereco("", "", "", "", "", "", null, null);
        Endereco e7 = new Endereco("", "", "", "", "", "", null, null);
        Endereco e8 = new Endereco("", "", "", "", "", "", null, null);
        Endereco e9 = new Endereco("", "", "", "", "", "", null, null);
        Endereco e10 = new Endereco("", "", "", "", "", "", null, null);*/
        // (DDD, numero, TelefoneType)
        Telefone t1 = new Telefone("67", "25345219", TelefoneType.COMERCIAL);
        /*Telefone t2 = new Telefone("", "", null);
        Telefone t3 = new Telefone("", "", null);
        Telefone t4 = new Telefone("", "", null);
        Telefone t5 = new Telefone("", "", null);
        Telefone t6 = new Telefone("", "", null);
        Telefone t7 = new Telefone("", "", null);
        Telefone t8 = new Telefone("", "", null);
        Telefone t9 = new Telefone("", "", null);
        Telefone t10 = new Telefone("", "", null);*/
        // (cpf, nome, rg, dataNasc, SexoType, PessoaType, endereco, telefone)
        Instrutor a1 = new Instrutor("85716565840", "Pietro José Teixeira", "262912399", new Date(96,10,17), SexoType.MASCULINO, PessoaType.INSTRUTOR, t1);
        /*Instrutor a2 = new Instrutor("", "", "", null, null, null, null, new Telefone());
        Instrutor a3 = new Instrutor("", "", "", null, null, null, null, new Telefone());
        Instrutor a4 = new Instrutor("", "", "", null, null, null, null, new Telefone());
        Instrutor a5 = new Instrutor("", "", "", null, null, null, null, new Telefone());
        Instrutor a6 = new Instrutor("", "", "", null, null, null, null, new Telefone());
        Instrutor a7 = new Instrutor("", "", "", null, null, null, null, new Telefone());
        Instrutor a8 = new Instrutor("", "", "", null, null, null, null, new Telefone());
        Instrutor a9 = new Instrutor("", "", "", null, null, null, null, new Telefone());
        Instrutor a10 = new Instrutor("", "", "", null, null, null, null, new Telefone());*/

        dados.add(a1);
        /*dados.add(a2);
        dados.add(a3);
        dados.add(a4);
        dados.add(a5);
        dados.add(a6);
        dados.add(a7);
        dados.add(a8);
        dados.add(a9);
        dados.add(a10);*/

    }

    private int insert()
    {
        List<Instrutor> dados = new ArrayList<>();
        populate(dados);
        int regs = 0;
        for (Instrutor dado : dados)
        {
            regs += ip.insert(dado);
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

        Endereco e1 = new Endereco("Brasil", "78", "casa", "cafezal", "86045680", "Londrina", UfType.PARANA, EnderecoType.COMERCIAL);
        Telefone t1 = new Telefone("67", "25345219", TelefoneType.COMERCIAL);
        Instrutor a1 = new Instrutor("85716565841", "Pietro José Teixeira", "262912399", new Date(96,10,17), SexoType.MASCULINO, PessoaType.INSTRUTOR, t1);

        System.out.println("INCLUIDO [" + ip.insert(a1) + "]");
    }

    private void processUpdate(String valorBusca, Instrutor newDados)
    {
        Instrutor dado = ip.select(valorBusca); // Sera modificado
        int res = 0;
        if (dado != null)
        {
            dado.setCodigo(newDados.getCodigo());
            dado.setCpf(newDados.getCodigo());
            dado.setEmail(newDados.getEmail());
            dado.setEndereco(newDados.getEndereco());
            dado.setFones(newDados.getFones());
            dado.setModulos(newDados.getModulos());
            dado.setNascimento(newDados.getNascimento());
            dado.setNome(newDados.getNome());
            dado.setSexo(newDados.getSexo());
            dado.setTipo(newDados.getTipo());
            dado.setRg(newDados.getRg());
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
        int deleted = ip.delete(valorBusca);

        if (deleted == 0)
        {
            System.out.println("EXCLUIDO [" + valorBusca + "]");
        } else
        {
            System.out.println("[" + valorBusca + "] nao encontrado");
        }
    }

    private void processDelete()
    {
        System.out.println("EXCLUIDOS [" + ip.delete() + "]");
    }

    private void processSelect()
    {
        processSelect(null);
    }

    private void processSelect(String valorBusca)
    {
        if (valorBusca == null)
        {
            List<Instrutor> dados = new ArrayList<>(/* ? */);
            print(dados);
        } else
        {
            print(new Instrutor());
        } // sera modificado
    }

    public void processInstrutores()
    {
        System.out.println("\n\n\n### PROCESSANDO INSTRUTORES : INICIO ###");

        System.out.println("\n===> EXCLUIR INSTRUTORES <===");
        processDelete();

        System.out.println("\n===> INCLUIR INSTRUTORES <===");
        processInsert(true);

        System.out.println("\n===> BUSCAR INSTRUTORES <===");
        processSelect();

        System.out.println("\n===> EXCLUIR INSTRUTORES <===");
        processDelete();

        System.out.println("\n===> BUSCAR INSTRUTORES <===");
        processSelect();

        System.out.println("\n===> INCLUIR INSTRUTORES <===");
        processInsert(true);

        System.out.println("\n===> BUSCAR INSTRUTORES <===");
        processSelect();

        System.out.println("\n===> INCLUIR INSTRUTOR <===");
        processInsert(false);

        System.out.println("\n===> BUSCAR INSTRUTORES <===");
        processSelect();

        String cpf = "25692096862";
        System.out.println("\n===> BUSCAR INSTRUTOR EXISTENTE [" + cpf + "] <===");
        processSelect(cpf);

        cpf = "11111111111";
        System.out.println("\n===> BUSCAR INSTRUTOR NAO EXISTENTE [" + cpf + "] <===");
        processSelect(cpf);

        cpf = "53451383039";
        Endereco endereco = new Endereco("", "", "", "", "", "", null, null);
        Telefone telefone = new Telefone("", "", null);
        Instrutor instrutor = new Instrutor("", "", "", null, null, null, null, new Telefone());
        System.out.println("\n===> ALTERAR INSTRUTOR EXISTENTE [" + cpf + "] <===");
        processUpdate(cpf, instrutor);

        cpf = "11111111111";
        System.out.println("\n===> ALTERAR INSTRUTOR NAO EXISTENTE [" + cpf + "] <===");
        processUpdate(cpf, instrutor);

        System.out.println("\n===> BUSCAR INSTRUTORES <===");
        processSelect();

        cpf = "22222222222";
        System.out.println("\n===> EXCLUIR INSTRUTOR NÃO EXISTENTE [" + cpf + "] <===");
        processDelete(cpf);

        cpf = "73711832318";
        System.out.println("\n===> EXCLUIR INSTRUTOR EXISTENTE [" + cpf + "] <===");
        processDelete(cpf);

        System.out.println("\n===> BUSCAR INSTRUTORES <===");
        processSelect();

        System.out.println("\n===> EXCLUIR INSTRUTORES <===");
        processDelete();

        System.out.println("\n===> INCLUIR INSTRUTORES <===");
        processInsert(true);

        System.out.println("\n===> BUSCAR INSTRUTORES <===");
        processSelect();

        System.out.println("\n### PROCESSANDO INSTRUTORES : FIM ###\n");
    }
}