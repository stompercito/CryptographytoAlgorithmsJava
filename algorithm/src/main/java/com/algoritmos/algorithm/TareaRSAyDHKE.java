package com.algoritmos.algorithm;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.math.BigInteger;

/**
 *
 * @author JADLL
 */
public class TareaRSAyDHKE {
    
    public static BigInteger phiEulerEficienteBI(BigInteger n){

        BigInteger result = n; 
  
        // for (int p = 2; p * p <= n; ++p) { 
        for (BigInteger p = BigInteger.valueOf(2); p.multiply(p).compareTo(n) < 0; p = p.add(BigInteger.valueOf(1))){
            // if (n % p == 0) { 
            if( n.mod(p).equals(BigInteger.valueOf(0)) ){
                // while (n % p == 0) 
                while(n.mod(p).equals(BigInteger.valueOf(0))){
                    //  n /= p; 
                    n = n.divide(p);
                }
                // result -= result / p;    
                //result = result.multiply(BigInteger.valueOf(1).subtract(BigInteger.valueOf(1).divide(p)));
                result = result.subtract(result.divide(p));
            }

        }
        
        if(BigInteger.valueOf(1).compareTo(n) < 0){
            //result -= result / n; 
             result = result.subtract(result.divide(n));
        }
        
        
  
        return (BigInteger)result; 
    }
    
    
    public static boolean comprobar_exponente_valido_e_RSA_recibiendo_epq(BigInteger e,BigInteger p,BigInteger q){
        /* Para comprobar si el E (Exponente) es valido se tiene que cumplir esta 
            condición (se tiene que comprobar que gcd(e,phi(n)) = 1 )
        
        */
        
        // Calcular N = (p)*(q)
        BigInteger n = p.multiply(q);
        
        // Calcular phi(n)
        BigInteger phiDeN = phiEulerEficienteBI(n);
        
        // Calcular el gcd para este caso vamos a utilizar la función de Java
         BigInteger gcd = e.gcd(phiDeN);
        
         // Comporbar si es 1
         if(gcd.equals(BigInteger.valueOf(1))){
             // El el true significa que el expoente se puede usar en RSA
             return true;
         }else{
             return false;
         }
        
        
        
    }
    
    public static BigInteger llave_privada_recibiendo_pqe(BigInteger p, BigInteger q, BigInteger e){
        // Obtner n
        BigInteger n = p.multiply(q);
        // Obtner phi de euler de n
        BigInteger d = e.modInverse(phiEulerEficienteBI(n));
        if(d.compareTo(BigInteger.valueOf(0))< 0){
            BigInteger phi = phiEulerEficienteBI(n);
            d = d.mod(phi);
            return d;
        }
             
        return d;
        
        
    }
    
    public static  BigInteger desencryptar_mensaje_rsa_recibiendo_pqem(BigInteger p, BigInteger q, BigInteger e,BigInteger y){
        
        BigInteger n = p.multiply(q);
        
        BigInteger d = llave_privada_recibiendo_pqe(p,q,e);
        // Realizamos la encriptación
        BigInteger x =  y.modPow(d,n);
        
        return x;
    }
    
    public static  BigInteger encryptar_mensaje_rsa_recibiendo_pqem(BigInteger p, BigInteger q, BigInteger e,BigInteger x){
        BigInteger n = p.multiply(q);
        BigInteger y = x.modPow(e,n);
        return y;
    }
    
    public static BigInteger llave_privada_recibiendo_ne(BigInteger n, BigInteger e){

        BigInteger d = e.modInverse(phiEulerEficienteBI(n));
        if(d.compareTo(BigInteger.valueOf(0))< 0){
            BigInteger phi = phiEulerEficienteBI(n);
            d = d.mod(phi);
            return d;
        }
             
        return d;
        
        
    }
    
    
    public static  BigInteger desencryptar_mensaje_rsa_recibiendo_nem(BigInteger n, BigInteger e,BigInteger y){
        
        BigInteger d = llave_privada_recibiendo_ne(n,e);
        // Realizamos la encriptación
        BigInteger x =  y.modPow(d,n);
        
        return x;
    }
    
