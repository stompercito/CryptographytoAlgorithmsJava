package com.algoritmos.algorithm;

import java.math.BigInteger;
//import java.util.ArrayList;
//import java.util.List;

public class Algorithm_RSA {

    public static void main(String[] args) {

         // Esta parte hace la fórmula para encriptar o desencriptar RSA
        
        Algorithm_Euclides gcdA = new Algorithm_Euclides();
        Algorithm_Euclides_Extended gcdE = new Algorithm_Euclides_Extended();
        Algorithm_Fast_Exponentiation fE2 = new Algorithm_Fast_Exponentiation();
        //Cripto sistema
        BigInteger M = new BigInteger("2"); //Mensaje

        BigInteger prime1 = new BigInteger("31"); //p
        BigInteger prime2 = new BigInteger("17"); //q

        BigInteger n = prime1.multiply(prime2); //n

        BigInteger e = new BigInteger("7"); //e
        
        //Comprobar e
        prime1.subtract(new BigInteger("1")); 
        prime2.subtract(new BigInteger("1"));
        BigInteger phiN = prime1.multiply(prime2); 
        System.out.println("e = " + e);
        System.out.println("Comprobación: e = " + gcdA.gcd(e.intValue(),phiN.intValue()));
        
        //Cifrado
        BigInteger x = M;
        
        BigInteger y = fE2.fastExp(x, e, n);
        System.out.println("El mensaje cifrado es = " + y);
        
        //Calcular d
        BigInteger d = gcdE.euclidesEx(e, phiN);
        //comprobar d
        BigInteger temp = e.multiply(d); 
        System.out.println("d = " + d);
        BigInteger mod = temp.mod(phiN); 
        System.out.println("Comprobación: d" + " = " + mod);
        
        //Decifrado
        x = fE2.fastExp(y, d, n);
        System.out.println("El mensaje decifrado es = " + x);

        
    }
}
