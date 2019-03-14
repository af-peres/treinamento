package br.edu.ifpr.treinamento.modelo.ids;

import java.io.Serializable;

public class MatriculaId implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String curso;
    private String aluno;

   public MatriculaId() {
    
   }
   
    public MatriculaId(String codigo, String cpf) {
        this.curso = codigo;
        this.aluno    = cpf;
    }

    public String getAluno() {
        return aluno;
    }
    
    public void setAluno(String cpf) {
        this.aluno = cpf;
    }
    public String getCodigo() {
        return curso;
    }
    public void setCodigo(String codigo) {
        this.curso = codigo;
    }

}
