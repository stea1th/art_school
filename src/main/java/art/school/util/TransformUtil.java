package art.school.util;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class TransformUtil {

    public static <T, S> List<T> transformTo(List<S> list, Class<T> t) {
        List<T> trans = new ArrayList<>();
        try {
            for (S s : list) {
                trans.add(t.getConstructor(s.getClass()).newInstance(s));
            }
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return trans;
    }

    public static <T, S> List<T> transformToFilterAktiv(List<S> list, Class<T> t) {
        List<T> trans = new ArrayList<>();
        try {
            for (T x : transformTo(list, t)) {
                if ((boolean) x.getClass().getMethod("isAktiv").invoke(x)) {
                    trans.add(x);
                }
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return trans;
    }
}