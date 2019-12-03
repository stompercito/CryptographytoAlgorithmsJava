package com.algoritmos.algorithm;

import java.math.BigInteger;
import java.util.List;
import java.util.ArrayList;

public class Rsa_Attack_CipherText {

        public static void main(String[] args) {

                // Esta parte hace la fórmula para encriptar o desencriptar RSA

                Algorithm_Fast_Exponentiation fE3 = new Algorithm_Fast_Exponentiation();
                List<String> caracteres = new ArrayList<>();

                for (int i = 32; i <= 122; i++) {
                        BigInteger M = new BigInteger(Integer.toString(i));
                        BigInteger e = new BigInteger("65537");
                        BigInteger n = new BigInteger("2199055761527");
                        BigInteger x = fE3.fastExp(M, e, n);
                        System.out.println(String.format("%c = ", i) + " " + x);
                        caracteres.add(x.toString());
                }

                String mensaje[] = { "336067595008", "1682970026313", "2195342536774", "1012748295869", "1331711163998",
                                "510154320953", "676512275779", "2195342536774", "1012748295869", "2052401454061",
                                "510154320953", "510154320953", "12175999401" };

                for (int i = 0; i < mensaje.length; i++) {
                        for (int j = 0; j < caracteres.size(); j++) {
                                if (mensaje[i].compareTo(caracteres.get(j)) == 0) {
                                        System.out.print(String.format("%c", j + 32));
                                }
                        }
                }

        }
}
