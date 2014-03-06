package chapter1_lambdas;

/**
 * @author Tomasz Lelek
 * @since 2014-03-05
 */
public interface TraitWithOneBehavior<T> {
    default void printSomething(T object){
        System.out.println("something " + object);
    }
}
