package br.edu.ifpr.treinamento.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.edu.ifpr.treinamento.modelo.ids.MatriculaId;
import br.edu.ifpr.utils.date.DateTimeUtils;

@Entity
@IdClass(MatriculaId.class)
public class Matricula
{
    @Id @ManyToOne
    @JoinColumn(name="MAT_CURSO_CODIGO", referencedColumnName="CURSO_CODIGO")
    private Curso curso;
    
    @Id @ManyToOne
    @JoinColumn(name="MAT_PES_CPF", referencedColumnName="PES_CPF")
    private Aluno aluno;
    
    @Temporal(value=TemporalType.DATE)
    @Column(name="MAT_DT_DTMAT")
    private java.util.Date dataMatricula;

    public Matricula()
    {
        // TODO Auto-generated constructor stub
    }
    
    public Matricula(Curso curso, Aluno aluno, Date dataMatricula) {
        this.curso        = curso;
        this.aluno        = aluno;
        this.dataMatricula = dataMatricula;
    }

    @Override
    public String toString() {
        return "Matricula [curso=" + curso.getNome() + ", aluno=" + aluno.getNome() + ", dataMatricula=" + DateTimeUtils.formatDate(dataMatricula) + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((aluno == null) ? 0 : aluno.hashCode());
        result = prime * result + ((curso == null) ? 0 : curso.hashCode());
        result = prime * result + ((dataMatricula == null) ? 0 : dataMatricula.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Matricula other = (Matricula) obj;
        if (aluno == null) {
            if (other.aluno != null)
                return false;
        } else if (!aluno.equals(other.aluno))
            return false;
        if (curso == null) {
            if (other.curso != null)
                return false;
        } else if (!curso.equals(other.curso))
            return false;
        if (dataMatricula == null) {
            if (other.dataMatricula != null)
                return false;
        } else if (!dataMatricula.equals(other.dataMatricula))
            return false;
        return true;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }
}
