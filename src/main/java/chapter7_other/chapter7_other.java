package chapter7_other;

import chapter1_lambdas.Person;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;


/**
 * @author Tomasz Lelek
 * @since 2014-03-07
 */
public class chapter7_other {
    private static String string;

    public static void main(String[] args) throws IOException, InterruptedException {
        List<Person> people = new LinkedList<>();

/*        Arrays.sort(people,
                Comparator.comparing(Person::getAge));
                        //.thenComparing(Person::getName));
                        */

        //files
        Path path = Paths.get("path");
       /* Stream<String> lines = null;
        try {
            lines = Files.lines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Optional<String> passwordEntry = lines.filter(s -> s.contains("password")).findFirst();*/

        //base64
        Base64.Encoder encoder = Base64.getEncoder();
        String original = "username" + ":" + "passowrd";
        String encoded = encoder.encodeToString(original.getBytes(StandardCharsets.UTF_8));
        System.out.println(encoded);

        Object o = new Object();
        String s = getString();
        String res = Objects.toString(s, "this string is null");
        System.out.println(res);
        System.out.println(Objects.hash("a", "b", "cde"));
        System.out.println(Integer.compare(Integer.MIN_VALUE, Integer.MAX_VALUE));
        //Objects.requireNonNull(s, "this string must be not null");
        ProcessBuilder processBuilder = new ProcessBuilder().command("pwd");
        processBuilder.inheritIO();
        Process process = processBuilder.start();
        process.waitFor();

        byte[] bytes = { (byte) 0b10101100, (byte) 0b00101000 };
        BitSet primes = BitSet.valueOf(bytes);
        // {2, 3, 5, 7, 11, 13}
        long[] longs = { 0x100010116L, 0x1L, 0x1L, 0L, 0x1L };
        BitSet powersOfTwo = BitSet.valueOf(longs);
        System.out.println(powersOfTwo);

    }



    @TestCase(params="4", expected="24")
    @TestCase(params="0", expected="1")
    public static long factorial(int n) { return n; }

    public static String getString() {
        return string;
    }
}
