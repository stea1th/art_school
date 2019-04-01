package art.school.util;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.ChronoUnit.DAYS;

//@Component
public class DateUtil {

//    @Autowired
//    private MessageSource messageSource;

    public String transformDateForForum(LocalDateTime dateTime) {
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
        return formatDateToString(dateTime);
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
}
