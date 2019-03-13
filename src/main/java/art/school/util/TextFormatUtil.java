package art.school.util;

import art.school.entity.NachrichtUpdater;

public class TextFormatUtil {

    public static String createUpdaterInfo(NachrichtUpdater updater){
        return " " + updater.getAction() + " " +
                updater.getUser().getName() + " " +
                DateUtil.transformDateForForum(updater.getDatum());
    }
}
