package br.edu.ifpr.treinamento.modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import br.edu.ifpr.treinamento.modelo.types.PessoaType;
import br.edu.ifpr.treinamento.modelo.types.SexoType;

@Entity
public class Instrutor extends Pessoa
{
    @Column(name="INS_CODIGO")
    private String codigo;
    
    @Transient
    private List<Modulo> modulos;

    public Instrutor()
    {
        super();
    }

    public Instrutor(String cpf, String nome, String rg, Date nascimento, SexoType sexo, PessoaType tipo,
            List<Telefone> fones)
    {
        super(cpf, nome, rg, nascimento, sexo, tipo, fones);
        // TODO Auto-generated constructor stub
    }

    public Instrutor(String cpf, String nome, String rg, Date nascimento, SexoType sexo, PessoaType tipo, Telefone fone)
    {
        super(cpf, nome, rg, nascimento, sexo, tipo, fone);
        // TODO Auto-generated constructor stub
    }

    public Instrutor(String cpf, String nome, String rg, String email, Date nascimento, SexoType sexo, PessoaType tipo,
            Endereco endereco, List<Telefone> fones)
    {
        super(cpf, nome, rg, email, nascimento, sexo, tipo, endereco, fones);
        // TODO Auto-generated constructor stub
    }

    public Instrutor(String cpf, String nome, String rg, String email, Date nascimento, SexoType sexo, PessoaType tipo,
            Endereco endereco, Telefone fone)
    {
        super(cpf, nome, rg, email, nascimento, sexo, tipo, endereco, fone);
        // TODO Auto-generated constructor stub
    }

    public Instrutor(String cpf, String nome, String rg, String email, Date nascimento, SexoType sexo, PessoaType tipo,
            Telefone fone)
    {
        super(cpf, nome, rg, email, nascimento, sexo, tipo, fone);
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the codigo
     */
    public String getCodigo()
    {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo)
    {
        this.codigo = codigo;
    }

    /**
     * @return the modulos
     */
    public List<Modulo> getModulos()
    {
        return modulos;
    }

    /**
     * @param modulos the modulos to set
     */
    public void setModulos(List<Modulo> modulos)
    {
        this.modulos = modulos;
    }
    

}