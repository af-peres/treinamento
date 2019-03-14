package br.edu.ifpr.treinamento.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import br.edu.ifpr.treinamento.modelo.types.CursoSituacaoType;

@Entity
public class Curso {
    
    @Id
    @Column(name="CURSO_CODIGO", nullable=false, length=5)
    private String codigo;
    
    @Column(name="CURSO_NOME", nullable=false)
    private String nome;
    
    @Enumerated(value=EnumType.ORDINAL)
    @Column(name="CURSO_TIPO", nullable=false)
    private CursoSituacaoType situacao;
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="MOD_CURSO_CODIGO", referencedColumnName="CURSO_CODIGO")
    private List<Modulo> modulos;
    
    @OneToMany(mappedBy="curso", fetch=FetchType.EAGER)
    private List<Matricula> matriculas;
    
    public Curso() {
        this.modulos = new ArrayList<>();
    }
    
    public Curso(String codigo, String nome, CursoSituacaoType situacao, List<Modulo> modulos) {
        this.codigo   = codigo;
        this.nome     = nome;
        this.situacao = situacao;
        this.modulos  = new ArrayList<>(modulos);
    }

    @Override
    public String toString() {
        return "Curso [codigo=" + codigo + ", nome=" + nome + ", situacao=" + situacao + ", modulos=" + modulos.size()
                + ", matriculas=" + matriculas.size() + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        result = prime * result + ((matriculas == null) ? 0 : matriculas.hashCode());
        result = prime * result + ((modulos == null) ? 0 : modulos.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((situacao == null) ? 0 : situacao.hashCode());
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
        Curso other = (Curso) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        if (matriculas == null) {
            if (other.matriculas != null)
                return false;
        } else if (!matriculas.equals(other.matriculas))
            return false;
        if (modulos == null) {
            if (other.modulos != null)
                return false;
        } else if (!modulos.equals(other.modulos))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (situacao != other.situacao)
            return false;
        return true;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CursoSituacaoType getSituacao() {
        return situacao;
    }

    public void setSituacao(CursoSituacaoType situacao) {
        this.situacao = situacao;
    }

    public List<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }
    
}