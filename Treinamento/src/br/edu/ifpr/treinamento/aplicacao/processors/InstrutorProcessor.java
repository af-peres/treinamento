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
        System.out.println(dado==null?"NENHUM INSTRUTOR ENCONTRADO":dado);
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
        Endereco e1 = new Endereco("Brasil", "78", "casa", "cafezal", "86045680", "Londrina", UfType.PARANA, EnderecoType.COMERCIAL);
        Telefone t1 = new Telefone("67", "25345219", TelefoneType.COMERCIAL);
        Instrutor a1 = new Instrutor("85716565840", "Pietro José Teixeira", "262912399", "teste@teste",new Date(96,10,17), SexoType.MASCULINO, PessoaType.INSTRUTOR,e1, t1,"566");
        dados.add(a1);
        
        e1 = new Endereco("Rua das Acácias", "787", "Casa", "Águas Negras (Icoaraci)", "66822680", "Belém",UfType.PARA, EnderecoType.RESIDENCIAL);
        t1 = new Telefone("91","988831036",TelefoneType.RESIDENCIAL);
        a1 = new Instrutor("74983194460", "Daniel Iago Filipe Galvão", "283538661","teste2@teste.com", new Date (96,10,7), SexoType.MASCULINO, PessoaType.INSTRUTOR,e1, t1,"856");
        dados.add(a1);
        
        e1 = new Endereco("Avenida Pioneiro Heitor Olsen", "243", "Bloco A", "Alpha Parque", "76965391", "Cacoal", UfType.RORAIMA, EnderecoType.COMERCIAL);
        t1 = new Telefone("69","39727407",TelefoneType.COMERCIAL);
        a1 = new Instrutor("06384635640", "Luiz Geraldo Campos", "423942128", "luizgeraldocampos__luizgeraldocampos@avantii.com.br", new Date(81,8,14), SexoType.MASCULINO, PessoaType.INSTRUTOR, e1, t1,"789");
        dados.add(a1);
        
        e1 = new Endereco("Quadra 399", "562", "Quadra", "Mansões de Recreio Estrela Dalva VIII", "72859399", "Luziânia", UfType.GOIAS, EnderecoType.COMERCIAL);
        t1 = new Telefone("61","984442352",TelefoneType.COMERCIAL);
        a1 = new Instrutor("16105789882", "Priscila Elza Vera Porto", "126785612", "ppriscilaelzaveraporto@temavonfeccaosjc.com.br", new Date(62,1,22), SexoType.FEMININO, PessoaType.INSTRUTOR, e1, t1,"742");
        dados.add(a1);
        
        e1 = new Endereco("Travessa Bereia", "874", "casa", "Cidade de Deus", "22763410", "Rio de Janeiro", UfType.RIO_JANEIRO, EnderecoType.RESIDENCIAL);
        t1 = new Telefone("21","38681557",TelefoneType.RESIDENCIAL);
        a1 = new Instrutor("55270575388", "Maria Esther Rezende", "211781897", "mariaestherrezende_@profiledesign.com.br", new Date(73,5,20), SexoType.FEMININO, PessoaType.INSTRUTOR, e1, t1,"745");
        dados.add(a1);
        
        e1 = new Endereco("Avenida General Bento da Gama", "592", "casa dos fundos", "Ipsep", "51350450", "Recife", UfType.PERNAMBUCO, EnderecoType.RESIDENCIAL);
        t1 = new Telefone("81", "28823050", TelefoneType.RESIDENCIAL);
        a1 = new Instrutor("99827916050", "Raul Emanuel Assunção", "474066915", "raulemanuelassuncao..raulemanuelassuncao@cuppari.com.br", new Date(76,6,17), SexoType.MASCULINO, PessoaType.INSTRUTOR, e1, t1,"458");
        dados.add(a1);
        
        e1 = new Endereco("Rua Nemésio Fabrício", "913", "apt 305", "Aeroporto", "97513750", "Uruguaiana", UfType.RIO_GRANDE_SUL, EnderecoType.RESIDENCIAL);
        t1 = new Telefone("55","985907910",TelefoneType.RESIDENCIAL);
        a1 = new Instrutor("13199860303", "Joaquim Bernardo Freitas", "266912333", "jjoaquimbernardofreitas@andrelam.com.br", new Date(87,9,20),SexoType.MASCULINO, PessoaType.INSTRUTOR, e1, t1,"1236");
        dados.add(a1);
        
        e1 = new Endereco("Quadra SHIGS 710 Bloco Q", "931", "Quadra", "Asa Sul", "70360767", "Brasília", UfType.DISTRITO_FEDERAL, EnderecoType.RESIDENCIAL);
        t1 = new Telefone("61","37918049",TelefoneType.RESIDENCIAL);
        a1 = new Instrutor("47027742632", "Alexandre Ruan da Costa", "428796278", "alexandreruandacosta..alexandreruandacosta@gmapst.com", new Date(68,6,16), SexoType.MASCULINO, PessoaType.INSTRUTOR, e1, t1,"6548");
        dados.add(a1);
        
        e1 = new Endereco("Rua Severina Crispim Veras", "967", "Casa B", "Planalto Boa Esperança", "58065075", "João Pessoa", UfType.PARAIBA, EnderecoType.RESIDENCIAL);
        t1 = new Telefone("83","39661462",TelefoneType.RESIDENCIAL);
        a1 = new Instrutor("39476493984", "Valentina Hadassa Maya Costa", "232303745", "valentinahadassamayacosta..valentinahadassamayacosta@tecsysbrasil.com.br", new Date(100,0,16), SexoType.FEMININO, PessoaType.INSTRUTOR, e1, t1,"748");
        dados.add(a1);
        
        e1 = new Endereco("Rua Joinville","963","loja 12","Setor 09","76876200","Ariquemes",UfType.RORAIMA,EnderecoType.COMERCIAL);
        t1 = new Telefone("69", "987147476", TelefoneType.COMERCIAL);
        a1  =new Instrutor("39536283999", "Pietra Carolina Ribeiro", "350926025", "pietracarolinaribeiro__pietracarolinaribeiro@unimedrio.com.br", new Date(89,11,23), SexoType.MASCULINO, PessoaType.INSTRUTOR, e1, t1,"125");
        dados.add(a1);
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
        Instrutor a1 = new Instrutor("12296785069", "Pietro José Teixeira", "262912399","pietro@gmail.com", new Date(96,10,17), SexoType.MASCULINO, PessoaType.INSTRUTOR, e1,t1,"745");

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
            System.out.println("[" + valorBusca + " NÃO ENCONTRADO]");
        }
    }

    private void processDelete(String valorBusca)
    {
        int deleted = ip.delete(valorBusca);

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
            List<Instrutor> dados = (List<Instrutor>) ip.select();
            print(dados);
        } else
        {
            print(ip.select(valorBusca));
        }
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

        String cpf = "55270575388";
        System.out.println("\n===> BUSCAR INSTRUTOR EXISTENTE [" + cpf + "] <===");
        processSelect(cpf);

        cpf = "12345678909";
        System.out.println("\n===> BUSCAR INSTRUTOR NAO EXISTENTE [" + cpf + "] <===");
        processSelect(cpf);

        cpf = "55270575388";
        Endereco endereco = new Endereco("rua 1000", "152", "fundos", "bairro 12", "86253351", "Londrina", UfType.PARANA, EnderecoType.RESIDENCIAL);
        Telefone telefone = new Telefone("43", "33268956", TelefoneType.RESIDENCIAL);
        Instrutor instrutor = new Instrutor("55270575388", "", "", null, null, null, null,endereco,telefone,"005");
        System.out.println("\n===> ALTERAR INSTRUTOR EXISTENTE [" + cpf + "] <===");
        processUpdate(cpf, instrutor);

        cpf = "12345678909";
        System.out.println("\n===> ALTERAR INSTRUTOR NAO EXISTENTE [" + cpf + "] <===");
        processUpdate(cpf, instrutor);

        System.out.println("\n===> BUSCAR INSTRUTORES <===");
        processSelect();

        cpf = "12345678909";
        System.out.println("\n===> EXCLUIR INSTRUTOR NÃO EXISTENTE [" + cpf + "] <===");
        processDelete(cpf);

        cpf = "74983194460";
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