package com.algoritmos.algorithm;

import java.math.BigInteger;

public class Algorithm_DiffieHellman {

	public static void main(String[] args) {
		//Encryption
		BigInteger p = new BigInteger ("3989");
		BigInteger alpha = new BigInteger ("10");
		BigInteger a = new BigInteger ("4");
		BigInteger b = new BigInteger ("3");
		BigInteger x = alpha.pow(a.intValue()).mod(p);
		BigInteger y = alpha.pow(b.intValue()).mod(p);
		BigInteger A = new BigInteger("3382");
		BigInteger B = new BigInteger("2589");
		
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
