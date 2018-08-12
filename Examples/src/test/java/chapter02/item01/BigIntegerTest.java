package chapter02.item01;

import org.junit.Test;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

public class BigIntegerTest {
    @Test
    public void compareInstances() {
        BigInteger instanceConstructor1 = new BigInteger(0);
        BigInteger instanceConstructor2 = new BigInteger(0);
        BigInteger instanceFactoryMethod1 = BigInteger.valueOf(0);
        BigInteger instanceFactoryMethod2 = BigInteger.valueOf(0);
        BigInteger instanceConstant = BigInteger.ZERO;

        assertNotSame(instanceConstructor1, instanceConstructor2);
        assertNotSame(instanceConstructor1, instanceFactoryMethod1);
        assertSame(instanceFactoryMethod1, instanceFactoryMethod2);
        assertNotSame(instanceConstructor1, instanceConstant);
        assertSame(instanceFactoryMethod1, instanceConstant);
    }
}
