package chapter03.item08;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class EqualsAndHashCodeExampleTest {
    @Test
    public void equals() throws Exception {
        String[] tags = {"example", "code"};
        EqualsAndHashCodeExample x = new EqualsAndHashCodeExample("elon", 100, tags);
        EqualsAndHashCodeExample y = new EqualsAndHashCodeExample("elon", 100, tags);
        EqualsAndHashCodeExample z = new EqualsAndHashCodeExample("elon", 100, tags);

        // 1. 반사성
        assertThat(x.equals(x),
                is(true));

        // 2. 대칭성
        assertThat(x.equals(y) == y.equals(x),
                is(true));

        // 3. 추이성
        if(x.equals(y) == y.equals(z)) {
            assertThat(z.equals(z),
                    is(true));
        }

        // 4. null에 대한 비동치성
        assertThat(x.equals(null),
                is(false));

    }

}