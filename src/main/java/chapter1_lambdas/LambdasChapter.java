package chapter1_lambdas;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Predicate;

/**
 * @author Tomasz Lelek
 * @since 2014-03-04
 */
public class LambdasChapter {
    public static void main(String[] args) throws InterruptedException {
        List<Person> roster = new LinkedList<>();
        roster.add(new Person(1, 29, "marcin"));
        roster.add(new Person(1, 30, "piecuy"));
        printPersonsWithPredicate(
                roster,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25
        );
        Integer sumOfAges = roster.stream().map(Person::getAge).filter( p -> p > 20).reduce(0,
                (a, b) -> a + b);
        System.out.println(sumOfAges);

        Runnable sleeper = () -> { System.out.println("Zzz");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        //or
        Callable<Void> callable = () -> { System.out.println("Zzz"); Thread.sleep(1000); return null; };

        ConcurrentGreeter concurrentGreeter = new ConcurrentGreeter();
        concurrentGreeter.greet();
        //Arrays.sort(new Integer[]{1,2}, x-> String::compareToIgnoreCase);

        List<String> labels = new ArrayList<>();
        labels.add("one");
        labels.add("two");
        Button[] buttons = labels.stream().toArray(Button[]::new);;
        System.out.println(Arrays.toString(buttons));
    }

    //public int addTwoFunction(){

//    }





    public static void printPersonsWithPredicate(
            List<Person> roster, Predicate<Person> tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

}


class Greeter {
    public void greet() {
        System.out.println("Hello, world!");
    }
}

class ConcurrentGreeter extends Greeter {
    public void greet() {
        Thread t = new Thread(super::greet);
        t.start();
    }
}


