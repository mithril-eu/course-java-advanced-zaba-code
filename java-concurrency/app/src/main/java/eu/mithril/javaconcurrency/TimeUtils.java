package eu.mithril.javaconcurrency;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtils {

    private static final String TIME_ZONE = "Europe/Zagreb";

    public static LocalDateTime now() {
        return ZonedDateTime.now(ZoneId.of(TIME_ZONE)).toLocalDateTime();
    }

    public static String formattedTimestamp() {
        return DateTimeFormatter.ofPattern("uuuu-MM-dd-HH:mm:ss.SSSSSS").format(now());
    }
}
