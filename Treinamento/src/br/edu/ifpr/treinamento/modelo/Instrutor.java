package br.edu.ifpr.treinamento.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
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
        this.modulos = new ArrayList();
    }

    public Instrutor(String cpf, String nome, String rg, Date nascimento, SexoType sexo, PessoaType tipo,
            List<Telefone> fones)
    {
        super(cpf, nome, rg, nascimento, sexo, tipo, fones);
    }

    public Instrutor(String cpf, String nome, String rg, Date nascimento, SexoType sexo, PessoaType tipo, Telefone fone)
    {
        super(cpf, nome, rg, nascimento, sexo, tipo, fone);
    }

    public Instrutor(String cpf, String nome, String rg, String email, Date nascimento, SexoType sexo, PessoaType tipo,
            Endereco endereco, List<Telefone> fones)
    {
        super(cpf, nome, rg, email, nascimento, sexo, tipo, endereco, fones);
    }

    public Instrutor(String cpf, String nome, String rg, String email, Date nascimento, SexoType sexo, PessoaType tipo,
            Endereco endereco, Telefone fone,String cod)
    {
        super(cpf, nome, rg, email, nascimento, sexo, tipo, endereco, fone);
        this.codigo = cod;
    }

    public Instrutor(String cpf, String nome, String rg, String email, Date nascimento, SexoType sexo, PessoaType tipo,
            Telefone fone)
    {
        super(cpf, nome, rg, email, nascimento, sexo, tipo, fone);
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

    @Override
    public String toString()
    {
        return "Instrutor [codigo=" + codigo + ", modulos=" + modulos.size() + ", " + super.toString() + "]";
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    /*@Override
    public String toString()
    {
        return "Instrutor [codigo=" + codigo + ", modulos=" + modulos.size() + ", " + super.toString() + "]";
    }*/
    
    
    
    
    

}