package se.lexicon;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtils {

    public static void printTimestamp() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDate = now.format(formatter);
        System.out.println("Converted at: " + formattedDate);
    }
}
