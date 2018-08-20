package chapter02.item05;

import org.junit.Test;

import java.util.Date;

public class PersonTest {
    Date birthDate = new Date();

    @Test
    public void measurePersonExecutionTime() {
        Person person = new Person(birthDate);

        long start = System.nanoTime();
        for(int i=0; i<1000000; i++) {
            person.isBabyBoomer();
        }
        long finish = System.nanoTime();
        long timeElapsed = finish - start;

        System.out.println(timeElapsed); // 1.079070247s
    }

    @Test
    public void measurePersonRefactorExecutionTime() {
        PersonRefactor personRefactor = new PersonRefactor(birthDate);

        long start = System.nanoTime();
        for(int i=0; i<1000000; i++) {
            personRefactor.isBabyBoomer();
        }
        long finish = System.nanoTime();
        long timeElapsed = finish - start;

        System.out.println(timeElapsed); // 0.014479830s
    }
}
