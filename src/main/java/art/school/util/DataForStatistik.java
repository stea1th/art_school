package art.school.util;

import art.school.entity.Unterricht;
import art.school.statik.MonthForStatistik;
import art.school.statik.WeeksForStatistik;

import java.time.Month;
import java.time.temporal.WeekFields;
import java.util.*;
import java.util.stream.Collectors;

public class DataForStatistik {

    public static List<MonthForStatistik> getResponse(List<Unterricht> unterrichts){

        Map<Month, Double> map = unterrichts.stream()
                .collect(Collectors.groupingBy(i -> i.getDatum()
                                .toLocalDate()
                                .getMonth(),
                        Collectors.summingDouble(x -> x.getZahlung().getPreis().doubleValue())));

//        getWeeks(unterrichts);

//
        List<MonthForStatistik> collect = map.entrySet()
                .stream()
                .map((e) -> new MonthForStatistik(e.getKey(), e.getValue(), getWeeks(unterrichts, e.getKey())))
                .sorted(Comparator.comparing(i-> i.getName().getValue()))
                .collect(Collectors.toList());

//        Map<Integer, MonthForStatistik> response = new LinkedHashMap<>();
//        collect.forEach(i-> response.put(i.getName().getValue(), i));

        return collect;
    }

    private static List<WeeksForStatistik> getWeeks(List<Unterricht> unterrichts, Month monat){

        return unterrichts.stream().filter(i-> i.getDatum().getMonth().equals(monat))
                .collect(Collectors.groupingBy(i -> i.getDatum()
                                .toLocalDate()
                        .get(WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear()),
                        Collectors.summingDouble(x -> x.getZahlung().getPreis().doubleValue())))
        .entrySet().stream().map(e-> new WeeksForStatistik(e.getKey(), e.getValue()))
                .sorted(Comparator.comparing(WeeksForStatistik::getName))
                .collect(Collectors.toList());



//        for(Unterricht u : unterrichts){
//            LocalDate date = u.getDatum().toLocalDate();
//            int weekNumber = date.get(WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear());
//            System.out.println(weekNumber +" -> "+date.getMonth().name()+" -> "+date);
//        }
//        return null;
    }

}
