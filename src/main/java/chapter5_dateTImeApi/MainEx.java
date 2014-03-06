package chapter5_dateTImeApi;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * @author Tomasz Lelek
 * @since 2014-03-05
 */
public class MainEx {
    public static void main(String[] args) {
        Instant start = Instant.now();
        runAlgorithm();
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        long millis = timeElapsed.toMillis();
        System.out.println(millis);

        LocalDate today = LocalDate.now(); // Today's date
        LocalDate alonzosBirthday = LocalDate.of(1903, 6, 14);
        alonzosBirthday = LocalDate.of(1903, Month.JUNE, 14);

        LocalDate firstTuesday = LocalDate.of(2012, 2 , 1).with(
                TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY));
        System.out.println(firstTuesday);

        TemporalAdjuster NEXT_WORKDAY = TemporalAdjusters.ofDateAdjuster(w -> {
            LocalDate result = w; // No cast
            do {
                result = result.plusDays(1);
            } while (result.getDayOfWeek().getValue() >= 6);
            return result;
        });

        LocalDate backToWork = today.with(NEXT_WORKDAY);
        System.out.println(backToWork);

        ZonedDateTime ambiguous = ZonedDateTime.of(
                LocalDate.of(2013, 10, 27), // End of daylight savings time
                LocalTime.of(2, 30),
                ZoneId.of("Europe/Berlin"));
        // 2013-10-27T02:30+02:00[Europe/Berlin]
        ZonedDateTime anHourLater = ambiguous.plusHours(1);
        // 2013-10-27T02:30+01:00[Europe/Berlin]
        System.out.println(anHourLater);

        LocalDate churchsBirthday = LocalDate.parse("1903-06-14");
        ZonedDateTime apollo11launch =
                ZonedDateTime.parse("1969-07-16 03:32:00-0400",
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssxx"));
        System.out.println(apollo11launch);
    }

    private static void runAlgorithm() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
