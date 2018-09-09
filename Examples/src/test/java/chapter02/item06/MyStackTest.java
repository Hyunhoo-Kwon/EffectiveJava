package chapter02.item06;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MyStackTest {

    private final MyStack myStack = new MyStack();

    @Test
    public void pushAndPopTest() {
        myStack.push("test");
        assertThat(myStack.pop(),
                is("test"));
    }
}
