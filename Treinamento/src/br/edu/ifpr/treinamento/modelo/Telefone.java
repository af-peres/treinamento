package br.edu.ifpr.treinamento.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.edu.ifpr.treinamento.modelo.types.TelefoneType;

@Entity
public class Telefone
{
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="END_ID")
    private Long id;
    
    @Column(name="TEL_DDD",nullable=false,length=2)
    private String ddd;
    
    @Column(name="TEL_NUMERO",nullable=false)
    private String numero;
    
    @Enumerated(value=EnumType.ORDINAL)
    @Column(name="TEL_tipo",nullable=false)
    TelefoneType tipo;

    public Telefone(String ddd, String numero, TelefoneType tipo)
    {
        this.ddd = ddd;
        this.numero = numero;
        this.tipo = tipo;
    }

    public Telefone()
    {
        
    }

}