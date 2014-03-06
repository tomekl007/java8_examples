package chapter1_lambdas;

/**
 * @author Tomasz Lelek
 * @since 2014-03-04
 */
public class Person {
    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Object gender) {
        this.gender = gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {

        return name;
    }

    private String name;
    private Object gender;

    public void setAge(int age) {
        this.age = age;
    }

    private int age;

    public int getId() {
        return id;
    }

    private int id;


    public Person(int i, int age, String name) {
        this.id = i;
        this.name = name;
        this.age = age;
    }

    public void printPerson() {

    }

    public Object getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public enum Sex {MALE}
}
