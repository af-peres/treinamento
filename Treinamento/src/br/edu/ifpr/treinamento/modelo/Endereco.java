package br.edu.ifpr.treinamento.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.edu.ifpr.treinamento.modelo.types.EnderecoType;
import br.edu.ifpr.treinamento.modelo.types.UfType;
import br.edu.ifpr.utils.formatter.CepFormatter;

@Entity
public class Endereco
{
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="END_ID")
    private Long id;
    
    @Column(name="END_LOGRADOURO",nullable=false)
    private String logradouro;
    @Column(name="END_NUMERO")
    private String numero;
    @Column(name="END_COMPLEMENTO")
    private String complemento;
    @Column(name="END_BAIRRO")
    private String bairro;
    @Column(name="END_CEP")
    private String cep;
    @Column(name="END_CIDADE")
    private String cidade;
    @Column(name="END_UF")
    private UfType uf;
    @Column(name="END_tipo")
    private EnderecoType tipo;

    public Endereco()
    {
        
    }

    public Endereco(String logradouro, String numero, String complemento, String bairro, String cep, String cidade,
            UfType uf, EnderecoType endereco)
    {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = CepFormatter.formatCep(cep);
        this.cidade = cidade;
        this.uf = uf;
        this.tipo = endereco;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return " [logradouro=" + logradouro + ", numero=" + numero + ", complemento=" + complemento
                + ", bairro=" + bairro + ", cep=" + cep + ", cidade=" + cidade + ", uf=" + uf + ", tipo=" + tipo + "]";
    }

}