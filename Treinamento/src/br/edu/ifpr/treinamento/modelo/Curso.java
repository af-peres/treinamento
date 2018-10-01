package br.edu.ifpr.treinamento.modelo;

import br.edu.ifpr.treinamento.modelo.types.CursoSituacaoType;

public class Curso
{
    private String codigo,nome;
    private CursoSituacaoType situacao;
    
    public Curso()
    {
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
     * @return the situacao
     */
    public CursoSituacaoType getSituacao()
    {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(CursoSituacaoType situacao)
    {
        this.situacao = situacao;
    }

    public Curso(String codigo, String nome, CursoSituacaoType situacao)
    {
        this.codigo = codigo;
        this.nome = nome;
        this.situacao = situacao;
    }

}
