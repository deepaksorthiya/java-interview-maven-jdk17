package com.example.corejava;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class DoubleDecimalFormat {

    public static void main(String[] args) {
        double input = 3.14159265359;
        final DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("double : " + input);
        System.out.println("double : " + df.format(input));    //3.14

        // DecimalFormat, default is RoundingMode.HALF_EVEN
        df.setRoundingMode(RoundingMode.DOWN);
        System.out.println("\ndouble (RoundingMode.DOWN) : " + df.format(input));  //3.14

        df.setRoundingMode(RoundingMode.UP);
        System.out.println("double (RoundingMode.UP)  : " + df.format(input));    //3.15
    }
}
