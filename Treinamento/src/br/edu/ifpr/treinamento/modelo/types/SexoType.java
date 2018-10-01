package br.edu.ifpr.treinamento.modelo.types;

public enum SexoType
{
    MASCULINO(1),
    FEMININO(2);
    
    private int codigo;
    
    SexoType(int codigo)
    {
        this.codigo = codigo;
    }
}
