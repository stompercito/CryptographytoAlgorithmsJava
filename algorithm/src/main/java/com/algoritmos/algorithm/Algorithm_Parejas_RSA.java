package com.algoritmos.algorithm;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Algorithm_Parejas_RSA {
	public void parejas(int p, int q) {
		Algorithm_Euclides gcd = new Algorithm_Euclides();
		int phi = (p-1)*(q-1);
		//int n = p * q;
		
		List<BigInteger> numeros = new ArrayList<>();
		BigInteger phiBig = new BigInteger(String.format("%d", phi));
		BigInteger inv;
		
		//gcd(num, phi(n)) = 1
		for(int i = 2; i < phi; i++) {
			int x = gcd.gcd(i, phi);
			if(x==1) {
				BigInteger number = new BigInteger(String.format("%d", i));
				/*if(number.isProbablePrime(1)) {
					numeros.add(new BigInteger(number.toString()));
				}	*/
				numeros.add(new BigInteger(number.toString()));
			}
		}
				
		System.out.println(numeros);
		Algorithm_Euclides_Extended ea = new Algorithm_Euclides_Extended();
		List<List<BigInteger>> parejasNum = new ArrayList<>();
		
		//Posibles parejas
		for(int i = 0; i < numeros.size(); i++) {
			inv = ea.euclidesEx(numeros.get(i), phiBig);
			if(inv.compareTo(numeros.get(i)) == 0) {
				System.out.println(numeros.get(i) + " es inverso de sí mismo");
				continue;
			} else {
				List<BigInteger> nums = new ArrayList<>();
				nums.add(numeros.get(i));
				nums.add(inv);
				parejasNum.add(nums);
				numeros.remove(inv);
			}
			//System.out.println(parejasNum);
		}
		
		System.out.println(parejasNum);
		
		
	}
}
