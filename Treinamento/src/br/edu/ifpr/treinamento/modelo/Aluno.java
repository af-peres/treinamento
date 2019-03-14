package br.edu.ifpr.treinamento.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import br.edu.ifpr.treinamento.modelo.types.PessoaType;
import br.edu.ifpr.treinamento.modelo.types.SexoType;

@Entity
@AssociationOverrides({
    @AssociationOverride (name="fones",
            joinColumns = @JoinColumn (name= "ALU_TEL_PES_CPF"))
})
public class Aluno extends Pessoa
{
    
    @Column(name="ALU_CODIGO")
    private String codigo;
    
    @OneToMany(mappedBy="aluno", orphanRemoval=true, fetch=FetchType.EAGER)
    @JoinColumn(name="MAT_PES_CPF", referencedColumnName="PES_CPF")
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
            Endereco endereco, Telefone fone, String cod)
    {
        super(cpf, nome, rg, email, nascimento, sexo, PessoaType.ALUNO, endereco, fone);
        this.codigo=cod;
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

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Aluno [codigo=" + codigo + ", matriculas=" + matriculas.size() + ", " + super.toString() + "]";
    }
    
    
    
}