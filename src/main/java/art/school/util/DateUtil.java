package art.school.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.ChronoUnit.DAYS;

public class DateUtil {

    public static String transformDateForForum(LocalDateTime dateTime) {
        String time = dateTime.toLocalTime().truncatedTo(ChronoUnit.MINUTES).toString();
        int days = (int) DAYS.between(dateTime.toLocalDate(), LocalDate.now());
        switch (days) {
            case 0:
                return "Сегодня, " + time;
            case 1:
                return "Вчера, " + time;
            case 2:
            case 3:
            case 4:
                return days + " дня назад, " + time;
            case 5:
            case 6:
            case 7:
                return days + " дней назад, " + time;
        }
        return dateTime.truncatedTo(ChronoUnit.MINUTES).format(DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm"));
    }
}