package br.edu.ifpr.treinamento.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.edu.ifpr.utils.date.DateTimeUtils;

@Entity
public class Modulo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOD_ID", nullable = false)
    private Long id;

    @Column(name = "MOD_NOME")
    private String nome;

    @Column(name = "MOD_DURACAO")
    private Integer duracao;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "MOD_DT_INIC", nullable = false)
    private java.util.Date inicio;

    @OneToOne(optional = true)
    @JoinColumn(name = "MOD_INSTR_CPF", referencedColumnName = "PES_CPF")
    private Instrutor instrutor;

    public Modulo()
    {
        
    }
    
    public Modulo(String nome, Integer duracao, Date inicio, Instrutor instrutor)
    {
        this.nome = nome;
        this.duracao = duracao;
        this.inicio = inicio;
        this.instrutor = instrutor;
    }

    /**
     * @return the nome
     */
    public String getNome()
    {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome)
    {
        this.nome = nome;
    }

    /**
     * @return the duracao
     */
    public Integer getDuracao()
    {
        return duracao;
    }

    /**
     * @param duracao the duracao to set
     */
    public void setDuracao(Integer duracao)
    {
        this.duracao = duracao;
    }

    /**
     * @return the inicio
     */
    public java.util.Date getInicio()
    {
        return inicio;
    }

    /**
     * @param inicio the inicio to set
     */
    public void setInicio(java.util.Date inicio)
    {
        this.inicio = inicio;
    }

    /**
     * @return the instrutor
     */
    public Instrutor getInstrutor()
    {
        return instrutor;
    }

    /**
     * @param instrutor the instrutor to set
     */
    public void setInstrutor(Instrutor instrutor)
    {
        this.instrutor = instrutor;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "Modulo [nome=" + nome + ", duracao=" + duracao + ", inicio=" + DateTimeUtils.formatDate(inicio) + ", " + instrutor
                + "]";
    }


    
}
