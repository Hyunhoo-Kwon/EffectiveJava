package chapter03.item08;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SubClassTest {
    @Test
    public void SuperClassAndSubClassEquals() {
        SuperClass superClass = new SuperClass(1,2);
        SubClass subClass = new SubClass(1,2,"sub");

        assertThat(superClass.equals(subClass),
                is(true));
        assertThat(subClass.equals(superClass),
                is(false));
    }
}
