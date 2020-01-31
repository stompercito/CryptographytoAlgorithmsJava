package com.algoritmos.algorithm;

import java.math.BigInteger;

/**
Algoritmo para encontrar el órden de los elementos de un grupo ( DLP )
*/
public class Algorithmn_DLP_Order {
	public void encontrarOrden(BigInteger prime) {
		BigInteger one = new BigInteger ("1");
		int acc = 1;
		int generators = 0;
		for(int i = 2; i < prime.intValue() ; i++) {
			BigInteger iB = new BigInteger(String.format("%d", i));
			for(int j = 1; j <= prime.intValue() ; j++) {
				BigInteger jB = new BigInteger(String.format("%d", j));
				//System.out.print(iB.pow(j).mod(prime) + " ");
				if(iB.pow(j).mod(prime).compareTo(one) == 0) {
					System.out.println("|||| " + i + " : " + acc);
					if(acc == (prime.intValue() -1)) {
						generators++;
					}
					//generators++;
					acc = 1;
					break;
				} else {
					acc++;
				}
			}
		}
		System.out.println("# of generators: " + generators);
	}
	
	public static void discreteLog(int b, int alpha, int p) {
		
	}
}
