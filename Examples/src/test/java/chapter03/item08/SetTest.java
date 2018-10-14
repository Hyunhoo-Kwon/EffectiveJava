package chapter03.item08;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SetTest {

    @Test
    public void compareTreeSetAndHashSet() {
        List<String> list = Arrays.asList("TreeSet", "HashSet", "Equals", "True");
        HashSet<String> hashSet = new HashSet<String>(list);
        TreeSet<String> treeSet = new TreeSet<String>(list);

        assertThat(hashSet.equals(treeSet),
                is(true));
        assertThat(treeSet.equals(hashSet),
                is(true));
    }
}
