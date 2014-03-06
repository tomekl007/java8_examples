package chapter1_lambdas;

/**
 * @author Tomasz Lelek
 * @since 2014-03-05
 */
public interface TraitWithSecondBehaviour<T extends Number> {
    default int addingTwoTypes(T first, T second){
        return first.intValue() + second.intValue();
    }
}
