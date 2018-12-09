package art.school.statik.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WochenTag {
    MONTAG("Понедельник"),
    DIENSTAG("Вторник"),
    MITTWOCH("Среда"),
    DONNERSTAG("Четверг"),
    FREITAG("Пятница"),
    SAMSTAG("Суббота"),
    SONNTAG("Воскресенье");

    private String name;
}