    public static  BigInteger encryptar_mensaje_recibiendo_ney(BigInteger n,BigInteger e,BigInteger x){
        // llave publica [e,n]
        // llave privada [d]
        // Encriptar y congruencia x ^ e mod n
        // x: mensaje sin encriptar
        /*
        x: mensaje sin encriptar
        e: numero elegido que cumpla con las condiciones requeridad
        n: multiplicacion de p y q -> n = p*q
        y: mensaje ya encriptado
        */

        
    //      BigInteger modPow(BigInteger exponent, BigInteger m): This method returns a BigInteger whose value is (thisexponent mod m).
        
        BigInteger y = x.modPow(e,n);
        return y;
    }
    
    public static int gcd(int a, int b) {
        BigInteger b1 = BigInteger.valueOf(a);
        BigInteger b2 = BigInteger.valueOf(b);
        BigInteger gcd = b1.gcd(b2);
        return gcd.intValue();
    }
    
    /*
    public static int orden_de_un_elemento(){
        
    }

*/
    public static int mod(int a, int b){
        int m = a%b;
        
        if(m<0){
            m = b+m;
        }
        return m;
    }
    
    public static BigInteger fast_exponentiation_BI_recibe_anz(BigInteger a, BigInteger n, BigInteger z){
        // Eponenciación rapida las entradas a,n, z
        // a^n mod z
        BigInteger resultado = BigInteger.valueOf(1);
        BigInteger x = a.mod(z);
        
        while(n.compareTo(BigInteger.valueOf(0)) > 0){
                                
            if( n.mod(BigInteger.valueOf(2)).equals(BigInteger.valueOf(1)) ){
                resultado = (resultado.multiply(x)).mod(z);
            }
            
           x = (x.multiply(x)).mod(z);
           n = n.divide(BigInteger.valueOf(2));
        }
        return resultado;
    }
    
    // ********************** DHKE *******************************         
    
    public static void determinar_cantidad_generadores(int p){
        int x,alpha,A;
        
        for (alpha = 2;alpha <p;alpha++){
            x = 1;
            A = alpha;
            do{
               A = mod( A * alpha, p);
                
               // A = (A * alpha ) % p; 
                x++;
            }while (A != 1 && x < p);
            
            if(x == (p-1) ){
                System.out.println(">" + alpha + " :: " + x);
            }
        }
    }
    
    public static int determinar_cantidad_generadores_cant(int p){
        int cant = 0;
        int x,alpha,A;
        
        for (alpha = 2;alpha <p;alpha++){
            x = 1;
            A = alpha;
            do{
               A = mod( A * alpha, p);
                
               // A = (A * alpha ) % p; 
                x++;
            }while (A != 1 && x < p);
            if(x == (p-1) ){
                cant++;
               // System.out.println(">" + alpha + " :: " + x);
            }
        }
        
        return cant;
    }
    
    public static int DHKE_obtener_llave_publica_AoB_recibiendo_primo_alpha_exponente(int p, int alpha,int exponente){
        // Este algoritmo puede recibir a o b 
        // Recibe p y el alpha
        
        // alpha^a
        
        // OJO utilizarbig integer por si el exponente es muy grande 
        BigInteger primo = BigInteger.valueOf(p);
        BigInteger BigAplha = BigInteger.valueOf(alpha);
        BigInteger BigExponente = BigInteger.valueOf(exponente);
        
        // a^n mod z
        
        BigInteger base = fast_exponentiation_BI_recibe_anz(BigAplha,BigExponente,primo);
        
        BigInteger llave = base.mod(primo);
        int llave_publica = llave.intValue();
            
        return llave_publica;
        
    }
    
    public static int DHKE_obtener_llave_en_comun_KAB_recibiendo_primo_exponente_llave(int primo,int exponente,int llave){
        // KAB = B^a mod p
        
        BigInteger BigPrimo = BigInteger.valueOf(primo);
        BigInteger BigLlave = BigInteger.valueOf(llave);
        BigInteger BigExponente = BigInteger.valueOf(exponente);
        
        
        
        //int base = (int)Math.pow(llave, exponente);
        
         // a^n mod z
        BigInteger base = fast_exponentiation_BI_recibe_anz(BigLlave,BigExponente,BigPrimo);
        
        BigInteger Big_llave_comun = base.mod(BigPrimo);
        int llave_comun = Big_llave_comun.intValue();
        //int llave_comun = mod(base,primo);
        return llave_comun;
    }
    
