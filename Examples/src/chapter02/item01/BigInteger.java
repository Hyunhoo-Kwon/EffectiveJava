package chapter02.item01;

import java.util.Random;

public class BigInteger {
    private static final int SMALL_PRIME_THRESHOLD = 95;
    private static final int DEFAULT_PRIME_CERTAINTY = 100;

    public static BigInteger probablePrime(int bitLength, Random rnd) {
        if (bitLength < 2)
            throw new ArithmeticException("bitLength < 2");

        return (bitLength < SMALL_PRIME_THRESHOLD ?
                smallPrime(bitLength, DEFAULT_PRIME_CERTAINTY, rnd) :
                largePrime(bitLength, DEFAULT_PRIME_CERTAINTY, rnd));
    }

    private static BigInteger smallPrime(int bitLength, int certainty, Random rnd) {
        return null;
    }

    private static BigInteger largePrime(int bitLength, int certainty, Random rnd) {
        return null;
    }
}
