package br.edu.ifpr.treinamento.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import br.edu.ifpr.treinamento.modelo.types.PessoaType;
import br.edu.ifpr.treinamento.modelo.types.SexoType;

@MappedSuperclass
public abstract class Pessoa
{
    @Id
    @Column(name="PES_CPF",length=11,nullable=false)
    protected String cpf;
    
    @Column(name="PES_NOME",nullable=false)
    protected String nome;
    
    @Column(name="PES_RG",nullable=false)
    protected String rg;
    
    @Column(name="PES_email")
    protected String email;
    
    @Temporal(value=TemporalType.DATE)
    @Column(name="PES_DT_NASC",nullable=false)
    protected java.util.Date nascimento;
    
    @Enumerated(value=EnumType.ORDINAL)
    @Column(name="PES_SEXO",nullable=false)
    protected SexoType sexo;
    
    @Enumerated(value=EnumType.ORDINAL)
    @Column(name="PES_TIPO",nullable=false)
    protected PessoaType tipo;
    
    @Transient
    protected List<Telefone> fones;
    
    @Transient
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
        this.cpf = cpf;
        this.nome = nome;
        this.rg = rg;
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
}