    public static int DHKE_computar_logaritmo_discreto_por_busqueda_exhaustiva_recibiendo_alpha_primo_llavepublica(int alpha,int primo,int llave){
        // El limite del exponente a o b es  2 >=  b  <= primo-2
        int limite = primo - 2;
        int exponente = 0;
        // Valores a BigInteger para el mod y fastexponenc
        BigInteger BigPrimo = BigInteger.valueOf(primo);
        BigInteger BigAlpha = BigInteger.valueOf(alpha);
        //BigInteger Bigllave = BigInteger.valueOf(llave);
        
        for (int i = 2; i<= limite; i++){
            // a^n mod z
            BigInteger posible_llave = fast_exponentiation_BI_recibe_anz(BigAlpha,BigInteger.valueOf(i),BigPrimo);
            //System.out.println(i + ":" +posible_llave);
            if(posible_llave.intValue() == llave){
                return i;
            }
        }
        return exponente;
    }
    
    public static void main(String[] args) {
        
        
        System.out.println("**************Ejercicio 1:***********************");   
        System.out.println("Comprobar si los parametros e1 y e2 son validos.");
        // P y Q generales
        BigInteger p1 = new BigInteger("41");
        BigInteger q1 = new BigInteger("17");
        // e1 y e2
        BigInteger e1 = new BigInteger("32");
        BigInteger e2 = new BigInteger("49");
        System.out.println("a) Que parametro es valido");
        System.out.println("e1: " + e1 + " " + comprobar_exponente_valido_e_RSA_recibiendo_epq(e1,p1,q1));
        System.out.println("e2: " + e2 + " " + comprobar_exponente_valido_e_RSA_recibiendo_epq(e2,p1,q1));
        System.out.println("b) Calcular llave privada");
        System.out.println("LLave privada d: " + llave_privada_recibiendo_pqe(p1,q1,e2));
        
        System.out.println("************************************************");
        System.out.println("");
       
        System.out.println("**************Ejercicio 2:***********************");   
        System.out.println("Desencriptar mensaje recibiendo p= 31 q =37 e =17 y m= 2");
        BigInteger P2 = new BigInteger("31");
        BigInteger Q2 = new BigInteger("37");
        BigInteger E2 = new BigInteger("17");
        BigInteger Y2 = new BigInteger("2");
        
        System.out.println("Mensaje Desencriptado: " + desencryptar_mensaje_rsa_recibiendo_pqem(P2,Q2,E2,Y2));
        // Comprobación
        System.out.println("Comprobación:");
        System.out.println("Mensaje encriptado: " + encryptar_mensaje_rsa_recibiendo_pqem(P2,Q2,E2,desencryptar_mensaje_rsa_recibiendo_pqem(P2,Q2,E2,Y2)));
        
        System.out.println("************************************************");
        System.out.println("");
        
        System.out.println("**************Ejercicio 3:***********************");
        System.out.println("Este ejercicio se realiza a mano y con wolfram");
        
        System.out.println("************************************************");
        System.out.println("");
        
        
        System.out.println("**************Ejercicio 4:***********************");
        System.out.println("Desencriptar mensaje con la llave publica (n,e)= 2623,2111) y el texto cifrado y = 1141");
        
        BigInteger N4 = new BigInteger("2623");
        BigInteger E4 = new BigInteger("2111");
        BigInteger Y4 = new BigInteger("1141");
        
        System.out.println("Mensaje Desencriptado: " + desencryptar_mensaje_rsa_recibiendo_nem(N4,E4,Y4));
        
        // Comprobar 
        System.out.println("Comprobación:");
        System.out.println("Mensaje Encriptado: " + encryptar_mensaje_recibiendo_ney(N4,E4,desencryptar_mensaje_rsa_recibiendo_nem(N4,E4,Y4)));
        
        
      
        
    
        System.out.println("----------------------- DHKE -------------------------------");
        System.out.println("");
        
        System.out.println("**************Ejercicio 5:***********************");
        System.out.println("Cantidad de elementos primitivos (generadores) de un grupo multiplicativo");
        System.out.println("Generadores de p = 4969");
        
        System.out.println("Generadores: " + determinar_cantidad_generadores_cant(4969));
        
        determinar_cantidad_generadores(4969);
       
        //System.out.println("Generadores: " + determinar_cantidad_generadores_cant(11));
        
        System.out.println("************************************************");
        System.out.println("");
        
        
        System.out.println("**************Ejercicio 6:***********************");
        System.out.println("Computar llave public y llave en comun p = 467, alpha = 2");
        // p y alpha generales
        int p = 467;
        int alpha = 2;
        
        System.out.println("a) a = 3, b = 5");

        
        int a61 = 3;
        int b61 = 5;
          
        // Calcular para a
        System.out.println("A: " + DHKE_obtener_llave_publica_AoB_recibiendo_primo_alpha_exponente(p,alpha,a61));
        int A61 = DHKE_obtener_llave_publica_AoB_recibiendo_primo_alpha_exponente(p,alpha,a61);
        // Calcular para b
        System.out.println("B: " + DHKE_obtener_llave_publica_AoB_recibiendo_primo_alpha_exponente(p,alpha,b61));
        int B61 = DHKE_obtener_llave_publica_AoB_recibiendo_primo_alpha_exponente(p,alpha,b61);
        // Llaves en comun de a
        // Recibe B
        System.out.println("Llave en comun de a: " + DHKE_obtener_llave_en_comun_KAB_recibiendo_primo_exponente_llave(p,a61,B61));
        
        // llave en comun de b
        // Recibe A
        System.out.println("Llave en comun de b: " + DHKE_obtener_llave_en_comun_KAB_recibiendo_primo_exponente_llave(p,b61,A61));

        System.out.println("");
        System.out.println("");
        
        System.out.println("b) a = 400, b = 134");
        
        int a62 = 400;
        int b62 = 134;
          
        // Calcular para a
        System.out.println("A: " + DHKE_obtener_llave_publica_AoB_recibiendo_primo_alpha_exponente(p,alpha,a62));
        int A62 = DHKE_obtener_llave_publica_AoB_recibiendo_primo_alpha_exponente(p,alpha,a62);
        
        
        // Calcular para b
        System.out.println("B: " + DHKE_obtener_llave_publica_AoB_recibiendo_primo_alpha_exponente(p,alpha,b62));
        int B62 = DHKE_obtener_llave_publica_AoB_recibiendo_primo_alpha_exponente(p,alpha,b62);
        // Llaves en comun de a
        // Recibe B
        System.out.println("Llave en comun de a: " + DHKE_obtener_llave_en_comun_KAB_recibiendo_primo_exponente_llave(p,a62,B62));
        
        // llave en comun de b
        // Recibe A
        System.out.println("Llave en comun de b: " + DHKE_obtener_llave_en_comun_KAB_recibiendo_primo_exponente_llave(p,b62,A62));
        
        System.out.println("");
        System.out.println("");
        
        System.out.println("c) a = 228, b = 57");
        
        int a63 = 228;
        int b63 = 57;
          
        // Calcular para a
        System.out.println("A: " + DHKE_obtener_llave_publica_AoB_recibiendo_primo_alpha_exponente(p,alpha,a63));
        int A63 = DHKE_obtener_llave_publica_AoB_recibiendo_primo_alpha_exponente(p,alpha,a63);
        // Calcular para b
        System.out.println("B: " + DHKE_obtener_llave_publica_AoB_recibiendo_primo_alpha_exponente(p,alpha,b63));
        int B63 = DHKE_obtener_llave_publica_AoB_recibiendo_primo_alpha_exponente(p,alpha,b63);
        // Llaves en comun de a
        // Recibe B
        System.out.println("Llave en comun de a: " + DHKE_obtener_llave_en_comun_KAB_recibiendo_primo_exponente_llave(p,a63,B63));
        
        // llave en comun de b
        // Recibe A
        System.out.println("Llave en comun de b: " + DHKE_obtener_llave_en_comun_KAB_recibiendo_primo_exponente_llave(p,b63,A63));
        
        System.out.println("************************************************");
        System.out.println("");
        
        System.out.println("**************Ejercicio 7:***********************");
        System.out.println("Computar algoritmo discreto por busqueda exhaustiva log106 12375 mod 24691");
        System.out.println("Datos: alpha = 106, p = 24691, A=12375 a=? ");

        System.out.println("a = "+DHKE_computar_logaritmo_discreto_por_busqueda_exhaustiva_recibiendo_alpha_primo_llavepublica(106,24691,12375));
        
    } 
}
