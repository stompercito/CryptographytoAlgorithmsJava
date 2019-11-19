package com.algoritmos.algorithm;
import java.math.BigInteger;

class Algorithm_Euclides_Extended {

    public BigInteger euclidesEx(BigInteger a, BigInteger b) {

        BigInteger b_Original = b;
        BigInteger[] x = new BigInteger[2];
        BigInteger[] y = new BigInteger[2];
        BigInteger q, r, xx, yy;
        int sign;
        // Initializes the coefficients
        x[0] = BigInteger.ONE;
        x[1] = BigInteger.ZERO;
        y[0] = BigInteger.ZERO;
        y[1] = BigInteger.ONE;
        sign = 1;
        // As long as b != 0 we replace a by b and b by a % b.
        while (!b.equals(BigInteger.ZERO)) {
            r = a.mod(b);
            q = a.divide(b);
            a = b;
            b = r;
            xx = x[1];
            yy = y[1];
            x[1] = (q.multiply(x[1]).add(x[0]));
            y[1] = (q.multiply(y[1]).add(y[0]));
            x[0] = xx;
            y[0] = yy;
            sign = -sign;
        }
        // Final computation of the coefficients
        BigInteger zero = new BigInteger("0");

        x[0] = x[0].multiply(new BigInteger(String.valueOf(sign)));
        y[0] = y[0].multiply(new BigInteger(String.valueOf(-sign)));
        //System.out.println(" x : " + x[0]);
        //System.out.println(" y : " + y[0]);

        if (x[0].compareTo(zero) < 0) {
            return b_Original.add(x[0]);
        } else {          
            return x[0];
        }
    }

    public static void main(String[] args) {
        // Número Entero.
        BigInteger a = new BigInteger("7"); 
        // Número Módulo.
        BigInteger b = new BigInteger("20"); 
        Algorithm_Euclides_Extended ejemplo = new Algorithm_Euclides_Extended();
        System.out.println("The inverse is: " + ejemplo.euclidesEx(a, b));
    }
}
