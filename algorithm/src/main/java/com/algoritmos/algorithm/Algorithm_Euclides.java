package com.algoritmos.algorithm;
  
class Algorithm_Euclides { 
  
    // Function to return GCD of a and b 
    public int gcd(int a, int b) 
    { 
        if (a == 0) 
            return b; 
        return gcd(b % a, a); 
    } 
  
    //Euler Totient Function 
    public int phi(int n) 
    { 
        int result = 1; 
        for (int i = 2; i < n; i++) 
            if (gcd(i, n) == 1) 
                result++; 
        return result; 
    } 
  
    // Driver code 
    public static void main(String[] args) 
    { 
        Algorithm_Euclides ejemplo = new Algorithm_Euclides();

        //Insciso 1
        System.out.println(ejemplo.gcd(2091, 4807));
        System.out.println(ejemplo.gcd(2475, 32670));
        System.out.println(ejemplo.gcd(67942, 4209));
        System.out.println(ejemplo.gcd(490256, 337));

        System.out.println();

        //Insciso 2
        System.out.println(ejemplo.phi(20));
        System.out.println(ejemplo.phi(37));
        System.out.println(ejemplo.phi(503));
        System.out.println(ejemplo.phi(650));
        System.out.println(ejemplo.phi(809));

        
        /*for (int n = 1; n <= 10; n++) 
            System.out.println("phi(" + n + ") = " + phi(n)); 
        //*/
    } 
} 