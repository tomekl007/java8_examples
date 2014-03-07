package chapter6_concurencyEnhancements;

import java.util.concurrent.CompletableFuture;

/**
 * @author Tomasz Lelek
 * @since 2014-03-07
 */
public class CompletableFutureEx {
    public static void main(String[] args) throws InterruptedException {


    CompletableFuture<Void> contents
            = CompletableFuture.supplyAsync(CompletableFutureEx::blockingReadPage)
            .thenApply(Parser::getLinks)
            .thenAccept(System.out::println);
        System.out.println(contents);

        Thread.currentThread().join();
        int s = 2;

    }

    private static String blockingReadPage() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "some web page";
    }
}
