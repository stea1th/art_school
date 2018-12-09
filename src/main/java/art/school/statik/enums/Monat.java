package art.school.statik.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Monat {
    JANUAR("Январь", 1),
    FEBRUAR("Февраль", 2),
    MAERZ("Март", 3),
    APRIL("Апрель", 4),
    MAI("Май", 5),
    JUNI("Июнь", 6),
    JULI("Июль", 7),
    AUGUST("Август", 8),
    SEPTEMBER("Сентябрь", 9),
    OKTOBER("Октябрь", 10),
    NOVEMBER("Ноябрь", 11),
    DEZEMBER("Декабрь", 12);

    private String name;
    private int number;


}
