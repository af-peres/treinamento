package br.edu.ifpr.utils.validator;

public class CepValidator
{
    public static boolean validateCep(final String cep) {
        for (char c : cep.toCharArray())
           if (!Character.isDigit(c))
              return false;

        return true;
     }
}
