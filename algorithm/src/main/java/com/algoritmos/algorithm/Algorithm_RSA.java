package com.algoritmos.algorithm;

import java.math.BigInteger;
//import java.util.ArrayList;
//import java.util.List;

public class Algorithm_RSA {
    Algorithm_Phi_Euler phiT = new Algorithm_Phi_Euler();

    public BigInteger llave_privada_ne(BigInteger n, BigInteger e) {

        BigInteger d = e.modInverse(phiT.phiEulerEficient(n));
        if (d.compareTo(BigInteger.valueOf(0)) < 0) {
            BigInteger phi = phiT.phiEulerEficient(n);
            d = d.mod(phi);
            return d;
        }

        return d;

    }

    public BigInteger desencryptar_mensaje_rsa(BigInteger n, BigInteger e, BigInteger y) {

        BigInteger d = llave_privada_ne(n, e);
        // Realizamos la encriptación
        BigInteger x = y.modPow(d, n);

        return x;
    }

    public static void main(String[] args) {

         // Esta parte hace la fórmula para encriptar o desencriptar RSA
        
        Algorithm_Euclides gcdA = new Algorithm_Euclides();
        Algorithm_Euclides_Extended gcdE = new Algorithm_Euclides_Extended();
        Algorithm_Fast_Exponentiation fE2 = new Algorithm_Fast_Exponentiation();
        //Cripto sistema
        BigInteger M = new BigInteger("2115163475"); //Mensaje

        BigInteger prime1 = new BigInteger("65809"); //p
        BigInteger prime2 = new BigInteger("65827"); //q

        //BigInteger n = prime1.multiply(prime2); //n
        BigInteger n = new BigInteger("4348083479"); //n

        BigInteger e = new BigInteger("199"); //e
        
        //Comprobar e
        prime1 = prime1.subtract(new BigInteger("1")); 
        prime2 = prime2.subtract(new BigInteger("1"));
        BigInteger phiN = prime1.multiply(prime2); 
        System.out.println("e = " + e);
        System.out.println("Comprobación: e = " + gcdA.gcd(e.intValue(),phiN.intValue()));
        
        //Cifrado
        BigInteger x = M;
        
        BigInteger y = fE2.fastExp(x, e, n);
        System.out.println("El mensaje cifrado es = " + y);
        
        //Calcular d
        BigInteger d = gcdE.euclidesEx(e, phiN);
        if(d.compareTo(BigInteger.valueOf(0)) < 0 ){
            d = d.mod(phiN);
        }
        //comprobar d
        BigInteger temp = e.multiply(d); 
        System.out.println("d = " + d);
        BigInteger mod = temp.mod(phiN); 
        System.out.println("Comprobación: d" + " = " + mod);
        
        //Decifrado
        x = fE2.fastExp(M, d, n);
        System.out.println("El mensaje decifrado es = " + x);

        
    }
}
