package com.algoritmos.algorithm;

import java.math.BigInteger;

class Algorithm_Phi_Euler {

    public BigInteger phiEulerEficient(BigInteger n) {

        BigInteger result = n;

        // for (int p = 2; p * p <= n; ++p) {
        for (BigInteger p = BigInteger.valueOf(2); p.multiply(p).compareTo(n) < 0; p = p.add(BigInteger.valueOf(1))) {
            // if (n % p == 0) {
            if (n.mod(p).equals(BigInteger.valueOf(0))) {
                // while (n % p == 0)
                while (n.mod(p).equals(BigInteger.valueOf(0))) {
                    // n /= p;
                    n = n.divide(p);
                }
                // result -= result / p;
                // result =
                // result.multiply(BigInteger.valueOf(1).subtract(BigInteger.valueOf(1).divide(p)));
                result = result.subtract(result.divide(p));
            }

        }

        if (BigInteger.valueOf(1).compareTo(n) < 0) {
            // result -= result / n;
            result = result.subtract(result.divide(n));
        }

        return result;
    }
}
