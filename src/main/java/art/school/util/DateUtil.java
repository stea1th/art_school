package art.school.util;

import art.school.to.DateTo;
import org.springframework.context.MessageSource;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

import static java.time.temporal.ChronoUnit.DAYS;

public class DateUtil {

    public static DateTo transformDateInTo(LocalDateTime dateTime) {
        String time = dateTime.toLocalTime().truncatedTo(ChronoUnit.MINUTES).toString();
        int days = (int) DAYS.between(dateTime.toLocalDate(), LocalDate.now());
        switch (days) {
            case 0:
                return new DateTo("forum.today", time);
            case 1:
                return new DateTo("forum.yesterday", time);
            case 2:
            case 3:
            case 4:
                return new DateTo("forum.days.ago", time, days);
            case 5:
            case 6:
            case 7:
                return new DateTo("forum.days.ago2", time, days);

        }
        return new DateTo(formatDateToString(dateTime));
    }

    public static String formatDateToString(LocalDateTime dateTime){
        return dateTime.truncatedTo(ChronoUnit.MINUTES).format(DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm"));
    }

    public static LocalDateTime transformToDate(Integer interval, String unit){
        if(interval == null || interval == 0){
            interval = 10000;
            unit = "days";
        }
        Duration d = Duration.ZERO;
        switch(unit){
            case "minutes":
                d = Duration.ofMinutes(interval);
                break;
            case "hours":
                d = Duration.ofHours(interval);
                break;
            case "days":
                d = Duration.ofDays(interval);
                break;

        }
        return LocalDateTime.now().plus(d);
    }

    public static String convertDateToToString(DateTo d, MessageSource messageSource, Locale locale){
        return d.getCode() == null ? d.getTime() :
                d.getDays() == null ? messageSource.getMessage(d.getCode(), new Object[]{d.getTime()}, locale) :
                        messageSource.getMessage(d.getCode(), new Object[]{d.getTime(), d.getDays()}, locale);
    }
}
