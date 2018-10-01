package br.edu.ifpr.utils.validator;

public class TelefoneValidator
{
    public static boolean validateDdd(final String ddd) {
        if (ddd == null || ddd.isEmpty() || ddd.length() != 2)
           return false;

        char c1 = ddd.charAt(0);
        char c2 = ddd.charAt(1);

        return (Character.isDigit(c1) && Character.isDigit(c2));
     }

     public static boolean validateNumero(final String numero) {
        if (numero == null || numero.isEmpty() ||
            (numero.length() != 8 && numero.length() != 9)
           )
           return false;

        for (char c : numero.toCharArray())
           if (!Character.isDigit(c))
              return false;

        return true;
     }

     public static boolean validate(final String ddd, final String numero) {
        return validateDdd(ddd) && validateNumero(numero);
     }
}
