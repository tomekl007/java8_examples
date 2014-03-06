package chapter3_programmingWithLambdas;

import java.util.function.IntConsumer;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Tomasz Lelek
 * @since 2014-03-05
 */
public class DeferredEx {

    public static void main(String[] args) {
        int x = 2;
        info(Logger.getLogger(DeferredEx.class.toString()), () -> "x : " + x );
        repeat(10, i -> System.out.println("Countdown: " + (9 - i)));
    }

    public static void info(Logger logger, Supplier<String> message) {
        if (logger.isLoggable(Level.INFO))
            logger.info(message.get());
    }

    public static void repeat(int n, IntConsumer action) {
        for (int i = 0; i < n; i++) action.accept(i);
    }




}
