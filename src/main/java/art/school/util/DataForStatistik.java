package art.school.util;

import art.school.entity.Unterricht;
import art.school.statik.DaysForStatistik;
import art.school.statik.enums.Monat;
import art.school.statik.MonthForStatistik;
import art.school.statik.WeeksForStatistik;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.WeekFields;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class DataForStatistik {

    public static List<MonthForStatistik> getResponse(List<Unterricht> unterrichts) {
        if(unterrichts.isEmpty()){
            return null;
        }
        List<MonthForStatistik> all = getAllMonth();

        int year = unterrichts.get(0).getDatum().getYear();

        unterrichts.stream()
                .collect(Collectors.groupingBy(i -> i.getDatum()
                                .toLocalDate()
                                .getMonth(),
                        Collectors.summingDouble(x -> x.getZahlung().getPreis().doubleValue())))
                .forEach((key, value) -> {
                    MonthForStatistik m = all.get(key.getValue() - 1);
                    m.setMonat(key);
                    m.setValue(BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP));
                    m.setChildrens(getWeeks(unterrichts, key, year));
                    all.set(key.getValue() - 1, m);
                });

        return all;
    }

    private static List<WeeksForStatistik> getWeeks(List<Unterricht> unterrichts, Month monat, int year) {

        List<WeeksForStatistik> allWeeks = getAllWeeksForMonth(monat, year);

        unterrichts.stream().filter(i -> i.getDatum().getMonth().equals(monat))
                .collect(Collectors.groupingBy(i -> i.getDatum()
                                .toLocalDate()
                                .get(WeekFields.ISO.weekOfYear()),
                        Collectors.summingDouble(x -> x.getZahlung().getPreis().doubleValue())))
                .forEach((key, value) -> allWeeks.stream()
                        .filter(w -> w.getNummer().equals(key))
                        .forEachOrdered(w -> w.setValue(BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP))));
        return allWeeks;
    }

    private static List<DaysForStatistik> getDays(List<Unterricht> unterrichts) {

        return null;
    }

    public static void test() {
        LocalDate d = LocalDate.now();
        System.out.println(d.get(WeekFields.ISO.dayOfWeek()));
    }

    private static List<MonthForStatistik> getAllMonth() {

        return Arrays.stream(Monat.values())
                .map(i -> new MonthForStatistik(i.getName(), Month.of(i.getNumber()), BigDecimal.valueOf(0), null))
                .collect(Collectors.toList());

    }

    private static List<WeeksForStatistik> getAllWeeksForMonth(Month month, int year) {
        List<WeeksForStatistik> allWeeks = new LinkedList<>();
        LocalDate first = LocalDate.of(year, month, 1);
        LocalDate last = LocalDate.of(year, month, month.length(first.isLeapYear()));
        int fWeek = first.get(WeekFields.ISO.weekOfYear());
        int lWeek = last.get(WeekFields.ISO.weekOfYear());
        String firstWeek = first.getDayOfMonth() + " - " + first.with(DayOfWeek.SUNDAY).getDayOfMonth();
        String lastWeek = last.with(DayOfWeek.MONDAY).getDayOfMonth() + " - " + last.getDayOfMonth();
        allWeeks.add(new WeeksForStatistik(fWeek, firstWeek, BigDecimal.valueOf(0)));
        int d1 = first.with(DayOfWeek.SUNDAY).getDayOfMonth() + 1;
        for (int i = fWeek + 1; i < lWeek; i++) {
            int d2 = d1 + 6;
            allWeeks.add(new WeeksForStatistik(i, d1 + " - " + d2, BigDecimal.valueOf(0)));
            d1 += 7;
        }
        allWeeks.add(new WeeksForStatistik(lWeek, lastWeek, BigDecimal.valueOf(0)));
        return allWeeks;
    }
}
