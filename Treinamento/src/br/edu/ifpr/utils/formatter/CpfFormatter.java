package br.edu.ifpr.utils.formatter;

import br.edu.ifpr.utils.validator.CpfValidator;

public class CpfFormatter
{
    public static String formatCpf(final String cpf) {
        if (!CpfValidator.isCPF(cpf))
           throw new IllegalArgumentException("FORMAT: CPF inválido");

        return (new StringBuilder()).append(cpf.substring(0,3))
                                    .append('.')
                                    .append(cpf.substring(3,6))
                                    .append('.')
                                    .append(cpf.substring(6, 9))
                                    .append('-')
                                    .append(cpf.substring(9))
                                    .toString();
     }
}
