package br.edu.ifpr.utils.formatter;

import br.edu.ifpr.utils.validator.TelefoneValidator;

public class TelefoneFormatter
{
    public static String formatDdd(final String ddd) {
        return formatDdd(ddd,Boolean.FALSE);
     }

     public static String formatDdd(final String ddd, final Boolean appendZero) {
        if (!TelefoneValidator.validateDdd(ddd))
           throw new IllegalArgumentException("FORMAT: DDD inválido");

        String format = appendZero ? "(0%s)" : "(%s)";

        return String.format(format,ddd);
     }

     public static String formatNumero(final String numeroFone) {
        if (!TelefoneValidator.validateNumero(numeroFone))
           throw new IllegalArgumentException("FORMAT: " + numeroFone +
                                              "inválido");
        int pos = 4;

        if (numeroFone.length() == 9) pos = 5;

        return (new StringBuilder()).append(numeroFone.substring(0,pos))
                                    .append('-')
                                    .append(numeroFone.substring(pos))
                                    .toString();
     }

     public static String formatTelefone(final String ddd,
                                         final String numeroFone) {
        return formatTelefone(ddd,Boolean.FALSE,numeroFone);
     }

     public static String formatTelefone(final String ddd,
                                         final Boolean appendZero,
                                         final String numeroFone) {
        return formatDdd(ddd,appendZero) + " " + formatNumero(numeroFone);
     }
}
