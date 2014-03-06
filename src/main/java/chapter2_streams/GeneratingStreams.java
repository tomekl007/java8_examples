package chapter2_streams;

import chapter1_lambdas.Person;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

/**
 * @author Tomasz Lelek
 * @since 2014-03-05
 */
public class GeneratingStreams {
    public static void main(String[] args) {
        Stream<Double> randoms = Stream.generate(Math::random);
        Stream<BigInteger> integers
                = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));

        List<String> wordList = new LinkedList<>();
        wordList.add("AlFa");
        wordList.add("Beta");
        wordList.add("b");
        Stream<String> words = wordList.stream();
        Stream<String> longWords = words.filter(w -> w.length() > 3);
        Stream<String> toLowerCase = longWords.map(String::toLowerCase);

        //Stream<Stream<Character>> result = toLowerCase.map(GeneratingStreams::characterStream);
        //System.out.println(Arrays.toString(result.toArray()));

        //Stream<Character> letters = toLowerCase.flatMap(GeneratingStreams::characterStream);
        //System.out.println(Arrays.toString(letters.toArray()));

        Object[] powers = Stream.iterate(1.0, p -> p * 2)
                .peek(e -> System.out.println("Fetching " + e))
                .limit(20).toArray();

        Optional<String> largest = toLowerCase.max(String::compareToIgnoreCase);
        if (largest.isPresent())
            System.out.println("largest: " + largest.get());


        Set<String> results = new LinkedHashSet<>();

        largest.ifPresent(results::add);
        Optional<Boolean> added = largest.map(results::add);
        System.out.println(results);


        String result = largest.orElseGet(() -> System.getProperty("user.dir"));
        System.out.println(result);

        Optional<String> optional = Optional.empty();
        String result2 = optional.orElseGet(() -> System.getProperty("user.dir"));
        System.out.println(result2);

        try {
            String result3 = optional.orElseThrow(NoSuchElementException::new);
        } catch (NoSuchElementException ex) {
            System.out.println("catch : " + ex);
        }

        Optional<Double> result4 = inverse(9.9).flatMap(GeneratingStreams::squareRoot);
        System.out.println(result4);
        Optional<Double> empty = Optional.of(-4.0).flatMap(GeneratingStreams::inverse).flatMap(GeneratingStreams::squareRoot);

        System.out.println(empty);

        List<String> words2 = new LinkedList<>();
        words2.add("asfasd");
        words2.add("sadafafaefgaga");
        int reduceResult = words2.stream().reduce(0,
                (total, word) -> total + word.length(),
                (total1, total2) -> total1 + total2);
        System.out.println(reduceResult);

        String[] toArrayString = words2.stream().toArray(String[]::new);


        IntSummaryStatistics summary = words2.stream().collect(
                Collectors.summarizingInt(String::length));

        double averageWordLength = summary.getAverage();
        System.out.println("averageWordLength  =  " + averageWordLength );
        double maxWordLength = summary.getMax();
        System.out.println("maxWordLength =  " + maxWordLength);

        List<Person> people = new LinkedList<>();
        people.add(new Person(1, 1, "Tomek"));
        people.add(new Person(44, 2, "Barter"));

        Map<Integer, String> idToName = people.stream().collect(
                Collectors.toMap(Person::getId, Person::getName));
        System.out.println(idToName);

        List<LocaleCountry> locales = new LinkedList<>();
        locales.add(new LocaleCountry("Switzerland", "French"));
        locales.add(new LocaleCountry("Switzerland", "German"));
        locales.add(new LocaleCountry("Switzerland", "Italian"));

        Map<String, Set<String>> countryLanguageSets = locales.stream().collect(
                Collectors.toMap(
                        LocaleCountry::getDisplayCountry,
                        l -> Collections.singleton(l.getDisplayLanguage()),
                        (a, b) -> { // Union of a and b
                            System.out.println("a : " + a + " b : " + b);
                            Set<String> r = new HashSet<>(a);
                            r.addAll(b);
                            return r;
                        }));
        System.out.println(countryLanguageSets);

        Map<String, List<LocaleCountry>> countryToLocales = locales.stream().parallel().collect(
                Collectors.groupingByConcurrent(LocaleCountry::getDisplayCountry));
        System.out.println(countryToLocales);

        /*Map<String, String> stateToCityNames = cities.collect(
                groupingBy(City::getState,
                        reducing("", City::getName,
                                (s, t) -> s.length() == 0 ? t : s + ", " + t)*/

        IntStream zeroToNinetyNine = IntStream.range(0, 100);

    }

    public static Optional<Double> inverse (Double x){
        return x == 0 ? Optional.empty() : Optional.of(1 / x);
    }

    public static Optional<Double> squareRoot(Double x) {
        return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
    }



    public static Stream<Character> characterStream(String s) {
        List<Character> result = new ArrayList<>();
        for (char c : s.toCharArray()) result.add(c);
        return result.stream();
    }
}
