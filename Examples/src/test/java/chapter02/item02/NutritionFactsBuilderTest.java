package chapter02.item02;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class NutritionFactsBuilderTest {
    @Test
    public void canCreate() {
        NutritionFacts_Builder cocaCola = new NutritionFacts_Builder.Builder(240, 8).calories(100).fat(10).build();
        System.out.println(cocaCola);
        assertThat(cocaCola, is(notNullValue()));
        assertThat(cocaCola.toString(), equalTo("NutritionFacts_Builder{servingSize=240, servings=8, calories=100, fat=10}"));
    }
}
