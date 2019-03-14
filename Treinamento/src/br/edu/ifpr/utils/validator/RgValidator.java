package br.edu.ifpr.utils.validator;

public class RgValidator
{

    public static boolean isRG(final String rg)
    {
        if(!(rg.length() == 9))
            return false;
            
        for (char c : rg.toCharArray())
            if (!Character.isDigit(c))
               return false;
         return true;
    }

}
