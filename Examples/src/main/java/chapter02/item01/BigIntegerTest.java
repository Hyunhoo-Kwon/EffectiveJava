package chapter02.item01;

public class BigIntegerTest {
    public static void main(String[] args) {
        BigInteger instance1 = new BigInteger(0);
        BigInteger instance2 = BigInteger.valueOf(0);
        BigInteger instance3 = BigInteger.valueOf(0);
        BigInteger instance4 = BigInteger.ZERO;

        System.out.println(instance1==instance2); // false
        System.out.println(instance2==instance3); // true
        System.out.println(instance1==instance4); // false
        System.out.println(instance3==instance4); // true
    }
}
