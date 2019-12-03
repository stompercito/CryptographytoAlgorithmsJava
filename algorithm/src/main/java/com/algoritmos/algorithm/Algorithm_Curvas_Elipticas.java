package com.algoritmos.algorithm;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


//Fórmula del negativo = (x, prime - y mod prime)
public class Algorithm_Curvas_Elipticas {
	private static BigInteger p = new BigInteger("11");
	private static BigInteger a = new BigInteger("1");

	public static void main(String[] args) {
//		BigInteger x;
//		BigInteger y;

		BigInteger b = new BigInteger("6");

		
		//Example		
		List<List<BigInteger>> tabla = new ArrayList<List<BigInteger>>();
		BigInteger first;
		BigInteger second;
		BigInteger third;
		
		int middle = 0;
		int flag = 0;
		List<List<Integer>> tablaY = new ArrayList<List<Integer>>();
		List<Integer> rowY;
		
		for(int i = 0; i < p.intValue(); i++) {
			List<BigInteger> row = new ArrayList<BigInteger>();
			first = new BigInteger(String.format("%d", i));
			row.add(first);
			second = first.pow(2).mod(p);
			row.add(second);
			third = first.pow(3).add(a.multiply(first)).add(b).mod(p);
			row.add(third);	
			tabla.add(row);
			System.out.println(row);
			if(i == 0) {
				continue;
			} else if ((middle <= (p.intValue()-1)/2) && flag == 0) {
				rowY = new ArrayList<Integer>();
				rowY.add(row.get(1).intValue());
				rowY.add(row.get(0).intValue());
				tablaY.add(rowY);
				middle++;
			} 
			
			if(middle == ((p.intValue()-1)/2)+1){
				flag = 1;
				middle -= 2;
			} 
			
			if(middle < (p.intValue()-1)/2 && flag == 1){
				rowY = tablaY.get(middle);
				rowY.add(row.get(0).intValue());
				System.out.println("New row"  + rowY);
				middle--;
			}			

		}
		tablaY.remove(tablaY.size()-1);
		System.out.println(tablaY);
		
		List<List<Integer>> puntos = new ArrayList<List<Integer>>();
		List<Integer> p1;
		List<Integer> p2;
		int x3;
		
		for(int i = 0; i < p.intValue();i++) {
			x3 = tabla.get(i).get(2).intValue();
			for(int j = 0; j < tablaY.size(); j++) {
				if(x3 == tablaY.get(j).get(0).intValue()) {
					p1 = new ArrayList<Integer>();
					p1.add(tabla.get(i).get(0).intValue());
					p1.add(tablaY.get(j).get(1));
					p2 = new ArrayList<Integer>();
					p2.add(tabla.get(i).get(0).intValue());
					p2.add(tablaY.get(j).get(2));
					puntos.add(p1);
					puntos.add(p2);
				}
			}
		}
		
		System.out.println("Los puntos son: " + puntos);
		System.out.println("Cantidad de puntos: " + puntos.size());
		
		BigInteger x1 = new BigInteger("278");
		BigInteger y1 = new BigInteger("285");
		BigInteger x2 = new BigInteger("278");
		BigInteger y2 = new BigInteger("285");
		
		multiplyPoints(x1, y1, x2, y2, puntos);
		System.out.println("Puntos Final: " + puntos);
	}
	
	public static void multiplyPoints(BigInteger x1, BigInteger y1, BigInteger x2, BigInteger y2, List<List<Integer>> puntos) {
		BigInteger s;
		Algorithm_Euclides_Extended egcd = new Algorithm_Euclides_Extended();
		BigInteger two = new BigInteger ("2");
		BigInteger three = new BigInteger ("3");
		int sizeP = puntos.size();
		System.out.println("P = (" + x1 + ", " + y1 + ")");
		for(int i = 1; i < sizeP; i++) {
			if(x1.equals(x2) && y1.equals(y2)) {
				s = x1.pow(2).multiply(three).add(a).multiply(egcd.euclidesEx(two.multiply(y1), p)).mod(p);
				
			} else {
				s = y2.subtract(y1).multiply(egcd.euclidesEx(x2.subtract(x1), p)).mod(p);
			}
			
			BigInteger x3 = s.pow(2).subtract(x1).subtract(x2).mod(p);
			BigInteger y3 = s.multiply(x1.subtract(x3)).subtract(y1).mod(p);
			
			x2 = x3;
			y2 = y3;
			
			//Esta es una prueba
			
			
			for(int j = 0; j < puntos.size(); j++) {				
				if((puntos.get(j).get(0).intValue() == x3.intValue()) && (puntos.get(j).get(1).intValue() == y3.intValue())) {
					puntos.remove(j);
					break;
				}				
			}	
			System.out.println("P" + (i+1) + " = (" + x3 + ", " + y3 + ")");
			
			if(puntos.size() == 1) {
				break;
			}
			
			
		}

		
	}

}
