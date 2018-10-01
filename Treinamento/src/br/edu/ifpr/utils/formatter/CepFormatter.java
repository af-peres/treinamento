package br.edu.ifpr.utils.formatter;

import br.edu.ifpr.utils.validator.CepValidator;

public class CepFormatter
{
    public static String formatCep(final String cep) {
        if (!CepValidator.validateCep(cep))
           throw new IllegalArgumentException("FORMAT: CEP inválido");

        return (new StringBuilder()).append(cep.substring(0,5))
                                    .append('-')
                                    .append(cep.substring(5))
                                    .toString();
     }
}
