package chapter02.item05;

import java.util.Date;

public class PersonTest {
    public static void main(String[] args) {
        Date birthDate = new Date();

        Person person = new Person(birthDate);
        Person_Refactor person_refactor = new Person_Refactor(birthDate);

        long start_person = System.currentTimeMillis();
        for(int i=0; i<1000000; i++) {
            person.isBabyBoomer();
        }
        long end_person = System.currentTimeMillis();

        long start_person_refac = System.currentTimeMillis();
        for(int i=0; i<1000000; i++) {
            person_refactor.isBabyBoomer();
        }
        long end_person_refac = System.currentTimeMillis();

        System.out.println(end_person-start_person);    // 1003
        System.out.println(end_person_refac-start_person_refac); // 16
    }
}
