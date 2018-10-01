package br.edu.ifpr.treinamento.aplicacao.processors;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.edu.ifpr.treinamento.modelo.Aluno;
import br.edu.ifpr.treinamento.modelo.Endereco;
import br.edu.ifpr.treinamento.modelo.Telefone;
import br.edu.ifpr.treinamento.modelo.service.JpaService;
import br.edu.ifpr.treinamento.modelo.service.command.JpaPersistenceDAOType;
import br.edu.ifpr.treinamento.modelo.service.command.impl.AlunoPersistenceDAO;
import br.edu.ifpr.treinamento.modelo.types.EnderecoType;
import br.edu.ifpr.treinamento.modelo.types.PessoaType;
import br.edu.ifpr.treinamento.modelo.types.SexoType;
import br.edu.ifpr.treinamento.modelo.types.TelefoneType;
import br.edu.ifpr.treinamento.modelo.types.UfType;

public class AlunoProcessor
{
 
    private JpaService js = null;
    //private AlunoPersistenceDAO ps = (AlunoPersistenceDAO) this.js.persistenceCommandFactory(JpaPersistenceDAOType.ALUNO);
    private AlunoPersistenceDAO ps = null;
    
    public AlunoProcessor(JpaService js)
    {
        this.js = js;
        this.ps = (AlunoPersistenceDAO) this.js.persistenceCommandFactory(JpaPersistenceDAOType.ALUNO);
        this.js.persistenceCommandFactory(JpaPersistenceDAOType.ALUNO);
    }
 
    private void print(Aluno dado)
    {
        System.out.println(dado);
    }
 
    private void print(List<Aluno> dados)
    {
        System.out.println("TOTAL [" + dados.size() + "]");
        for (Aluno dado : dados)
        {
            print(dado);
        }
    }
 
    private void populate(List<Aluno> dados)
    {
        Endereco e = new Endereco("Rua pereira","901","Casa","Cambezinho","86040380","Londrina",UfType.PARANA,EnderecoType.RESIDENCIAL);
        Telefone t = new Telefone("43", "33429654", TelefoneType.RESIDENCIAL);
        Aluno a = new Aluno("84412146030", "Murilo Andrade", "879412587","murilo@gmail.com", new Date(), SexoType.MASCULINO,e, t);
        dados.add(a);
        
        e = new Endereco("Rua Silva","2344","apt 505", "centro","86080920","Cambé",UfType.SAO_PAULO,EnderecoType.COMERCIAL);
        t = new Telefone("48","2939-6483",TelefoneType.COMERCIAL);
        a = new Aluno("78171874959", "Matheus Marcos Vinicius Sebastião Ramos", "313966205","matheus@bol.com", new Date(96,4,9), SexoType.FEMININO,e, t);
        dados.add(a);
                
        e = new Endereco("Rua Castanheira","156","apt 505", "Portal da Amazônia","69915882","Rio Branco",UfType.ACRE,EnderecoType.COMERCIAL);
        t = new Telefone("68","36552839",TelefoneType.COMERCIAL);
        a = new Aluno("61428786210", "Guilherme Benedito Antonio Ribeiro", "266298357","guilhermebeneditoantonioribeiro@truckeixo.com.br", new Date(96,9,9), SexoType.MASCULINO,e,t);
        dados.add(a);
        
        e = new Endereco("Rua Cuiabá", "100", "casa", "Módulo II", "68625350", "Paragominas", UfType.PARA, EnderecoType.RESIDENCIAL);
        t = new Telefone("91","29229165",TelefoneType.COMERCIAL);
        a = new Aluno("52310823503", "Leandro Calebe Levi Porto","calebe@hotmail.com", "247720185", new Date(96,3,4), SexoType.MASCULINO, e,t);
        dados.add(a);
        
        e = new Endereco("Rua Amapá", "447", "Apt. 612", "Liberdade", "76967562", "Cacoal", UfType.RORAIMA, EnderecoType.COMERCIAL);
        t = new Telefone("69","29996112",TelefoneType.COMERCIAL);
        a = new Aluno("32246912474", "Laís Maitê Sabrina Rocha", "325108857", "laismaitesabrinarocha-95@ddfnet.com.br", new Date(92,10,18), SexoType.FEMININO, e, t);

    }
 
