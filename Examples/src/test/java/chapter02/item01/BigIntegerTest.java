package chapter02.item01;

import org.hamcrest.Matcher;
import org.junit.Test;

import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsSame.sameInstance;
import static org.junit.Assert.assertThat;

public class BigIntegerTest {
    BigInteger instanceConstructor = new BigInteger(0);
    BigInteger instanceFactoryMethod = BigInteger.valueOf(0);
    BigInteger instanceConstant = BigInteger.ZERO;

    @Test
    public void compareInstanceConstructorWithOthers() {
        assertThat(instanceConstructor, notSameInstance(getNewInstanceConstructor()));
        assertThat(instanceConstructor, notSameInstance(instanceFactoryMethod));
        assertThat(instanceConstructor, notSameInstance(instanceConstant));
    }

    @Test
    public void compareInstanceFactoryMethodWithOthers() {
        assertThat(instanceFactoryMethod, notSameInstance(instanceConstructor));
        assertThat(instanceFactoryMethod, sameInstance(getNewInstanceFactoryMethod()));
        assertThat(instanceFactoryMethod, sameInstance(instanceConstant));
    }

    @Test
    public void compareInstanceConstantMethodWithOthers() {
        assertThat(instanceConstant, notSameInstance(instanceConstructor));
        assertThat(instanceConstant, sameInstance(instanceFactoryMethod));
        assertThat(instanceConstant, sameInstance(getNewInstanceConstant()));
    }

    private Matcher<BigInteger> notSameInstance(BigInteger instance) {
        return not(sameInstance(instance));
    }

    private BigInteger getNewInstanceConstructor() {
        return new BigInteger(0);
    }

    private BigInteger getNewInstanceFactoryMethod() {
        return BigInteger.valueOf(0);
    }

    private BigInteger getNewInstanceConstant() {
        return BigInteger.ZERO;
    }
}
