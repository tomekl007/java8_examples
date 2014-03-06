package chapter1_lambdas;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Tomasz Lelek
 * @since 2014-03-05
 */
public class InterfaceClash {


    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("something first ");
        list.add("sth second");
        Stream<String> result = list.stream().map(InterfaceClash::trimAllSpacesInString);
        System.out.println(result);
    }
    public static String trimAllSpacesInString(String s){
        return s.trim();
    }
}



interface Person2 {
    long getId();
    default String getName() { return "John Q. Public"; }
}
interface Named {
   default String getName() { return getClass().getName() + "_" + hashCode(); }
}

class Student implements Person2, Named {
    @Override
    public long getId() {
        return 0;
    }

    @Override
    public String getName() { return Person2.super.getName(); }

}

