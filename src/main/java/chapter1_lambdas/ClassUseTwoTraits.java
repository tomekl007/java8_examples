package chapter1_lambdas;

/**
 * @author Tomasz Lelek
 * @since 2014-03-05
 */
public class ClassUseTwoTraits implements TraitWithOneBehavior<Integer>, TraitWithSecondBehaviour<Integer> {
    public static void main(String[] args) {
        ClassUseTwoTraits classUseTwoTraits = new ClassUseTwoTraits();
        classUseTwoTraits.usingTrait();
    }
    public void usingTrait(){
        printSomething(addingTwoTypes(2, 3));
    }

}
