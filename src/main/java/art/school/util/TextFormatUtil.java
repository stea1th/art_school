package art.school.util;

import art.school.entity.NachrichtUpdater;

import java.util.Arrays;
import java.util.List;

public class TextFormatUtil {

    public static List<String> splitMessageByLineSeparator(String message){
        return Arrays.asList(message.split("[\\r\\n]+"));
    }

    public static String createUpdaterInfo(NachrichtUpdater updater){
        return " " + updater.getAction() + " " +
                updater.getUser().getName() + " " +
                DateUtil.transformDateForForum(updater.getDatum());
    }
}
