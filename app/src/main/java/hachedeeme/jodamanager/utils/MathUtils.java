package hachedeeme.jodamanager.utils;

import java.text.DecimalFormat;

/**
 * Created by Hache on 06/03/2015.
 */
public class MathUtils {
    public static Double roundTwoDecimals(Double aDouble){
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.valueOf(df.format(aDouble));
    }
}