    private int insert()
    {
        List<Aluno> dados = new ArrayList<>();
        populate(dados);
        int regs = 0;
        for (Aluno dado : dados)
        {
            regs += ps.insert(dado);
        }
        return regs;
    }
 
    private void processInsert(boolean varios)
    {
        if (varios)
        {
            System.out.println("INCLUÍDOS [" + insert() + "]");
            return;
        }
        // Criar um objeto Aluno
        System.out.println("INCLUÍDO []");
    }
 
    private void processUpdate(String valorBusca)
    {
        Aluno dado = ps.select(valorBusca);
        int res = 0;
        if (dado != null)
        {
            // Modificar qualquer informação de dado
            res = ps.update(dado);
        }
        if (res == 1)
        {
            System.out.println("ALTERADO [" + valorBusca + "]");
        }
        else
        {
            System.out.println("[" + valorBusca + " NÃO ENCONTRADO");
        }
    }
    
    private void processDelete(String valorBusca)
    {
        int deleted =  ps.delete(valorBusca);
        
        if (deleted==0) {System.out.println("EXCLUÍDO ["+valorBusca+"]");}
        else {System.out.println("["+valorBusca+"] não encontrado");
        }
    }
        
    private void processDelete()
    {
        System.out.println("EXCLUIDOS ["+ ps.delete() +"]");
    }
    
    private void processSelect()
    {
        processSelect(null);
    }
    
    private void processSelect(String valorBusca)
    {
        if(valorBusca==null)
        {
            List<Aluno> dados = new ArrayList<>(/*?*/);
            print(dados);
        }
        else {print (new Aluno());}//sera modificado
    }
    
    public void processAlunos()
    {
        System.out.println("\n\n\n### PROCESSANDO ALUNOS : INÍCIO ###");
        
        System.out.println("\n===> EXCLUIR ALUNOS <===");
        processDelete();
   
        System.out.println("\n===> INCLUIR ALUNOS <===");
        processInsert(true);
   
        System.out.println("\n===> BUSCAR ALUNOS <===");
        processSelect();
   
        System.out.println("\n===> EXCLUIR ALUNOS <===");
        processDelete();
   
        System.out.println("\n===> BUSCAR ALUNOS <===");
        processSelect();
   
        System.out.println("\n===> INCLUIR ALUNOS <===");
        processInsert(true);
   
        System.out.println("\n===> BUSCAR ALUNOS <===");
        processSelect();
   
        System.out.println("\n===> INCLUIR ALUNO <===");
        processInsert(false);
   
        System.out.println("\n===> BUSCAR ALUNOS <===");
        processSelect();
   
        String cpf = "";
        System.out.println("\n===> BUSCAR ALUNO EXISTENTE [" + cpf + "] <===");
        processSelect(cpf);
   
        cpf = "22222222222";
        System.out.println("\n===> BUSCAR ALUNO NÃO EXISTENTE [" + cpf +
                              "] <===");
        processSelect(cpf);
   
        cpf = "";
        System.out.println("\n===> ALTERAR ALUNO EXISTENTE [" + cpf +
                              "] <===");
        processUpdate(cpf);
   
        cpf = "22222222222";
        System.out.println("\n===> ALTERAR ALUNO NÃO EXISTENTE [" + cpf +
                           "] <===");
        processUpdate(cpf);
   
        System.out.println("\n===> BUSCAR ALUNOS <===");
        processSelect();
   
        cpf = "22222222222";
        System.out.println("\n===> EXCLUIR ALUNO NÃO EXISTENTE [" + cpf +
                           "] <===");
        processDelete(cpf);
   
        cpf = "95811419015";
        System.out.println("\n===> EXCLUIR ALUNO EXISTENTE [" + cpf +
                           "] <===");
        processDelete(cpf);
   
        System.out.println("\n===> BUSCAR ALUNOS <===");
        processSelect();
   
        System.out.println("\n===> EXCLUIR ALUNOS <===");
        processDelete();
   
        System.out.println("\n===> INCLUIR ALUNOS <===");
        processInsert(true);
   
        System.out.println("\n===> BUSCAR ALUNOS <===");
        processSelect();
   
        System.out.println("\n### PROCESSANDO ALUNOS : FIM ###\n");
    }
}