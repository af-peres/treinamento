package br.edu.ifpr.treinamento.modelo;

import java.util.Date;

public class Modulo
{
    private String nome;
    private Integer duracao;
    private java.util.Date inicio;
    private Instrutor instrutor;
    
    
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


    public Modulo(String nome, Integer duracao, Date inicio, Instrutor instrutor)
    {
        this.nome = nome;
        this.duracao = duracao;
        this.inicio = inicio;
        this.instrutor = instrutor;
    }


    public Modulo()
    {
        // TODO Auto-generated constructor stub
    }
}
