// Checa si es primo...
package com.algoritmos.algorithm;

import java.math.BigInteger;

class Algorithm_Is_Prime {
  
    static boolean isPrime(BigInteger n) 
    { 
        BigInteger i = new BigInteger("5");
        BigInteger DOS = new BigInteger("2");
        BigInteger TRES = new BigInteger("3");
        BigInteger SEIS = new BigInteger("6");
        // Casos de las esquinas
        if (n.compareTo(BigInteger.ONE) == -1 || n.equals(BigInteger.ONE)) 
            return false; 
        if (n.compareTo(TRES) == -1 || n.equals(TRES)) 
            return true; 
  
        if ((n.mod(DOS)).equals(BigInteger.ZERO) || (n.mod(TRES)).equals(BigInteger.ZERO)) 
            return false; 
  
        for (; i.multiply(i).compareTo(n) == -1 || i.multiply(i).equals(n); i = i.add(SEIS)) 
            if ((n.mod(i)).equals(BigInteger.ZERO) || (n.mod(i.add(DOS))).equals(BigInteger.ZERO)) 
                return false; 
  
        return true; 
    } 
  
    // Driver Program 
    public static void main(String args[]) 
    { 
    	BigInteger x;
    	String nums [] = {"4001", "19537", "9001", "5001", "32771", "32773", "9500021", "34359738423", "34359738421"};
    	 
    	for(int i = 0; i < nums.length; i++) {
    		x = new BigInteger(nums[i]);
            if (isPrime(x)) 
                System.out.println(x + " is prime"); 
            else
                System.out.println(x + " is composite"); 
    	}

    } 
}