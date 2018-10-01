package br.edu.ifpr.treinamento.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

import br.edu.ifpr.treinamento.modelo.types.PessoaType;
import br.edu.ifpr.treinamento.modelo.types.SexoType;

@Entity
public class Aluno extends Pessoa
{
    @Column(name="ALU_CODIGO")
    private String codigo;
    @Transient
    private List<Matricula> matriculas;
    
    public Aluno()
    {
        super();
        this.matriculas = new ArrayList();
    }
    
    public Aluno(String cpf, String nome, String rg, Date nascimento, SexoType sexo,
            List<Telefone> fones)
    {
        super(cpf, nome, rg, nascimento, sexo, PessoaType.ALUNO, fones);
        // TODO Auto-generated constructor stub
    }
    
    public Aluno(String cpf, String nome, String rg, Date nascimento, SexoType sexo, Telefone fone)
    {
        super(cpf, nome, rg, nascimento, sexo, PessoaType.ALUNO, fone);
        // TODO Auto-generated constructor stub
    }
    
    public Aluno(String cpf, String nome, String rg, String email, Date nascimento, SexoType sexo,
            Endereco endereco, List<Telefone> fones)
    {
        super(cpf, nome, rg, email, nascimento, sexo, PessoaType.ALUNO, endereco, fones);
        // TODO Auto-generated constructor stub
    }
    
    public Aluno(String cpf, String nome, String rg, String email, Date nascimento, SexoType sexo,
            Endereco endereco, Telefone fone)
    {
        super(cpf, nome, rg, email, nascimento, sexo, PessoaType.ALUNO, endereco, fone);
        // TODO Auto-generated constructor stub
    }
    
    public Aluno(String cpf, String nome, String rg, String email, Date nascimento, SexoType sexo,
            Telefone fone)
    {
        super(cpf, nome, rg, email, nascimento, sexo, PessoaType.ALUNO, fone);
        // TODO Auto-generated constructor stub
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        result = prime * result + ((matriculas == null) ? 0 : matriculas.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Aluno other = (Aluno) obj;
        if (codigo == null)
        {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        if (matriculas == null)
        {
            if (other.matriculas != null)
                return false;
        } else if (!matriculas.equals(other.matriculas))
            return false;
        return true;
    }
    
    
}