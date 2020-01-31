package com.algoritmos.algorithm;

import java.math.BigInteger;

public class Algorithm_DiffieHellman {

	public static void main(String[] args) {
		Algorithm_Fast_Exponentiation fE3 = new Algorithm_Fast_Exponentiation();
		//Encryption
		BigInteger p = new BigInteger ("3389");
		BigInteger alpha = new BigInteger ("10");
		BigInteger A = new BigInteger("3382");
		BigInteger B = new BigInteger("2589");
		BigInteger i = new BigInteger ("1");
		BigInteger i2 = new BigInteger ("1");
		BigInteger a = new BigInteger ("0");
		BigInteger b = new BigInteger ("0");

		while(fE3.fastExp(alpha, i, p).equals(A)){
			a = i;
			i.add(BigInteger.ONE);
		}

		while(fE3.fastExp(alpha, i2, p).equals(B)){
			b = i;
			i.add(BigInteger.ONE);
		}

		BigInteger x = alpha.pow(a.intValue()).mod(p);
		BigInteger y = alpha.pow(b.intValue()).mod(p);
		
		
		System.out.println("x : " + x);
		System.out.println("y : " + y);
		
		//Decryption
		BigInteger ka = y.pow(a.intValue()).mod(p);
		BigInteger kb = x.pow(b.intValue()).mod(p);
		
		System.out.println("Shared secret: " + ka);
		System.out.println("Shared secret: " + kb);
		
		bruteForce(alpha, p, A, B);
	}
	
	public static void bruteForce(BigInteger alpha, BigInteger p, BigInteger A, BigInteger B) {
		int a = 0, b = 0;
		for(int i = 0; i < p.intValue(); i++) {
			if(alpha.pow(i).mod(p).compareTo(A) == 0) {
				a = i;
				System.out.println("a = " + a);
			}
			if(alpha.pow(i).mod(p).compareTo(B) == 0) {
				b = i;
				System.out.println("b = " + b);
			}
		}
		
		BigInteger x = alpha.pow(a).mod(p);
		BigInteger y = alpha.pow(b).mod(p);
		System.out.println("Confirmation");
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		
		BigInteger ka = y.pow(a).mod(p);
		BigInteger kb = x.pow(b).mod(p);
		
		System.out.println("Shared secret: " + ka);
		System.out.println("Shared secret: " + kb);
	}
	
	
	

}
