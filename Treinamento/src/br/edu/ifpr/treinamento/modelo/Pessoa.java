package br.edu.ifpr.treinamento.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.edu.ifpr.treinamento.modelo.types.PessoaType;
import br.edu.ifpr.treinamento.modelo.types.SexoType;
import br.edu.ifpr.utils.date.DateTimeUtils;
import br.edu.ifpr.utils.formatter.CpfFormatter;
import br.edu.ifpr.utils.formatter.RgFormatter;

@MappedSuperclass
public abstract class Pessoa
{
    @Id
    @Column(name="PES_CPF",length=15,nullable=false)
    protected String cpf;
    
    @Column(name="PES_NOME",nullable=false)
    protected String nome;
    
    @Column(name="PES_RG",nullable=false)
    protected String rg;
    
    @Column(name="PES_email")
    protected String email;
    
    @Temporal(value=TemporalType.DATE)
    @Column(name="PES_DT_NASC")
    protected java.util.Date nascimento;
    
    @Enumerated(value=EnumType.ORDINAL)
    @Column(name="PES_SEXO",nullable=false)
    protected SexoType sexo;
    
    @Enumerated(value=EnumType.ORDINAL)
    @Column(name="PES_TIPO",nullable=false)
    protected PessoaType tipo;
    
    @OneToMany (cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.EAGER)
    @JoinColumn (name="TEL_PES_CPF", referencedColumnName="PES_CPF")
    protected List<Telefone> fones;
    
    @OneToOne (cascade=CascadeType.ALL, orphanRemoval=true, optional=false)
    @JoinColumn (name="PES_END_ID", referencedColumnName="END_ID", nullable=false)
    protected Endereco endereco;
    

    public Pessoa()
    {
        this.fones = new ArrayList<>();
    }

    //sem email e endereço, um telefone
    public Pessoa(String cpf, String nome, String rg, Date nascimento, SexoType sexo, PessoaType tipo,
            Telefone fone)
    {
        this(cpf,nome,rg,"",nascimento,sexo,tipo,new Endereco(),Arrays.asList(fone));
    }
    
    //sem email e endereço, vários telefones
    public Pessoa(String cpf, String nome, String rg, Date nascimento, SexoType sexo, PessoaType tipo,
            List<Telefone> fones)
    {
        this(cpf,nome,rg,"",nascimento,sexo,tipo,new Endereco(),fones);
    }
    
    //Sem endereço, um telefone
    public Pessoa(String cpf, String nome, String rg, String email, Date nascimento, SexoType sexo, PessoaType tipo,
            Telefone fone)
    {
        this(cpf,nome,rg,email,nascimento,sexo,tipo,new Endereco(),Arrays.asList(fone));
    }
    
    //Completo, um telefone
    public Pessoa(String cpf, String nome, String rg, String email, Date nascimento, SexoType sexo, PessoaType tipo,Endereco endereco,
            Telefone fone)
    {
        this(cpf,nome,rg,email,nascimento,sexo,tipo,endereco,Arrays.asList(fone));
    }
    
    
    //COmpleto, vários telefones
    public Pessoa(String cpf, String nome, String rg, String email, Date nascimento, SexoType sexo, PessoaType tipo, Endereco endereco,
            List<Telefone> fones)
    {
        this.cpf = CpfFormatter.formatCpf(cpf);
        this.nome = nome;
        this.rg = RgFormatter.formatRg(rg);
        this.email = email;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.tipo = tipo;
        this.fones = new ArrayList<>();
        this.fones.addAll(fones);
        this.endereco = endereco;
    }

    public String getCpf()
    {
        return cpf;
    }

    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getRg()
    {
        return rg;
    }

    public void setRg(String rg)
    {
        this.rg = rg;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public java.util.Date getNascimento()
    {
        return nascimento;
    }

    public void setNascimento(java.util.Date nascimento)
    {
        this.nascimento = nascimento;
    }

    public SexoType getSexo()
    {
        return sexo;
    }

    public void setSexo(SexoType sexo)
    {
        this.sexo = sexo;
    }

    public PessoaType getTipo()
    {
        return tipo;
    }

    public void setTipo(PessoaType tipo)
    {
        this.tipo = tipo;
    }

    public List<Telefone> getFones()
    {
        return fones;
    }

    public void setFones(List<Telefone> fones)
    {
        this.fones = fones;
    }

    public Endereco getEndereco()
    {
        return endereco;
    }

    public void setEndereco(Endereco endereco)
    {
        this.endereco = endereco;
    }    
    
    @Override
    public String toString() {
        return "cpf=" + cpf + ", nome=" + nome + ", rg=" + rg + ", nascimento=" + DateTimeUtils.formatDate(nascimento) + ", sexo=" + sexo
                + ", tipo=" + tipo + ", email=" + email + ", endereco=" + endereco + ", fones=" + fones;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
        result = prime * result + ((fones == null) ? 0 : fones.hashCode());
        result = prime * result + ((nascimento == null) ? 0 : nascimento.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((rg == null) ? 0 : rg.hashCode());
        result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
        result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
        Pessoa other = (Pessoa) obj;
        if (cpf == null)
        {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        if (email == null)
        {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (endereco == null)
        {
            if (other.endereco != null)
                return false;
        } else if (!endereco.equals(other.endereco))
            return false;
        if (fones == null)
        {
            if (other.fones != null)
                return false;
        } else if (!fones.equals(other.fones))
            return false;
        if (nascimento == null)
        {
            if (other.nascimento != null)
                return false;
        } else if (!nascimento.equals(other.nascimento))
            return false;
        if (nome == null)
        {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (rg == null)
        {
            if (other.rg != null)
                return false;
        } else if (!rg.equals(other.rg))
            return false;
        if (sexo != other.sexo)
            return false;
        if (tipo != other.tipo)
            return false;
        return true;
    }
    
    
}