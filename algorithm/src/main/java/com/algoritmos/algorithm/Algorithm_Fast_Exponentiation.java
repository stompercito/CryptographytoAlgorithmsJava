package com.algoritmos.algorithm;
import java.math.BigInteger;

class Algorithm_Fast_Exponentiation {

    public BigInteger fastExp(BigInteger a, BigInteger n, BigInteger z) {
        //a^n mod z

        BigInteger resultado = BigInteger.ONE;
        BigInteger DOS = new BigInteger("2");
        BigInteger x = a.mod(z);

        while(!n.equals(BigInteger.ZERO)){
            if((n.mod(DOS)).equals(BigInteger.ONE)){
                resultado = (resultado.multiply(x).mod(z));
            }
            x = (x.multiply(x).mod(z));
            n = n.divide(DOS);
        }

        return resultado;
        
    }

    public static void main(String[] args) {
        Algorithm_Fast_Exponentiation fE = new Algorithm_Fast_Exponentiation();
        
        BigInteger a = new BigInteger("380");
        BigInteger n = new BigInteger("65537");
        BigInteger m = new BigInteger("401");
        BigInteger y = fE.fastExp(a, n, m);
        System.out.println("Resultado = " + y);
    }
}
