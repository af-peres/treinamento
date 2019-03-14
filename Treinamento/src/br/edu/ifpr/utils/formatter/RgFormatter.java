package br.edu.ifpr.utils.formatter;

import br.edu.ifpr.utils.validator.RgValidator;

public class RgFormatter
{
    public static String formatRg(final String rg) {
        if (!RgValidator.isRG(rg)) return rg;

        return (new StringBuilder()).append(rg.substring(0,1))
                                    .append('.')
                                    .append(rg.substring(1,4))
                                    .append('.')
                                    .append(rg.substring(4, 7))
                                    .append('-')
                                    .append(rg.substring(7))
                                    .toString();
     }
}
