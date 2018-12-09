package art.school.util;

import art.school.entity.Unterricht;
import art.school.statik.Monat;
import art.school.statik.MonthForStatistik;
import art.school.statik.WeeksForStatistik;

import java.time.Month;
import java.time.temporal.WeekFields;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class DataForStatistik {

    public static List<MonthForStatistik> getResponse(List<Unterricht> unterrichts) {
        List<MonthForStatistik> all = getAllMonth();


        unterrichts.stream()
                .collect(Collectors.groupingBy(i -> i.getDatum()
                                .toLocalDate()
                                .getMonth(),
                        Collectors.summingDouble(x -> x.getZahlung().getPreis().doubleValue())))
                .forEach((key, value) -> {
                    MonthForStatistik m = all.get(key.getValue() - 1);
                    m.setMonat(key);
                    m.setValue(value);
                    m.setChildrens(getWeeks(unterrichts, key));
                    all.set(key.getValue() - 1, m);
                });

        return all;
//                .map((e) -> new MonthForStatistik(e.getKey(), e.getValue(), getWeeks(unterrichts, e.getKey())))
//                .sorted(Comparator.comparing(i -> i.getMonat().getValue()))
//                .collect(Collectors.toList());

//        Map<Integer, MonthForStatistik> response = new LinkedHashMap<>();
//        collect.forEach(i-> response.put(i.getName().getValue(), i));

    }

    private static List<WeeksForStatistik> getWeeks(List<Unterricht> unterrichts, Month monat) {

        return unterrichts.stream().filter(i -> i.getDatum().getMonth().equals(monat))
                .collect(Collectors.groupingBy(i -> i.getDatum()
                                .toLocalDate()
                                .get(WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear()),
                        Collectors.summingDouble(x -> x.getZahlung().getPreis().doubleValue())))
                .entrySet().stream().map(e -> new WeeksForStatistik(e.getKey(), e.getValue()))
                .sorted(Comparator.comparing(WeeksForStatistik::getName))
                .collect(Collectors.toList());

    }


    public static void test() {
        Arrays.stream(Monat.values())
                .forEach(e -> System.out.println("Ordinal -> " +
                        e.ordinal() + " Number -> " + e.getNumber()
                        + " Russian -> " + e.getName() +
                 " Name -> " + e.name()));
    }

    private static List<MonthForStatistik> getAllMonth(){

        return Arrays.stream(Monat.values())
               .map(i -> new MonthForStatistik(i.getName(), Month.of(i.getNumber()), 0.0, null))
               .collect(Collectors.toList());

    }

}
