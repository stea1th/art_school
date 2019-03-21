package art.school.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

import static java.time.temporal.ChronoUnit.DAYS;

//@Component
public class DateUtil {

//    @Autowired
//    private static MessageSource messageSource;

    public static String transformDateForForum(LocalDateTime dateTime) {
        String time = dateTime.toLocalTime().truncatedTo(ChronoUnit.MINUTES).toString();
        int days = (int) DAYS.between(dateTime.toLocalDate(), LocalDate.now());
//        Locale locale = LocaleContextHolder.getLocale();
//        System.out.println(messageSource.getMessage("forum.title", null, locale));
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
