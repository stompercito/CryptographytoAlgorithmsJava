package com.algoritmos.algorithm;

import java.io.FileNotFoundException;
import java.math.BigInteger;

public class Algorithms_Exam {
	public static void main(String[] args) throws FileNotFoundException{
		//Algoritmo 1 = Ceaesar Cipher
		System.out.println("-------------Algoritmo 1 = Ceaesar Cipher--------------");
		String in = "VCTFU ZXFJV TIVKF UVVJK VVORD VEVJR OIPYE";
		
		Algorithm_Cipher_Cesar ce = new Algorithm_Cipher_Cesar();

		ce.cesar(in);
		
		//Algoritmo 2 = EGCD
		System.out.println("-------------Algoritmo 2 = EGCD--------------");
		BigInteger one = new BigInteger("1");
		BigInteger p = new BigInteger("65809");
		BigInteger q = new BigInteger("65827");
		BigInteger e = new BigInteger("199");
		BigInteger n = p.multiply(q);
		BigInteger pM = p.subtract(one);
		System.out.println("pM " + pM);
		BigInteger qM = q.subtract(one);
		System.out.println("qM " + qM);
		BigInteger phi = pM.multiply(qM);
		System.out.println("PhiN " + phi);
		Algorithm_Euclides_Extended gcdE = new Algorithm_Euclides_Extended();
		BigInteger a = new BigInteger(e.toString()); //Número menor
		BigInteger b = new BigInteger(phi.toString()); //Número mayor (módulo)
		BigInteger c = gcdE.euclidesEx(a, b);
		System.out.println("Llave " + c);

		//Algoritmo 3 = Decifrar mensaje RSA
		System.out.println("-------------Algoritmo 3 = Decifrar mensaje RSA--------------");
		Algorithm_RSA de = new Algorithm_RSA();
		BigInteger n2 = new BigInteger("4348083479"); //n
		BigInteger e2 = new BigInteger("199"); //e
		BigInteger y2 = new BigInteger("2115163475"); //Mensaje cifrado
		System.out.println(de.desencryptar_mensaje_rsa(n2, e2, y2)); //(primo menor, primo mayor)
		
		//Algoritmo 4 = Algoritmo para encontrar los pares de llaves en RSA
		System.out.println("-------------Algoritmo 4 = Algoritmo para encontrar los pares de llaves en RSA--------------");
		Algorithm_Parejas_RSA rsa = new Algorithm_Parejas_RSA();
		rsa.parejas(3, 11); //(primo menor, primo mayor)
		
		//Algoritmo 5 = Algoritmo para encontrar el órden de los elementos de un grupo (DLP)
		System.out.println("-------------Algoritmo 5 = Algoritmo para encontrar el órden de los elementos de un grupo (DLP)--------------");
		BigInteger prime = new BigInteger("11");
		Algorithmn_DLP_Order orden = new Algorithmn_DLP_Order();
		orden.encontrarOrden(prime); //(número primo)
	
		//Algoritmo 6 = Algoritmo para atacar un intercambio de llaves Diffie-Hellman
		System.out.println("-------------Algoritmo 6 = Algoritmo para atacar un intercambio de llaves Diffie-Hellman--------------");
		
		BigInteger prueba  = new BigInteger("65951");
		System.out.println("Es primo? = " +  prueba.isProbablePrime(0));
		
		//Algoritmo 6 = Algoritmo para encontrar los puntos de una curva elíptica
		System.out.println("-------------Algoritmo 6 = Algoritmo para encontrar los puntos de una curva elíptica--------------");
		
		
		//Algoritmo 7 = Algoritmo para multiplicar un punto de una curva elíptica
		System.out.println("-------------Algoritmo 7 = Algoritmo para multiplicar un punto de una curva elíptica--------------");
		
	}
}
